package il.ac.hit.costmanagerDBSPRING.model.DBCost;

import java.sql.*;

// costs DB
public class CostsManagerDB implements CostModel {
    public static String driver ="com.mysql.jdbc.Driver";//-5.1.13-bin
    public static String protocol = "jdbc:mysql://localhost:3306/costmanager";
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet rs = null;
// get cost json and add to db

    /**
     * add cost to the db
     * @param cost
     * @return
     * @throws DBException
     */
    public static Boolean addCost(Cost cost) throws DBException  {
        String userName = cost.getUserName();
        String category= cost.getCategory();
        double sum=cost.getSum();
        String currency=cost.getCurrency();
        String text = cost.getText();
        String Date = cost.getDate();
        try {
            Class.forName(driver);
//Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol, "admin", "admin");
            statement = connection.createStatement();
            //ResultSet rs=statement.executeQuery("INSERT INTO `users` (`userName`, `password`) VALUES ("+UserName+", "+password+");");
            PreparedStatement stmt=connection.prepareStatement("INSERT INTO costs (userName, category, currency, text, sum, Date)  VALUES (?,?,?,?,?,?)");
            stmt.setString(1,userName);
            stmt.setString(2,category);
            stmt.setString(3,currency);
            stmt.setString(4,text);
            stmt.setDouble(5,sum);
            stmt.setString(6,Date);

            int rowsAdd=stmt.executeUpdate();
            if (rowsAdd>0) {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            throw new  DBException("false");
            // return false;
        }
        finally {
            try {
                connection.close();
                statement.close();
            }
            catch (Exception e)
            {
                throw  new DBException("false");
            }
        }
    }

    /**
     * get all the user costs
     * @param userName
     * @return
     * @throws DBException
     */
    // get all costs of user by username
    public static String allUserCost(String userName) throws DBException {
        String answer="";
        try {
            Class.forName(driver);
//Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol, "admin", "admin");
            statement = connection.createStatement();
            PreparedStatement stmt=connection.prepareStatement("select * from costs WHERE userName =?");
            stmt.setString(1,userName);//1 specifies the first parameter in the query
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                answer += "Category: "+ rs.getString(1).toString() + " Currency: "+ rs.getString(4).toString() +" Sum: "+ rs.getString(3).toString() + " Text: "+ rs.getString(5).toString()  +" Date: "+rs.getString(6)+ "\n";

            }
            return answer;

        }
        catch (Exception e) {
            System.out.println(e);
            throw new DBException("",e);
           // return answer="";
        }
        finally {
            try {
                connection.close();
                statement.close();
            }
            catch (Exception e)
            {
                throw  new DBException("");
            }
        }
    }

    /**
     * Get costs by filter date.
     * @param userName
     * @param fromDate
     * @param untilDate
     * @return
     * @throws DBException
     */
// filter costs for user :from date - until date
    public static String allUserCostsByDate(String userName,String fromDate,String untilDate) throws DBException {
        String answer="";
        try {
            Class.forName(driver);
//Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol, "admin", "admin");
            statement = connection.createStatement();
            PreparedStatement stmt=connection.prepareStatement("select * from costs WHERE userName =?  and Date > ?  and Date < ?");
            stmt.setString(1,userName);
            stmt.setString(2,fromDate);
            stmt.setString(3,untilDate);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                answer += "Category: "+ rs.getString(1).toString() + " Currency: "+ rs.getString(4).toString() +" Sum: "+ rs.getString(3).toString() + " Text: "+ rs.getString(5).toString()  +" Date: "+rs.getString(6)+ "\n";

            }
            System.out.println("answer");
            return answer;

        }
        catch (Exception e) {
            System.out.println(e);
            throw new DBException("");
            //return answer="";
        }
        finally {
            try {
                connection.close();
                statement.close();
            }
            catch (Exception e)
            {
                throw  new DBException("");
            }
        }
    }

}

