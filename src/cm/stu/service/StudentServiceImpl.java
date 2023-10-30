package cm.stu.service;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;
import cm.stu.dao.StudentDao;
import cm.stu.dao.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao sd = new StudentDaoImpl();

    @Override
    public List<Course> getAllCourse() {
        return sd.getAllCourse();
    }

    @Override
    public List<StudentCourse> getMyCourse(String stuAccount) {
        return sd.getMyCourse(stuAccount);
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        return sd.getSearchCourse(matchText);
    }

    @Override
    public void requestCourse(String stuAccount, String courseId) {
        sd.requestCourse(stuAccount, courseId);
    }

    @Override
    public void quitCourse(String stuAccount, String courseId) {
        sd.quitCourse(stuAccount, courseId);
    }

    @Override
    public List<StudentCourse> getMyRequest(String stuAccount) {
        return sd.getMyRequest(stuAccount);
    }

    @Override
    public List<StudentCourse> getMyRequested(String stuAccount) {
        return sd.getMyRequested(stuAccount);
    }

    @Override
    public List<StudentCourse> getMyRequestedA(String stuAccount) {
        return sd.getMyRequestedA(stuAccount);
    }

    @Override
    public List<StudentCourse> getMyRequestedR(String stuAccount) {
        return sd.getMyRequestedR(stuAccount);
    }

}
