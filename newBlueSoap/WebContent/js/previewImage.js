function PreviewImage(imgFile) {

	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if (!pattern.test(imgFile.value)) {
		alert("�u�䴩jpg/jpeg/png/gif/bmp���榡�ɮ�");
		imgFile.focus();
	} else {
		var path;
		if (document.all) { // IE
			imgFile.select();
			imgFile.blur();
			path = document.selection.createRange().text;
			document.getElementById("imgPreview").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""+ path + "\")";// �o��
			// document.getElementById('img1').src = path; // IE �L��
		} else { // FF �� Chrome ��
			path = URL.createObjectURL(imgFile.files[0]);
			document.getElementById("imgPreview").innerHTML = "<img src='"+ path +"'  width='143' height='100'/>";
			// document.getElementById('img1').src = path; // Chrome ����
		}
	}
}

function PreviewImage2(imgFile) {

	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if (!pattern.test(imgFile.value)) {
		alert("�u�䴩jpg/jpeg/png/gif/bmp���榡�ɮ�");
		imgFile.focus();
	} else {
		var path;
		if (document.all) { // IE
			imgFile.select();
			imgFile.blur();
			path = document.selection.createRange().text;
			document.getElementById("imgPreview2").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""+ path + "\")";// �o��
			// document.getElementById('img1').src = path; // IE �L��
		} else { // FF �� Chrome ��
			path = URL.createObjectURL(imgFile.files[0]);
			document.getElementById("imgPreview2").innerHTML = "<img src='"+ path +"'  width='143' height='100'/>";
			// document.getElementById('img1').src = path; // Chrome ����
		}
	}
}
