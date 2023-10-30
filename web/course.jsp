<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有课程</title>
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
            width: 15%;
            text-align: center;
            padding: 10px;
        }

        .con-b .row .rg {
            width: 85%;
        }

        .con-b tr:nth-of-type(odd) {
            background-color: #f2f2f2;
        }

        #content {
            width: 1300px;
            height: 70px;
            float: right;
            border: grey 1px solid;
            margin-right: 40px;
            color: grey;
            font-size: 50px;
        }
    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div id="content">
    <div style="float: right;height: 70px">
        <c:if test="${session_person.getUserIdentity()==0}">
        <form action="student.action?action=searchCourse" method="post">
            </c:if>
            <input type="text" name="matchText"
                   style="height: 35px;width: 500px;font-size: 28px;color: darkslateblue;border: grey solid 1px;">
            <input type="submit" style="margin-left: 6px;margin-right: 30px;font-size: 24px;" value="查询">
        </form>
    </div>
</div>

<br><br>
<table id="courseData" border="1" cellspacing="0" align="center" class="con-b">
    <thead>
    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">课程编号</td>
        <td class="lf">课程名称</td>
        <td class="lf">主讲教师</td>
        <td class="lf">主管教师</td>
        <td style="width: 10%">申请</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${arr}" var="course">
        <tr>
            <td class="lf">${course.getCourseId()}</td>
            <td class="lf">${course.getCourseName()}</td>
            <td class="lf">${course.getTeachName()}</td>
            <td class="lf">${course.getManageName()}</td>
            <td><img style="width:40px;height: 40px"
                     onclick="requestCourse('${person.getUserAccount()}','${course.getCourseId()}')"
                     src="requestCourse.png"></td>
        </tr>
    </c:forEach>

    </tbody>

</table>

<%--<table width="60%" align="right">--%>
<%--    <tr><td><div id="changePages" name="changePages"></div></td></tr>--%>
<%--</table>--%>



</body>

<script type="text/javascript">
    function requestCourse(stuAccount, courseId) {
        window.location.href = "student.action?action=requestCourse&stuAccount=" + stuAccount + "&courseId=" + courseId
    }

    // function goPage(pno, psize) {
    //     let iTable = document.getElementById("courseData");//获取table
    //     let num = iTable.rows.length;//得到记录总数
    //     let totalPage = 0;
    //     let pageSize = psize;//一页显示pageSize条记录
    //     //计算总页数
    //     if (num / pageSize > parseInt(num / pageSize)) {
    //         totalPage = parseInt(num / pageSize) + 1;
    //     } else {
    //         totalPage = parseInt(num / pageSize);
    //     }
    //     //当前页数
    //     let currentPage = pno;
    //     //获取当前页第一条、最后一条记录的行号
    //     let startRow = (currentPage - 1) * pageSize + 1;
    //     let endRow = currentPage * pageSize;
    //     endRow = (endRow > num) ? num : endRow;
    //     //修改table中当前页对应的行的属性为显示，非本页的记录为隐藏
    //     for (var i = 1; i < (num + 1); i++) {
    //         var irow = iTable.rows[i - 1];
    //         if (i >= startRow && i <= endRow) {
    //             irow.style.display = "block";
    //         } else {
    //             irow.style.display = "none";
    //         }
    //     }
    //
    //     //分页页码列表
    //     let tempStr = "共" + num + "条记录 分" + totalPage + "页 当前第" + currentPage + "页";
    //     if (currentPage > 1) {
    //         tempStr += "<a href=\"#\" onClick=\"goPage(" + (1) + "," + psize + ")\">首页</a>";
    //         tempStr += "<a href=\"#\" onClick=\"goPage(" + (currentPage - 1) + "," + psize + ")\"><上一页</a>"
    //     } else {
    //         tempStr += "首页";
    //         tempStr += "<上一页";
    //     }
    //
    //     if (currentPage < totalPage) {
    //         tempStr += "<a href=\"#\" onClick=\"goPage(" + (currentPage + 1) + "," + psize + ")\">下一页></a>";
    //         tempStr += "<a href=\"#\" onClick=\"goPage(" + (totalPage) + "," + psize + ")\">尾页</a>";
    //     } else {
    //         tempStr += "下一页>";
    //         tempStr += "尾页";
    //     }
    //     document.getElementById("changePages").innerHTML = tempStr;
    // }

</script>
</html>

