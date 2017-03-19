<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>模块管理</title>
<style type="text/css"> 
	h1{
		text-align: center;
	}
	table{width:800px;
		margin: 0 auto;
	} 
	th{background:#FCA;
		padding: 5px; 
	} 
	td{text-align:center;} 
 	#dsi{
 		position:fixed;
		top:100px;
		left:200px
 	}
 	tr:hover {background-color:gray;}  /* 鼠标移动到表格 */
	tr:active {background-color:#c0c0c0;}  /* 鼠标点击时 */
 	td:hover {background-color:green;}  /* 鼠标移动到表格 */
	td:active {background-color:white;}  /* 鼠标点击时 */
</style> 
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>

<script type="text/javascript" src="<%=basePath%>resource/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>resource/css/pagination.css" />
<script type="text/javascript" src="<%=basePath%>resource/js/jquery.pagination.js"></script>
<script type="text/javascript"> 	
         var pageIndex = 0;     //页面索引初始值   
         var pageSize = 2;     //每页显示条数初始化，修改显示条数，修改这里即可   
         var pcount=$("#modules").val();
 
         $(function () { 
        	
              InitTable(0);    //Load事件，初始化表格数据，页面索引为0（第一页）
                //分页，PageCount是总条目数，这是必选参数，其它参数都是可选
                $("#Pagination").pagination(pcount, {
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                    prev_text: "« 上一页",
                    next_text: "下一页 »",
                    items_per_page:pageSize,
                    num_edge_entries: 2,       //两侧首尾分页条目数
                    num_display_entries: 6,    //连续分页主体部分分页条目数
                    current_page: pageIndex,   //当前页索引
                });
                //翻页调用   
                function PageCallback(index, jq) {                  
                    InitTable(index);  
                }  
                //请求数据   
                function InitTable(pageIndex) {   
                	   alert("pageIndex=" + (pageIndex) + "& pageSize=" + pageSize );
                    $.ajax({                                   
       				 url:"<%=request.getContextPath()%>/page.do",		
       				data:"pageIndex=1&pageSize=2&handle=modules",
       				/*  data:"pageIndex=" + (pageIndex) + "& pageSize=" + pageSize+"& handle=modules",          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数 */
       				 type:"post",
       				 dataType:"json",
       				 success: function(result) {   
       					 
       					$(result).each(function (i) { 
       						
       					}
       					 
                      	$("#modules").html(result.pcount);
                     	alert("pcount:" +a);
                     	var a=result.pageMap;
                     	alert("pageMap:" +pageMap);
                     	var html = "";
                 		for(var i=1; i<a.lenth; i+=1){
                 			var b=a[i-1];
                 			html +='<tr>';
                 			html += '<td>'+b.name+'</td>';
                 			html += '<td>'+b.description+'</td>';    
                 			html +='</tr>';
                 			alert("i :" + i+"b.name："+b.name+"b.description"+b.description);
                 		}

                         /* $("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）    */                          
                          $("#Result").append(html);  //将返回的数据追加到表格   
                         alert("html :" + html);  
                     }  ,
       				 error:function(xhr,status,error){
       					 $("h2").html("status :"+status+", error:"+error);
       				 }
                    }); 
                }  
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                 $("tr td img").mouseenter (function(){
        			var url = $(this).attr("src");
        			$("#dsi").html("<img id=showImg src="+url+" width='200px' height='200px'>");
        			$("#showImg").attr({src:url});
        			$("#dsi").show();
        		}) 
        		 $("tr td img").mouseleave (function(){
        			$("#dsi").hide();
        		}) 
        		
        		
            });  
         
</script>

</head>
<body>

	
	 <table width="100%" border="0" cellspacing="0" cellpadding="0">
	 	<input type="text" id="modules" value="${pcount}">

		<form action="<%=basePath %>system/findmodules.do" method="post" style="display:inline">	
			<input type="text" name="keyword" placeholder="模块名"/>
			<input type="submit" value="查询模块">	
		</form>	
		<a href="#" style="text-decoration:none;" onclick="window.open('<%=basePath %>system/addmodules.do','','width=400,height=180,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');"><button style="display:inline">添加模块</button></a>
	</table>
	
	
	<table border="1" style="position:relative;left:-150px;">
		<tr>
			<th>模块名</th>
			<th>模块描述</th>
			
			<th colspan="3">操作</th>
		</tr>
	<%-- 	<c:forEach items="${modulesList}" var="modules">
			<tr>
				<td>${modules.name}</td>
					<td>${modules.description}</td>
				<td><a href="<%=basePath %>system/deletemodules/${modules.modules_id}.do" onclick="if(confirm('删除是不可恢复的，你确认要删除吗？')==false)return false;">删除</a></td>
				<td><a href="#" onclick="window.open('<%=basePath %>system/updatemodules/${modules.modules_id}.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">修改</a></td>
				<td><a href="<%=basePath%>system/allfunctionbymodules/${modules.modules_id}.do">查看模块功能</a></td>
			</tr>
			
		</c:forEach> --%>
	</table>
	<div id="Pagination" class="right flickr"></div> 
	
	
	
	<span id="msg" style="color: red; font-size: 15px">${message}</span>
	
</body>
</html>