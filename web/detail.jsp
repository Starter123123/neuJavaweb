<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情界面</title>
    <style>
        table {
            width: 1300px;
        }

        tr, td {
            border: grey 1px;
        }

        td {
            height: 20px;
        }

        table td {
            height: 20px;
            vertical-align: middle !important; /*设置文字垂直居中*/
        }

        th {
            font-weight: bold;
            background: #ccc;
        }

        .con-b .row .lf {
            width: 15%;
            /*text-align: center;*/
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
<table border="1" cellspacing="0" align="center" class="con-b">
    <tbody>
    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">登录账户</td>
        <td class="lf">${session_person.getUserAccount()}</td>
    </tr>
    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">姓名</td>
        <td class="lf">${session_person.getUserName()}</td>
    </tr>

    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">身份</td>
        <td class="lf">${session_person.getUserOtherName()}</td>
    </tr>

    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">
            <button onclick="upPassword()">修改密码</button>
        </td>
    </tr>
    </tbody>

</table>
</body>
</html>
<script>
    function upPassword() {
        window.open("common.action?action=upPassword", null, "width=700,height=400,left=400,top=150", true);
    }
</script>