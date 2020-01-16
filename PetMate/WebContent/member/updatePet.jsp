<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	PetDTO pet = (PetDTO)request.getAttribute("pet");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_펫 정보 수정페이지</title>
<script>
function updatePet() {
	if (form.pet_name.value == "") {
		alert("pet 이름을 입력하십시오.");
		form.pet_name.focus();
		return false;
	}
	
	if (form.pet_gender.value == "") {
		alert("pet 성별을 입력하십시오.");
		form.pet_gender.focus();
		return false;
	}
	
	if (form.pet_age.value == "") {
		alert("pet 나이를 입력하십시오.");
		form.pet_age.focus();
		return false;
	}
	
	alert("수정되었습니다");
	form.submit();
}

function deletePet(targetUri) {
	alert("삭제되었습니다");
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
   <td>&nbsp;<a href="<c:url value='/main/form'/>"><img src="<c:url value='/images/chat_caticon.png' />"></a>
</tr>
</table>
<form name="form" method="POST" action="<c:url value='/member/updatePet' />">
	<input type="hidden" name="userId" value="<%= pet.getUserID() %>"	/>
	<input type="hidden" name="petId" value="<%= pet.getPet_ID() %>"	/>
	<input type="hidden" name="kind" value="<%= pet.getKind_ID() %>"	/>
	<table style="width: 100%" align="center">
	<tr>
	 <td width="20"></td>
	  <td>
	    <table style="width: 100%" align="center">
		  <tr align="center">
			<td height="22">&nbsp;&nbsp;<b>마이펫 관리 - 정보 수정</b></td>
		  </tr>
	    </table>  
	    <br>	  
	    <table style="background-color: #353535" align="center">
	  	<tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>pet 이름</b></td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">		
			&nbsp;<input type="text" style="width: 240" name="pet_name" value="<%= pet.getPet_name() %>">
			</td>
		  </tr>		
		  <tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>pet 나이</b></td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				&nbsp;<input type="text" style="width: 240" name="pet_age" value="<%= pet.getPet_age() %>">
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="#FFFFF"><b>pet 종류</b></td>
			<td width="150" bgcolor="ffffff" style="padding-left:10">
             &nbsp;<c:set var="kind" value="<%= pet.getKind_ID() %>"/>
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
		<% if(pet.getPet_gender().equals("남")) { %>
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
	    </table>
	    <br>	  
	    <table style="width: 100%" align="center">
		  <tr>
			<td align="center">
			<input type="button" value="수정" onClick="updatePet()"> &nbsp;
			<input type="button" value="삭제" onClick="deletePet('<c:url value='/member/deletePet'/>')">
			</td>
		  </tr>
	    </table>
	  </td>
	</tr>
  </table>  
</form>
</body>
</html>