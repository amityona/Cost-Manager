package il.ac.hit.costmanagerDBSPRING.model.DBCost;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostsManagerDBTest {

    @Test
    void addCost() {
        try {
            Cost newCost = new Cost("a", "test", 12, "shekel", "text", "0000-00-00");
            Boolean answer = CostsManagerDB.addCost(newCost);
            if (answer == true) {
                System.out.println("Work add cost");

            } else {
                System.out.println("the user is Exsits Error");
            }
        }
        catch (Exception e) {
            System.out.println("error add cost");
        }

    }

    @Test
    void allUserCost() {
        try {
            String answer = CostsManagerDB.allUserCost("a");
            if (answer.length() > 10) {
                System.out.println("Work");
            } else {
                System.out.println("Not Display All Users");
            }
        } catch (DBException ex) {
            System.out.println("errorr");
        }
    }

}