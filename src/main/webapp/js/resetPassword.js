var oldpass_value = 0;
var newpass_value = 0;
var cfpass_value = 0;

//处理旧密码的输入
function oldpassIn(){
	document.getElementById("nulloldpass").style.display="none";
	document.getElementById("shortoldpass").style.display="none";
	document.getElementById("printoldpass").style.display="";
};
function oldpassOut(){
	document.getElementById("printoldpass").style.display="none";
	var oldpass = document.getElementById("oldpassword");
	if(oldpass.value == ""){
		document.getElementById("nulloldpass").style.display="";
		oldpass_value = 0;
	}else if(oldpass.value.length < 6){
		document.getElementById("shortoldpass").style.display="";
		oldpass_value = 0;
	}else{
		oldpass_value = 1;
	}
};
//处理新密码的输入
function newpassIn(){
	document.getElementById("nullnewpass").style.display="none";
	document.getElementById("shortnewpass").style.display="none";
	document.getElementById("printnewpass").style.display="";
};
function newpassOut(){
	document.getElementById("printnewpass").style.display="none";
	var newpass = document.getElementById("newpassword");
	if(newpass.value == ""){
		document.getElementById("nullnewpass").style.display="";
		newpass_value = 0;
	}else if(newpass.value.length < 6){
		document.getElementById("shortnewpass").style.display="";
		newpass_value = 0;
	}else{
		newpass_value = 1;
	}
};
//处理重复密码的输入
function confirmIn(){
	document.getElementById("nullconfirm").style.display="none";
	document.getElementById("twopass").style.display="none";
	document.getElementById("printconfirm").style.display="";
};
function confirmOut(){
	document.getElementById("printconfirm").style.display="none";
	var newpass = document.getElementById("newpassword");
	var confirm = document.getElementById("confirmpass");
	if(confirm.value == ""){
		document.getElementById("nullconfirm").style.display="";
		cfpass_value = 0;
	}else if(newpass.value != confirm.value){
		document.getElementById("twopass").style.display="";
		cfpass_value = 0;
	}else{
		cfpass_value = 1;
	}
};
//form提交前，验证各项信息是否都已填写正确
function check(){
    if(oldpass_value==1 && pass_value==1 && cfpass_value==1){
        return true;//不写该返回值也行，此时form直接提交
    }else{
        return false;
    }
};