package cm.stu.service;

import cm.stu.bean.StudentCourse;

import java.util.List;

/**
 * @Author JiangWu
 * @Description TODO
 * @Date 2023/5/20 19:34
 * @Version 1.0
 */
public interface ManageTeacherService {
    List<StudentCourse> toExamineList(String userAccount);
//    void rejectRequestM(String courseId, String stuAccount);
    void sureRejectM(String courseId, String stuAccount,String info);

    void approveRequestM(String courseId, String stuAccount);

    List<StudentCourse> goMyExamined(String userAccount);
}
