package com.Backend;

import java.util.*;

import javax.persistence.Id;

public abstract class Entidad{
    
    @Id
    private UUID id;

    
    public UUID getId(){
        return this.id;
    }
  
    public void setId() {
        this.id = UUID.randomUUID();
    }
    public void validate(){
        try{
            if(id == null){
                throw new Exception("Invalid UUID, cannot validate.");
            }
        }catch(Exception excep){
            excep.printStackTrace();
        }
    }


//Overriding HashCode & equals methods. Failure to do so will result 
// in a violation of the general contract for Object.

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Entidad)){
            return false;
        }
        Entidad temp = (Entidad) object;
        return this.getId().equals(temp.getId());
    }


}
 
