
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>posting</title>

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

    <script type="text/javascript">
        //判断输入框内是否为空，若为空，则禁止提交表单
        function check(){
            var title = document.getElementById("TitleArea").value;
            var content = document.getElementById("PostingArea").value;
            if(title == "" || content == ""){
                return false;//表单不提交
            }
            else{
                return true;//表单提交
            }
        };
    </script>
</head>

<body>
<div class="container">
    <!-- head -->
    <div class="row">
        <div class="demo col-lg-12">
            <nav class="navbar-static-top">
                <div class="navbar-header" style="float:left; width:20%; margin-left:30px; margin-bottom:30px">
                    <img src="logo.png" />
                </div>

                <div class="navbar-header" style="float:left; width:50%">
                    <nav class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right" >
                            <li onMouseOver="this.style.color='#fff'"><a href="post_findAll.action">首页</a></li>
                            <li onMouseOver="this.style.color='#fff'"><a href="post_findAll.action?currPage=1&type=study">学习</a></li>
                            <li onMouseOver="this.style.color='#fff'"><a href="post_findAll.action?currPage=1&type=friend">交友</a></li>
                        </ul>
                    </nav>
                </div>

                <div class="navbar-header" style="float:left; width:20%">
                    <nav class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="account_showPersonalInfo.action?currentPage=1" class="btn btn-link">个人信息</a></li>
                        </ul>
                    </nav>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-1">
        </div>

        <div class="col-lg-10">
            <font size="5" color="#9370db">新建帖子</font>
            <br>
            <br>

            <form action="post_save" method="POST" namespace="/" enctype="multipart/form-data" onsubmit="return check()">
                <input class="form-control" id="TitleArea" name="title" type="text" placeholder="请输入标题" size="60"/>
                <br>

                    <table class="tab-content">
                        <tr>
                            <td width="80">类型</td>
                            <td width="240">
                                <select name="category">
                                    <option value="study">学习</option>
                                    <option value="friend">交友</option>
                                </select>
                            </td>
                            <td width="80"></td>
                            <td width="80">文件：</td>
                            <td width="240">
                                <input  type="file" name="file"  maxlength="40"  />
                            </td>
                        </tr>
                    </table>

                <br/>

                <textarea rows="15" class="form-control" name="content" id="PostingArea" maxlength="140" placeholder="请输入内容......" >
				</textarea>
                <br/>

                <input id="PostingButton" name="PostingButton" type="submit" class="btn btn-primary" value="发贴"/>
                <span>&nbsp;&nbsp;</span>
                <input class="btn btn-default" type=reset value="重置">
            </form>
        </div>

        <div class="col-lg-1">
        </div>
    </div>
    <footer style="margin:40px;">
        <p align=center> &copy; 2017 OnlineForum. All Rights Reserved | Design by <a href="Login.jsp" >软件工程某小组</a></p>
    </footer>
</div>
</body>
</html>
