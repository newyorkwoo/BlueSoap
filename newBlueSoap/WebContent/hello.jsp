<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- request.setCharacterEncoding("UTF-8"); --%>  <%-- 在Struts 2 中已可省略 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>hello.jsp</title>
<s:head theme="xhtml" /> <!--預設為 xhtml --> <!--theme 可為 xhtml 或 simple 或 css_xhtml --> 
</head>
<body>
<h3>我是展示層 (view) hello.jsp</h3>
<UL>

        
        <LI> 產品序號【OGNL取值】: <s:property value="productVO.pdnumber"/> </LI>
        <LI> 產品名稱【OGNL取值】: <s:property value="productVO.productname"/>   </LI>
        <LI> 產品名稱【OGNL取值】: <s:property value="productVO.valdatefrom"/>   </LI>
 </UL>
</body>
</html>
