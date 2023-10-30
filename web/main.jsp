<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <style>
        #BigBodyFrame{
            width: 1600px;
            height: 120px;
            border: grey 2px solid;
            background-image: url("chang.png");
        }
        #daohang{
            width: 250px;
            float: left;
            border: grey 1px solid;
        }
        #file{
            width: 230px;
            height: 50px;
            margin-left: 11px;
            margin-top: 10px;
            border: grey 1px solid;
            background-color: mediumslateblue;
        }
        a{
            color: white;
            font-size: 26px;
            margin-left: 30px;
            margin-top: 25px;
        }

    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" media="screen">
</head>
<body>
<div id="BigBodyFrame"></div>
<br>
<span style="float: right;color: grey;margin-right: 100px"> 当前用户：${session_person.userName}</span><br>
<span style="float: right;color: grey;margin-right: 100px"> 当前身份：${session_person.userOtherName}</span><br>
<br>
<div id="daohang">
    <c:if test="${session_person.userIdentity == 0}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="student.action?action=list">选择课程</a></li>
        <li id="file"><a href="student.action?action=goMyCourse">我的课程</a></li>
        <li id="file"><a href="student.action?action=goMyRequest">进度查询</a></li>
        <li id="file"><a href="student.action?action=goMyRequested">记录查询</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>
    <c:if test="${session_person.userIdentity == 1}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="teachTeacher.action?action=toExamineList">待审批申请</a></li>
        <li id="file"><a href="teachTeacher.action?action=goMyExamined">已审批申请</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>

    <c:if test="${session_person.userIdentity == 2}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="manageTeacher.action?action=toExamineList">待审批申请</a></li>
        <li id="file"><a href="manageTeacher.action?action=goMyExamined">已审批申请</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>

    <c:if test="${session_person.userIdentity == 3}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="man.action?action=list">用户管理</a></li>
        <li id="file"><a href="man.action?action=listCourse">课程管理</a></li>
        <li id="file"><a href="man.action?action=goAddPerson">添加用户</a></li>
        <li id="file"><a href="man.action?action=goAddCourse">添加课程</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>

</div>
<jsp:include page="${mainRignt=null?'blank.jsp':mainRight}"></jsp:include>

</body>
</html>
