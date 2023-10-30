<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

</script>
<div class="data_list">
</div>

<form method="post" action="man.action?action=addThisCourse" onsubmit="return checkThis()">
    <div class="data_form">
        <table align="center">
            <tr>
                <td><font color="red">*</font>课程编号：</td>
                <td><input type="text" id="courseId" name="courseId"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>
            <tr>
                <td><font color="red">*</font>课程名称：</td>
                <td><input type="text" id="courseName" name="courseName"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>主讲老师：</td>
                <td><input type="text" id="teachName" name="teachName"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>主管老师：</td>
                <td><input type="text" id="manageName" name="manageName"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>
            <script>


                function checkThis() {
                    let courseId = document.getElementById("courseId").value;
                    let courseName = document.getElementById("courseName").value;
                    let teachName = document.getElementById("teachName").value;
                    let manageName = document.getElementById("manageName").value;
                    if (courseId.trim() == null || courseId.trim() === "") {
                        document.getElementById("error").innerHTML = "课程编号不能为空！";
                        return false;
                    }
                    if (courseName.trim() == null || courseName.trim() === "") {
                        document.getElementById("error").innerHTML = "课程名称不能为空！";
                        return false;
                    }
                    if (teachName == null || teachName.trim() === "") {
                        document.getElementById("error").innerHTML = "主讲老师不能为空！";
                        return false;
                    }
                    if (manageName.trim() == null || manageName.trim() === "") {
                        document.getElementById("error").innerHTML = "主管老师不能为空！";
                        return false;
                    }
                    if (teachName.trim() === manageName.trim()) {
                        document.getElementById("error").innerHTML = "主讲教师和主管教师不能相同";
                        return false;
                    }
                    return true;
                }
            </script>
        </table>
        <div align="center">
            <input type="submit" class="btn btn-primary" value="保存"/>
            <span style="color: #dd1144" id="error">${tip}</span>
        </div>
    </div>
</form>
</div>

