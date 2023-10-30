<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户</title>
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
        <c:if test="${session_person.getUserIdentity()==3}">
        <form action="man.action?action=getSearchPerson" method="post">
            </c:if>
            <input type="text" name="matchText"
                   style="height: 35px;width: 500px;font-size: 28px;color: darkslateblue;border: grey solid 1px;">
            <input type="submit" style="margin-left: 6px;margin-right: 30px;font-size: 24px;" value="查询">
        </form>
    </div>
</div>

<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">
    <thead>
    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">账户</td>
        <td class="lf">姓名</td>
        <td class="lf">密码</td>
        <td class="lf">身份</td>
        <td class="lf">详细</td>
        <td style="width: 10%">删除用户</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${arr}" var="person">
        <tr>
            <td class="lf">${person.getUserAccount()}</td>
            <td class="lf">${person.getUserName()}</td>
            <td class="lf">${person.getUserPassword()}</td>
            <td class="lf">${person.getUserIdentity()}</td>
            <td class="lf">${person.getUserOtherName()}</td>
            <td>
                <img src="del.png" onclick="delThisPerson('${person.getUserAccount()}')">
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

</body>

<script>
    function delThisPerson(userAccount) {
        window.location.href = "man.action?action=delThisPerson&userAccount="+userAccount;
    }
</script>
</html>

