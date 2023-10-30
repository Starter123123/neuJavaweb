package cm.stu.util;

import cm.stu.bean.Person;
import cm.stu.dao.Deal;
import cm.stu.dao.Generate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Deal.deal("INSERT INTO task VALUES('11','11','11','11')");
    }

    public static String getDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdt.format(date);
    }

    public static String getPersonAccount() {
        String userAccount ="";
        while (true){
            for(int i=0;i<8;i++){
                userAccount = userAccount+ (int) (Math.random() * 10);
            }
            int num = Generate.isExistPersonAccount(userAccount);
            if(num==0){
                break;
            }else {
                userAccount="";
            }
        }
        return userAccount;
    }
}
