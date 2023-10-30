package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDaoImpl implements UserLoginDao {
    @Override
    public Person getLogin(Person person) {
        String sql = "select * from person where userAccount='"+person.getUserAccount()+"' and userPassword='"+person.getUserPassword()+"'";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        Person newPerson = null;
        try {
            pre =connection.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                newPerson = new Person();
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentity(res.getInt("userIdentity"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
        }
        return newPerson;
    }
}
