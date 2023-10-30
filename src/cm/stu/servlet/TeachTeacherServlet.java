package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;
import cm.stu.service.TeachTeacherService;
import cm.stu.service.TeachTeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teachTeacher.action")
public class TeachTeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        TeachTeacherService ts = new TeachTeacherServiceImpl();
        Person person = (Person) (req.getSession().getAttribute("session_person"));
        String userAccount = person.getUserAccount();

        String courseId = req.getParameter("courseId");
        String studentAccount = req.getParameter("stuAccount");
        switch (action) {
            case "goMyExamined" -> {
                List<StudentCourse> arr = ts.goMyExamined(userAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "myExamined.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "toExamineList" -> {
                List<StudentCourse> arr = ts.toExamineList(userAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "toExamineList.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "rejectRequestT" -> {
//                ts.rejectRequestT(courseId, studentAccount);
//                List<StudentCourse> arr = ts.toExamineList(userAccount);
//                req.setAttribute("arr", arr);
//                req.setAttribute("mainRight", "rejectInfoT.jsp");
                req.getRequestDispatcher("rejectInfoT.jsp").forward(req, resp);
            }
            case "sureRejectT"->{
                String info = req.getParameter("info");
                ts.sureRejectT(courseId, studentAccount,info);
                req.setAttribute("tip", "申请驳回，请关闭此页面");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            }
            case "approveRequestT" -> {
                ts.approveRequestT(courseId, studentAccount);
                List<StudentCourse> arr = ts.toExamineList(userAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "toExamineList.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
        }
    }
}
