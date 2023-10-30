package cm.stu.bean;

import java.util.List;

/*
identity: 0学生，1主讲，2主管，3管理员
 */
public class Person {
    private String userAccount;
    private String userName;
    private String userPassword;
    private int userIdentity;
    private String userOtherName;

    public Person() {
    }

    public Person(String userAccount, String userName, String userPassword, int userIdentity, String userOtherName) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userIdentity = userIdentity;
        this.userOtherName = userOtherName;
    }

    public Person(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(int userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserOtherName() {
        return userOtherName;
    }

    public void setUserOtherName(String userOtherName) {
        this.userOtherName = userOtherName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIdentity=" + userIdentity +
                ", userOtherName='" + userOtherName + '\'' +
                '}';
    }
    public static  Person getPersonByUserAccount(List<Person> list, String userAccount){
        for(Person p:list){
            if(p.getUserAccount().equals(userAccount)){
                return  p;
            }
        }
        return null;
    }
}
