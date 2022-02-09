package il.ac.hit.costmanagerDBSPRING.model.DBCost;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UsersManagerDBTest {

    @Test
    void checkLogin() throws DBException {
        User newUser = new User("a","a");
       Boolean status= UsersManagerDB.checkLogin(newUser);
       if (status == true)
       {
           System.out.println("Work Login");
       }
       else {
       System.out.print("Error");
       }
    }

    @Test
    void addUser() {
        try {
            User newUser = new User("a", "a");
            Boolean status = UsersManagerDB.addUser(newUser);
            if (status == false) {
                System.out.print("Work!");
            } else {
                System.out.println("Error");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}