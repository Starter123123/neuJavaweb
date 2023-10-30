package cm.stu.dao;

import cm.stu.bean.Course;
import cm.stu.bean.StudentCourse;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Course> getAllCourse() {
        String sql = "SELECT * from course";
        return Deal.getAllCourse(sql);
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        String sql = "SELECT * FROM `course` WHERE `courseId` LIKE'%" + matchText + "%' OR courseName LIKE'%" + matchText + "%' " +
                "OR teachName LIKE'%" + matchText + "%' OR manageName LIKE'%" + matchText + "%'";
        return Deal.getAllCourse(sql);
    }

    @Override
    public List<StudentCourse> getMyCourse(String stuAccount) {
        String sql = "SELECT courseId,courseName,teachName,manageName FROM studentcourse WHERE `state` = '申请成功' AND studentAccount='" + stuAccount+"'";
        return Deal.getMyCourse(sql);
    }

    @Override
    public void requestCourse( String stuAccount,String courseId) {
        List<Course> list=getAllCourse();
        Course c=Course.getCourseByCourseId(list,courseId);
        assert c != null;
        String courseName=c.getCourseName();
        String teachName=c.getTeachName();
        String manageName=c.getManageName();
        String sql = "INSERT INTO `studentcourse` values('" +courseId+ "','"+courseName+"','"+ stuAccount + "','" + teachName+ "','"+manageName+"','待主讲审批','申请课程')";
        Deal.deal(sql);
    }

    @Override
    public void quitCourse(String stuAccount, String courseId) {
        String sql = "DELETE FROM `studentcourse` WHERE `studentAccount`='" + stuAccount + "' AND `courseId`='" + courseId + "'";
        Deal.deal(sql);
    }

    @Override
    public List<StudentCourse> getMyRequest(String stuAccount) {
        String sql = "SELECT courseId,courseName,teachName,manageName,state,info FROM studentcourse WHERE `studentAccount` = '" + stuAccount+ "'AND (state != '申请成功' AND state !='申请驳回')";
        return Deal.getMyRequest(sql);
    }

    @Override
    public List<StudentCourse> getMyRequested(String stuAccount) {
        String sql = "SELECT courseId,courseName,teachName,manageName,state,info FROM studentcourse WHERE `studentAccount` = '" + stuAccount+ "' AND (state = '申请成功' OR state ='申请驳回')";
        return Deal.getMyRequest(sql);
    }

    @Override
    public List<StudentCourse> getMyRequestedA(String stuAccount) {
        String sql = "SELECT courseId,courseName,teachName,manageName,state,info FROM studentcourse WHERE `studentAccount` = '" + stuAccount+ "' AND state = '申请成功'";
        return Deal.getMyRequest(sql);
    }

    @Override
    public List<StudentCourse> getMyRequestedR(String stuAccount) {
        String sql = "SELECT courseId,courseName,teachName,manageName,state,info FROM studentcourse WHERE `studentAccount` = '" + stuAccount+ "' AND state ='申请驳回'";
        return Deal.getMyRequest(sql);
    }
}
