<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>HomePageU</title>
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
        <h3>管理用户</h3>
        <hr>
    </div>

    <!-- 搜索框 -->
    <div class="row">
        <form action="admin_findU" method="POST" namespace="/">
        <div class="col-lg-2">
            <div class="input-group">
                <select name="category">
                    <option value="findAllUser">无</option>
                    <option value="findUserByNameAndPage">昵称</option>
                    <option value="findUserById">ID</option>
                </select>
            </div>
        </div>

        <div class="col-lg-8">
            <div class="input-group">
                <input name="keyword" class="form-control" type="text" placeholder="请输入..." />
                <span class="input-group-btn">
                    <input id="SearchButton" name="SearchButton" class="btn btn-success" type="submit" value="搜索" />
                </span>
            </div>
        </div>
        </form>

        <div class="col-lg-2">
            <a class="btn btn-primary" href='/administration/adminchoice.jsp'>返回</a>
        </div>
    </div>
<%--
<div class="row">
    <div class="col-lg-1">
    </div>



    <div class="col-lg-1">
    </div>
</div>

--%>

    <div class="col-lg-10">
        <table class="table table-hover" style="margin-right:20px; margin-left:30px; margin-bottom:5px; margin-top:20px; background-color:#ecf7f1">
            <thead>
            <td width="30%">ID</td>
            <td width="35%">昵称</td>
            <td width="35%">专业</td>
            </thead>
            <tbody>
            <s:iterator value="list" var="p">
                <tr>

                    <td width="30%"><a href="/admin_viewUserPage.action?currPage=1&uid=<s:property value="#p.id"/>"><s:property value="#p.id"/> </a></td>

                    <td width="35%"><s:property value="#p.nickname"/></td>
                    <td width="35%"><s:property value="#p.major"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <br>
    </div>

    <table style="width:900px;">
        <tr>
            <td align="right">
                <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
                <span>总记录数：<s:property value="totalCount"/>每页显示：<s:property value="pageSize"/></span>&nbsp;&nbsp;
                <span>
					 <s:if test="currPage!=1">
                         <a href="admin_findU.action?currPage=1&category=<s:property value="#request.category"/>&type=<s:property value="type"/>">[首页]</a>&nbsp;&nbsp;
                         <a href="admin_findU.action?currPage=<s:property value="currPage-1"/>&category=<s:property value="#request.category"/>&type=<s:property value="type"/>">[上一页]</a>&nbsp;&nbsp;
                     </s:if>
					<s:if test="currPage!=totalPage">
                        <a href="admin_findU.action?currPage=<s:property value="currPage+1"/>&category=<s:property value="#request.category"/>&type=<s:property value="type"/>">[下一页]</a>&nbsp;&nbsp;
                        <a href="admin_findU.action?currPage=<s:property value="totalPage"/>&category=<s:property value="#request.category"/>&type=<s:property value="type"/>">[尾页]</a>&nbsp;&nbsp;
                    </s:if>
				</span>
            </td>
        </tr>
    </table>

</div>
</body>
</html>
