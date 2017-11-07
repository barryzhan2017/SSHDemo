<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人中心</title>
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
        <br>
        <br>
        <br>
        <br>
    </div>

    <div class="row">
        <div class="col-lg-3">
        </div>
        <div class="col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <s:property value="#request.user.nickname"/>的信息
                </div>
                <div class="panel-body">
                    <img class="img-circle" src="account_readUserImg.action?id=<s:property value="#request.user.id"/>" width="136" height="99">
                    <br>
                    <ul class="list-group">
                        <li class="list-group-item">账号：<s:property value="#request.user.id"/></li>
                        <li class="list-group-item">昵称：<s:property value="#request.user.nickname"/></li>
                        <li class="list-group-item">专业：<s:property value="#request.user.major"/></li>
                        <li class="list-group-item">电子邮箱：<s:property value="#request.user.email"/></li>
                        <li class="list-group-item">出生日期：<s:date name="#request.user.birthday" format="yyyy-MM-dd"/></li>
                        <li class="list-group-item">
                                <a href="/admin_deleteAccount.action?fid=<s:property value="#request.user.id"/>" class="btn btn-default">删除</a>&nbsp;&nbsp;
                                <%--
                                <a href="/administration/homepageU.jsp" class="btn btn-default">返回</a>&nbsp;&nbsp;

                                <input class="form-control btn btn-success" type="submit" value="删除"/>&nbsp;&nbsp;
                                <input class="form-control btn btn-danger" type="reset" value="返回"/>&nbsp;&nbsp;
                                --%>
                        </li>

                        <li class="list-group-item">
                                <a href="/admin_findU.action" class="btn btn-default">返回</a>&nbsp;&nbsp;
                        </li>
                    </ul>
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
                <td width="45%">标题</td>
                <td width="20%">发帖日期</td>
                <td width="15%">回帖量</td>
                <td width="10%">删除</td>
                </thead>
                <tbody>
                <s:iterator value="list" var="p">
                    <tr>
                        <td width="45%">
                            <a target="_blank" href="admin_viewPostPage.action?currPage=1&fid=<s:property value="#p.id"/>"><s:property value="#p.title"/></a>
                        </td>
                        <td width="20%"><s:date name="#p.time" format="yyyy-MM-dd hh:mm:ss"/></td>
                        <td width="15%"><s:property value="#p.comments.size"/></td>
                        <td width="10%">
                            <a href="/admin_deletePostU.action?fid=<s:property value="#p.id"/>&uid=<s:property value="#request.user.id"/>">删除</a>
                        </td>
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
                                 <a href="admin_viewUserPage.action?currPage=1&uid=<s:property value="#user.id"/>">[首页]</a>&nbsp;&nbsp;
                                 <a href="admin_viewUserPage.action?currPage=<s:property value="currPage-1"/>&uid=<s:property value="#user.id"/>">[上一页]</a>&nbsp;&nbsp;
                             </s:if>
					<s:if test="currPage!=totalPage">
                        <a href="admin_viewUserPage.action?currPage=<s:property value="currPage+1"/>&uid=<s:property value="#user.id"/>">[下一页]</a>&nbsp;&nbsp;
                        <a href="admin_viewUserPage.action?currPage=<s:property value="totalPage"/>&uid=<s:property value="#user.id"/>">[尾页]</a>&nbsp;&nbsp;
                    </s:if>
				</span>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</div>
</body>

</html>
