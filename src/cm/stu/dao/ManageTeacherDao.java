package cm.stu.dao;

import cm.stu.bean.StudentCourse;

import java.util.List;

/**
 * @Author JiangWu
 * @Description TODO
 * @Date 2023/5/20 19:32
 * @Version 1.0
 */
public interface ManageTeacherDao {
    List<StudentCourse> toExamineList(String userAccount);

//    void rejectRequestM(String courseId, String stuAccount);

    void approveRequestM(String courseId, String stuAccount);

    List<StudentCourse> goMyExamined(String userAccount);

    void sureRejectM(String courseId,String stuAccount,String info);
}
