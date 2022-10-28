<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">board read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">board read</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
			<div class="form-group">
				<label>Bno</label>
				<input class="form-control" name="bno" 
				value='<c:out value="${board.bno}" />' readonly >
			</div>
			<div class="form-group">
				<label>title</label>
				<input class="form-control" name="title" 
				value='<c:out value="${board.title}"/>' readonly >
			</div>
			<div class="form-group">
				<label>Text area</label>
				<textarea class="form-control" rows="3" name="content"
				readonly ><c:out value="${board.content}"/></textarea>
			</div>
			<div class="form-group">
				<label>Writer</label><input class="form-control" name="writer" 
				value='<c:out value="${board.writer}"/>' readonly >
			</div>
			
			<button data-oper="Modify" 
			onClick="location.href='/board/modify?bno=<c:out value="${board.bno }"/>'"
			class="btn btn-default">Modify</button>
			<button data-oper="List" 
			onClick="location.href='/board/list'" class="btn btn-info">List</button>
				<!-- /.table-responsive -->
				
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<%@include file="../includes/footer.jsp"%>