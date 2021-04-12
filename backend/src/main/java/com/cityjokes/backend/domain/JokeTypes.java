/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cityjokes.backend.domain;

import lombok.AllArgsConstructor;

/**
 *
 * @author lilit 
 */
@AllArgsConstructor
public enum JokeTypes {
    GENERAL("General","general"), 
    PROGRAMMING("Programming","programming"),
    KNOCK_KNOCK("Knock-knock","knock-knock"); 

    private final String key;
    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    
    

    
    
}
