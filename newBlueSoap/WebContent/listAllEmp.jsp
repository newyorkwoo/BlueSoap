<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.shop.model.*"%>
<%-- 此頁採用 Struts2 的 iterator 與 OGNL 取值 --%>

<%
    ProductService pdSvc = new ProductService();
    List<ProductVO> list = pdSvc.getAll();
    request.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
</head>
<body bgcolor='white'>
<b><font color=red>此頁採用 Struts2 的 iterator 與 OGNL 取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td><h3>所有員工資料 - ListAllEmp.jsp</h3>
		          <a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td></tr></table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>產品編號</th>
		<th>產品名稱</th>
		<th>有效日期</th>
		<th>折扣</th>
		<th>說明</th>

	</tr>
<s:iterator value="#request.list">
		<tr align='center' valign='middle'>
			<td><s:property value="pdnumber" /></td>
			<td><s:property value="pdname" /></td>
			<td><s:property value="valdateto" /></td>
			<td><s:property value="discount" /></td>
			<td><s:property value="description" /></td>

			<%-- <td>
			    <s:form action="getOne_For_UpdateEmp" namespace="/emp"  method="getOne_For_Update">
			        <s:submit value="修改" />
			        <input type="hidden" name="empno" value="<s:property value="empno" />">
			    </s:form>
			</td>
			<td>
			    <s:form action="deleteEmp" namespace="/emp"  method="delete">
			        <s:submit value="刪除" />
			        <input type="hidden" name="empno" value="<s:property value="empno" />">
			    </s:form>
			</td> --%>
		</tr>
</s:iterator>
</table>

</body>
</html>
