/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import java.io.IOException;

/**
 *
 * @author 2124519
 */
public interface WheatherService {
    /**
     * 
     * @param Name
     * @return
     * @throws IOException 
     */
    public StringBuffer getCity(String city) throws IOException;
        
}
