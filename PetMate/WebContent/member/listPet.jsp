<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	@SuppressWarnings("unchecked") 
   	List<PetDTO> petList = (List<PetDTO>)request.getAttribute("petList");
	String curUserId = (String)request.getAttribute("curUserId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_마이펫 리스트</title>
<script>
function petRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
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
<!-- listAdopt form  -->
<form name = "f" method = "post" action = "<c:url value='/adopt/addAdopt/form'/>">
  <table style="width:100%" align="center">
   <tr>
     <td>
       <table style="width:100%">
        <tr>
         <td height="22" align="center"><b>마이펫 리스트</b></td>
        </tr>
       </table>  
       <br>     
       <table style="background-color:#353535" align = 'center'>
         <tr height="30">
         <td width="150" align="center" bgcolor="#FFFFF" align = "center"><b>펫 이름</b></td>
         <td width = "150" align = "center" bgcolor = "#FFFFF"><b>펫 종류</b></td> 
         <td width = "150" align = "center" bgcolor = "#FFFFF"><b>펫 나이</b></td> 
         <td width = "150" align = "center" bgcolor = "#FFFFF"><b>펫 성별</b></td> 
        </tr>
        
  <%
        if(petList != null){
            Iterator<PetDTO> petIter = petList.iterator();
            
            while(petIter.hasNext()){
               PetDTO pet = (PetDTO)petIter.next();
               String pet_Id = String.valueOf(pet.getPet_ID());
  %>
        <tr> <!-- 사용자 ID 클릭시 상세보기  -->
        <td width ="150" align = "center" bgcolor = "ffffff">
        <a href="<c:url value='/member/updatePetForm'>
        <c:param name='petId' value ='<%= String.valueOf(pet.getPet_ID()) %>'/>
     	<c:param name='userId' value ='<%= pet.getUserID() %>' /></c:url>">
           <%= pet.getPet_name() %></a>&nbsp;    
        </td>
      
         <td width ="150" align = "center" bgcolor = "ffffff">
        
        <c:set var="kind" value="<%=pet.getKind_ID() %>"/>     
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
          <td width ="150" align = "center" bgcolor = "ffffff">
           <%= pet.getPet_age() %>          
        </td>
         <td width ="150" align = "center" bgcolor = "ffffff">
           <%= pet.getPet_gender() %>     
        </td>
        </tr>
    <%
              }
        }
    %>
        </table>
       <br>   
     
     </td>
   </tr>
  </table>  
</form>
</body>
</html>