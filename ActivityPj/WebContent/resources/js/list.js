//
//function deleteBatch(basePath)
//{
//	
//  $("#mainForm").attr("action",bathPath+"DeleteBatchMessage.do");
//  $("#mainForm").submit();
//}


function deleteBatch(basePath)
{ 
	var form=document.getElementById("mainForm"); 
form.action=basePath+"DeleteBatchMessage.do"; 
form.submit();	
}