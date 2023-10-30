package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;
import cm.stu.service.ManageTeacherService;
import cm.stu.service.ManageTeacherServiceImpl;
import cm.stu.service.TeachTeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author JiangWu
 * @Description TODO
 * @Date 2023/5/14 13:36
 * @Version 1.0
 */
@WebServlet("/manageTeacher.action")
public class ManageTeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        ManageTeacherService ms = new ManageTeacherServiceImpl();
        Person person = (Person) req.getSession().getAttribute("session_person");
        String userAccount = person.getUserAccount();

        String courseId = req.getParameter("courseId");
        String studentAccount = req.getParameter("stuAccount");

        switch (action) {
            case "goMyExamined" -> {
                List<StudentCourse> arr = ms.goMyExamined(userAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "myExamined.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "toExamineList" -> {
                List<StudentCourse> arr = ms.toExamineList(userAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "toExamineList.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "rejectRequestM" -> {
                req.getRequestDispatcher("rejectInfoM.jsp").forward(req, resp);
            }
            case "sureRejectM" -> {
                String info = req.getParameter("info");
                ms.sureRejectM(courseId, studentAccount, info);
                req.setAttribute("tip", "申请驳回，请关闭此页面");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            }
            case "approveRequestM" -> {
                ms.approveRequestM(courseId, studentAccount);
                List<StudentCourse> arr = ms.toExamineList(userAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "toExamineList.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
        }
    }
}
