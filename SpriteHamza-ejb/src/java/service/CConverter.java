/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.awt.Color;
import javax.faces.application.FacesMessage;
import javax.faces.convert.ConverterException;

/**
 *
 * @author hamza
 * Converter class
 * Take color object converts it to String to user display
 * take String and converts it to color object to Db
 * 
 */


@FacesConverter(forClass=Color.class)
public  class CConverter implements Converter {

    /*
    Constructor
    */
    public CConverter(){
        
    }
    
    /*
    Responsible for converting string and returns it as object color
    */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
        
        
       return new Color(Integer.parseInt(value.substring(1,3),16),  //red
                         Integer.parseInt(value.substring(3,5),16),  //green
                         Integer.parseInt(value.substring(5,7),16)); //blue
        
      
       
    }
               
       
    /*
    Responsible for converting color object and returns it as a string
    */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
       
        
        
        return String.format("#%02x%02x%02x",
                       ((Color)value).getRed(),
                       ((Color)value).getGreen(),
                       ((Color)value).getBlue());
    }
    
  
    
}
