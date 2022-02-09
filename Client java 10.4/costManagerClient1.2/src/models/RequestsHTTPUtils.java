package models;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class RequestsHTTPUtils {
    /**
     * get utilit dynamic
     * @param  url
     * @return the result from server
     * @throws ClientException
     */
    public static String getUtilits(String url) throws ClientException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result="";
        try {

            HttpGet request = new HttpGet(url);

            CloseableHttpResponse response = httpClient.execute(request);


            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    result = EntityUtils.toString(entity);
                    System.out.println(result);
                }

            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            throw new ClientException(e);
        } catch (IOException e) {
            throw new ClientException(e);
        }
            finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new ClientException(e);
            }
        }
    return result;
    }

    /**
     * * utilits
     * sent dynamic post request to server
     * @param url
     * @param json
     * @return the data from the server
     * @throws ClientException
     */
    public static String sendPOST(String url,StringBuilder json) throws ClientException{
        String result = "";
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");
        // send a JSON data
        try {
            post.setEntity(new StringEntity(json.toString()));
        } catch (UnsupportedEncodingException e) {
            throw new ClientException(e);
        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
        catch (IOException e) {
        throw new ClientException(e);
        }

        return result;
    }

}




