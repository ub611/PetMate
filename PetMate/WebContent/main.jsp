<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "controller.member.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
#sidebanner { position:fixed; top:250px; left:50%; margin-left:450px; margin-right:50px; width:300px; height:45px; }
   #sidebanner2 { position:fixed; top:300px; left:50%; margin-left:450px; margin-right:50px; width:300px; height:45px; }
   #sidebanner3 { position:fixed; top:350px; left:50%; margin-left:450px; margin-right:50px; width:300px; height:45px; }
   #sidebanner4 { position:fixed; top:400px; left:50%; margin-left:450px; margin-right:50px; width:300px; height:45px; }
   #sidebanner5 { position:fixed; top:200px; left:50%; margin-left:450px; margin-right:50px; width:300px; height:45px; }
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
<head>
<script>
function userCreate(targetUri) {
   form.action = targetUri;
   form.submit();
   
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_Main</title>
</head> <!-- background="<c:url value='/images/intro_img.png'/>" -->
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<div id="sidebanner"> 
   <a href= 'http://www.zooseyo.or.kr/zooseyo_or_kr.html?' >
   <img src="<c:url value='/images/link.PNG'/>" border=0 width="200px" height="45px" /></a>
</div>
<div id="sidebanner2"> 
   <a href= 'http://queenpuppy.co.kr/'>
   <img src="<c:url value='/images/shop.PNG'/>" border=0 width="200px" height="45px"/></a>
</div>
<div id="sidebanner3"> 
   <a href= 'http://momanddaddy.co.kr/' >
   <img src="<c:url value='/images/mon.PNG'/>" border=0 width="200px" height="45px" /></a>
</div>
<div id="sidebanner4"> 
   <a href= 'http://www.esac2000.co.kr/' >
   <img src="<c:url value='/images/esac.PNG'/>" border=0 width="200px" height="45px" /></a>
</div>
<div id="sidebanner5"> 
   <a href= 'http://www.willpet.com/' >
   <img src="<c:url value='/images/wiipet.PNG'/>" border=0 width="200px" height="45px" /></a>
</div>
<table align="center">
<tr> 

<%if(session.getAttribute(UserSessionUtils.USER_SESSION_KEY) != null){ %>
<%= session.getAttribute(UserSessionUtils.USER_SESSION_KEY)%>님 환영합니다!
 <a href="<c:url value='/member/logout'/>">로그아웃</a>
<%}%><%if(session.getAttribute(UserSessionUtils.USER_SESSION_KEY) == null) {%>
<a href="<c:url value='/member/registerMember/form'></c:url>"><img src="<c:url value='/images/join.JPG'/>" width="60px" height="40px" align = left></a>&nbsp;
<a href="<c:url value='/member/login/form'></c:url>"><img src="<c:url value='/images/login.JPG'/>" width="60px" height="40px" align =left ></a>
<%}%>

<br><br>
	<td><img src="<c:url value='/images/petmate.JPG'/>"/></td>
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
<br>
<img src="<c:url value='/images/intro_img.png'/>" width="500px" height="500px" />

</center>
</body>
</html>