<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

</script>
<div class="data_list">
</div>

<form method="post" action="man.action?action=addThisPerson" onsubmit="return checkThis()">

    <div class="data_form">
        <table align="center">
            <tr>
                <td><font color="red">*</font>姓名：</td>
                <td><input type="text" id="userName" name="userName"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>身份：</td>
                <td>
                    <select id="userIdentity" name="userIdentity" style="width: 205px" ;>
                        <option id="a" value="0">学生</option>
                        <option id="b" value="1">主讲老师</option>
                        <option id="c" value="2">主管老师</option>
                    </select>
                </td>
            </tr>


            <tr>
                <td><font color="red">*</font>职务：</td>
                <td><input type="text" id="userOtherName" name="userOtherName" placeholder="某科老师/学生"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>


            <tr>
                <td><font color="red">*</font>输入密码：</td>
                <td><input type="text" id="userPassword" name="userPassword"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>确认密码：</td>
                <td><input type="text" id="rUserPassword" name="rUserPassword"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>
            <script>

                function checkThis() {
                    let userName = document.getElementById("userName").value;
                    let userOtherName = document.getElementById("userOtherName").value;
                    let userPassword = document.getElementById("userPassword").value;
                    let rUserPassword = document.getElementById("rUserPassword").value;
                    if (userName.trim() == null || userName.trim() === "") {
                        document.getElementById("error").innerHTML = "姓名不能为空！";
                        return false;
                    }
                    if (userOtherName.trim() == null || userOtherName.trim() === "") {
                        document.getElementById("error").innerHTML = "身份不能为空！";
                        return false;
                    }
                    if (userPassword == null || userPassword.trim() === "") {
                        document.getElementById("error").innerHTML = "密码不能为空！";
                        return false;
                    }
                    if (rUserPassword == null || rUserPassword.trim() === "") {
                        document.getElementById("error").innerHTML = "密码不能为空！";
                        return false;
                    }
                    if (rUserPassword !== userPassword) {
                        document.getElementById("error").innerHTML = "两次密码不相同";
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

