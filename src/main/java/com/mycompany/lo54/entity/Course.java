/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.entity;

import java.io.Serializable;

/**
 *
 * @author PanJin
 */
public class Course implements Serializable {
    
   
    private String code;
    private String title;

    public Course() {
    }
    
    
    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
