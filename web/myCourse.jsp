<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的课程</title>
    <style>
        table{
            width: 1300px;
        }
        tr,td{
            border: grey 1px ;
        }
        td{
            height: 40px;
        }
        table td{
            height: 60px;
            vertical-align: middle!important;  /*设置文字垂直居中*/
            text-align: center;
        }
        tr,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}

        th{font-weight:bold;background:#ccc;}

        .con-b .row .lf{
            width: 15%;
            text-align: center;
            padding: 10px;
        }
        .con-b .row .rg{
            width: 85%;
        }
        .con-b tr:nth-of-type(odd){
            background-color: #f2f2f2;
        }

    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">
    <thead>
    <tr class="row" style="color: black;font-size: 25px" >
        <td class="lf">课程编号</td>
        <td class="lf">课程名称</td>
        <td class="lf">主讲教师</td>
        <td class="lf">主管教师</td>
        <td style="width: 10%">退课</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${arr}" var="studentcourse">
        <tr>
            <td class="lf">${studentcourse.getCourseId()}</td>
            <td class="lf">${studentcourse.getCourseName()}</td>
            <td class="lf">${studentcourse.getTeachName()}</td>
            <td class="lf">${studentcourse.getManageName()}</td>
            <td><img style="width:40px;height: 40px"
                     onclick="quitCourse('${session_person.getUserAccount()}','${studentcourse.getCourseId()}')"
                     src="del.png"></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>

<script>
    
    function quitCourse(stuAccount,courseId) {
        window.location.href = "student.action?action=quitCourse&stuAccount=" + stuAccount +"&courseId="+courseId;
    }

</script>
</html>

