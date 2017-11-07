<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!-- 可以删，不知道干啥用的-->
<% response.setHeader("Cache-Control","no-cache");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires",-1);
%>

<html>
<head>
    <title>主页</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

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

        //判断搜索框内是否为空，若为空，则禁止搜索
        function check(){
            var keyword = document.getElementById("SearchArea").value;
            if(keyword == ""){
                return false;//表单不提交
            }else{
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
                            <!--TODO**********************************************-->
                            <li onMouseOver="this.style.color='#fff'"><a href="post_findAll.action">首页</a></li>
                            <li onMouseOver="this.style.color='#fff'"><a href="post_findAll.action?currPage=1&type=study">学习</a></li>
                            <li onMouseOver="this.style.color='#fff'"><a href="post_findAll.action?currPage=1&type=friend">交友</a></li>
                        </ul>
                    </nav>
                </div>

                <div class="navbar-header" style="float:left; width:20%">
                    <nav class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="/account_showPersonalInfo.action?currentPage=1" class="btn btn-link">个人信息</a></li>
                        </ul>
                    </nav>
                </div>
            </nav>
        </div>
    </div>

    <!-- 搜索框和新建帖子 -->
    <div class="row">
        <div class="col-lg-2">
        </div>

        <div class="col-lg-8">
            <s:form id="SearchForm"  name="SearchForm" action="post_findByKeyword" method="POST" namespace="/" onsubmit="return check()">
                <div class="input-group">
                    <input id="SearchArea" name="keyword" class="form-control" type="text" placeholder="请输入..." />
                    <span class="input-group-btn">
						<input id="SearchButton" name="SearchButton" class="btn btn-success" type="submit" value="搜索" />
					</span>
                </div>
            </s:form>
        </div>

        <div class="col-lg-2">
            <a class="btn btn-primary" href='PostSubmit.jsp'>发表新帖</a>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-1">
        </div>

        <div class="col-lg-10">
            <!-- 表格显示帖子 -->
            <table class="table table-hover" style="margin-right:20px; margin-left:30px; margin-bottom:5px; margin-top:20px; background-color:#ecf7f1">
                <thead>
                <td width="10%">发帖人</td>
                <td width="55%">标题</td>
                <td width="20%">发帖日期</td>
                <td width="15%">回帖量</td>
                </thead>

                <tbody>
                <s:iterator value="list" var="p">
                    <tr>
                        <td width="10%"><a href="/account_viewUserInfo.action?currPage=1&id=<s:property value="#p.poster.id"/>" ><s:property value="#p.poster.nickname"/></a></td>
                        <td width="55%">
                            <a href="post_postPage.action?currPage=1&id=<s:property value="#p.id"/>"><s:property value="#p.title"/></a>
                        </td>
                        <td width="20%"><s:date name="#p.time" format="yyyy-MM-dd HH:mm:ss"/></td>
                        <td width="15%"><s:property value="#p.comments.size"/></td>
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
                                <a href="post_findAll.action?currPage=1&type=<s:property value="type"/>">[首页]</a>&nbsp;&nbsp;
                                <a href="post_findAll.action?currPage=<s:property value="currPage-1"/>&type=<s:property value="type"/>">[上一页]</a>&nbsp;&nbsp;
                            </s:if>

                            <s:if test="currPage!=totalPage">
                                <a href="post_findAll.action?currPage=<s:property value="currPage+1"/>&type=<s:property value="type"/>">[下一页]</a>&nbsp;&nbsp;
                                <a href="post_findAll.action?currPage=<s:property value="totalPage"/>&type=<s:property value="type"/>">[尾页]</a>&nbsp;&nbsp;
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
