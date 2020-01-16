<%@page language="java" contentType="text/html; charset=EUC-KR"
		pageEncoding="EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "model.*" %>
<%
	//memberDTO가져오기 sessionId로 
	MemberDTO member = (MemberDTO)request.getAttribute("memberDTO");

%>
<html>
<head>
<title>PetMate_정보수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function userUpdate() {
	if (form.pwd.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.pwd.focus();
		return false;
	}
	if (form.pwd.value != form.pwd2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.pwd.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	if (form.region.value == "") {
		alert("지역을 입력하십시오.");
		form.region.focus();
		return false;
	}
	
   form.submit();
}

function backMyPage(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table align= "center">
<tr> 
	<td><h1><font color=#FF5E00 size="24px">PetMate</font></h1></td> 
	<td>&nbsp;<a href="<c:url value='/main/form'/>"><img src="<c:url value='/images/chat_caticon.png' />"></a>
</tr>
</table>
<!-- registration form  -->
<form name="form" method="POST" action= "<c:url value='/member/myPage/update' />">
  <table style="width: 100%">
    <tr>
      <td width="20"></td>
     <td>
       <table style="width: 100%">
        <tr>
          <td height="22" align="center">&nbsp;&nbsp;<b>사용자 관리 - 회원 가입</b></td>
        </tr>
       </table>  
       <br>    
       
       <c:if test="${registerFailed}">
         <font color="red"><c:out value="${exception.getMessage()}" /></font>
       </c:if>
           
       <br>     
       <table style="background-color: #353535" align="center">
         <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>사용자 ID</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
         		<%= member.getUserID() %>
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>비밀번호</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="password" style="width: 240" name="pwd" %>
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>비밀번호 확인</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="password" style="width: 240" name="pwd2">
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>이름</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="text" style="width: 240" name="name" value = <%= member.getName() %>
                <c:if test="${registerFailed}">value="${member.name}"</c:if>>
         </td>
        </tr>
         <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>지역</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
         <select name="region">
    			<option value="서울">서울</option>
    			<option value="인천">인천</option>
    			<option value="경기">경기</option>
    			<option value="강원">강원</option>
    			<option value="부산">부산</option>
    			<option value="대구">대구</option>
    			<option value="대전">대전</option>
    			<option value="전북">전북</option>
    			<option value="전남">전남</option>
    			<option value="경북">경북</option>
    			<option value="경남">경남</option>
    			<option value="충북">충북</option>
    			<option value="충남">충남</option>
    			<option value="제주">제주</option>
    			</select>
         </td>
        </tr>
       </table>
       <br>     
       <table style="width: 100%">
        <tr>
         <td align="center"> 
         <input type="button" value="이전 화면" onClick= "backMyPage('<c:url value='/member/myPage/form' />')"/> &nbsp;
         <input type="button" value="변경 완료" onClick="userUpdate()"/>        
         </td>
        </tr>
       </table>
     </td>
    </tr>
  </table>  
</form>
</body>
</html>