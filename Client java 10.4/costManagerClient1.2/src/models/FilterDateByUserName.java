package models;
// help mange filter request
public class FilterDateByUserName {
    private String userName;
    private String fromDate,untilDate;

    /**
     * class that help get costs by dates
     * @param userName
     * @param fromDate
     * @param untilDate
     */
    public FilterDateByUserName(String userName, String fromDate, String untilDate) {
        setUserName(userName);
        setFromDate(fromDate);
        setUntilDate(untilDate);
        this.untilDate = untilDate;
    }

    /**
     * Get user Name of obj.
     * @return String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set username to obj.
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the date of start the filter
     * @return String
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Set the date of start the filter
     * @parm fromDate
     */

    public void setFromDate(String fromDate) {
        this.fromDate= fromDate;
    }

    /**
     * Get the date of end the filter.
     * @return String
     */
    public String getUntilDate() {
        return untilDate;
    }

    /**
     * Set the date of end the filter
     * @param untilDate
     */
    public void setUntilDate(String untilDate) {
        this.untilDate = untilDate;
    }

}
