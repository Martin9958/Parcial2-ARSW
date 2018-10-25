/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.controller;

import com.example.services.WheatherService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2124519
 */

@RestController
@RequestMapping(value = "/wheather")
public class wheatherController {
    
    @Autowired
    public WheatherService ws; 
    
    @RequestMapping(method = RequestMethod.GET, path= "/{ciudad}")
    public StringBuffer getCityInformation(@PathVariable String ciudad){
        try{
            return ws.getCity(ciudad);
        }catch(IOException ex){
            return null;
        }
    }
    
}
