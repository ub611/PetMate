<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
      AdoptDTO adopt = (AdoptDTO)request.getAttribute("adopt");
	  List<AdoptCommentDTO> com = (List<AdoptCommentDTO>)request.getAttribute("adoptList");
	  String curUserId = (String)request.getAttribute("curUserId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>PetMate_�Ծ�/�о� ����������</title>
<script>
function adoptRemove() {
	return confirm("���� �����Ͻðڽ��ϱ�?");		
}
function priceList(targetUri) {
	   form.action = targetUri;
	   form.submit();
}
</script>
</head>
<body bgcolor = #FFFFFF>
<br>
<table align="center">
<tr> 
   <td><h1><font color=#FF5E00 size="24px">PetMate</font></h1></td> 
   <td><a href="<c:url value='/main/form'/>"><img src="<c:url value='/images/chat_caticon.png' />"></a>
</tr>
</table>
<br>
 <table style="width:100%">
   <tr>
   <td height="22" align="center">&nbsp;&nbsp;<b>�Ծ�/�о� ����������</b></td>
   </tr>
</table>
<br>
<form name="form" method="POST" action = "<c:url value='/adopt/listAdopt'/>">
<input type="hidden" name="kind" value="<%= adopt.getAdopt_kind() %>"	/>
<table style="background-color: #353535" align="center">
   <tr height="30">
        <td width="150" align="center" bgcolor="#FFFFF"><b>����ھ��̵�</b></td>
        <td width="150" bgcolor="ffffff" style="padding-left:10">
        &nbsp;<%= adopt.getUserID() %></td>
      </tr>
      <tr height="30">
        <td width="150" align="center" bgcolor="#FFFFF"><b>pet ����</b></td>
        <td width="250" bgcolor="ffffff" style="padding-left:10">
            &nbsp;<%= adopt.getAdopt_age() %></td>
      </tr>
    <tr height="30">
        <td width="150" align="center" bgcolor="#FFFFF"><b>pet ����</b></td>
        <td width="250" bgcolor="ffffff" style="padding-left:10">
             <c:set var="kind" value="<%=adopt.getAdopt_kind() %>"/>
        <c:choose>
           <c:when test="${kind == 'k1'}"> 
           		������
           </c:when>
           <c:when test="${kind == 'k2'}"> 
        		  �����
           </c:when>
           <c:when test="${kind == 'k3'}"> 
           		����ġ
             </c:when>
             <c:when test="${kind == 'k4'}"> 
           		�����
           </c:when>
             <c:when test="${kind == 'k5'}"> 
          		 �䳢
           </c:when>
             <c:when test="${kind == 'k6'}"> 
         		  ��
           </c:when>
             <c:when test="${kind == 'k7'}"> 
           		�ܽ���
           </c:when>
        </c:choose>
      </tr>
      <tr height="30">
       <td width="150" align="center" bgcolor="#FFFFF"><b>pet ����</b></td>
       <td width="250" bgcolor="ffffff" style="padding-left:10">
            &nbsp;<%= adopt.getAdopt_gender() %> </td>
      </tr>
      <tr height="30">
        <td width="150" align="center" bgcolor="#FFFFF"><b>����</b></td>
        <td width="250" bgcolor="ffffff" style="padding-left:10">
            &nbsp;<%= adopt.getAdopt_price() %>��</td>
      </tr>
      <tr height="30">
        <td width="150" align="center" bgcolor="#FFFFF"><b>����</b></td>
        <td width="250" bgcolor="ffffff" style="padding-left:10">
        <% if(adopt.getIs_adopted() == 0){ %>
            &nbsp;������
        <% } else { %>
            &nbsp;�Ϸ�
        <% } %>
        </td>
      </tr>
</table>
<br>
<center>
	  <a href="<c:url value='/adopt/updateAdoptForm'>
	 	<c:param name='adoptId' value ='<%= String.valueOf(adopt.getAdopt_ID()) %>'/>
     	<c:param name='userId' value ='<%= adopt.getUserID() %>' />
     </c:url>">����</a> &nbsp; 
     <a href="<c:url value='/adopt/deleteAdopt'>
	 	<c:param name='adoptId' value ='<%= String.valueOf(adopt.getAdopt_ID()) %>'/>
     	<c:param name='userId' value ='<%= adopt.getUserID() %>' />
     </c:url>" onclick="return adoptRemove();">����</a> &nbsp;
<input type = "submit" value="���" />
</center>
  		<table align = "center">
  		<br>
  		<center><h4>��� ����Ʈ</h4></center>
  		 <%
        if(com != null){
            Iterator<AdoptCommentDTO> comIter = com.iterator();
            
            while(comIter.hasNext()){
            	AdoptCommentDTO comment = (AdoptCommentDTO)comIter.next();
  %>
  		<tr><td><%= comment.getUserid() %></td>
  		<td><%= comment.getContent() %></td>
  		<td><%= comment.getTime() %></td>
  		</tr>
  <%
            }
        }
  %>
		<tr><td  align="center">
		<center>
     	<form name="f" method="POST">
     		<input type="hidden" id="adoptId" name="adoptId" value='<%= String.valueOf(adopt.getAdopt_ID()) %>'/>
     		<input type="hidden" id="userId" name="userId" value='<%= adopt.getUserID() %>'/>
     		<input type="text" id="comment" name="comment" />
     		<input type="button" value="��� �Է�" onClick= "priceList('<c:url value='/comment/adoptRegister' />')" />
     	</form>
     	</center>
		</td>
		</tr>
		</table>
</form>
<br><br><br>
</body>
</html>