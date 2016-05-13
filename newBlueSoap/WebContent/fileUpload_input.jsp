<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>檔案上傳 - fileUpload.jsp</title>
    <s:head/>
    <script src="<%=request.getContextPath()%>/js/previewImage.js"></script>
</head>

<body background="images/cnvbkgnd.jpg"><br>

    <table border='1' cellpadding='5' cellspacing='0' width='500'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3> Struts2 <font color="red">File Upload</font></h3></td>
			<td><img src="images/struts-black-Web.png" border="0"></td></tr></table>

	<h3>This is the Home page for Struts2 <font color="red">File Upload</font></h3>

    <s:actionerror/><!-- struts.messages.upload.error.SizeLimitExceededException: 請求超出允許總大小的限制！ -->

	<s:form action="myAction" namespace="/myNamespace" enctype="multipart/form-data">
		<s:textfield name="productVO.pdnumber" label="產品序號" value="00001"/>
		<s:textfield name="productVO.pdname"   label="產品名稱" />
        <s:file name="fileUpload" label="檔案上傳" size="20" onchange="PreviewImage(this)" /> <!-- name="fileUpload" fileUpload與Action中的暫時File物件變數名稱要一致 -->
		<s:file name="fileUpload" label="檔案上傳" size="20" onchange="PreviewImage2(this)"/> <!-- name="fileUpload" fileUpload與Action中的暫時File物件變數名稱要一致 -->
		<sx:datetimepicker type="date"  name="productVO.valdatefrom"  label="雇用日期"  displayFormat="yyyy-MM-dd"   id="picker1"  language="zh-tw"  cssStyle="background:cyan ;  font-size:13.5px"/>
		<s:submit value="送出上傳" align="center" method="addProduct"/>
		
		<td class="tdLabel">上傳預覽:</td>
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

