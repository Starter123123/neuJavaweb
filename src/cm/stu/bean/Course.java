package cm.stu.bean;

import java.util.List;

/**
 * @Author JiangWu
 * @Description TODO
 * @Date 2023/5/6 17:23
 * @Version 1.0
 */
public class Course {
    private String courseId;
    private String courseName;
    private String teachName;
    private String manageName;

    public Course() {
    }

    public Course(String courseId, String courseName, String teachName, String manageName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teachName = teachName;
        this.manageName = manageName;
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

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teachName='" + teachName + '\'' +
                ", manageName='" + manageName + '\'' +
                '}';
    }

    public static  Course getCourseByCourseId(List<Course> list,String courseId){
        for(Course c:list){
            if(c.getCourseId().equals(courseId)){
                return  c;
            }
        }
        return null;
    }
}
