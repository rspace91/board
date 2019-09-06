<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>

<%@ include file="/commonJsp/basicLib.jsp"%>

<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = [];

	$(document).ready(function() {
		
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, 
			elPlaceHolder : "smarteditor", 
			sSkinURI : "/SE2/SmartEditor2Skin.html", 
			fCreator : "createSEditor2", 
			htParams : {
				bUseToolbar : true,
				bUseVerticalResizer : true,
				bUseModeChanger : true,
			}
		});

		// 전송버튼 클릭이벤트
		$("#updateButton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

				if(validation()) {
					$("#frm").submit();
				}
			}
		})

		$('.fileSpan').on('click', function () {

			var dataValue = $(this).data('fileno');

			$('#fileNo').val(dataValue);
			$('#deleteFileForm').submit();
		});

       

	});

	// 필수값 Check
	function validation(){
		var contents = $.trim(oEditors[0].getContents());
		if(contents  === ''){ 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>

<style>
	td{
		padding-right : 10px;
		padding-bottom: 20px;
	}
	#button{
		float: right;
	}
</style>
</head>

<body>

	<!-- 파일 삭제 -->
	<form id="deleteFileForm" action="${cp }/deletePost" method="post">
		<input type="hidden" id="fileNo" name="fileNo"/>
		<input type="hidden" id="postNo" name="postNo" value="${post.postno }"/>
	</form>

	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h1>게시글 수정</h1>

				<br><br>

				<form action="${cp }/updatePost" method="post" id="frm" enctype="multipart/form-data">
					<input type="hidden" id="postNo" name="postNo" value="${post.postno }"/>
					<table>
						<tr>
							<td>제목</td>
							<td><input type="text" id="postTitle" name="postTitle" style="width:750px; height:40px;" value="${post.posttitle }"/></td>
						</tr>
						<tr>
							<td>글내용</td>
							<td><textarea name="postContent" id="smarteditor" rows="10" cols="100" style="width:750px; height:412px;">${post.postcontent }</textarea></td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td></td>
						</tr>
						<c:forEach items="${fileList}" var="postFile">
							<tr>
								<td></td>
								<td>${postFile.filename}&nbsp;&nbsp;<span class="fileSpan glyphicon glyphicon-remove" data-fileNo="${postFile.fileno}" ></span></td>
							</tr>
						</c:forEach>
						<tr>
							<td>첨부파일</td>
							<td><input type="file" multiple="multiple" id="file" name="file"/></td>
						</tr>
						<tr>
							<td></td>
							<td id="button"><input type="button" id="updateButton" class="btn btn-default pull-right" value="수정" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>