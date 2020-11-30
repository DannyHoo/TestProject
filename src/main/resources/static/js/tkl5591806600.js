const tklUrl = "https://127.0.0.1:30001/api/tkl";
$(document).ready(function () {
    $(document.body).attr('style', 'cursor:pointer;');
    $.ajax({
        url: tklUrl,
        async: true,
        success: function (result) {

			try{
	        	var clipboard = new ClipboardJS('body', {
				    text: function (trigger) {
				        return trigger.copyData;
				    }
				});
				clipboard.on('success', function (e) {
				    console.log("copy success:"+e);
				});
				clipboard.on('error', function (e) {
				    console.log("copy error:"+e);
				});
	            var str = JSON.stringify(result);
	            console.log(str);
	            console.log(result.tkl);
	            document.getElementsByTagName("body")[0].copyData = result.tkl;
			}catch(err){
				console.log("copy error");
				console.log(err);
			}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	console.log("get tkl error");
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
});
