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
<title>添加服务项目</title>
<script type="text/javascript">
	function check() {
		var name = $("#name").val(); //获取表单元素值
		if (name == "") {
			$("#msg").text("模块名不能为空！");
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
</script>
</head>
<body>
	<form action="<%=basePath%>system/combination/operation.do" method="post"
		enctype="multipart/form-data" onsubmit="return check()">
		<input type="hidden" name="operation" value="${operation}">
		<input type="hidden" name="m_id" value="${m_id}">
		<input type="text" name="combination_money" value="${combination.combination_money}">${combination.combination_money}
		<input type="text" name="combination_ratio" value="${combination.combination_ratio}">${combination.combination_ratio}
		<input type="text" name="combination_extra" value="${combination.combination_extra}">${combination.combination_extra}		
		<span id="msg" style="color: red; font-size: 15px">${message}</span> 
		<input type="submit" value="提交">
			 <input type="reset" value="重置">
	</form>
</body>
</html>