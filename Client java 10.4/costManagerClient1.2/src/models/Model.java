package models;

public class Model implements IModel {
    /**
     * Add new User on the server side.
     * @param user the user
     * @return String status of the request
     */
    @Override
    public String postNewUser(User user) {

        String status = UsersUtilits.postUsers(user);
        // display the answer from server side
        return status;
    }

    /**
     * Check Login on the Server side.
     * by User obj
     *
     * @return true if login work
     */
    @Override
    public String checkLogin(User user) {
        String status = UsersUtilits.getCheckLogin(user);
        return status;
    }

    /**
     * postCost(Cost newCost)
     * post a new cost by user name and param
     *
     * @param NewCost the new cost
     * @return string
     */
    @Override
    public String postCost(Cost NewCost) {
        try {
            String userName = NewCost.getUserName();
            String category = NewCost.getCategory();
            double sum = NewCost.getSum();
            String date = NewCost.getDate();
            String currency = NewCost.getCurrency();
            String text = NewCost.getText();
            String answer = "";
            // add post to the server side db.
            StringBuilder data = new StringBuilder("{\n  \"userName\":\"" + userName + "\", \n  \"category\": \"" + category + "\"\n ,\"sum\":\"" + sum + "\"\n , \"currency\":\"" + currency + "\"\n ,\"text\":\"" + text + "\"\n ,\"date\":\"" + date + "\" }");
            answer = RequestsHTTPUtils.sendPOST("http://localhost:8080/addcost", data);
            return answer;
        } catch (ClientException e) {
            System.out.println(e);
            return "Not Working";
        }
    }

    /**
     * Check login on the server side.
     * return user name if true
     *
     * @param user
     */
    @Override
    public String getCheckLogin(User user) {
        try {
            String answer;
            String userName = user.getUserName();
            String password = user.getPassword();
            StringBuilder stringBuilder = new StringBuilder();
            // check login for specfic user if exsist in db.
            StringBuilder data = new StringBuilder("{\n  \"userName\":\"" + userName + "\", \n  \"password\": \"" + password + "\"\n}");
            answer = RequestsHTTPUtils.sendPOST("http://localhost:8080/checkloginpost", data);
            return answer;
        } catch (ClientException e) {
            System.out.println(e);
            return "Not Work";
        }
    }

    /**
     * Get all costs by specific user name.
     *
     * @param userName
     * @return String of all costs by user name
     */
    @Override
    public String getInfoCost(String userName) {
        String answer = "Error";
        try {
            // get the cost for the user
            answer = RequestsHTTPUtils.getUtilits("http://localhost:8080/getallcosts/" + userName);
        } catch (ClientException e) {
            System.out.println(e);
            return "Error! " + e.toString();
        }
        return answer;
    }


    /**
     * get costs from date-until date for specif user name
     *
     * @param filterDate
     * @return string of filter costs
     */
    @Override
    public String getCostsByDate(FilterDateByUserName filterDate) {
        try {
            String userName = filterDate.getUserName();
            String fromDate = filterDate.getFromDate();
            String untilDate = filterDate.getUntilDate();
            // json for the filter user and date.
            StringBuilder data = new StringBuilder("{\n  \"userName\":\"" + userName + "\", \n  \"fromDate\": \"" + fromDate + "\",\n \"untilDate\":\"" + untilDate + "\"}");
            String answer;
            answer = RequestsHTTPUtils.sendPOST("http://localhost:8080/getallcostbydate", data);
            System.out.println(data);
            return answer;
        } catch (ClientException e) {
            System.out.println(e);
            return "Not Work";
        }

    }
}
