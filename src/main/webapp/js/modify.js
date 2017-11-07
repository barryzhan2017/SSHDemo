/**JavaScript Document About Register.jsp
 * 
 */
var nick_value = 1;
var email_value = 1;
var birth_value = 1;
var school_value = 1;
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
//处理学校的输入
function schoolIn(){
	document.getElementById("nullschool").style.display="none";
	document.getElementById("printschool").style.display="";
};
function schoolOut(){
	document.getElementById("printschool").style.display="none";
	var school = document.getElementById("schoolname");;
	if(school.value == ""){
		document.getElementById("nullschool").style.display="";
		school_value = 0;
	}else{
		school_value = 1;
	}
};
//form提交前，验证各项信息是否都已填写正确
function check(){
	if(nick_value &&email_value && birth_value && school_value){
        return true;//不写该返回值也行，此时form直接提交
    }else{
        return false;
    }
};