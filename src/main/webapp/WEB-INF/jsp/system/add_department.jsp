<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=basePath%>resource/js/jquery.js"></script>
<script
	src="<%=basePath%>resource/js/jquery.mCustomScrollbar.concat.min.js"></script>
<title>添加部门</title>
<script type="text/javascript">
	function check() {
		var name = $("#name").val(); //获取表单元素值
		if (name == "") {
			$("#msg").text("部门名不能为空！");
			return false;
		}
		return true;
	}
	function getSiblings(id) {
		var tr = $("#" + id);
		var pId = tr.attr("pId");
		var siblings = [];
		if (pId != undefined) {
			$("tr").each(function(i, ele) {
				tr = $(ele);
				if (tr.attr("pId") == pId) {
					siblings.push($(this));
				}
			});
		}
		return siblings;
	}

	function getParent(id) {
		var tr = $("#" + id);
		var parents = [];
		parents.push(tr);

		var pId = tr.attr("pId");
		if (pId != undefined) {
			parents = parents.concat(getParent(pId));
		}
		return parents;
	}

	function getChildren(id) {
		var tr = null;
		var children = [];
		if (id != undefined) {
			$("tr").each(
					function(i, ele) {
						tr = $(ele);
						if (tr.attr("pId") == id) {
							children.push(tr);
							children = children.concat(getChildren(tr.find(
									"input:eq(0)").val()));
						}
					});
		}
		return children;
	}
	function getChildrenChecked(id) {
		var chked = false;
		$.each(getChildren(id), function(i, v) {
			chked = v.find("input:eq(0)").attr("checked") == true;
			if (chked) {
				return false;
			}
		});
		return chked;
	}

	function chkModel(obj) {
		var id = obj.value, chkbox = null;
		$.each(getChildren(id), function(i, v) {
			v.find("input:eq(0)").attr("checked", function() {
				return obj.checked ? "checked" : "uncheck()"
			});
		});
		$.each(getParent(id), function(i, v) {
			if (i > 0) {
				chkbox = v.find("input:eq(0)");
				chkbox.attr("checked", function() {
					return getChildrenChecked(chkbox.val()) ? "checked"
							: "uncheck()"
				});
			}
		});
	}
	
	function subform(){
	    var form = document.getElementById('myForm');//获取表单dom
	    form.action="<%=basePath%>system/department/operation.do";//重新设置提交url
	    form.submit();//提交表单
	    window.close();//关闭窗口
	 }
</script>
</head>
<body>
	<form action="#" method="post" enctype="multipart/form-data"
		onsubmit="return check()" id="myForm" target="showpage">
		<input type="hidden" name="operation" value="${operation}">
		部门名:<input id="name" name="name" type="text" class="textbox"
			placeholder="部门名" value="${department.name}"/><br /> <br /> 描述：
			<c:if test="${empty department}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >部门描述</textarea>
			</c:if>
			<c:if test="${!empty department}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >${department.description}</textarea>			
		<br /> <br />
		<table id="treeTable1" style="width: 100%;">
			<caption>职位详情</caption>
			<thead>
				<tr>
					<th style="width: 30%">职位名称</th>
					<th style="width: 20%">职位基本工资</th>
					<th style="width: 20%">职位描述</th>
					
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${department.postSet}" var="post">
					<tr id="function.function_id">
						<td>${post.post_name}</td>
						<td>${post.post_wage}</td>
						<td>${post.description}</td>
						<td><a href="<%=basePath %>system/deletepost/${post.post_id}.do" onclick="if(confirm('删除是不可恢复的，你确认要删除吗？')==false)return false;">删除</a></td>
						<td><a href="#" onclick="window.open('<%=basePath %>system/updatepost/${post.post_id}.do','','width=400,height=400,top='+(screen.height-400)/2+',left='+(screen.width-400)/2 + '');">修改</a></td>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<span id="msg" style="color: red; font-size: 15px">${message}</span> 
		<!-- <input type="submit" value="提交"> -->
		<input type="button" value="提交" onclick="subform();">
		<input type="reset" value="重置">	
	</form>
</body>
</html>