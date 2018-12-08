function ss() {
		var i = document.getElementById("upHomeWork");
		
		if (i == 'none') {
			document.getElementById('upHomeWork').style.display = 'block';
			
		} else {
			document.getElementById('upHomeWork').style.display = 'none';
			
			
		}
		
	}

//修改密码
subBox = document.getElementsByClassName('ex-acSubmit')[0],
subBut = subBox.getElementsByClassName('ex-sub')[0],
updatePwd=document.getElementsByClassName('updatePwd')[0] 
updatePwd.onclick=function(){
	addBut.style.display='block';
	
}

subBut.onclick = function(){
	console.log(reg1.test(date.value),reg2.test(num.value))
	if (!reg1.test(date.value) || !reg2.test(num.value)) {
		alert('创建失败')
		return;
	}
	
	alert('生成二维码成功，请在 D:/活动/活动二维码 中查看');
	subBox.submit();
	
	
}
