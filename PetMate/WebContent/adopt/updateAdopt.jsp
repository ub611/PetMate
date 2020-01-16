<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	AdoptDTO adopt = (AdoptDTO)request.getAttribute("adopt");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_입양/분양 수정페이지</title>
<script>
function numkeyCheck(e){
	var keyValue = event.keyCode; 
	if( ((keyValue >= 48) && (keyValue <= 57)) ) 
		return true; 
	return false; 
	}
	
function updateAdopt() {
	if (form.pet_age.value == "") {
		alert("pet 나이를 입력하십시오.");
		form.pet_age.focus();
		return false;
	}
	
	if (form.kind.value == "") {
		alert("pet 종류를 입력하십시오.");
		form.pet_kind.focus();
		return false;
	}
	
	if (form.pet_gender.value == "") {
		alert("pet 성별을 입력하십시오.");
		form.pet_gender.focus();
		return false;
	}
	
	if (form.price.value == "") {
		alert("가격을 입력하십시오.");
		form.price.focus();
		return false;
	}
	
	alert("수정되었습니다");
	form.submit();
}

function adoptList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body>
<br>
<table align="center">
<tr> 
   <td><h1><font color=#FF5E00 size="24px">PetMate</font></h1></td> 
   <td>&nbsp;<img src="<c:url value='/images/chat_caticon.png' />">
</tr>
</table>
<form name="form" method="POST" action="<c:url value='/adopt/updateAdopt' />">
	<input type="hidden" name="userId" value="<%= adopt.getUserID() %>"	/>
	<input type="hidden" name="adoptId" value="<%= adopt.getAdopt_ID() %>"	/>
	<input type="hidden" name="kind" value="<%= adopt.getAdopt_kind() %>"	/>
	<table style="width: 100%" align="center">
	<tr>
	 <td width="20"></td>
	  <td>
	    <table style="width: 100%" align="center">
		  <tr align="center">
			<td height="22">&nbsp;&nbsp;<b>입양/분양 관리 - 정보 수정</b></td>
		  </tr>
	    </table>  
	    <br>	  
	    <table style="background-color: #353535" align="center">
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>사용자 ID</b></td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				&nbsp;<%= adopt.getUserID() %>
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>pet 나이</b></td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				&nbsp;<input type="text" style="width: 240"  onKeyPress="return numkeyCheck(event)" name="pet_age" value="<%= adopt.getAdopt_age() %>">
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>pet 종류</b></td>
			<td width="150" bgcolor="ffffff" style="padding-left:10">
             &nbsp;<c:set var="kind" value="<%=adopt.getAdopt_kind() %>"/>
	        <c:choose>
	           <c:when test="${kind == 'k1'}"> 
	           		강아지
	           </c:when>
	           <c:when test="${kind == 'k2'}"> 
	        		  고양이
	           </c:when>
	           <c:when test="${kind == 'k3'}"> 
	           		고슴도치
	             </c:when>
	             <c:when test="${kind == 'k4'}"> 
	           		파충류
	           </c:when>
	             <c:when test="${kind == 'k5'}"> 
	          		 토끼
	           </c:when>
	             <c:when test="${kind == 'k6'}"> 
	         		  새
	           </c:when>
	             <c:when test="${kind == 'k7'}"> 
	           		햄스터
	           </c:when>
	        </c:choose>
			</td>
		  </tr>	
		<tr height="40">
		<td width="150" align="center" bgcolor="#FFFFF"><b>pet 성별</b></td>
		<% if(adopt.getAdopt_gender().equals("남")) { %>
		<td width="250" bgcolor="ffffff" style="padding-left: 10"  align="center">		
		<input type="radio" name="pet_gender" value="남" checked="checked"/>남
		<input type="radio" name="pet_gender" value="여" />여
		</td>
		<% } else { %>
		<td width="250" bgcolor="ffffff" style="padding-left: 10"  align="center">		
		<input type="radio" name="pet_gender" value="남" />남
		<input type="radio" name="pet_gender" value="여" checked="checked"/>여
		</td>
		<% } %> </tr>	
		  <tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>가격</b></td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">		
			&nbsp;<input type="text" style="width: 240" onKeyPress="return numkeyCheck(event)" name="price" value="<%= adopt.getAdopt_price() %>">원
			</td>
		  </tr>		
		  <tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>상태</b></td>
			<% if(adopt.getIs_adopted() == 0) { %>
			<td width="250" bgcolor="ffffff" style="padding-left: 10" align="center">
			<input type="radio" name="isAdopted" value="0" checked="checked"/>진행중
			<input type="radio" name="isAdopted" value="1" />완료
			</td>
			<% } else { %>
			<td width="250" bgcolor="ffffff" style="padding-left: 10" align="center">
			<input type="radio" name="isAdopted" value="0" />진행중
			<input type="radio" name="isAdopted" value="1" checked="checked"/>완료
			</td>
			<% } %>
		  </tr>		    
	    </table>
	    <br>	  
	    <table style="width: 100%" align="center">
		  <tr>
			<td align="center">
			<input type="button" value="수정" onClick="updateAdopt()"> &nbsp;
			<input type="button" value="목록" onClick="adoptList('<c:url value='/adopt/listAdopt'/>')"> <!-- url 변경 -->
			</td>
		  </tr>
	    </table>
	  </td>
	</tr>
  </table>  
</form>
</body>
</html>