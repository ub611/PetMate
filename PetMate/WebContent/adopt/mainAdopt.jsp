<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import= "java.util.*"%>
<%@ page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_입양 정보 메인 페이지</title>
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
<li><a class="menuLink" href="<c:url value='/member/myPage/form'/>">마이 페이지</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerPet/form'/>">펫 등록</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerAdopt/form'></c:url>">입양</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerHospital/form'></c:url>">병원</a></li> 
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerSell/form'></c:url>">물품 거래</a></li>
<li>|</li> 
<li><a class="menuLink" href="<c:url value='/member/registerFestival/form'></c:url>">축제</a></li> 
</ul></nav>
</center>
<br>
<form name="form" method="POST" action="<c:url value='/adopt/checkLoginAdopt'/>">
<table style="width:100%">
<tr>
<td>
<c:if test="${NotLogin}">
<center><font color="red"><c:out value="${exception}" /></font></center>
</c:if>
</td>
</tr></table>
<table style="width:70%">
<tr>
<td height="22" align="right"><b>입양/분양 정보를 알고싶은 동물을 클릭하세요</b></td>
<td height=22 align=center">
<input type="submit" value="글쓰기"></td>
</tr>
</table>
</form>
<br>
<center>
<table align=center width=280 height=200>
<tr>
	<td><a href="<c:url value='/adopt/listAdopt'> <c:param name='kind' value='k1' /> </c:url>" > 
	<img src="<c:url value='/images/dog.PNG' />" width=160 height=160/></a></td>
	<td><a href="<c:url value='/adopt/listAdopt'> <c:param name='kind' value='k2' /> </c:url>" > 
	<img src="<c:url value='/images/cat.png' />" width=200 height=200/></a></td>
	<td><a href="<c:url value='/adopt/listAdopt'> <c:param name='kind' value='k5' /> </c:url>" > 
	<img src="<c:url value='/images/rabbit.jpg'/>" width=200 height=200/></a></td>
</tr>
</table>
<table align=center width=280 height=300>
<tr>
	<td><a href="<c:url value='/adopt/listAdopt'> <c:param name='kind' value='k6' /> </c:url>" > 
	<img src="<c:url value='/images/bird.jpg' />" width=200 height=200/></a></td>
	<td><a href="<c:url value='/adopt/listAdopt'> <c:param name='kind' value='k7' /> </c:url>" > 
	<img src="<c:url value='/images/hamster.jpg' />" width=200 height=200 /></a></td>
	<td><a href="<c:url value='/adopt/listAdopt'> <c:param name='kind' value='k3' /> </c:url>" > 
	<img src="<c:url value='/images/hedgehog.jpg' />"  width=250 height=250 /></a></td>
	<td><a href="<c:url value='/adopt/listAdopt'> <c:param name='kind' value='k4' /> </c:url>" > 
	<img src="<c:url value='/images/reptile.png' />" width=200 height=200 /></a></td>
</tr>
</table>
</center>
</body>
</html>