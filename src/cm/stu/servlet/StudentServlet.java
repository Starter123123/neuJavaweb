package cm.stu.servlet;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;
import cm.stu.dao.Generate;
import cm.stu.service.StudentService;
import cm.stu.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student.action")
public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String courseId = req.getParameter("courseId");
        StudentService ss = new StudentServiceImpl();
        Person person = (Person)( req.getSession().getAttribute("session_person"));
        String stuAccount = person.getUserAccount();

        switch (action) {
            case "list", "searchCourse" -> {
                List<Course> arr;
                if (action.equals("list")) {
                    arr = ss.getAllCourse();
                } else {
                    String matchText = req.getParameter("matchText");
                    arr = ss.getSearchCourse(matchText);
                }
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "course.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "goMyCourse", "quitCourse" -> {
                if (action.equals("quitCourse")) {
                    ss.quitCourse(stuAccount, courseId);
                }
                List<StudentCourse> arr = ss.getMyCourse(stuAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "myCourse.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "requestCourse" -> {
                int flag = Generate.IsExistStuCourse(stuAccount, courseId);
                if (flag == 0) {
                    ss.requestCourse(stuAccount, courseId);
                    req.setAttribute("tip", "成功申请");
                } else {
                    req.setAttribute("tip", "你已经选择这个课程了，本次选择失败！");
                }
                req.setAttribute("mainRight", "blank.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "goMyRequest" -> {
                List<StudentCourse> arr = ss.getMyRequest(stuAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "myRequest.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "goMyRequested" -> {
                List<StudentCourse> arr = ss.getMyRequested(stuAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "myRequested.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "goMyRequestedA" -> {
                List<StudentCourse> arr = ss.getMyRequestedA(stuAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "myRequested.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "goMyRequestedR" -> {
                List<StudentCourse> arr = ss.getMyRequestedR(stuAccount);
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "myRequested.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
        }
    }
}

