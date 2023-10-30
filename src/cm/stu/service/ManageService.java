package cm.stu.service;

import cm.stu.bean.Course;
import cm.stu.bean.Person;

import java.util.List;

public interface ManageService {
    List<Person> getAllPerson();
     List<Course> getAllCourse();
    List<Person> getSearchPerson(String matchText);
    List<Course> getSearchCourse(String matchText);

    void addPerson(Person newPerson);
    void addCourse(Course newCourse);

    void sureUpPassword(String userAccount, String userPassword);

    void delThisPerson(String delAccount);
    void delThisCourse(String courseId);
}
