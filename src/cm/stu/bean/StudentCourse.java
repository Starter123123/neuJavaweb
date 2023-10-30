package cm.stu.bean;

import java.util.List;

/*
state:待主讲审批、待主管审批、申请成功、申请驳回
 */
public class StudentCourse {
    private String courseId;
    private String courseName;
    private String studentAccount;
    private String teachName;
    private String manageName;
    private String state;
    private String info;

    public StudentCourse() {
    }

    public StudentCourse(String courseId, String courseName, String studentAccount, String teachName, String manageName, String state) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentAccount = studentAccount;
        this.teachName = teachName;
        this.manageName = manageName;
        this.state = state;
    }

    public StudentCourse(String courseId, String courseName, String studentAccount, String teachName, String manageName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentAccount = studentAccount;
        this.teachName = teachName;
        this.manageName = manageName;
    }

    public StudentCourse(String courseId, String courseName, String studentAccount, String teachName, String manageName, String state,String info) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentAccount = studentAccount;
        this.teachName = teachName;
        this.manageName = manageName;
        this.state = state;
        this.info = info;
    }

    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static StudentCourse getRequestByIdAndAccount(List<StudentCourse> list, String courseId, String studentAccount) {
        for (StudentCourse s : list) {
            if (s.getCourseId().equals(courseId) && s.getStudentAccount().equals(studentAccount)) {
                return s;
            }
        }
        return null;
    }
}
