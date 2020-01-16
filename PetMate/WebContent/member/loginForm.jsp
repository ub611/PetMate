<%@page language="java" contentType="text/html; charset=EUC-KR"
      pageEncoding="EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>PetMate_Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function login() {
   if (form.userID.value == "") {
      alert("사용자 ID를 입력하십시오.");
      form.userId.focus();
      return false;
   } 
   if (form.pwd.value == "") {
      alert("비밀번호를 입력하십시오.");
      form.password.focus();
      return false;
   }      
   form.submit();
}

</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table align="center">
<tr> 
	<td><h1><font color=#FF5E00 size="24px">PetMate</font></h1></td> 
	<td>&nbsp;<a href="<c:url value='/main/form'/>"><img src="<c:url value='/images/chat_caticon.png' />"></a>
</tr>
</table>

<!-- login form  -->
<form name="form" method="POST" action="<c:url value='/member/login' />">   <!-- LoginController로  , Suc) redirect:main Fail) LoginForm.jsp -->
  <table style="width:100%">
   <tr>
     <td width="20"></td>
     <td>
       <table style="width:100%">
        <tr>
         <td height="22" align="center">&nbsp;&nbsp;<b>사용자 관리 - 로그인</b></td>
        </tr>
       </table>  
       <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <center><c:if test="${loginFailed}">
          <font color="red"><c:out value="${exception.getMessage()}" /></font>
       </c:if></center>
       <center><c:if test="${NotLogin}">
          <font color="red"><c:out value="${msg}" /></font>
       </c:if></center>
       <br>     
       <table style="background-color: #353535" align="center">
          <tr height="30">
         <td width="100" align="center" bgcolor="#FFFFF"><b>아이디</b></td>
         <td width="200" bgcolor="ffffff" style="padding-left:10">
            <input type="text" style="width:180" name="userID">
         </td>
        </tr>
          <tr height="30">
         <td width="100" align="center" bgcolor="#FFFFF"><b>비밀번호</b></td>
         <td width="200" bgcolor="ffffff" style="padding-left:10">
            <input type="password" style="width:180" name="pwd">
         </td>
        </tr>
       </table>
       <br>     
       <table style="width:100%">
        <tr>
         <td align=center>
         <input type="button" value="로그인"  onClick="login()"> &nbsp;
         </td>         
        </tr>
       </table>
     </td>
   </tr>
  </table>  
</form>
</body>
</html>