<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragrma","no-cache");
    response.setDateHeader("Expires",0);
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Adminchoice</title>
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
    </script>
</head>

<body>
<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_post">
            <div class="cont_info_post_user">
                <div class="col_md_post">
                    <div class="cont_ba_opcitiy">
                        <h2>管理帖子</h2>
                        <button class="btn btn-success" style="margin:10px" onClick="{location.href='/admin_findP.action'}">管理帖子</button>
                    </div>
                </div>
                <div class="col_md_user">
                    <div class="cont_ba_opcitiy">
                        <h2>管理用户</h2>
                        <button class="btn btn-success" style="margin:10px" onClick="{location.href='/admin_findAllUser'}">管理用户</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
