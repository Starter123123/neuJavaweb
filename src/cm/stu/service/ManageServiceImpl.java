package cm.stu.service;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.dao.ManageDao;
import cm.stu.dao.ManageDaoImpl;

import java.util.List;

public class ManageServiceImpl implements ManageService {
    ManageDao md = new ManageDaoImpl();

    @Override
    public List<Person> getAllPerson() {
        return md.getAllPerson();
    }

    @Override
    public List<Course> getAllCourse() {
        return md.getAllCourse();
    }

    @Override
    public List<Person> getSearchPerson(String matchText) {
        return md.getSearchPerson(matchText);
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        return md.getSearchCourse(matchText);
    }

    @Override
    public void addPerson(Person newPerson) {
        md.addPerson(newPerson);
    }

    @Override
    public void addCourse(Course newCourse) {
        md.addCourse(newCourse);

    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) {
        md.sureUpPassword(userAccount, userPassword);
    }

    @Override
    public void delThisPerson(String delAccount) {
        md.delThisPerson(delAccount);
    }

    @Override
    public void delThisCourse(String courseId) {
        md.delThisCourse(courseId);
    }
}
