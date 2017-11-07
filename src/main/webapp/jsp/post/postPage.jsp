
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <title>PostPage</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>PostPage</title>

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
    <script type="text/javascript" src="/js/jquery.js"></script>

    <script type="text/javascript">
        //判断输入框内是否为空，若为空，则禁止提交表单
        function check(){
            var content = document.getElementById("content").value;
            if(content == ""){
                return false;//表单不提交
            }
            else{
                return true;//表单提交
            }
        };

        function writeComment(object) {
            var classSelect = "." + object.id;
            if (object.value == 0) {
                this.value = 1;
                $(object).html("取消");
            }
            else {
                object.value = 0;
                $(object).html("回复");
            }
            $(classSelect).toggle();
        }

        //找到回复的回复 0的时候取消评论，1的时候加载
        function findComments(button){
            var id =  button.value;
            if (button.name=="0") {
                document.getElementById("comments"+id).innerHTML ="";
                button.name="1";
                return;
            }
            $.ajax({
                type: "post",
                url: '/comment/findComments',
                data: {//设置数据源
                    cid: id,
                },
                dataType: "json",//设置需要返回的数据类型
                success: function (d) {
                    document.getElementById("comments"+(d.id)).innerHTML = d.info;
                    button.name="0";
                },
                error: function (d) {
                    alert(d.responseText);
                }
            });
        }

        //提交回复的回复
        function  postCommentComment(object) {
            var cid = object.name;
            var content =  document.getElementById("commentCommentContent"+cid).value;
            //login1为Action类命名空间名称；AjaxExecute为Action方法名称
            $.ajax({
                type: "post",
                url: '/comment/postComment',
                data: {//设置数据源
                    content: content,
                    cid :cid
                },
                dataType: "json",//设置需要返回的数据类型
                success: function (d) {
                    window.location.reload();
                },
                error: function (d) {
                    alert(d.responseText);
                }
            });
        }
        //发表回复
        function  postComment () {
            var content = $("#content").val();
            var pid = $("#pid").val();
            //login1为Action类命名空间名称；AjaxExecute为Action方法名称
            $.ajax({
                type: "post",
                url: '/comment/postComment',
                data: {//设置数据源
                    pid: pid,
                    content: content
                },
                dataType: "json",//设置需要返回的数据类型
                success: function (d) {
                    window.location.reload();
                },
                error: function (d) {
                    alert(d.responseText);
                }
            });

        }
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

    <div class="row" style="height:30px">
    </div>

    <!-- 用div重新布局 -->
    <table>
        <tr>
            <td width=100></td>
            <td width="800"><font size="6"><s:property value="#currentPost.title"/></font></td>
            <td width="200"></td>
            <td width="50"></td>
        </tr>
    </table>
    <br>

    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            资源：  <a href="fileDownload_fileDownload?fileName=<s:property value="#currentPost.resource.path"/>"><s:property value="fileFileName"/></a>

        </div>
    </div>
    <hr>

    <div class="row">
        <div class="col-lg-1">
        </div>

        <div class="col-lg-10">
            <table class="table" style="table-layout:fixed;">
                <tr>
                    <table class="table" style="background-color:#ecf7f1">
                        <tr style=" background-color:#F0F0F0">
                            <td width=20%><s:property value="#currentPost.poster.nickname"/></td>
                            <td width="60%"></td>
                            <td width="20%"><s:date name="#currentPost.time" format="yyyy-MM-dd HH:mm:ss"/></td>
                        </tr>

                        <tr>
                            <td width="16%"></td>
                            <td colspan="2" style="word-wrap:break-word; word-break: normal;">
                                <p name="content" ><s:property value="#currentPost.content"/></p>
                            </td>
                            <td width="30%"></td>
                        </tr>
                    </table>
                </tr>
                <s:iterator value="list" var="p">
                <tr>
                    <table class="table" style="background-color:#ecf7f1">
                        <tr style=" background-color:#F0F0F0">
                            <td width=20%><s:property value="#currentPost.poster.nickname"/></td>
                            <td width="20%"></td>
                            <td width="20%"><s:date name="#p.time" format="yyyy-MM-dd hh:MM:ss"/></td>
                            <td width="20%">
                                <button class="btn-link" value="<s:property value="#p.id"/>" onclick="findComments(this)" name="1/>">查看回复</button>
                            </td>
                            <td width="20%">
                                <button class="btn-link" id="<s:property value="#p.id" /> " value="0" onclick="writeComment(this)">回复</button>
                            </td>
                        </tr>

                        <tr>
                            <td width="16%"></td>
                            <td colspan="2" style="word-wrap:break-word; word-break: normal;">
                                <p name="content" ><s:property value="#p.content"/></p>
                            </td>
                            <td width="30%"></td>
                        </tr>

                        <tr>
                            <td width="16%"></td>
                            <td colspan="2" style="word-wrap:break-word; word-break: normal;">
                                <div id="comments<s:property value="#p.id"/>">
                                </div>
                            </td>
                            <td width="30%"></td>
                        </tr>

                        <tr>
                            <td width="16%"></td>
                            <td colspan="2" style="word-wrap:break-word; word-break: normal;">
                                <div class="<s:property value="#p.id"/>" style="display: none;">
                                    <form >
                                        <input  type="hidden" name="commentId"  value="<s:property value="#p.id"/>"  />
                                        <textarea name="content" id="commentCommentContent<s:property value="#p.id"/>"></textarea>
                                        <input type="button" name="<s:property value="#p.id"/>" onclick="postCommentComment(this)" value="提交"/>&nbsp;&nbsp;
                                    </form>
                                </div>
                            </td>
                            <td width="30%"></td>
                        </tr>
                    </table>
                </tr>
                </s:iterator>
            </table>
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
                                <a href="post_postPage.action?currPage=1&id=<s:property value="#currentPost.id"/>"> [首页]</a>&nbsp;&nbsp;
                                <a href="post_postPage.action?currPage=<s:property value="currPage-1"/>&id=<s:property value="#currentPost.id"/>"> [上一页]</a>&nbsp;&nbsp;
                            </s:if>
                            <s:if test="currPage!=totalPage">
                                <a href="post_postPage.action?currPage=<s:property value="currPage+1"/>&id=<s:property value="#currentPost.id"/>">[下一页]</a>&nbsp;&nbsp;
                                <a href="post_postPage.action?currPage=<s:property value="totalPage"/>&id=<s:property value="#currentPost.id"/>">[尾页]</a>&nbsp;&nbsp;
                            </s:if>
                        </span>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- 分页结束 -->

    <div class="row">
        <div class="col-lg-1">
        </div>

        <div class="col-lg-5">
            <font size="4">&nbsp;	发表回复:</font>
        </div>
    </div>
    <!-- 行结束 -->

    <form onsubmit="return check();">
        <div class="row">
            <div class="col-lg-1">
            </div>

            <input  type="hidden" name="pid" id="pid" value="<s:property value="#currentPost.id"/>"  />

            <div class="col-lg-8">
                <textarea class="form-control" rows=8 cols=110 id="content" name="content" maxlength="127" ></textarea>
            </div>
        </div>
        <!-- 行结束 -->
        <br/>
        <div class="row">
            <div class="col-lg-2">
            </div>

            <div class="col-lg-8">
                <input class="btn btn-primary" type="button" onclick="postComment()" value=确认回复 name=send>
                <span>&nbsp;&nbsp;</span>
                <input class="btn btn-default" type=reset value=清除重写>
            </div>
        </div>
        <!--行结束-->
    </form>

    <footer style="margin:40px">
        <p align=center> &copy; 2017 OnlineForum. All Rights Reserved | Design by <a href="Login.jsp" >软件工程某小组</a></p>
    </footer>
</div>
</body>
</html>
