<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	@SuppressWarnings("unchecked") 
   List<HospitalDTO> hospitalList = (List<HospitalDTO>)request.getAttribute("hospitalList");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_���� �˻�����Ʈ</title>
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
 <table style="width:100%">
   <tr>
   <td height="22" align="center">&nbsp;&nbsp;<b>���� �� ������</b></td>
   </tr>
</table>
<br>
 <table style="background-color: #353535" align = 'center'>
         <tr height="40">
         <td width="200" align="center" bgcolor="#FFFFF" align = "center"><b>���� �̸�</b></td>
         <td width = "200" align = "center" bgcolor = "#FFFFF"><b>���� �ּ�</b></td> 
          <td width = "200" align = "center" bgcolor = "#FFFFF"><b>���� �����ð�</b></td> 
        </tr>
        
  <%
  		if(hospitalList != null){
  			 Iterator<HospitalDTO> hospitalIter = hospitalList.iterator();
  			 
  			 while(hospitalIter.hasNext()){
  				 HospitalDTO h = (HospitalDTO)hospitalIter.next();
  %>
        <tr>
        <td width ="200" align = "center" bgcolor = "ffffff"><%= h.getHospital_name() %>
        </td>
        <td width ="200" align = "center" bgcolor = "ffffff"><%= h.getHospital_address() %>
         </td>
        <td width ="200" align = "center" bgcolor = "ffffff"><%= h.getHospital_closed() %>
         </td>
         </tr>
    <%
    			 }
  		}
    %>
        </table>
</body>
</html>