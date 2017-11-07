/**JavaScript Document About Register.jsp
 * 
 */
var nick_value = 0;
var pass_value = 0;
var cfpass_value = 0;
var email_value = 0;
var major_value = 0;
//处理昵称的输入
function nickIn(){
	document.getElementById("nullnick").style.display="none";
	document.getElementById("printnick").style.display="";
};
function nickOut(){
	document.getElementById("printnick").style.display="none";
	var nick = document.getElementById("nickname");
	if(nick.value == ""){
		document.getElementById("nullnick").style.display="";
		nick_value = 0;
	}else{
		nick_value = 1;
	}
};
//处理密码的输入
function passIn(){
	document.getElementById("nullpass").style.display="none";
	document.getElementById("shortpass").style.display="none";
	document.getElementById("printpass").style.display="";
};
function passOut(){
	document.getElementById("printpass").style.display="none";
	var pass = document.getElementById("password");
	if(pass.value == ""){
		document.getElementById("nullpass").style.display="";
		pass_value = 0;
	}else if(pass.value.length < 6){
		document.getElementById("shortpass").style.display="";
		pass_value = 0;
	}else{
		pass_value = 1;
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
	var password = document.getElementById("password");
	var confirm = document.getElementById("confirmpass");
	if(confirm.value == ""){
		document.getElementById("nullconfirm").style.display="";
		cfpass_value = 0;
	}else if(password.value != confirm.value){
		document.getElementById("twopass").style.display="";
		cfpass_value = 0;
	}else{
		cfpass_value = 1;
	}
};
//处理email的输入
function emailIn(){
	document.getElementById("nullemail").style.display="none";
	document.getElementById("errorformat").style.display="none";
	document.getElementById("printemail").style.display="";
};
function emailOut(){
	document.getElementById("printemail").style.display="none";
	var email = document.getElementById("email");
	//对email进行正则校验
	var emailformat = /^([a-zA-Z0-9]+[_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(email.value == ""){
		document.getElementById("nullemail").style.display="";
		email_value = 0;
	}else if(!emailformat.test(email.value)){	//正则校验失败
		document.getElementById("errorformat").style.display="";
		email_value = 0;
	}else{
		email_value = 1;
	}
};

/*
//处理生日的输入
function birthIn(){
	document.getElementById("errordate").style.display="none";
};
function birthOut(){
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("month").value;
	if(year != "" && month != "" && day != ""){
		birthday();
	}
};
function birthday(){
	var year = parseInt(document.getElementById("year").value);
	var month = parseInt(document.getElementById("month").value);
	var day = parseInt(document.getElementById("day").value);
	var days = 0;
	if(month == 2){
		if(year%4==0&&year%100!=0 || year%400==0){	//判断是否为闰年
			days = 29;
		}
		days = 28;
	}else{
		switch(month)
		{
			case 1:
				days = 31;
				break;
			case 3:
				days = 31;
				break;
			case 4:
				days = 30;
				break;
			case 5:
				days = 31;
				break;
			case 6:
				days = 30;
				break;
			case 7:
				days = 31;
				break;
			case 8:
				days = 31;
				break;
			case 9:
				days = 30;
				break;
			case 10:
				days = 31;
				break;
			case 11:
				days = 30;
				break;
			case 12:
				days = 31;
				break;
			default:
				days = 0;
				break;
		}
	}
	if(year > 2016 || year < 1926){
		document.getElementById("errordate").style.display="";
		birth_value = 0;
	}else if(year == 1926 && month < 8){
		document.getElementById("errordate").style.display="";
		birth_value = 0;
	}else if(year == 1926 && month ==8 && day < 17){
		document.getElementById("errordate").style.display="";
		birth_value = 0;
	}else if(day < 1 || day > days){
		document.getElementById("errordate").style.display="";
		birth_value = 0;
	}else{
		birth_value = 1;
	}
};
*/

//处理专业的输入
function majorIn(){
	document.getElementById("nullmajor").style.display="none";
	document.getElementById("printmajor").style.display="";
};
function majorOut(){
	document.getElementById("printmajor").style.display="none";
	var major = document.getElementById("major");;
	if(major.value == ""){
		document.getElementById("nullmajor").style.display="";
		major_value = 0;
	}else{
		major_value = 1;
	}
};
//form提交前，验证各项信息是否都已填写正确
function check(){
    if(nick_value && pass_value && cfpass_value && email_value && major_value){
        return true;//不写该返回值也行，此时form直接提交
    }else{
        return false;
    }
};