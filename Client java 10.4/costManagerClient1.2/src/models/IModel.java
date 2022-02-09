package models;

public interface IModel {
    /**
     * Post cost string.
     *
     * @param NewCost the new cost
     * @return the string
     */
     String postCost(Cost NewCost);

    /**
     * Gets check login.
     *
     * @param user the user
     * @return the check login
     */
    String getCheckLogin(User user);

    /**
     * Gets info cost.
     *
     * @param userName the user name
     * @return the info cost
     */
    String getInfoCost(String userName);

    /**
     * Gets costs by date.
     *
     * @param filterDate the filter date
     * @return the costs by date
     */
    String getCostsByDate(FilterDateByUserName filterDate);
    /**
     * Post new user string.
     *
     * @param user the user
     * @return the string
     */
    String postNewUser(User user);

    /**
     * Check login string.
     *
     * @param user the user
     * @return the string
     */
    String checkLogin(User user);
}
