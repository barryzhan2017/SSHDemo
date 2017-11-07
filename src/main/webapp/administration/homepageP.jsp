<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>

<head>
    <title>HomePageP</title>
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
        <br>
        <br>
    </div>

    <!-- 搜索框 -->
    <div class="row">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
            <s:form id="SearchForm"  name="SearchForm" action="admin_findPostByKeyWord" method="POST" namespace="/">
                <div class="input-group">
                    <input id="SearchArea" name="keyword" class="form-control" type="text" placeholder="请输入..." />
                    <span class="input-group-btn">
						<input id="SearchButton" name="SearchButton" class="btn btn-success" type="submit" value="搜索" />
					</span>
                </div>
            </s:form>
        </div>
        <div class="col-lg-2">
            <a class="btn btn-primary" href='/administration/adminchoice.jsp'>返回</a>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-1">
        </div>
        <div class="col-lg-10">
            <!-- 表格显示帖子 -->
            <table class="table table-hover" style="margin-right:20px; margin-left:30px; margin-bottom:5px; margin-top:20px; background-color:#ecf7f1">
                <thead>
                <td width="25%">发帖人</td>
                <td width="40%">标题</td>
                <td width="20%">发帖日期</td>
                <td width="15%">回帖量</td>
                </thead>
                <tbody>
                <s:iterator value="list" var="p">
                    <tr>
                        <td  width="25%"><s:property value="#p.poster.nickname"/></td>
                        <td  width="40%"><a  target="_blank" href="admin_viewPostPage.action?currPage=1&fid=<s:property value="#p.id"/>"><s:property value="#p.title"/></a></td>
                        <td  width="20%"><s:date name="#p.time" format="yyyy-mm-dd hh:mm:ss"/></td>
                        <td  width="15%"><s:property value="#p.comments.size"/></td>
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
                                 <a href="admin_findP.action?currPage=1&category=<s:property value="#request.category"/>">[首页]</a>&nbsp;&nbsp;
                                 <a href="admin_findP.action?currPage=<s:property value="currPage-1"/>&category=<s:property value="#request.category"/>">[上一页]</a>&nbsp;&nbsp;
                             </s:if>
					<s:if test="currPage!=totalPage">
                        <a href="admin_findP.action?currPage=<s:property value="currPage+1"/>&category=<s:property value="#request.category"/>">[下一页]</a>&nbsp;&nbsp;
                        <a href="admin_findP.action?currPage=<s:property value="totalPage"/>&category=<s:property value="#request.category"/>">[尾页]</a>&nbsp;&nbsp;
                    </s:if>
				</span>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- 分页结束 -->

</div>

<%--

<s:form action="admin_findPostByKeyWord" method="POST" namespace="/">
    <table>
        <tr>
            <td>
                搜索关键字
            </td>
            <td>
                <input type="text" name="keyword">
            </td>
            <td><input type="submit"></td>
        </tr>
    </table>
</s:form>

</table>--%>
</body>
</html>
