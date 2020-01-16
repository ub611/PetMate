<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import= "java.text.SimpleDateFormat" %>
<%@ page import= "java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   @SuppressWarnings("unchecked") 
   List<FestivalDTO> festivalList = (List<FestivalDTO>)request.getAttribute("festivalList");
   @SuppressWarnings("unchecked")
   List<MemberDTO> memberList = (List<MemberDTO>)request.getAttribute("memberList");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_축제 검색리스트</title>
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
 <table style="width:100%">
   <tr>
   <td height="22" align="center">&nbsp;&nbsp;<b>축제 상세 페이지</b></td>
   </tr>
</table>
<br>
 <table style="background-color: #353535" align = 'center'>
         <tr height="40">
         <td width="200" align="center" bgcolor="#FFFFF" align = "center"><b>축제 이름</b></td>
         <td width = "200" align = "center" bgcolor = "#FFFFF"><b>축제 날짜</b></td> 
          <td width = "200" align = "center" bgcolor = "#FFFFF"><b>축제 장소</b></td> 
        </tr>
        
  <%
     int nYear;
     int nMonth;
     int nDay;
     String fontcolor = "black";

     // 현재 날짜 구하기
     Calendar calendar = new GregorianCalendar(Locale.KOREA);
     nYear = calendar.get(Calendar.YEAR);
     nMonth = calendar.get(Calendar.MONTH) + 1;
     nDay = calendar.get(Calendar.DAY_OF_MONTH);
     
     String today = nYear +"-" + nMonth + "-" + nDay;
     
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      Date beginDate = formatter.parse(today);

      System.out.println(beginDate);
      
        if(festivalList != null){
            Iterator<FestivalDTO> festivalIter = festivalList.iterator();
            
            while(festivalIter.hasNext()){
               FestivalDTO f = (FestivalDTO)festivalIter.next();
               String tmpd = f.getFestival_date().toString();
                Date endDate = formatter.parse(tmpd);
                System.out.println(endDate);
                
                long diff = endDate.getTime() - beginDate.getTime();
                
                System.out.println(diff);
                
                if(diff < 0)
                   fontcolor = "#b3b3b3";
                else if(diff <= 604800000)
                   fontcolor = "red";
                else 
                   fontcolor = "black";
  %>
        <tr>
        <td width ="200" align = "center"  style = "color:<%= fontcolor %>" bgcolor = "ffffff"><%= f.getFestival_title() %>
        </td>
        <td width ="200" align = "center" style = "color:<%= fontcolor %>" bgcolor = "ffffff"><%= f.getFestival_date() %>
         </td>
        <td width ="200" align = "center" style = "color:<%= fontcolor %>" bgcolor = "ffffff"><%= f.getFestival_place() %>
         </td>
         </tr>
    <%
              }
        }
    %>
        </table>
        
<br>
  <%
        if(memberList != null){
            Iterator<MemberDTO> memberIter = memberList.iterator();
  %>
       <table style="width:100%">
         <tr>
         <td height="22" align="center">&nbsp;&nbsp;<b>나와 같은 지역에 사는 펫메이트 알아보기</b></td>
         </tr>
      </table>
      <br>
        <table style="background-color: #353535" align = 'center'>
         <tr height="40">
         <td width="200" align="center" bgcolor="#FFFFF" align = "center"><b>펫메이트의 아이디</b></td>
         <td width = "200" align = "center" bgcolor = "#FFFFF"><b>펫메이트의 이름</b></td> 
        </tr>
  <% 
            while(memberIter.hasNext()){
               MemberDTO m = (MemberDTO)memberIter.next();
  %>
        <tr>
        <td width ="200" align = "center" bgcolor = "ffffff"><%= m.getUserID() %>
        </td>
        <td width ="200" align = "center" bgcolor = "ffffff"><%= m.getName() %>
         </td>
         </tr>
    <%
              }
        }
    %>
        </table>
        <br><br><br>
</body>
</html>