package il.ac.hit.costmanagerDBSPRING.model.DBCost;

public class User implements IUser {
    private String userName,password;
    User(String userName, String password) {
        setUserName(userName);
        setPassword(password);

    }
    @Override
    public String getUserName() {
        return   this.userName;
    }
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

}
