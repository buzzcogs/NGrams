/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ngram;

import java.util.Map;

/**
 *
 * @author buzzcogs
 */
public class Association implements Map.Entry
{
    protected Object theKey;
    protected Object theValue;
    
    public Association(Object key, Object value)
    {
        if (key == null)
          System.out.println("Key must not be null.");
        theKey = key;
        theValue = value;        
    }
    
    public Association (Object key)
    {
        this(key,null);
    }
            
    public boolean equals(Object other)
    {
        if(other.equals(theKey))
            return true;
        
        return false;
    }
    public Object getValue()
    {
        return theValue;
    }
    
    public Object getKey()
    {
        return theKey;
    }
            
    public Object setValue(Object value)
    {
        Object oldValue = theValue;
        theValue = value;
        return oldValue;
    }
}
