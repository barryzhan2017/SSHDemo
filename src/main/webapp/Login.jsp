<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.net.URLDecoder" %>

<%
    response.setHeader("Cache-Control","no-store");  
    response.setHeader("Pragrma","no-cache");  
    response.setDateHeader("Expires",0);  
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>登陆</title>

    <script type="text/javascript" src="../js/login.js"></script>
    <script src="../js/index.js"></script>

    <link rel="stylesheet" href="../css/style_first.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

    <script type="text/javascript">
        var value = 0;

        function loadXMLDoc() {
            var xmlhttp;
            var txt,x,i;
            var CodeArea=document.getElementById("VerificationCodeArea").value;
            var url="CodeAreaCheck?Code="+CodeArea;
            if (window.XMLHttpRequest) {
                /// / IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp=new XMLHttpRequest();
            }
            else {
                // IE6, IE5 浏览器执行代码
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlhttp.onreadystatechange=function() {
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    xmlDoc=xmlhttp.responseText;
                    //alert(xmlDoc);
                    if(xmlDoc=="0") {
                        value = 0;
                        document.getElementById("reminder").style.visibility="visible";
                    }
                    else {
                        document.getElementById("reminder").style.visibility="hidden";
                        value = 1;
                    }
                }
            }
            xmlhttp.open("GET",url,true);
            xmlhttp.send();
        }
	
        /*
        //form提交前，验证各项信息是否都已填写正确
        function check(){

            var id = document.getElementById("userid").value;
            var pass = document.getElementById("password").value;
		
            if(id ==""){
                value = 0;
                document.getElementById("nullid").style.display="";
            }
            if(pass == ""){
                value = 0;
                document.getElementById("nullpass").style.display="";
            }
	    if(value){
                return true;//不写该返回值也行，此时form直接提交
            }
            else{
	            return false;
	     }
        };
        */
    </script>
</head>

<body>
<center>
    <div class="cotn_principal">
        <div class="cont_centrar">
            <div class="cont_login">
                <div class="cont_info_log_sign_up">

                    <div class="col_md_login">
                        <div class="cont_ba_opcitiy">
                            <h2>登录</h2>
                            <button class="btn_login" style="margin:10px" onClick="cambiar_login()">登录</button>
                        </div>
                    </div>

                    <div class="col_md_sign_up">
                        <div class="cont_ba_opcitiy">
                            <h2>注册</h2>
                            <button class="btn_sign_up" style="margin:10px" onClick="{location.href='Register.jsp'}">注册</button>
                        </div>
                    </div>
                </div>

                <div class="cont_back_info">
                    <div class="cont_img_back_grey"> <img src="po.png" alt="" /> </div>
                </div>

                <div class="cont_forms" >
                    <div class="cont_img_back_"> <img src="po.png" alt="" /> </div><!-- 背景 -->
                    <div class="cont_form_login"> <!-- 登录表单 -->
                        <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a><br/>
                        <h2 style="margin-bottom:15px; margin-top:25px" align="center">登录</h2>
                        <s:form action="account_login" method="POST" namespace="/"  class="form-group" onsubmit="return check()">
                            <input class="form-control" type="text" name="id" id="userid" placeholder="请输入账号"  onfocus="textIn()" maxlength="6" style="width:220px; margin-left:52px" onkeypress="if ((event.keyCode<48 || event.keyCode>57)) event.returnValue=false" /><br/>
                            <input class="form-control" type="password" name="password" id="password"  style="width:220px; margin-left:52px" placeholder="请输入密码" onfocus="textIn()" maxlength="20"/><br/>

                            <br/>

                            <div class="sub-or-re">
                                <input type="submit" class="btn btn-success" onClick="cambiar_login()" value="登录"/>&nbsp;&nbsp;
                                <input type="reset" class="btn btn-danger" value="取消"/>
                                <br>
                                <br>
                            </div>
                        </s:form>
                    </div>
        
                    <!-- 注册表单 -->
                    <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</center>
</body>
</html>