package il.ac.hit.costmanagerDBSPRING.model.DBCost;
import java.sql.*;

/**
 * UsersManagerDB implements IUsersManager
 *parmas: driver protocol
 * addUser - checkLogin from SQL
 */
public class UsersManagerDB implements IUsersManager {

    // public static String driver = "org.apache.derby.jdbc.ClientDriver";
    public static String driver ="com.mysql.jdbc.Driver";//-5.1.13-bin
    public static String protocol = "jdbc:mysql://localhost:3306/costmanager";
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet rs = null;

    /**
     *  checkLogin(User user)
     * @param user
     * @return Boolean true if user exsits - login scusess
     * @throws DBException
     */
    public static Boolean checkLogin(User user) throws DBException {
        String userName=user.getUserName();
        String password=user.getPassword();
        try {
            Class.forName(driver);
//Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol, "admin", "admin");
            statement = connection.createStatement();
            PreparedStatement stmt=connection.prepareStatement("select * from users WHERE userName =? and password =?");
            stmt.setString(1,userName);//1 specifies the first parameter in the query
            stmt.setString(2,password);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).toString().length() >0) {
                    return true;
                };
             }
            return false;
            /*
            while (rs.next()) {
                if ((UserName == rs.getString(1).toString()) && (password == rs.getString(2).toString())) {
                    return true;
                }
                System.out.println("  " + rs.getString(1) + "  " + rs.getString(2));
            }
            */

        }
         catch (Exception e) {
            System.out.println(e);
            throw  new DBException("Errorr Login");
             //return false;
        }
        finally {
            try {
            connection.close();
            statement.close();
            }
            catch (Exception e)
            {
                throw  new DBException("Errorr Login");
            }
        }
    }

    /**
     * addUser(User user)
     * {userName : user , password : password}
     * @param user
     * @return Boolean true if user added
     * @throws DBException
     */
    public static Boolean addUser(User user ) throws DBException {
        String userName=user.getUserName();
        String password=user.getPassword();
        try {
            Class.forName(driver);
//Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol, "admin", "admin");
            statement = connection.createStatement();
            //ResultSet rs=statement.executeQuery("INSERT INTO `users` (`userName`, `password`) VALUES ("+UserName+", "+password+");");
            PreparedStatement stmt=connection.prepareStatement("INSERT INTO `users` (`userName`, `password`) VALUES (?,?)");
            stmt.setString(1,userName);
            stmt.setString(2,password);

            int rowsAdd=stmt.executeUpdate();
            if (rowsAdd > 0) {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            throw new DBException("Errorr add user",e);
            //return false;
        }
        finally {
            try {
                connection.close();
                statement.close();
            }
            catch (Exception e)
            {
                throw  new DBException("Errorr Login");
            }
        }
    }

}

