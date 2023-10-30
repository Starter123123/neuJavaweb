package cm.stu.dao;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;

import java.util.List;

public interface StudentDao {
    List<Course> getAllCourse();
    List<StudentCourse> getMyCourse(String stuAccount);
    List<Course> getSearchCourse(String matchText);
    void requestCourse(String stuAccount,String courseId);
    void quitCourse(String stuAccount, String courseId);
    List<StudentCourse> getMyRequest(String stuAccount);
    List<StudentCourse> getMyRequested(String stuAccount);
    List<StudentCourse> getMyRequestedA(String stuAccount);
    List<StudentCourse> getMyRequestedR(String stuAccount);
}
