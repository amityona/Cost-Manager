package models;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UsersUtilits {
    /**
     * post new user to server
     * @param user
     * @return string
     */
        public static String postUsers(User user) {
                String answer = "";
                String userName = user.getUserName();
                String password = user.getPassword();
                StringBuilder stringBuilder;
                stringBuilder = new StringBuilder("{\n  \"userName\":\"" + userName + "\", \n  \"password\": \"" + password + "\"\n}");
                try {
                    answer = RequestsHTTPUtils.sendPOST("http://localhost:8080/adduser", stringBuilder);
                } catch (ClientException e) {
                    System.out.println(e);
                    return "Not Work!";
                }
                return answer;
        }

    /**
     * Check if user is exists by post request
     * @param user
     * @return string the status of login
     */
        public static String getCheckLogin(User user) {
            try {
                String answer="";
                String userName = user.getUserName();
                String password = user.getPassword();
                StringBuilder stringBuilder;
                stringBuilder = new StringBuilder("{\n  \"userName\":\"" + userName + "\", \n  \"password\": \"" + password + "\"\n}");
                answer = RequestsHTTPUtils.sendPOST("http://localhost:8080/checkloginpost", stringBuilder);
                return answer;
            }
                 catch (ClientException e) {
                    System.out.println(e);
                    return "Not Work!";
                }

        }


    }


