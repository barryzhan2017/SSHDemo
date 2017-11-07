<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>帖子内容</title>
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
    <script type="text/javascript" src="/js/jquery.js"></script>
</head>

<body>
<div class="container">
    <div class="row" style="height:30px">
        <br>
        <br>
        <br>
        <br>
    </div>

    <!-- 用div重新布局 -->
    <table>
        <tr>
            <td width=100>
                <a href="admin_deletePost.action?fid=<s:property value='#currentPost.id'/>&uid=<s:property value="uid"/>">删除</a>
            </td>
            <td width="800">
                <font size="6"><s:property value="#currentPost.title"/></font>
            </td>
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
                                <td width="60%"></td>
                                <td width="20%"><s:date name="#p.time" format="yyyy-MM-dd hh:MM:ss"/></td>
                            </tr>

                            <tr>
                                <td width="16%"></td>
                                <td colspan="2" style="word-wrap:break-word; word-break: normal;">
                                    <p name="content" ><s:property value="#p.content"/></p>
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


<table style="width:900px;">
    <tr>
        <td align="right">
            <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
            <span>总记录数：<s:property value="totalCount"/>每页显示：<s:property value="pageSize"/></span>&nbsp;&nbsp;
            <span>
					 <s:if test="currPage!=1">
                         <a href="admin_viewPostPage.action?currPage=1&id=<s:property value="#currentPost.id"/>&fid=<s:property value="#currentPost.id"/>&category=<s:property value="#request.category"/>"> [首页]</a>&nbsp;&nbsp;
                         <a href="admin_viewPostPage.action?currPage=<s:property value="currPage-1"/>&fid=<s:property value="#currentPost.id"/>&category=<s:property value="#request.category"/>"> [上一页]</a>&nbsp;&nbsp;
                     </s:if>
					<s:if test="currPage!=totalPage">
                        <a href="admin_viewPostPage.action?currPage=<s:property value="currPage+1"/>&fid=<s:property value="#currentPost.id"/>&category=<s:property value="#request.category"/>">[下一页]</a>&nbsp;&nbsp;
                        <a href="admin_viewPostPage.action?currPage=<s:property value="totalPage"/>&fid=<s:property value="#currentPost.id"/>&category=<s:property value="#request.category"/>">[尾页]</a>&nbsp;&nbsp;
                    </s:if>
				</span>
        </td>
    </tr>
</table>
</div>
</body>
</html>
