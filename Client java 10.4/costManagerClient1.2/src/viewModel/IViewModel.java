package viewModel;

import models.Cost;
import models.FilterDateByUserName;
import models.Model;
import models.User;
import view.View;

public interface IViewModel {
    /**
     * Sets view.
     *
     * @param view the view
     */
    void setView(View view);

    /**
     * Sets model.
     *
     * @param model the model
     */
    void setModel(Model model);

    /**
     * add cost for username
     *
     * @param cost the cost
     */
    void addItem(Cost cost);

    /**
     * get all costs by username
     *
     * @param userName the user name
     */
    void getMyCosts(String userName);

    /**
     * get filter costs for username from date - until date
     *
     * @param filterDate the filter date
     */
    void getSpecialCostsByDate(FilterDateByUserName filterDate);

    /**
     * add user get User obj with username and password
     *
     * @param user the user
     */
    void addItem(User user);

    /**
     * Check Login to User obj by username and password
     *
     * @param user the user
     */
    void checkLogin(User user);
}
