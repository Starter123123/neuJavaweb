<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
    * {
        background-color: #ffffff;
    }
</style>

<div class="data_list">
    <h1></h1>

    <div>
        <form method="post" action="manageTeacher.action?action=sureRejectM" onsubmit="return rejectThisRequestM()">
            <table class="table table-striped table-bordered table-hover datatable">
                <thead>
                <tr height="15px">
                    <th style="text-align: center;">课程编号：</th>
                    <th style="text-align: center;"><input name="courseId" id="courseId" type="text" width="400px"
                                                           height="26px"
                                                           style="border-bottom-right-radius: 3px"></th>
                </tr>
                <tr height="15px">
                    <th style="text-align: center;">学生账户：</th>
                    <th style="text-align: center;"><input name="stuAccount" id="stuAccount" type="text" width="400px"
                                                           height="26px"
                                                           style="border-bottom-right-radius: 3px"></th>
                </tr>
                <tr height="15px">
                    <th style="text-align: center;">驳回原因：</th>
                    <th style="text-align: center;"><input name="info" id="info" type="text" width="400px"
                                                           height="400px"
                                                           style="border-bottom-right-radius: 3px"></th>
                </tr>

                <tr style="width: 500px">
                    <td></td>
                    <td>
                        <input type="submit" value="确认">
                    </td>
                </tr>
                <tr style="width: 500px">
                    <td></td>
                    <td>
                        <span style="color: #dd1144" id="error"></span>
                    </td>
                </tr>
                </thead>
            </table>

        </form>

        <script>
            function rejectThisRequestM() {
                let info = document.getElementById("info").value;

                if (info==null||info.trim()=="") {
                    document.getElementById("error").innerHTML = "请输入完整理由";
                    return false;
                }
                return true;

            }
        </script>
    </div>
    <div align="center"><font color="red"></font></div>
</div>



