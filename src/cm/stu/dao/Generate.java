package cm.stu.dao;

public class Generate {
    public static int IsExistStuCourse(String studentAccount, String courseId) {
        String sql = "select count(*) num from studentcourse where studentAccount='"+studentAccount+"' AND courseId='"+courseId+"' AND state!='申请驳回'";
        return Deal.isExist(sql);
    }

    public static int isExistPersonAccount(String userAccount) {
        String sql = "select count(*) num from person where userAccount='"+userAccount+"'";
        return Deal.isExist(sql);
    }
}
