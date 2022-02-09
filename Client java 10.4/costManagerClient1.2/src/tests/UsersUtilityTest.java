package tests;

import models.ClientException;
import models.User;
import models.UsersUtilits;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * The type Users utilities test.
 */
class UsersUtilityTest {

    /**
     * Post users.
     */
    @Test
    void postUsers() throws ClientException{
        User newUser = new User("a", "a");
        String status = UsersUtilits.postUsers(newUser);
        try {
            assertEquals("true", status);
        }
        catch (Exception e)
        {
            throw new ClientException(e);
        }
    }

    /**
     * Gets check login.
     */
    @Test
    void getCheckLogin() throws ClientException {
        User newUser = new User("a", "a");
        String status = UsersUtilits.getCheckLogin(newUser);
        try {
            assertEquals("false", status);
        }
        catch (Exception e)
        {
            throw new ClientException(e);
        }
    }
}