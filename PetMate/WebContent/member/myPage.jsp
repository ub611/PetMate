<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import = "model.dao.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	MemberDTO member = (MemberDTO)request.getAttribute("memberDTO");

%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script>

function beforePage(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>

<title>PetMate_����������</title>
</head>
<body bgcolor = #FFFFFF>
<br>
<table align="center">
<tr> 
   <td><h1><font color=#FF5E00 size="24px">PetMate</font></h1></td> 
   <td><a href="<c:url value='/main/form'/>"><img src="<c:url value='/images/chat_caticon.png' />"></a>
</tr>
</table>
<br>
 <table style="width:100%">
   <tr>
   <td height="22" align="center">&nbsp;&nbsp;<b>����������</b></td>
   
   </tr>
</table>
<br>
   <br>
<table style="background-color: #353535" align = 'center' >
          <tr height="30">
          	<td width = "100" align = "center" bgcolor = "#FFFFF"><b>���̵�<b></b></td>
         	<td width="300" align="center" bgcolor="#FFFFFF"><%= member.getUserID() %></td>
        </tr>
         <tr height="30">
            <td width = "100" align = "center" bgcolor = "#FFFFF"><b>�̸�</b></td> 	
         	<td width="300" align="center" bgcolor="#FFFFFF"><%= member.getName() %></td>
        </tr>
         <tr height="30">
         	<td width = "100" align = "center" bgcolor = "#FFFFF"><b>����</b></td>
         <td width="300" align="center" bgcolor="#FFFFFF"><%= member.getRegion() %></td>
        </tr>
        <tr>	
        </tr>
  </table>
  <br><br>
  <table style="width:100%">
	<tr>
		<td align=center> 
          		<a href="<c:url value='/main/form'/>">�������� ���ư��� </a> &nbsp;&nbsp;
          		<a href="<c:url value='/member/myPage/update/form'/>">ȸ�� ���� �����ϱ� </a>
		</td>			
	</tr>
	</table>
<br>
</body>
</html>