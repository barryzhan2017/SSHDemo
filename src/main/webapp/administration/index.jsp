<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>管理员登陆</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="js/ie6Fixpng.js"></script>
    <![endif]-->

    <link href="bootstrap.css" rel="stylesheet" type="text/css">
    <link href="main.css" rel="stylesheet" type="text/css">
    <link href="style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="style_l.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style_l.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>css/main.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>css/style.css" />
    <script src="<%=request.getContextPath()%>/js/main.js"></script>
</head>

<body>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="container">
    <div class="row">
        <h2 style="margin-bottom:15px; margin-top:25px" align="center">管理员登录</h2>
    </div>
    <div class="row">
        <div class="col-lg-4">
        </div>

        <div class="col-lg-3">
            <div class="headerBar">
                <div align="center">
                    <s:form action="admin_login" method="POST" namespace="/"  class="form-group" onsubmit="return check()">
                        <div class="loginBox">
                            <h3><s:actionerror/></h3>
                            <div class="login_cont">
                                <ul class="login">
                                    <input class="form-control" type="text" name="id" id="userid" placeholder="请输入账号"  onfocus="textIn()" maxlength="6" style="width:220px; margin-left:52px" onkeypress="if ((event.keyCode<48 || event.keyCode>57)) event.returnValue=false" /><br/>
                                    <input class="form-control" type="password" name="password" id="password"  style="width:220px; margin-left:52px" placeholder="请输入密码" onfocus="textIn()" maxlength="20"/><br/>
                                    <br/>
                                    <div class="sub-or-re">
                                        <input type="submit" class="btn btn-success" onClick="cambiar_login()" value="登录"/>&nbsp;&nbsp;
                                        <input type="reset" class="btn btn-danger" value="取消"/>
                                        <br>
                                        <br>
                                    </div>
                                </ul>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>

        <div class="col-lg-5">
        </div>
    </div>
</div>


</body>
</html>
