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
		// Editor Setting
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
		$("#savebutton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

				if(validation()) {
					$("#frm").submit();
				}
			}
		})


	});

	// 필수값 Check
	function validation(){
		var contents = $.trim(oEditors[0].getContents());
		if(contents === ''){ 
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

	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<c:choose>
					<c:when test="${postNo == null }">
						<h1>새글 작성</h1>
					</c:when>
					<c:otherwise>
						<h1>답글 작성</h1>
					</c:otherwise>
				</c:choose>

				<br><br>

				<form action="${cp }/insertPost" method="post" id="frm" enctype="multipart/form-data">
					<input type="hidden" id="boardNo" name="boardNo" value="${boardno }"/>
					<input type="hidden" id="parentpostno" name="parentpostno" value="${postNo }"/>
					<input type="hidden" id="postGn" name="postGn" value="${postGn }"/>
					<table>
						<tr>
							<td>제목</td>
							<td><input type="text" id="postTitle" name="postTitle" style="width:750px; height:35px;"/></td>
						</tr>
						<tr>
							<td>글내용</td>
							<td><textarea name="postContent" id="smarteditor" rows="10" cols="100" style="width:750px; height:412px;"></textarea></td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td><input type="file" multiple="multiple" maxlength="5" id="file" name="file"/></td>
						</tr>
						<tr>
							<td></td>
							<td id="button"><input type="button" id="savebutton" class="btn btn-default pull-right" value="저장" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>