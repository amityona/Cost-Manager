package models;

public class Cost {
    private String userName;
    private String category;
    private String text;
    private String currency;
    private double sum;
    private String date;

    /**
     * cost class that help to add and remove cost
     * @param userName
     * @param category
     * @param text
     * @param currency
     * @param sum
     * @param date
     */
    public Cost(String userName, String category, String text, String currency, double sum, String date) {
        setUserName(userName);
        setCategory(category);
        setDate(date);
        setCurrency(currency);
        setText(text);
        setSum(sum);

    }

    /**
     * Get specif user name of cost
     * @return string
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the specific user of the cost.
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}

