package il.ac.hit.costmanagerDBSPRING.model.DBCost;

/**
 * CostModel
 * addCost(Cost cost) - add costs to speceif user name  to db
 * allUserCost(String UserName) get all costs
 */
public interface CostModel {
    /**
     * addCost(Cost cost)
     * @param cost
     * @return true if cost add
     * @throws DBException
     */
    static Boolean addCost(Cost cost) throws DBException {
        return null;
    }

    /**
     *  allUserCost(String UserName)
     * @param UserName
     * @return String all costs by id information
     * @throws DBException
     */
   static String allUserCost(String UserName) throws DBException {
        return null;
   }
}
