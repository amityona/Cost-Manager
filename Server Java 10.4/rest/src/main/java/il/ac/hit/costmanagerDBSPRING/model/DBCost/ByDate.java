package il.ac.hit.costmanagerDBSPRING.model.DBCost;


public class ByDate implements IByDate {
    private String userName;
    private String fromDate;
    private String untilDate;
    public ByDate(String userName, String fromDate, String untilDate) {
        setUserName(userName);
        setFromDate(fromDate);
        setUntilDate(untilDate);
    }
    @Override
    public String getUserName() {
        return userName;
    }
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String getFromDate() {
        return fromDate;
    }
    @Override
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    @Override
    public String getUntilDate() {
        return untilDate;
    }
    @Override
    public void setUntilDate(String untilDate) {
        this.untilDate = untilDate;
    }

}
