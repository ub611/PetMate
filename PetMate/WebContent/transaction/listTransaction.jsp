<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	@SuppressWarnings("unchecked") 
   	List<SellDTO> sellList = (List<SellDTO>)request.getAttribute("sellList");
	String curUserId = (String)request.getAttribute("curUserId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script>

function priceList(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>
<title>PetMate_��ǰ�ŷ�������</title>
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
<body>
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

<form name = "form" method = "post" action = "<c:url value='/transaction/checkLogin'/>">
<%-- <c:url value='/transaction/registerTransaction/form'/> --%>
  <table style="width:100%" align="center">
   <tr>
     <td>
       <table style="width:100%">
        <tr>
         <td height="22" align="center"><b>��ǰ�ŷ� ����Ʈ</b></td>
        </tr>
       </table>
       <table style="width:80%">
        <tr>
         <td height="22" align="right">
          <a href="<c:url value='/transaction/view/price' /> ">���ݳ�����</a>&nbsp;
          <a href="<c:url value='/transaction/view/highprice' /> ">���ݳ�����</a>&nbsp;
		</td>
        </tr>
       </table>
       <br>     
       <table style="background-color:#353535" align = 'center'>
         <tr height="30">
         <td width="200" align="center" bgcolor="#FFFFF" align = "center"><b>����</b></td>
         <td width = "200" align = "center" bgcolor = "#FFFFF"><b>�ۼ���</b></td> 
         <td width = "200" align = "center" bgcolor = "#FFFFF"><b>����</b></td> 
         <td width = "200" align = "center" bgcolor = "#FFFFF"><b>����</b></td> 
        </tr>
        
  <%
        if(sellList != null){
            Iterator<SellDTO> sellIter = sellList.iterator();
            
            while(sellIter.hasNext()){
               SellDTO sell = (SellDTO)sellIter.next();
  %>
  		<tr>
  		 <td width ="150" align = "center" bgcolor = "ffffff">
  		 	<a href = "<c:url value='/comment/list'>
  		 		 <c:param name='sellId' value ='<%= String.valueOf(sell.getSell_ID()) %>'/>
                 <c:param name='userId' value ='<%= sell.getUserID() %>' />
                 </c:url>">
           <%= sell.getTitle() %>    
           </a>	       
        </td>
         <td width ="150" align = "center" bgcolor = "ffffff">
           <%= sell.getUserID() %>          
        </td>
         <td width ="150" align = "center" bgcolor = "ffffff">
           <%= sell.getItem_price() %>��        
        </td>
         <td width ="150" align = "center" bgcolor = "ffffff">
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
	<%
	            }    
	    }
  %>
       </table>
       <br>   
       <table style="width:100%">
		<tr>
		<td>
		<c:if test="${NotLogin}">
		<center><font color="red"><c:out value="${exception}" /></font></center>
		</c:if>
		</td>
		</tr></table>
       <table align = "center">
        <tr><td> <input type = "submit" value = "�۾���" /></td>
        	<input type="hidden" name="command" id="command"/>
          </tr>
       </table>
     </td>
   </tr>
  </table>  
</form>
<br><br><br>
</body>
</html>