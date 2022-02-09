package il.ac.hit.costmanagerDBSPRING.model.DBCost;

import java.sql.SQLException;

/**
 * IUsersManager manage users in db
 */
public interface IUsersManager {

    /**
     * checkLogin(User user)
     * @param user
     * @return Boolean ture if user exsits and login work
     * @throws DBException
     */
    public static Boolean checkLogin(User user) throws DBException {
        return null;
    }

    /**
     *  addUser(User user )
     * @param user
     * @return Boolean true if user add
     * @throws DBException
     */
    public static Boolean addUser(User user ) throws DBException {
    return null;
    }
}
