package il.ac.hit.costmanagerDBSPRING.controller;
import il.ac.hit.costmanagerDBSPRING.model.DBCost.*;
import il.ac.hit.costmanagerDBSPRING.model.DBCost.CostsManagerDB;
import il.ac.hit.costmanagerDBSPRING.model.DBCost.UsersManagerDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class ApiComtrollers {
    //{"userName":"asf", "password":"asf"}
    @GetMapping(value = "/checklogin")
        public ResponseEntity<String> CheckLogin (@RequestBody User user){
            try {
                Boolean statusLogin = UsersManagerDB.checkLogin(user);
                String answer = statusLogin.toString();
                return new ResponseEntity<String>(answer, HttpStatus.OK);
                // return "welcome";
            }
            catch (DBException e) {
                return new ResponseEntity<String>("errorr", HttpStatus.OK);
            }

        }

    /**
     * Post request to add user to db.
     * @param user
     * @return
     */
    @PostMapping(value = "/adduser")
        public ResponseEntity<String> addUser(@RequestBody User user) {
            try {
                Boolean statusLogin = UsersManagerDB.addUser(user);
                String answer = statusLogin.toString();
                return new ResponseEntity<String>(answer, HttpStatus.OK);
                // return "welcome";
            }
            // send the excption on the client
            catch (DBException e)
            {
               System.out.println(e);
                return new ResponseEntity<String>("false", HttpStatus.OK);
        }
    }

    @GetMapping(value="/")
    public String homePage() {
        return "welcome";
    }
    @GetMapping(value="/getallcosts")
    public String errinfo() {
        return "you need to put a user name for search";
    }
    @GetMapping(value="/getallcosts/{userName}")
    public ResponseEntity<String> updateProduct(@PathVariable("userName") String userName) {
        try {
            String answer = CostsManagerDB.allUserCost(userName);
            return new ResponseEntity<String>(answer, HttpStatus.OK);
        }
        catch (DBException e) {
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
    }
//{"userName":"amit","category":"games","sum":"7","currency":"shekel","text":"New game","date":"1122-2-2"}
    @PostMapping(value = "/addcost")
    public ResponseEntity<String> Addcost (@RequestBody Cost cost)  {
        try {
            Boolean statusLogin = CostsManagerDB.addCost(cost);
            String answer = statusLogin.toString();
            return new ResponseEntity<String>(answer, HttpStatus.OK);
            // return "welcome";
        } catch (DBException e) {
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
    }

    /**
     * Check Login by post requests
     * @param user
     * @return
     */
    @PostMapping(value = "/checkloginpost")
    public ResponseEntity<String> checkLoginPost(@RequestBody User user){
        try {
            Boolean statusLogin = UsersManagerDB.checkLogin(user);
            String answer = statusLogin.toString();
            String newAnswer;
            if (answer == "true") {
                newAnswer = user.getUserName();
            } else {
                newAnswer = "false";
            }
            return new ResponseEntity<String>(newAnswer, HttpStatus.OK);
            // return "welcome";
        } catch (DBException e) {
            return new ResponseEntity<String>("false", HttpStatus.OK);
        }
    }
    //public ResponseEntity<Object> createProduct(@RequestBody Users user) {

   // }


    /**
     * Get all cost date filter for specfic user.
     * @param byDateInfo
     * @return
     */
    @PostMapping(value = "/getallcostbydate")
    public ResponseEntity<String> getAllCostByDate (@RequestBody ByDate byDateInfo) {
        try {
            String user = byDateInfo.getUserName();
            String fromDate = byDateInfo.getFromDate();
            String untilDate = byDateInfo.getUntilDate();
            String answer = CostsManagerDB.allUserCostsByDate(user, fromDate, untilDate);
            //String answer = costsManagerDB.AllUserCost(userName);
            return new ResponseEntity<String>(answer, HttpStatus.OK);
        } catch (DBException e) {
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
    }

}