package il.ac.hit.costmanagerDBSPRING.model.DBCost;

public interface ICost {
    public String getUserName();
    public void setUserName(String userName);
    public String getCategory();
    public void setCategory(String category);
    public double getSum();
    public void setSum(double sum);
    public String getCurrency();
    public void setCurrency(String currency);
    public String getText();
    public void setText(String text);
    public String getDate();
    public void setDate(String date);

}
