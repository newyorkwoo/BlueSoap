<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.io.*"%>
<html>
<head><title>�ɮפW�� - fileUpload_success.jsp</title></head>

<body background="images/cnvbkgnd.jpg">
<H1>Struts 2 �ɮפW��</H1>
<HR>
<H2>�ɮפW��</H2>

<% 
   File fileUpload = (File)request.getAttribute("productVO.fileUpload");
   String fileUploadContentType = (String)request.getAttribute("fileUploadContentType");
   String fileUploadFileName = (String)request.getAttribute("fileUploadFileName");
%>
<UL>
	    <LI>�s��:<s:property value="productVO.pdnumber"/> </LI>
        <LI>�W��:<s:property value="productVO.pdname"/>   </LI>
        <LI>����:<s:property value="productVO.description"/>   </LI>
        <LI>���Ĵ���:<s:property value="productVO.valdateto"/> </LI>
        <LI>�馩:<s:property value="productVO.discount"/>   </LI>
<%-- <% for (int i=0 ; i<fileUpload.length ; i++) { %> --%>
     <LI style="line-height: 150%"><b>�ɮצW�� :</b>        <%= fileUploadFileName%>      </LI>
         <LI style="line-height: 150%"><b>Content Type :</b> <%= fileUploadContentType%>   </LI>
         <LI style="line-height: 150%"><b>File���� :</b>       <%= fileUpload%>              </LI>
         <LI style="line-height: 150%"><b>�W�ǹϹ� :</b><br>
         <img src='<%=request.getContextPath()%>/rsc/image/<%=fileUploadFileName%>'><br><br><br></LI></UL>
<%-- <%}%> --%>
</body>
</html>