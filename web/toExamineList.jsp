<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>待审批申请</title>
    <style>
        table {
            width: 1300px;
        }

        tr, td {
            border: grey 1px;
        }

        td {
            height: 40px;
        }

        table td {
            height: 60px;
            vertical-align: middle !important; /*设置文字垂直居中*/
            text-align: center;
        }

        tr, td {
            border-right: 1px solid #888;
            border-bottom: 1px solid #888;
            padding: 5px 15px;
        }

        th {
            font-weight: bold;
            background: #ccc;
        }

        .con-b .row .lf {
            width: 12%;
            text-align: center;
            padding: 10px;
        }

        .con-b .row .rg {
            width: 85%;
        }

        .con-b tr:nth-of-type(odd) {
            background-color: #f2f2f2;
        }

    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">
    <thead>
    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">课程编号</td>
        <td class="lf">课程名称</td>
        <td class="lf">学生账户</td>
        <td class="lf">主讲教师</td>
        <td class="lf">主管教师</td>
        <td class="lf">状态</td>
        <td class="lf">备注信息</td>
        <td class="lf">批准</td>
        <td class="lf">驳回</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${arr}" var="studentcourse">
        <tr>
            <td class="lf">${studentcourse.getCourseId()}</td>
            <td class="lf">${studentcourse.getCourseName()}</td>
            <td class="lf">${studentcourse.getStudentAccount()}</td>
            <td class="lf">${studentcourse.getTeachName()}</td>
            <td class="lf">${studentcourse.getManageName()}</td>
            <td class="lf">${studentcourse.getState()}</td>
            <td class="lf">${studentcourse.getInfo()}</td>
            <c:if test="${session_person.getUserIdentity()==1}">
                <td><img style="width:40px;height: 40px"
                         onclick="approveRequestT('${studentcourse.getCourseId()}','${studentcourse.getStudentAccount()}')"
                         src="approve.png"></td>
                <td><img style="width:40px;height: 40px"
                         onclick="rejectRequestT('${studentcourse.getCourseId()}','${studentcourse.getStudentAccount()}')"
                         src="reject.png"></td>
            </c:if>
            <c:if test="${session_person.getUserIdentity()==2}">
                <td><img style="width:40px;height: 40px"
                         onclick="approveRequestM('${studentcourse.getCourseId()}','${studentcourse.getStudentAccount()}')"
                         src="approve.png"></td>
                <td><img style="width:40px;height: 40px"
                         onclick="rejectRequestM('${studentcourse.getCourseId()}','${studentcourse.getStudentAccount()}')"
                         src="reject.png"></td>
            </c:if>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>

<script>
    function approveRequestT(courseId, stuAccount) {
        window.location.href = "teachTeacher.action?action=approveRequestT&courseId=" + courseId + "&stuAccount=" + stuAccount
    }

    function rejectRequestT(courseId, stuAccount) {
        // window.location.href = "teachTeacher.action?action=rejectRequestT&stuAccount=" + stuAccount + "&courseId=" + courseId;
        window.open("teachTeacher.action?action=rejectRequestT&courseId=" + courseId + "&stuAccount=" + stuAccount, null, "width=700,height=400,left=400,top=150",true)
    }

    function approveRequestM(courseId, stuAccount) {
        window.location.href = "manageTeacher.action?action=approveRequestM&courseId=" + courseId + "&stuAccount=" + stuAccount
    }

    function rejectRequestM(courseId, stuAccount) {
        // window.location.href = "manageTeacher.action?action=rejectRequestM&stuAccount=" + stuAccount + "&courseId=" + courseId;
        window.open("manageTeacher.action?action=rejectRequestM&courseId=" + courseId + "&stuAccount=" + stuAccount, null, "width=700,height=400,left=400,top=150", true)
    }

</script>

</body>
</html>
