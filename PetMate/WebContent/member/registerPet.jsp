<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_����</title>
<script>
function petCreate() {
   if (form.pet_name.value == "") {
      alert("pet �̸��� �Է��Ͻʽÿ�.");
      form.pet_name.focus();
      return false;
   }
  
   if (form.pet_age.value == "") {
      alert("pet ���̸� �Է��Ͻʽÿ�.");
      form.pet_age.focus();
      return false;
   }
   
   alert("�� ����� ���������� �Ǿ����ϴ�");
   form.submit();
}
</script>
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

<!-- pet form -->
<form name="form" method="POST" action="<c:url value='/member/registerPet' />">
	<table style="width:100%" align="center">
	<tr>
	<br>
		<td height="22" align="center"><b>pet ���</b></td>
    </tr>
    </table>  
	<br>
	<table style="background-color: #353535" align = 'center'>
    <tr height="30"> 
		<td width="150" align="center" bgcolor=#FFFFF"><b>pet �̸�</b> </td>
		<td width="250" bgcolor="#FFFFFF" style="padding-left: 10">&nbsp;&nbsp;
			<input type="text" style="width: 215px;" name="pet_name" /></td>
    </tr>
    <tr height="30"> 
		<td width="150" align="center" bgcolor=#FFFFF"><b>pet ����</b></td>
		<td width="250" bgcolor="#FFFFFF" style="padding-left: 10">&nbsp;&nbsp;
			<input type="text" style="width: 215px;" name="pet_age" /></td>
    </tr>
    <tr height="30"> 
		<td width="150" align="center" bgcolor=#FFFFF"><b>pet ����</b></td>
		<td width="200" bgcolor="#FFFFFF" style="padding-left: 10" align="center">
			<input type="radio" name="pet_gender" value="��" checked="checked"/>��
			<input type="radio" name="pet_gender" value="��" />��
		</td>
    </tr>
    <tr height="30">
    	<td width="150" align="center" bgcolor=#FFFFF"><b>pet ����</b></td>
    	<td width="200" bgcolor="#FFFFFF" style="padding-left: 10" align="center">
    		<select name="kind_ID">
    			<option value="k1">������</option>
    			<option value="k2">�����</option>
    			<option value="k3">����ġ</option>
    			<option value="k4">�����</option>
    			<option value="k5">�䳢</option>
    			<option value="k6">��</option>
    			<option value="k7">�ܽ���</option>
    		</select>
    	</td>
    </tr>
    </table>
	<br>	  
	<table style="width:100%">
	<tr>
		<td align=center> 
		 <a href="<c:url value='/member/listPet'></c:url>">������ ����Ʈ����</a> &nbsp;  
			<input type="button" value="���" onClick="petCreate()">
		</td>			
	</tr>
	</table>
</form>
</body>
</html>