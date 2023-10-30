package cm.stu.dao;

import cm.stu.bean.StudentCourse;

import java.util.List;

public interface TeachTeacherDao {
    List<StudentCourse> toExamineList(String userAccount);

//    void rejectRequestT(String courseId, String stuAccount);

    void sureRejectT(String courseId, String stuAccount,String info);

    void approveRequestT(String courseId, String stuAccount);

    List<StudentCourse> goMyExamined(String userAccount);
}
