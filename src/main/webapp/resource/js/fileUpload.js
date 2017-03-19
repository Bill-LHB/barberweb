/** 
 * 图片上传 
 */  
function ajaxFileUpload() {  
    $.ajaxFileUpload({  
       url:'../../../hr/upload.do', //需要链接到服务器地址  
       secureuri:false,  
       fileElementId:'file', //文件选择框的id属性  
       dataType: 'json',  //服务器返回的格式类型  
       success: function (data, status) //成功  
       {        
           var json =  eval("("+data+")");//解析返回的json  
           var imageCode = json.imageCode;  
           if(imageCode!='-1'){  
             $("#showImg").attr("src", imageCode);   
             $("#input_photo").val(imageCode);  
               
           }else{  
             alert("上传失败！只允许上传图片类型(jpg,gif,png)且小于1M的照片");  
           }  
              
             
       },  
       error: function (data, status, e) //异常  
       {  
          alert("出错了，请重新上传！");  
       }  
   });  
}  