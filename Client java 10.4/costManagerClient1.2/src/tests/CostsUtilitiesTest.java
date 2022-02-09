package tests;

import models.ClientException;
import models.Cost;
import models.Model;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * The type Costs utilities test.
 */
class CostsUtilitiesTest {

    /**
     * Post cost.
     */
    @Test
    @org.junit.Test
    void postCost() throws ClientException {
        Cost cost = new Cost("a", "asf", "asf", "ad", 13, "1222-1-1");
        Model obj = new Model();
        String status = obj.postCost(cost);
        try {
            assertEquals("false", status);
        }
        catch (Exception e)
        {
            throw new ClientException(e);
        }

        System.out.println("Cost  add status need to be (true) = " + status);
    }

    /**
     * Gets info cost.
     */
    @Test
    void getInfoCost() throws ClientException {
        boolean statusTest=true;
        String userName = "a";
        Model obj = new Model();
        String status = obj.getInfoCost(userName);
        System.out.println(status);
        if (status.length() < 5) {
            statusTest=false;
        }
        try {
            assertEquals(false, statusTest);
        } catch (Exception e) {
           throw new ClientException(e);
        }
    }
}