package cm.stu.dao;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.bean.StudentCourse;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Deal {
    public static List<Course> getAllCourse(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Course> list = new ArrayList<>();
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Course newCourse = new Course();
                newCourse.setCourseId(res.getString("courseId"));
                newCourse.setCourseName(res.getString("courseName"));
                newCourse.setTeachName(res.getString("teachName"));
                newCourse.setManageName(res.getString("manageName"));
                list.add(newCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static List<StudentCourse> getMyCourse(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentCourse> list = new ArrayList<>();
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentCourse sc = new StudentCourse();
                sc.setCourseId(res.getString("courseId"));
                sc.setCourseName(res.getString("courseName"));
                sc.setTeachName(res.getString("teachName"));
                sc.setManageName(res.getString("manageName"));
                list.add(sc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static List<Person> getAllPerson(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Person> list = new ArrayList<>();
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                Person newPerson = new Person();
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentity(res.getInt("userIdentity"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
                list.add(newPerson);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }


    public static int isExist(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        int num=0;
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                num = res.getInt("num");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return num;
    }

    public static List<StudentCourse> getMyRequest(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentCourse> list = new ArrayList<>();
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentCourse sc = new StudentCourse();
                sc.setCourseId(res.getString("courseId"));
                sc.setCourseName(res.getString("courseName"));
                sc.setTeachName(res.getString("teachName"));
                sc.setManageName(res.getString("manageName"));
                sc.setState(res.getString("state"));
                sc.setInfo(res.getString("info"));
                list.add(sc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static List<StudentCourse> getMyExamineList(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentCourse> list = new ArrayList<>();
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentCourse sc = new StudentCourse();
                sc.setCourseId(res.getString("courseId"));
                sc.setCourseName(res.getString("courseName"));
                sc.setStudentAccount(res.getString("studentAccount"));
                sc.setTeachName(res.getString("teachName"));
                sc.setManageName(res.getString("manageName"));
                sc.setState(res.getString("state"));
                sc.setInfo(res.getString("info"));
                list.add(sc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static List<StudentCourse> getMyExamined(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentCourse> list = new ArrayList<>();
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                StudentCourse sc = new StudentCourse();
                sc.setCourseId(res.getString("courseId"));
                sc.setCourseName(res.getString("courseName"));
                sc.setStudentAccount(res.getString("studentAccount"));
                sc.setTeachName(res.getString("teachName"));
                sc.setManageName(res.getString("manageName"));
                sc.setState(res.getString("state"));
                sc.setInfo(res.getString("info"));
                list.add(sc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return list;
    }

    public static void deal(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            assert connection != null;
            pre =connection.prepareStatement(sql);
            pre.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
    }
}
