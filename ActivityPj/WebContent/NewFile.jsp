<html >
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>

 
</head>
 
<body>
<%=request.getContextPath()%> 
   <table style="width: 100%">
        <tr>
            <h2>文件导入</h2>
            <td align="center">  
           <form id="importForm" name="importForm" enctype="multipart/form-data" method="post" action="<%=request.getContextPath()%>/importExcel.do?method=importExcel">
                文件:<input type="file" id="importContainerFile" name="importContainerFile" style="width:220px;" accept=".xlsm,.xls,.xlsx"/>
            </form>
            </td>
        </tr>

    <tr>
        <td align="center">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-import'" onclick="javascript:importExcel();">导入</a> 
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:closemyImportFileDialog();">取消</a>
        </td>
    </tr>
</table>

</body>
<script type="text/javascript">
function importExcel(){
	alert("进入importExcel j s函数")
    var formData = new FormData($( "#importForm" )[0]);  
    var filepath = encodeURI(encodeURI($("#importContainerFile").val()));
    var extname = filepath.substring(filepath.lastIndexOf(".")+1,filepath.length);//文件后缀
    extname = extname.toLowerCase();//处理了大小写
    if(extname!= "xls"){
        alert("导入文件格式不对,必须以.xls结尾！");
        return;
    }
   
    $.ajax({  //ajax方式提交表单  
    	
        url: '<%=request.getContextPath()%>/importExcel.do?method=importExcel',
        type: 'post',  
        dataType: 'json',
        data: formData,  
        async: false,  
        cache: false,  
        contentType: false,  
        processData: false,  
        success: function (data) {  
            $.messager.alert("操作提示",'上传成功!',"info");
        }
    });  
}

</script>
</html>
