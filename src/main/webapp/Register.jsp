<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="../js/register.js"></script>

	<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../css/style_l.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style_l.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" />

	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

	<link rel="stylesheet" href="<%=request.getContextPath()%>css/main.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>css/style.css" />

	<script src="<%=request.getContextPath()%>/js/main.js"></script>
</head>
  
<body>
<div class="container">
	<!-- head -->
	<div class="row">
		<div class="demo col-lg-10">
			<nav class="navbar-static-top">
				<div class="navbar-header" style="float:left; width:20%; margin-left:30px; margin-bottom:30px">
					<img src="logo.png" />
				</div>
			</nav>
		</div>

		<div class="demo col-lg-2">
			<nav class="navbar-static-top">
				<div class="navbar-header" style="float:left; width:20%">
					<nav class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="Login.jsp" class="btn btn-link">登录</a></li>
						</ul>
					</nav>
				</div>
			</nav>
		</div>
    </div>

	<div class="row">
		<div class="col-lg-3">
		</div>

		<div class="col-lg-6">
			<font size="6" color="#191970" face="华文楷体">用户注册</font>
			<hr>

			<s:form class="form-group" name="regForm" onsubmit="return check()"  action="account_register" method="post" namespace="/">
				<table border="0" width="800" cellspacing="0" cellpadding="0" style="border-collapse:separate; border-spacing:10px">

					<tr>
						<td width="80">昵称：</td>
						<td width="240">
							<input class="form-control" type="text" name="nickname" id="nickname" maxlength="12" onfocus="nickIn()" onblur="nickOut()" placeholder="" />
						</td>
						<td>
							<div id="printnick" style="display:none">
								<font color=gray> 请输入昵称，昵称不能超过12个字母、数字或汉字</font>
							</div>
							<div id="nullnick" style="display:none">
								<font color=red> 请输入昵称</font>
							</div>
						</td>
					</tr>

					<tr>
						<td width="80">密码：</td>
						<td width="240">
							<input class="form-control" type="password" name="password" id="password" maxlength="20" onfocus="passIn()" onblur="passOut()"/>
						</td>
						<td>
							<div id="printpass" style="display:none">
								<font color=gray> 请输入一个长度为6-20个字符的密码</font>
							</div>
							<div id="nullpass" style="display:none">
								<font color=red> 请输入密码</font>
							</div>
							<div id="shortpass" style="display:none">
								<font color=red> 密码长度应不少于6位</font>
							</div>
						</td>
					</tr>
 
					<tr>
						<td width="80">确认密码：</td>
						<td width="240">
							<input class="form-control" type="password" name="confirmpass" id="confirmpass" maxlength="20" onfocus="confirmIn()" onblur="confirmOut()"/>
						</td>
						<td>
							<div id="printconfirm" style="display:none">
								<font color=gray> 请再次输入密码</font>
							</div>
							<div id="nullconfirm" style="display:none">
								<font color=red> 请再次输入密码</font>
							</div>
							<div id="twopass" style="display:none">
								<font color=red> 密码不一致</font>
							</div>
						</td>
					</tr>

					<tr>
						<td width="80">电子邮箱：</td>
						<td width="240">
							<input class="form-control" type="text" name="email" id="email" onfocus="emailIn()" onblur="emailOut()"/>
						</td>
						<td>
							<div id="printemail" style="display:none">
								<font color=gray> 请输入您常用的电子邮箱，该邮箱将用来帮助您找回密码</font>
							</div>
							<div id="nullemail" style="display:none">
								<font color=red> 请输入邮箱</font>
							</div>
							<div id="errorformat" style="display:none">
								<font color=red> 邮箱格式错误</font>
							</div>
						</td>
					</tr>

					<tr >
						<td width="80">出生日期：</td>
						<td width="240">
							<input class="form-control" type="date" name="birthday" id="year" style="ime-mode:disabled;  display:inline" maxlength="12">

						</td>
					</tr>

					<tr>
						<td width="80">专业：</td>
						<td width="240">
							<input class="form-control" type="text" name="major" id="major" onfocus="majorIn()" onblur="majorOut()"/>
						</td>
						<td>
							<div id="printmajor" style="display:none">
								<font color=gray> 请输入您的专业</font>
							</div>
							<div id="nullmajor" style="display:none">
								<font color=red> 请输入您的专业</font>
							</div>
						</td>
					</tr>
		
					<tr>
						<td colspan="2" align="center">
							<input class="btn btn-primary" type="submit" value="注册"/>&nbsp;&nbsp;
							<input class="btn btn-default" type="reset" value="取消"/>&nbsp;&nbsp;
						</td>
					</tr>

				</table>
			</s:form>
	
			<footer style="margin:40px">
				<p align=center> &copy; 2017 OnlineForum. All Rights Reserved | Design by <a href="Login.jsp" >软件工程某小组</a></p>
			</footer>
		</div>
	</div>
</div>

</body>
</html>
