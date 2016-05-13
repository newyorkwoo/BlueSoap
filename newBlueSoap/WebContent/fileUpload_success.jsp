<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.io.*"%>
<html>
<head><title>檔案上傳 - fileUpload_success.jsp</title></head>

<body background="images/cnvbkgnd.jpg">
<H1>Struts 2 檔案上傳</H1>
<HR>
<H2>檔案上傳</H2>

<% 
   File fileUpload = (File)request.getAttribute("productVO.fileUpload");
   String fileUploadContentType = (String)request.getAttribute("fileUploadContentType");
   String fileUploadFileName = (String)request.getAttribute("fileUploadFileName");
%>
<UL>
	    <LI>編號:<s:property value="productVO.pdnumber"/> </LI>
        <LI>名稱:<s:property value="productVO.pdname"/>   </LI>
        <LI>說明:<s:property value="productVO.description"/>   </LI>
        <LI>有效期限:<s:property value="productVO.valdateto"/> </LI>
        <LI>折扣:<s:property value="productVO.discount"/>   </LI>
<%-- <% for (int i=0 ; i<fileUpload.length ; i++) { %> --%>
     <LI style="line-height: 150%"><b>檔案名稱 :</b>        <%= fileUploadFileName%>      </LI>
         <LI style="line-height: 150%"><b>Content Type :</b> <%= fileUploadContentType%>   </LI>
         <LI style="line-height: 150%"><b>File物件 :</b>       <%= fileUpload%>              </LI>
         <LI style="line-height: 150%"><b>上傳圖像 :</b><br>
         <img src='<%=request.getContextPath()%>/rsc/image/<%=fileUploadFileName%>'><br><br><br></LI></UL>
<%-- <%}%> --%>
</body>
</html>