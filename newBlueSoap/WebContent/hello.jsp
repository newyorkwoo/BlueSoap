<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- request.setCharacterEncoding("UTF-8"); --%>  <%-- �bStruts 2 ���w�i�ٲ� --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>hello.jsp</title>
<s:head theme="xhtml" /> <!--�w�]�� xhtml --> <!--theme �i�� xhtml �� simple �� css_xhtml --> 
</head>
<body>
<h3>�ڬO�i�ܼh (view) hello.jsp</h3>
<UL>

        
        <LI> ���~�Ǹ��iOGNL���ȡj: <s:property value="productVO.pdnumber"/> </LI>
        <LI> ���~�W�١iOGNL���ȡj: <s:property value="productVO.productname"/>   </LI>
        <LI> ���~�W�١iOGNL���ȡj: <s:property value="productVO.valdatefrom"/>   </LI>
 </UL>
</body>
</html>
