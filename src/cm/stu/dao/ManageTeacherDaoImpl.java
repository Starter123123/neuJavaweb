package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;

import java.util.List;

/**
 * @Author JiangWu
 * @Description TODO
 * @Date 2023/5/14 13:34
 * @Version 1.0
 */
public class ManageTeacherDaoImpl implements ManageTeacherDao {
    @Override
    public List<StudentCourse> toExamineList(String userAccount) {
        List<Person> list=getAllPerson();
        Person p=Person.getPersonByUserAccount(list,userAccount);
        assert p != null;
        String manageName=p.getUserName();
        String sql = "SELECT * FROM `studentcourse` WHERE manageName = '" + manageName + "' AND state='待主管审批'";
        return Deal.getMyExamineList(sql);
    }

//    @Override
//    public void rejectRequestM(String courseId, String stuAccount) {
////        String sql = "UPDATE `studentcourse` SET `state`='申请失败' WHERE courseId='" + courseId + "' AND studentAccount='" + stuAccount  + "'AND state = '待主管审批'";
////        Deal.deal(sql);
//    }

    @Override
    public void approveRequestM(String courseId, String stuAccount) {
        System.out.println(courseId);
        System.out.println(stuAccount);
        String sql = "UPDATE `studentcourse` SET `state`='申请成功' WHERE courseId='" + courseId + "' AND studentAccount='" + stuAccount  + "'AND state = '待主管审批'";
        Deal.deal(sql);
    }

    @Override
    public List<StudentCourse> goMyExamined(String userAccount) {
        List<Person> list=getAllPerson();
        Person p=Person.getPersonByUserAccount(list,userAccount);
        assert p != null;
        String manageName=p.getUserName();
        String sql = "SELECT * FROM studentcourse WHERE (state='申请成功' OR state='申请驳回') AND manageName ='"+manageName+"'";
        return Deal.getMyExamined(sql);
    }

    @Override
    public void sureRejectM(String courseId, String stuAccount,String info) {
        String sql = "UPDATE `studentcourse` SET `state`='申请驳回',info='"+info+"' WHERE courseId='" + courseId + "' AND studentAccount='" + stuAccount  + "'AND state = '待主管审批'";
        Deal.deal(sql);
    }

    public List<Person> getAllPerson() {
        String sql = "select * from person where userIdentity!=3";
        return Deal.getAllPerson(sql);
    }
}
