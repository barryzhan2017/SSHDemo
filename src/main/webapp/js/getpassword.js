/**JavaScript Document About Login.jsp
 * 
 */
function idIn(){
	document.getElementById("nullid").style.display="none";
	document.getElementById("nullemail").style.display="none";
	document.getElementById("erroremail").style.display="none";
	document.getElementById("printemail").style.display="none";
	document.getElementById("printid").style.display="";
};
function emailIn(){
	document.getElementById("nullid").style.display="none";
	document.getElementById("nullemail").style.display="none";
	document.getElementById("erroremail").style.display="none";
	document.getElementById("printid").style.display="none";
	document.getElementById("printemail").style.display="";
};
//form提交前，验证各项信息是否都已填写正确
function check(){
	var id = document.getElementById("userid").value;
	var email = document.getElementById("email").value;
	var value = 1;
	//对email进行正则校验
	var emailformat = /^([a-zA-Z0-9]+[_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(id == ""){
		value = 0;
		document.getElementById("printid").style.display="none";
		document.getElementById("printemail").style.display="none";
		document.getElementById("nullid").style.display="";
	}
	if(email == ""){
		value = 0;
		document.getElementById("printid").style.display="none";
		document.getElementById("printemail").style.display="none";
		document.getElementById("nullemail").style.display="";
	}else if(!emailformat.test(email)){	//正则校验失败
		value = 0;
		document.getElementById("printid").style.display="none";
		document.getElementById("printemail").style.display="none";
		document.getElementById("erroremail").style.display="";
	}
    if(value){
        return true;//不写该返回值也行，此时form直接提交
    }else{
        return false;
    }
};