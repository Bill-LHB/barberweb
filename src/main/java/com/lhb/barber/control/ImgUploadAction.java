package com.lhb.barber.control;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lhb.barber.util.FileUtil;
import com.lhb.barber.util.ImageUtil;  
  
/** 
 * 图片上传控制器 
 * @author tanfei 
 * @date 2013-09-23 
 */  
@Controller  
@RequestMapping("/hr")  
public class ImgUploadAction {  
  
    @RequestMapping(value="uploadImg")  
    public void uploadImg() {  
          
    }  
      
    /** 
     * 上传 
     * @param file 
     * @param request 
     * @param model 
     * @return 
     */  
    @RequestMapping(value="/upload",method=RequestMethod.POST)  
    public void fileUpload(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request ,HttpServletResponse response){  //图片文件上传  
    	 String headurl="";
        Map<String, Object> resMap = new HashMap<String, Object>();  
        String imageCode = "-1";//默认上传失败  
        /**判断文件是否为空,空直接返回上传错误**/  
        if(!file.isEmpty()){  
              
            //获得文件后缀名  
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));  
            if(suffix.equals(".jpg") || suffix.equals(".gif") || suffix.equals(".png")) {//检测图片类型  
                if(file.getSize() > 1000000) {  
                    imageCode = "-1";  
                    //throw new Exception("上传失败：文件大小不能超过1M");  
                }else {  
                    try {  
                        //将上传的图片转换成base64编码字符串  
                        imageCode = "data:image/gif;base64," + ImageUtil.encodeImageToStr(file.getInputStream());
                        headurl=System.currentTimeMillis()+"."+suffix;
                        String Filename=request.getContextPath()+"."+headurl;
                        File newFile=new File("Filename");                        
                        File oldFile=multipartToFile(file);                
                        FileUtil.copyFile(oldFile, newFile);                   
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }else{  
            imageCode = "-1";  
        }  
          
        resMap.put("imageCode", imageCode); 
        
        
        resMap.put("headurl", headurl);
        response.setContentType("text/html;charset=UTF-8");//指定响应内容类型，避免<pre...  
          
        try {  
            PrintWriter out = response.getWriter();  
            Gson gson = new GsonBuilder().create();  
            String gsonStr = gson.toJson(resMap);  
            out.write(gsonStr);  
            out.flush();  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    
    
    
   private File multipartToFile(MultipartFile multfile) throws IOException {  
        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;   
        //这个myfile是MultipartFile的  
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();  
        File file = fi.getStoreLocation();  
        //手动创建临时文件  
        if(file.length() < 2048){  
            File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +   
                    file.getName());  
            multfile.transferTo(tmpFile);  
            return tmpFile;  
        }  
        return file;  
    }
      
}