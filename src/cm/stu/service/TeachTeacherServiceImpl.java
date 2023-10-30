package cm.stu.service;

import cm.stu.bean.StudentCourse;
import cm.stu.dao.TeachTeacherDao;
import cm.stu.dao.TeachTeacherDaoImpl;

import java.util.List;

public class TeachTeacherServiceImpl implements TeachTeacherService {
    TeachTeacherDao ttd = new TeachTeacherDaoImpl();

    @Override
    public List<StudentCourse> toExamineList(String userAccount) {
        return ttd.toExamineList(userAccount);
    }

//    @Override
//    public void rejectRequestT(String courseId, String stuAccount) {
//        ttd.rejectRequestT(courseId, stuAccount);
//    }

    @Override
    public void approveRequestT(String courseId, String stuAccount) {
        ttd.approveRequestT(courseId, stuAccount);
    }

    @Override
    public List<StudentCourse> goMyExamined(String userAccount) {
        return ttd.goMyExamined(userAccount);
    }

    @Override
    public void sureRejectT(String courseId, String stuAccount,String info) {
         ttd.sureRejectT(courseId,stuAccount,info);
    }
}
