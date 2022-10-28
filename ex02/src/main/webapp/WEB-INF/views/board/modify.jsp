<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">board modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">board modify</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/modify">
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno"
							value='<c:out value="${board.bno}" />' readonly>
					</div>
					<div class="form-group">
						<label>title</label> <input class="form-control" name="title"
							value='<c:out value="${board.title}"/>'>
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content"><c:out
								value="${board.content}" /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label><input class="form-control" name="writer"
							value='<c:out value="${board.writer}"/>' readonly>
					</div>
					<div class="form-group">
						<label>Reg Date</label> <input class="form-control" name="regDate"
							value='<fmt:formatDate pattern="yyyy/MM/dd"
										value="${board.regdate }"/>'
							readonly>
					</div>
					<div class="form-group">
						<label>Update Date</label> <input class="form-control"
							name="updateDate"
							value='<fmt:formatDate pattern="yyyy/MM/dd"
										value="${board.updateDate }"/>'
							readonly>
					</div>
					<button data-oper="modify" type="submit" class="btn btn-primary">Submit</button>
					<button data-oper="remove" type="submit" class="btn btn-danger">Delete</button>
					<button data-oper="list" type="submit" class="btn btn-info">List</button>
					<!-- /.table-responsive -->
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {
		//글 등록 이후 모달팝업 생성
		var formObj = $("form");
		
		$("button").on("click",function (e){
			e.preventDefault();
			var operation = $(this).data("oper");
			console.log(operation);
			
			if(operation === 'remove'){
				formObj.attr("action","/board/remove")
				.attr("method","post");
			}else if(operation === 'modify'){
				formObj.attr("action","/board/modify")
				.attr("method","post");
			}else{
				self.location = "/board/list";
				return;
			}
			formObj.submit();
		});
		
	});
</script>

<%@include file="../includes/footer.jsp"%>