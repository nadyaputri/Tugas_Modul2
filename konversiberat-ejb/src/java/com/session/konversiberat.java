/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author hp
 */
@Stateless
@LocalBean
public class konversiberat {

    
    DecimalFormat a  = new DecimalFormat("0.0");
    String result;
    
      public String personal(double param) {
        return result= a.format(param *5000);
    }
    public String paket_Malam(double param) {
        return result= a.format(param *2000);
     }
     public String paket_biasa(double param) {
        if (param>= 3 ){result= a.format(param *3000);
        }
        else {result= a.format(param *5000); }
        return result;
     }
   
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
    }
