// 2.鼠标移动下拉和收缩
$(function() {
		$("#change_bg").hover(function() {
			$("#change_style_menu").slideToggle(800);
		}, function() {
			$("#change_style_menu").slideUp(4000);
		})
	});

$(document).ready(function(){
	//focusblur
    jQuery.focusblur = function(focusid) {
		var focusblurid = $(focusid);
		//获取输入框中默认的值
		var defval = focusblurid.val();
		
		//获取焦点时候
        focusblurid.focus(function(){
        //获取输入框中当前值
		 var thisval = $(this).val();
		 	//输入框值为默认值，置为空
			if(thisval==defval){
                $(this).val("");
            }
        });
        //失去焦点时候
        focusblurid.blur(function(){
        //获取输入框中当前值
		 var thisval = $(this).val();
		 //输入框值为空，置为默认值
		 if(thisval==""){
                $(this).val(defval);
                $(this).css("background-color","#FDF4F4");
                //展示后面的错误提醒
                $("#error_tips").css("display","block");;
                $("#error_tips").val("请输入用户名");
                $("#error_tips").css("font-color","red");
                $("#error_tips").css("border","red");
            }
        });
        
    };
/*下面是调用方法*/
    $.focusblur("#ipt_username");
});

