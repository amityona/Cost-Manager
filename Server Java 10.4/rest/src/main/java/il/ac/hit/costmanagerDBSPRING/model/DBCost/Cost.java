package il.ac.hit.costmanagerDBSPRING.model.DBCost;

public class Cost implements ICost{
    private String userName;
    private String category;
    private double sum;
    private String currency;
    private String text;
    private String date;
// mange cost to db
    public Cost(String userName, String category, double sum, String currency, String text, String date) {
        setDate(date);
        setUserName(userName);
        setCategory(category);
        setSum(sum);
        setCurrency(currency);
        setText(text);
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
    public String getCategory() {
        return category;
    }
    @Override
    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public double getSum() {
        return sum;
    }
    @Override
    public void setSum(double sum) {
        this.sum = sum;
    }
    @Override
    public String getCurrency() {
        return currency;
    }
    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @Override
    public String getText() {
        return text;
    }
    @Override
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String getDate() {
        return date;
    }
    @Override
    public void setDate(String date) {
        this.date = date;
    }

}
