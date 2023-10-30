package cm.stu.dao;

import cm.stu.bean.Course;
import cm.stu.bean.Person;

import java.util.List;

public class ManageDaoImpl implements ManageDao {
    @Override
    public List<Person> getAllPerson() {
        String sql = "select * from person where userIdentity!=3";
        return Deal.getAllPerson(sql);
    }

    public List<Course> getAllCourse() {
        String sql = "SELECT * from course";
        return Deal.getAllCourse(sql);
    }
    @Override
    public List<Person> getSearchPerson(String matchText) {
        String sql = "SELECT * FROM person WHERE userIdentity!=3 AND (userAccount='" + matchText + "' OR userName LIKE '%" + matchText + "%' OR userOtherName LIKE '%" + matchText+"%')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        String sql = "SELECT * FROM `course` WHERE `courseId` LIKE'%" + matchText + "%' OR courseName LIKE'%" + matchText + "%' " +
                "OR teachName LIKE'%" + matchText + "%' OR manageName LIKE'%" + matchText + "%'";
        return Deal.getAllCourse(sql);
    }

    @Override
    public void addPerson(Person newPerson) {
        String sql = "insert into person values('" + newPerson.getUserAccount() + "','" + newPerson.getUserName() + "','" + newPerson.getUserPassword() + "','" + newPerson.getUserIdentity() + "','" + newPerson.getUserOtherName() + "')";
        Deal.deal(sql);
    }
    public void addCourse(Course newCourse) {
        String sql = "insert into course values('" + newCourse.getCourseId() + "','" + newCourse.getCourseName() + "','" + newCourse.getTeachName() + "','" + newCourse.getManageName() + "')";
        Deal.deal(sql);
    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) {
        String sql = "update person set userPassword = '" + userPassword + "' where userAccount='" + userAccount + "'";
        Deal.deal(sql);
    }

    @Override
    public void delThisPerson(String delAccount) {
        Person p=Person.getPersonByUserAccount(getAllPerson(),delAccount);
        String name=p.getUserName();
        String sql1 = "DELETE FROM studentcourse WHERE `studentAccount` = '" + delAccount + "'";
        Deal.deal(sql1);
        String sql2 = "DELETE FROM person WHERE userAccount = '" + delAccount + "'";
        Deal.deal(sql2);
        String sql3 = "DELETE FROM course WHERE teachName = '" + name + "' OR manageName= '"+name+"'";
        Deal.deal(sql3);
    }

    @Override
    public void delThisCourse(String courseId) {
        String sql1 = "DELETE FROM studentcourse WHERE `courseId` = '" + courseId + "'";
        Deal.deal(sql1);
        String sql2 = "DELETE FROM course WHERE courseId = '" + courseId + "'";
        Deal.deal(sql2);
    }
}
