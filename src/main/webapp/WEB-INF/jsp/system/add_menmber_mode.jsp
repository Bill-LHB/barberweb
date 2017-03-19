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
<title>添加充值套餐</title>
<script type="text/javascript">
	function check() {
		var name = $("#name").val(); //获取表单元素值
		if (name == "") {
			$("#msg").text("充值套餐名名不能为空！");
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
	
	<form action="<%=basePath%>system/menmbermode/operation.do" method="post" enctype="multipart/form-data"
		onsubmit="return check()" target="showpage">
		<input type="hidden" name="c_list" value="${c_list}">
		<input type="hidden" name="operation" value="${operation}">
		充值套餐名:<input id="name" name="name" type="text" class="textbox"
			placeholder="充值套餐名" value="${menmbermode.name}"/>
			<c:if test="${empty menmbermode.m_isOverlay ||menmbermode.m_isOverlay==1}">
				<select>
					  	<option value="0">不叠加运算</option>
					  	<option value="1" selected="selected">叠加运算</option>	  
				</select>		
			</c:if>
			<c:if test="${menmbermode.m_isOverlay ==0}">
				<select>	
					  	<option value="0" selected="selected">不叠加运算</option>
					  	<option value="1" >叠加运算</option>	  
				</select>		
			</c:if>
			<br/>	<br/>	<br/>	<br/>	<br/>	<br/>	<br/>	<br/>
			<table>
			<th>金额</th>
			<th>优惠比例</th>
			<th>优惠金额</th>
			<th>操作</th>	
			<c:if test="${!empty menmbermode.combinationList}">
				<select>
					<c:forEach items="${menmbermode.combinationList}" var="combination">
				  		<td>${combination.combination_money}</td>
				  		<td>${combination.combination_ratio}</td>
				  		<td>${combination.combination_extra}</td>
				  		<td><a href="<%=basePath %>system/deleteFunction/${combination.combination_id}.do">删除</a></td>
						
				  	</c:forEach>
				</select>
			</c:if>
			</table>

				
			
			描述：
			<c:if test="${empty menmbermode}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >套餐描述</textarea>
			</c:if>
			<c:if test="${!empty menmbermode}">
		<textarea id="description" name="description"
			style="width: 200px; height: 80px;" >${menmbermode.description}</textarea>			
		<br /> <br />
		</c:if>
		<span id="msg" style="color: red; font-size: 15px">${message}</span> <input
			type="submit" value="提交">
		<input type="reset" value="重置">	
	</form>
	<form action="<%=basePath %>system/combination/operation2.do" method="post" style="position:relative;
	top:-240px;">	
	<input type="hidden" name="c_list" value="${c_list}">
		<input type="hidden" name="operation2" value="addcombination">
		<input type="hidden" name="operation" value="${operation}">
		金额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" name="combination_money"><br/>
		优惠比例：<input type="text" name="combination_ratio"><br/>
		优惠金额：<input type="text" name="combination_extra"><br/>
		<input type="submit" value="添加">
	</form>

</body>
</html>