package il.ac.hit.costmanagerDBSPRING.model.DBCost;

/**
 * get data costs by id from date until date
 * getUserName - specific user name to get date by id
 */
public interface IByDate {
     String getUserName();
     void setUserName(String userName);
     String getFromDate();
     void setFromDate(String fromDate);
     String getUntilDate();
     void setUntilDate(String untilDate);
}
