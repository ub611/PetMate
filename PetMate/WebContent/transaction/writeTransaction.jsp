<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ�ŷ� ��� ������</title>
</head>
<style>
#topMenu { 
	height: 30px; 
	width: 850px;
	} 
#topMenu ul li { 
	list-style: none;
	color: white;
	background-color: #FFBA85; 
	float: left;
	line-height: 40px;
	vertical-align: middle; 
	text-align: center;
	 }
#topMenu .menuLink { 
 	text-decoration:none;
 	color: white;
 	display: block;
 	width: 130px;
 	font-size: 12px;
 	font-weight: bold;
 	font-family: "Trebuchet MS", Dotum, Arial;
 	} 
 #topMenu .menuLink:hover { 
 	color: black;
 	background-color: #FF9436; 
 	}
</style>
<script>

function numkeyCheck(e){
	var keyValue = event.keyCode; 
	if( ((keyValue >= 48) && (keyValue <= 57)) ) 
		return true; 
	return false; 
	}

function transCreate() {
   if (form.title.value == "") {
      alert("������ �Է��Ͻʽÿ�.");
      form.title.focus();
      return false;
   } 
   if (form.content.value == "") {
      alert("������ �Է��Ͻʽÿ�.");
      form.content.focus();
      return false;
   }
   if (form.price.value == "") {
      alert("������ �Է��Ͻʽÿ�.");
      form.price.focus();
      return false;
   }
  

   form.submit();
}
</script>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<table align="center">
<tr> 
<br><br>
	<td><h1><font color=#FF5E00 size="24px">PetMate</font></h1></td> 
	<td>&nbsp;<a href="<c:url value='/main/form'/>"><img src="<c:url value='/images/chat_caticon.png' />"></a>
</tr>
</table>
<br>
<center>
<nav id="topMenu" > 
<ul> 
<li><a class="menuLink" href="<c:url value='/member/myPage/form'/>">���� ������</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerPet/form'/>">�� ���</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerAdopt/form'></c:url>">�Ծ�</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerHospital/form'></c:url>">����</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerSell/form'></c:url>">��ǰ �ŷ�</a></li>
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerFestival/form'></c:url>">����</a></li> 
</ul></nav>
</center>
<br>
<body>
<form name="form" method="POST" action="<c:url value='/transaction/registerTransaction' />">
  <table style="width: 100%">
    <tr>
      <td width="20"></td>
     <td>
       <table style="width: 100%">
        <tr>
          <td height="22" align="center">&nbsp;&nbsp;<b>��ǰ �ŷ� </b></td>
        </tr>
       </table>  
       <br>    
       <br>     
       <table style="background-color: #353535" align="center">
         <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>�� ����</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="text" size="80" style="width: 240; border: 0px;" name="title">
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>����</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">&nbsp;
       <select name="transaction_kind"> 
            <option value="ik1">�峭��</option> 
            <option value="ik2">����</option> 
            <option value="ik3">��å��ǰ</option>
            <option value="ik4">��</option>
            <option value="ik5">�Ƿ�</option>
      </select> 
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>�� ����</b></td>
         <td width="500" bgcolor="ffffff" style="padding-left: 10">
            <input type="text"name="content" size="80" style="height:100px; border: 0px;">
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>����</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <input type="text" size="80" style="width: 240; border: 0px;" name="price" onKeyPress="return numkeyCheck(event)">
         	��
         </td>
        </tr>
       </table>
       <br>     
       <table style="width: 100%">
        <tr>
         <td align="center"> 
         <input type="button" value="���" onClick="transCreate()"> &nbsp;
         </td>
        </tr>
       </table>
     </td>
    </tr>
  </table>  
</form>
<br><br><br>
</body>
</html>