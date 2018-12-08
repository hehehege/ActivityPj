
  
	function why() {
		 console.log(11);
		var i = document.getElementById("c");
		if (document.getElementById('c').style.display == 'none') {
			document.getElementById('c').style.display = 'block';
		} else {
			document.getElementById('c').style.display = 'none';
		}

	}
	
	
	
	function  stopRelease()
	{
		if(confirm("确认要停止发布此项活动? 一旦停止无法重新发布"))
		{
	    return true;
		}
	else
		{	
		return false;
	}
		
	}
	
	function getImgURL(node) {	
		var imgURL = "";	
		var b=document.getElementById("file").value
		alert(b)
	    try{   
	        var file = null;
	        if(node.files && node.files[0] ){
	        	file = node.files[0]; 
	        	
	        }else if(node.files && node.files.item(0)) {                    			
	        	file = node.files.item(0);  
	        	
	        } 	
	        //Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
	        	
	        try{
	        	//Firefox7.0 
	        	
				imgURL =  file.getAsDataURL();  
				
				//alert("//Firefox7.0"+imgRUL);             			
	        }catch(e){
	        	//Firefox8.0以上                    			
	        	imgRUL = window.URL.createObjectURL(file);
	        	
				//alert("//Firefox8.0以上"+imgRUL);
	        }
	     }catch(e){      //这里不知道怎么处理了，如果是遨游的话会报这个异常           		
	        //支持html5的浏览器,比如高版本的firefox、chrome、ie10
	        if (node.files && node.files[0]) {                    		
	        	var reader = new FileReader(); 
	        	reader.onload = function (e) {                      	        	
	        	    imgURL = e.target.result;  
	        	};
	        	reader.readAsDataURL(node.files[0]); 
	        	
	        }  
	     }
		//imgurl = imgURL;
		
		
		creatImg(imgRUL);
		return imgURL;
	}
	

	
	var pub = document.getElementsByClassName('ex-acPub')[0],
	addBut = document.getElementsByClassName('am-btn-primary')[0],
	look = document.getElementById('chakan'),
	table =document.getElementsByClassName('ManlookActivityBox')[0],
	subBox = document.getElementsByClassName('ex-acSubmit')[0],
	date = subBox.getElementsByClassName('ex-date')[0],
	num = subBox.getElementsByClassName('ex-num')[0],
	subBut = subBox.getElementsByClassName('ex-sub')[0],
	
	
	reg1 =  /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/,
	reg2 = /^\d{1,}\.\d$/;

addBut.style.display='none';
table.style.display='none';

// 发布活动
pub.onclick = function(){
	addBut.style.display='block';
	table.style.display='none';
}




// 查看活动
look.onclick = function(){
	table.style.display='block';
	addBut.style.display='none';
	
	var $acBox = $('.acIdBox')[0];
	var $submit = $('.submit')[0];
	var isOnclick = $('input:radio[name="radio"]:checked').val();
	//样式初始化
	if(isOnclick == 'acOld'){
		$acBox.style.display = 'block';
	}else{
		$acBox.style.display = 'none';
	}

	// acOld 隐藏id
	$('input[value="acOld"]').click(function(){
		isOnclick = $('input:radio[name="radio"]:checked').val();
		console.log('进入acOld'+isOnclick)
		$acBox.style.display = 'block';
		
	})

	// acNew
	$('input[value="acNew"]').click(function(){
		isOnclick = $('input:radio[name="radio"]:checked').val();
		console.log('进入acNew'+isOnclick)
		$acBox.style.display = 'none'
		
	})

	// 文件路径显示
	$('#importContainerFile').change(function(){
	    $('#em').text($('#importContainerFile').val());
	});

	// 导入 我想用jq的click，然而用不起
	$submit.onclick = function(){

	    console.log(isOnclick)
		// 判断是否点击单选按钮
		if (isOnclick) {
			
			importXls();
		}else{
			alert('请选择活动类型')
		}

	}
	

	// 导入xls
	function importXls(){
	    
	    
	    var form = document.getElementById('importForm');
		var acId = document.getElementById('acId').value;
	    var formData = new FormData($( "#importForm" )[0]);  
	    
	    var filepath = encodeURI(encodeURI($("#importContainerFile").val()));
	    var extname = filepath.substring(filepath.lastIndexOf(".")+1,filepath.length);//文件后缀
	    extname = extname.toLowerCase();//处理了大小写


	    // 判断id名 (如果是老活动，就判断id)
	    if((acId.value == '' || /\s/.test(acId.value)) && isOnclick == 'acOld'){
	    	alert("请输入正确的活动id!");
	        return;
	    }
	    
	    // 判断xls
	    
	    if(extname!= "xls" || !filepath){
	        alert("导入文件格式不对,必须以.xls结尾！");
	        return;
	    }
	    $.ajax({  //ajax方式提交表单  
	    	
	    	url: '/ActivityPj/ajax.do',
	        type: 'GET',  
	        dataType: 'json', 
	        success: function (data) {
	        	function hasId(){
	        		for (key in data){
	        			console.log(data[key]);
		            	if(data[key] == acId){
		            		console.log('xiayibu')
		            		return true;
		            	}
		            }
		            return false;
	        	}

	        	if (!hasId() && isOnclick == 'acOld') {
	        		alert('没这ID')
	        		return;
	        	}
	        	
	        	form.submit();

	        }
	    });  
	} 
 
    
}
	

// 扫二维码
subBut.onclick = function(){
	console.log(reg1.test(date.value),reg2.test(num.value))
	if (!reg1.test(date.value) || !reg2.test(num.value)) {
		alert('创建失败')
		return;
	}
	
	alert('生成二维码成功，请在 D:/活动/活动二维码 中查看');
	subBox.submit();
	
	
}


 
	
	
	

	

		 
		 /*
		  * $.ajax({  //ajax方式获取id 
    	
        url: '/ActivityPj/ajax.do',
        type: 'GET',  
        dataType: 'json',
        success: function (data) {
        	console.log(typeof data);
        	var sub = document.getElementsByClassName('submit')[0];
        	
        	
        	sub.onclick = function() {
            	console.log('onclick');
        		
            	var form = document.getElementById('importForm');
        		var acId = document.getElementById('acId').value;
        		var acId = 1;
        	    var formData = new FormData($( "#importForm" )[0]);  
        	    
        	    var filepath = encodeURI(encodeURI($("#importContainerFile").val()));
        	    var extname = filepath.substring(filepath.lastIndexOf(".")+1,filepath.length);//文件后缀
        	    extname = extname.toLowerCase();//处理了大小写
        	

        	    function hasId(){
            		if(typeof data =="object"){
            			
        				for (key in data){
                        	if(data[key] == acId){
                        		console.log('object:id正确')
                        		return true;
                        	}
                        }
            		}else{

            			for(var i=0;i<data.length;i++){
                        	if(data[i] == acId){
                        		console.log('arr:id正确')
                        		return true;
                        	}
            			}
            		}
            		console.log('hasId:no')
                    return false;
            	}

            	if (!hasId()) {
            		alert('没这ID')
            		return false;
            	}

        	    if(extname!= "xls" || extname==''){
        	        alert("导入文件格式不对,必须以.xls结尾！");
        	        return false;
        	    }
        		 
        	    

        	    form.submit();

        	

        	    

            }
        }
    });  
		  * 
		  */

	 	
	
	
	
	
	
