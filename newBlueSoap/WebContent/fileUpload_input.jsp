<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>�ɮפW�� - fileUpload.jsp</title>
    <s:head/>
    <script src="<%=request.getContextPath()%>/js/previewImage.js"></script>
</head>

<body background="images/cnvbkgnd.jpg"><br>

    <table border='1' cellpadding='5' cellspacing='0' width='500'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3> Struts2 <font color="red">File Upload</font></h3></td>
			<td><img src="images/struts-black-Web.png" border="0"></td></tr></table>

	<h3>This is the Home page for Struts2 <font color="red">File Upload</font></h3>

    <s:actionerror/><!-- struts.messages.upload.error.SizeLimitExceededException: �ШD�W�X���\�`�j�p������I -->

	<s:form action="myAction" namespace="/myNamespace" enctype="multipart/form-data">
		<s:textfield name="productVO.pdnumber" label="���~�Ǹ�" value="00001"/>
		<s:textfield name="productVO.pdname"   label="���~�W��" />
        <s:file name="fileUpload" label="�ɮפW��" size="20" onchange="PreviewImage(this)" /> <!-- name="fileUpload" fileUpload�PAction�����Ȯ�File�����ܼƦW�٭n�@�P -->
		<s:file name="fileUpload" label="�ɮפW��" size="20" onchange="PreviewImage2(this)"/> <!-- name="fileUpload" fileUpload�PAction�����Ȯ�File�����ܼƦW�٭n�@�P -->
		<sx:datetimepicker type="date"  name="productVO.valdatefrom"  label="���Τ��"  displayFormat="yyyy-MM-dd"   id="picker1"  language="zh-tw"  cssStyle="background:cyan ;  font-size:13.5px"/>
		<s:submit value="�e�X�W��" align="center" method="addProduct"/>
		
		<td class="tdLabel">�W�ǹw��:</td>
	    <td>
	       <table>
	         <tr>
	            <td><s:div id="imgPreview"  cssStyle="width:133px; height:100px;overflow:hidden;"></s:div></td>
	            <td><s:div id="imgPreview2" cssStyle="width:133px; height:100px;overflow:hidden;"></s:div></td>
	          </tr>
	        </table>
	    </td>
	</s:form>

</body>
</html>

