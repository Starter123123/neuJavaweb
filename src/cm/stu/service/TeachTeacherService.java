package cm.stu.service;

import cm.stu.bean.StudentCourse;

import java.util.List;

public interface TeachTeacherService {
    List<StudentCourse> toExamineList(String userAccount);

//    void rejectRequestT(String courseId, String stuAccount);

    void approveRequestT(String courseId, String stuAccount);

    List<StudentCourse> goMyExamined(String userAccount);
    void sureRejectT(String courseId, String stuAccount,String info);

}
