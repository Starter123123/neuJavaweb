package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;

import java.util.List;

public class TeachTeacherDaoImpl implements TeachTeacherDao {
    @Override
    public List<StudentCourse> toExamineList(String userAccount) {
        List<Person> list=getAllPerson();
        Person p=Person.getPersonByUserAccount(list,userAccount);
        assert p != null;
        String teachName=p.getUserName();
        String sql = "SELECT * FROM `studentcourse` WHERE teachName = '" + teachName + "' AND state='待主讲审批'";
        return Deal.getMyExamineList(sql);
    }

//    @Override
//    public void rejectRequestT(String courseId, String stuAccount) {
////        String sql = "UPDATE studentcourse SET state ='申请驳回' WHERE courseId = '" + courseId + "' AND studentAccount='" + stuAccount + "' AND state = '待主讲审批'";
////        Deal.deal(sql);
//    }

    @Override
    public void sureRejectT(String courseId, String stuAccount,String info) {
        String sql = "UPDATE studentcourse SET state ='申请驳回' , info='"+info+"' WHERE courseId = '" + courseId + "' AND studentAccount='" + stuAccount + "' AND state = '待主讲审批'";
        Deal.deal(sql);
    }

    @Override
    public void approveRequestT(String courseId, String stuAccount) {
        String sql = "UPDATE studentcourse SET state ='待主管审批' WHERE courseId = '" + courseId + "' AND studentAccount='" + stuAccount + "' AND state = '待主讲审批'";
        Deal.deal(sql);
    }

    @Override
    public List<StudentCourse> goMyExamined(String userAccount) {
        List<Person> list=getAllPerson();
        Person p=Person.getPersonByUserAccount(list,userAccount);
        assert p != null;
        String teachName=p.getUserName();
        String sql = "SELECT * FROM studentcourse WHERE state!='待主讲审批' AND teachName='"+teachName+"'";
        return Deal.getMyExamined(sql);
    }
    public List<Person> getAllPerson() {
        String sql = "select * from person where userIdentity!=3";
        return Deal.getAllPerson(sql);
    }
}
