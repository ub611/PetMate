<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	SellDTO sell = (SellDTO)request.getAttribute("sell");
	List<SellCommentDTO> com = (List<SellCommentDTO>)request.getAttribute("comList");
	String curUserId = (String)request.getAttribute("curUserId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_��ǰ�ŷ� ��������</title>
<script>
function priceList(targetUri) {
	   form.action = targetUri;
	   form.submit();
}</script>
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
<body>
<form name="form" method="POST" action="<c:url value='/member/registerSell/form' />">
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
            <%= sell.getTitle() %>
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>����</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
	           <c:set var="kind" value="<%= sell.getItem_kind_ID() %>"/>
 			<c:set var="kind" value="<%=sell.getItem_kind_ID() %>"/>
        <c:choose>
        	<c:when test="${kind == 'ik1'}"> 
        	�峭��
        	</c:when>
        	<c:when test="${kind == 'ik2'}"> 
        	����
        	</c:when>
        	<c:when test="${kind == 'ik3'}"> 
        	��å��ǰ
       		</c:when>
       		<c:when test="${kind == 'ik4'}"> 
        	��
        	</c:when>
       		<c:when test="${kind == 'ik5'}"> 
        	�Ƿ�
        	</c:when>
        </c:choose>  
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>�� ����</b></td>
         <td width="500" bgcolor="ffffff" style="padding-left: 10">
           <%= sell.getContent() %>
         </td>
        </tr>
          <tr height="40">
         <td width="150" align="center" bgcolor="#FFFFF"><b>����</b></td>
         <td width="250" bgcolor="ffffff" style="padding-left: 10">
            <%= sell.getItem_price() %>��
         </td>
        </tr>
       </table>
       <br>     
      <center>
<input type = "submit" value="���" /> 
</center>
     </td>
    </tr>
  </table>  
   		<table align = "center">
  		<br>
  		<center><h4>��� ����Ʈ</h4></center>
  		 <%
        if(com != null){
            Iterator<SellCommentDTO> comIter = com.iterator();
            
            while(comIter.hasNext()){
            	SellCommentDTO comment = (SellCommentDTO)comIter.next();
  %>
  		<tr><td><%= comment.getUserid() %></td>
  		<td><%= comment.getContent() %></td>
  		<td><%= comment.getTime() %></td>
  		</tr>
  <%
            }
        }
  %>
		<tr>
		<td  align="right">
		<center>
     	<form name="f" method="POST">
     		<input type="hidden" id="sellId" name="sellId" value='<%= String.valueOf(sell.getSell_ID()) %>'/>
     		<input type="hidden" id="userId" name="userId" value='<%= sell.getUserID() %>'/>
     		<input type="text" id="comment" name="comment" />
     		<input type="button" value="��� �Է�" onClick= "priceList('<c:url value='/comment/register' />')" />
     		</form>
     	</center>
		</td>
		</tr>
		</table>
		<br>
		<table style="width:100%">
		<tr>
		<td>
		<c:if test="${NotLogin}">
		<center><font color="red"><c:out value="${msg}" /></font></center>
		</c:if>
		</td>
		</tr></table>
</form>
<br><br><br>
</body>
</html>