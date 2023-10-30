package cm.stu.service;

import cm.stu.bean.StudentCourse;
import cm.stu.dao.ManageTeacherDao;
import cm.stu.dao.ManageTeacherDaoImpl;

import java.util.List;

/**
 * @Author JiangWu
 * @Description TODO
 * @Date 2023/5/14 15:51
 * @Version 1.0
 */
public class ManageTeacherServiceImpl implements ManageTeacherService {
    ManageTeacherDao mtd = new ManageTeacherDaoImpl();

    @Override
    public List<StudentCourse> toExamineList(String userAccount) {
        return mtd.toExamineList(userAccount);
    }

//    @Override
//    public void rejectRequestM(String courseId, String stuAccount) {
//        mtd.rejectRequestM(courseId, stuAccount);
//    }

    @Override
    public void sureRejectM(String courseId, String stuAccount, String info) {
        mtd.sureRejectM(courseId, stuAccount,info);
    }

    @Override
    public void approveRequestM(String courseId, String stuAccount) {
        mtd.approveRequestM(courseId, stuAccount);
    }

    @Override
    public List<StudentCourse> goMyExamined(String userAccount) {
        return mtd.goMyExamined(userAccount);
    }
}
