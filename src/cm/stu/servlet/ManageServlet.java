package cm.stu.servlet;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.service.ManageService;
import cm.stu.service.ManageServiceImpl;
import cm.stu.util.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/man.action")
public class ManageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        ManageService ms = new ManageServiceImpl();
        switch (action) {
            case "list", "getSearchPerson", "delThisPerson" -> {
                List<Person> arr;
                if (action.equals("list") || action.equals("delThisPerson")) {
                    if (action.equals("delThisPerson")) {
                        String delAccount = req.getParameter("userAccount");
                        ms.delThisPerson(delAccount);
                    }
                    arr = ms.getAllPerson();
                } else {
                    String matchText = (req.getParameter("matchText")).trim();
                    arr = ms.getSearchPerson(matchText);
                }
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "listPerson.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "listCourse","getSearchCourse" -> {
                List<Course> arr ;
                if(action.equals("getSearchCourse")){
                    String matchText = (req.getParameter("matchText")).trim();
                    arr = ms.getSearchCourse(matchText);
                }else{
                    arr = ms.getAllCourse();
                }
                req.setAttribute("arr", arr);
                req.setAttribute("mainRight", "listCourse.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "goAddPerson" -> {
                req.setAttribute("mainRight", "addPerson.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "goAddCourse" -> {
                req.setAttribute("mainRight", "addCourse.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "addThisPerson" -> {
                String newUserAccount = Test.getPersonAccount();
                String userName = req.getParameter("userName");
                String userPassword = req.getParameter("userPassword");
                int userIdentity = Integer.parseInt(req.getParameter("userIdentity"));
                String userOtherName = req.getParameter("userOtherName");
                Person newPerson = new Person(newUserAccount, userName, userPassword, userIdentity, userOtherName);
                System.out.println(newPerson);
                ms.addPerson(newPerson);
                req.setAttribute("tip", "添加人员完成");
                req.setAttribute("mainRight", "blank.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
            case "addThisCourse" -> {
                String courseId = req.getParameter("courseId");
                String courseName = req.getParameter("courseName");
                String teachName = req.getParameter("teachName");
                String manageName = req.getParameter("manageName");
                Course newCourse = new Course(courseId, courseName, teachName, manageName);
                ms.addCourse(newCourse);
                req.setAttribute("tip", "添加课程完成");
                req.setAttribute("mainRight", "blank.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            }
        }
    }
}
