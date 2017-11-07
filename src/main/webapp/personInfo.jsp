
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>个人信息</title>

    <script type="text/javascript" src="../js/modify.js"></script>

    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../css/style_l.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style_l.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" />

    <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

     <script type="text/javascript">
         var msg="${requestScope.tipMessage}";
         if(msg!="")
             alert(msg);
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
        <div class="col-lg-3">
        </div>

        <div class="col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    个人信息
                </div>

                <div class="panel-body form-group">
                    <img src="account_readPersonalImg" width="136" height="99">
                    <br>

                    <form action="account_modify" method="POST" namespace="/" enctype="multipart/form-data" onsubmit="return check()">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <td width="80">上传头像：</td>
                                <td width="240">
                                    <input class="form-control" type="file" name="image" />
                                </td>
                            </li>

                            <li class="list-group-item">
                                <td width="80">账号：</td>
                                <td width="240">
                                    <input class="form-control" type="text" name="id"  maxlength="40" value=" <s:property value="#session.existaccount.id"/> " disabled="disabled"/>
                                </td>
                            </li>

                            <li class="list-group-item">
                                <td width="80">昵称：</td>
                                <td width="240">
                                    <input class="form-control" type="text" name="nickname" id="nickname" value="<s:property value="#session.existaccount.nickname"/>" maxlength="12" onfocus="nickIn()" onblur="nickOut()"/>
                                </td>
                                <td>
                                    <div id="printnick" style="display:none">
                                        <font color=gray> 请输入昵称</font>
                                    </div>
                                    <div id="nullnick" style="display:none">
                                        <font color=red> 请输入昵称</font>
                                    </div>
                                </td>
                            </li>

                            <li class="list-group-item">
                                <td width="80">电子邮箱：</td>
                                <td width="240">
                                    <input class="form-control" type="text" name="email" id="email" value="<s:property value="#session.existaccount.email"/>"  onfocus="emailIn()" onblur="emailOut()"/>
                                </td>
                                <td>
                                    <div id="printemail" style="display:none">
                                        <font color=gray> 请输入您常用的电子邮箱</font>
                                    </div>
                                    <div id="nullemail" style="display:none">
                                        <font color=red> 请输入邮箱</font>
                                    </div>
                                    <div id="errorformat" style="display:none">
                                        <font color=red> 邮箱格式错误</font>
                                    </div>
                                </td>
                            </li>

                            <li class="list-group-item">
                                <td width="80">出生日期：</td>
                                <td>
                                    <input class="form-control" type="text" name="birth" id="birth" value="<s:date name="#session.existaccount.birthday" format="yyyy-MM-dd"/>" maxlength="30" />
                                </td>
                                <td width="240">
                                    <input class="form-control" type="date" name="birthday" id="birthday" value="<s:property value="#session.existaccount.birthday"/>" maxlength="30" />
                                </td>
                            </li>

                            <li class="list-group-item">
                                <td width="80">专业：</td>
                                <td width="240">
                                    <input class="form-control" type="text" name="major" id="schoolname" value=" <s:property value="#session.existaccount.major"/> " onfocus="schoolIn()" onblur="schoolOut()"/>
                                </td>
                                <td>
                                    <div id="printschool" style="display:none">
                                        <font color=gray> 请输入您的专业</font>
                                    </div>
                                    <div id="nullschool" style="display:none">
                                        <font color=red> 请输入您的专业</font>
                                    </div>
                                </td>
                            </li>

                            <li class="list-group-item">
                                <td colspan="2" align="center">
                                    <input class="form-control btn btn-success" type="submit" value="确定修改"/>&nbsp;&nbsp;
                                    <input class="form-control btn btn-danger" type="reset" value="取消"/>&nbsp;&nbsp;
                                </td>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-1">
        </div>
        <div class="col-lg-10">
            <!-- 表格显示帖子 -->
            <table class="table table-hover" style="margin-right:20px; margin-left:30px; margin-bottom:5px; margin-top:20px; background-color:#ecf7f1">
                <thead>
                <td width="55%">标题</td>
                <td width="20%">发帖日期</td>
                <td width="15%">回帖量</td>
                <td width="10%">操作</td>
                </thead>

                <tbody>
                <s:iterator value="list" var="p">
                    <tr>
                        <td width="55%">
                            <a href="post_postPage.action?currPage=1&id=<s:property value="#p.id"/>"><s:property value="#p.title"/></a>
                        </td>
                        <td width="20%"><s:date name="#p.time" format="yyyy-MM-dd hh:MM:ss"/></td>
                        <td width="15%"><s:property value="#p.comments.size"/></td>
                        <td width="15%"><a href="post_deletePost.action?id=<s:property value="#p.id"/>">删除</a> </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
            <br>
        </div>

        <div class="col-lg-1">
        </div>
    </div>
    <!-- 行结束 -->

    <!-- 表示分页的行 -->
    <div class="row">
        <div class="col-lg-4">
        </div>

        <div class="col-lg-8" style="float:right;">
            <nav>
                <ul class="pagination">
                    <li>
                        <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
                    </li>

                    <li>
                        <span>总记录数：<s:property value="totalCount"/>&nbsp;&nbsp;每页显示：<s:property value="pageSize"/></span>&nbsp;&nbsp;
                    </li>

                    <li>
                        <span>
                           <s:if test="currPage!=1">
                               <a href="account_showPersonalInfo.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
                               <a href="account_showPersonalInfo.action?currentPage=<s:property value="currPage-1"/> ">[上一页]</a>&nbsp;&nbsp;
                           </s:if>
                            <s:if test="currPage!=totalPage">
                                <a href="account_showPersonalInfo.action?currentPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
                                <a href="account_showPersonalInfo.action?currentPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
                            </s:if>
				</span>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- 分页结束 -->


    <footer style="margin:40px">
        <p align=center> &copy; 2017 OnlineForum. All Rights Reserved | Design by <a href="Login.jsp" >软件工程某小组</a></p>
    </footer>
</div>
</body>
</html>
