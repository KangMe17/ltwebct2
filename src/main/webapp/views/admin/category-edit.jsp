<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<form action="${pageContext.request.contextPath}/admin/category/update"
	method="post" enctype="multipart/form-data">
	<label for="fname">Category name:</label><br> <input type="text"
		id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
	<label for="lname">Link images:</label><br>
	<c:if test="${cate.images.substring(0,5) =='https'}">
		<c:url value="${cate.images}" var="imgUrl"></c:url>
	</c:if>
	<c:if test="${cate.images.substring(0,5)!='https'}">
		<c:url value="/images?fname=${cate.images}" var="imgUrl"></c:url>
	</c:if>

	<img height="150" width="200" src="${imgUrl}" /> <input type="text"
		id="images" name="images" value="${cate.images}"> <label
		for="lname">Upload File:</label><br> <input type="file"
		id="images1" name="images1"> <label for="lname">Status:</label><br>
	<input type="radio" id="statuson" name="status"
		value="${cate.categoryname}"> <label for="css">Hoat
		dong</label><br> <input type="radio" id="statusoff" name="status"
		value="${cate.categoryname}"> <label for="javascript">Ngung</label>
	<input type="submit" value="Insert">
</form>