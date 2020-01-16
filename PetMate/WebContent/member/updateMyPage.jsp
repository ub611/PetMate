<%@page language="java" contentType="text/html; charset=EUC-KR"
		pageEncoding="EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "model.*" %>
<%
	//memberDTO�������� sessionId�� 
	MemberDTO member = (MemberDTO)request.getAttribute("memberDTO");

%>
<html>
<head>
<title>PetMate_��������</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function userUpdate() {
	if (form.pwd.value == "") {
		alert("��й�ȣ�� �Է��Ͻʽÿ�.");
		form.pwd.focus();
		return false;
	}
	if (form.pwd.value != form.pwd2.value) {
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		form.pwd.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("�̸��� �Է��Ͻʽÿ�.");
		form.name.focus();
		return false;
	}
	if (form.region.value == "") {
		alert("������ �Է��Ͻʽÿ�.");
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
          <td height="22" align="center">&nbsp;&nbsp;<b>����� ���� - ȸ�� ����</b></td>
        </tr>
       </table>  
       <br>    
       
       <c:if test="${registerFailed}">
         <font color="red"><c:out value="${exception.getMessage()}" /></font>
       </c:if>
           
       <br>     
       <table style="background-color: #353535" align="center">
         <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>����� ID</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
         		<%= member.getUserID() %>
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>��й�ȣ</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="password" style="width: 240" name="pwd" %>
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>��й�ȣ Ȯ��</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="password" style="width: 240" name="pwd2">
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>�̸�</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="text" style="width: 240" name="name" value = <%= member.getName() %>
                <c:if test="${registerFailed}">value="${member.name}"</c:if>>
         </td>
        </tr>
         <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>����</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
         <select name="region">
    			<option value="����">����</option>
    			<option value="��õ">��õ</option>
    			<option value="���">���</option>
    			<option value="����">����</option>
    			<option value="�λ�">�λ�</option>
    			<option value="�뱸">�뱸</option>
    			<option value="����">����</option>
    			<option value="����">����</option>
    			<option value="����">����</option>
    			<option value="���">���</option>
    			<option value="�泲">�泲</option>
    			<option value="���">���</option>
    			<option value="�泲">�泲</option>
    			<option value="����">����</option>
    			</select>
         </td>
        </tr>
       </table>
       <br>     
       <table style="width: 100%">
        <tr>
         <td align="center"> 
         <input type="button" value="���� ȭ��" onClick= "backMyPage('<c:url value='/member/myPage/form' />')"/> &nbsp;
         <input type="button" value="���� �Ϸ�" onClick="userUpdate()"/>        
         </td>
        </tr>
       </table>
     </td>
    </tr>
  </table>  
</form>
</body>
</html>