<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>form.jsp</title>
<s:head theme="xhtml" />
<sx:head parseContent="true"/>
 <script src="<%=request.getContextPath()%>/js/previewImage.js"></script>
</head>
<body onLoad="setValue()"><br><!--Date Time picker  -->

	
		<h1>����޲z<font color="blue"><b></b></font></h1>
		
		<s:form action="myAction" namespace="/myNamespace" enctype="multipart/form-data">
 			    <s:textfield name="productVO.pdnumber" label="���~�Ǹ�"/>
			    <s:textfield name="productVO.pdname"   label="���~�W��" />
			    <s:textfield name="productVO.discount" label="�馩"/>
			    <s:textarea name="productVO.description" label="���~����" rows="10" cols="50"/>
			    <sx:datetimepicker type="date"  name="productVO.valdateto"  label="���Ĵ���"  displayFormat="yyyy-MM-dd"   id="picker1"  language="zh-tw"  cssStyle="background:cyan ;  font-size:13.5px"/>
			    <s:file name="fileUpload" label="�Ϥ��W��" size="20" onchange="PreviewImage(this)"/>			    
			    <s:submit value="�e�X" method="addProduct" />
			    
		<td class="tdLabel">�W�ǹw��:</td>
	   
	      
	            <td><s:div id="imgPreview"  cssStyle="width:133px; height:100px;overflow:hidden;"></s:div></td>
	         
	    
		</s:form>
		

 <script type="text/javascript">
		function setValue() {
			var picker1 = dojo.widget.byId("picker1");
			if (picker1.getValue() == "")
				picker1.setValue(new Date()); //Date value  //picker.setValue('2007-01-01');  //string value
		}
	</script>
</body>
</html>