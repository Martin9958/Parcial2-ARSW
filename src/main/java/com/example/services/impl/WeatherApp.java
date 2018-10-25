/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services.impl;
import com.example.services.WheatherService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
/**
 *
 * @author 2124519
 */
public class WeatherApp implements WheatherService{
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=8b5f9d89ab010470abc66c0e7d06cfb5";
    
    
    /**
     * 
     * @param direction
     * @return 
     * @throws IOException 
     */
    public StringBuffer getWheaterdata(URL direction) throws IOException {

        HttpURLConnection con = (HttpURLConnection) direction.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response;
        } else {
            System.out.println("GET request not worked");
            return null;
        }
        
    }

    @Override
    public StringBuffer getCity(String city) throws IOException {
           URL object = new URL(String.format(GET_URL,city));
           return getWheaterdata(object);
       
    }

}
