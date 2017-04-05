/*
 */

package miniprojekti.entities;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Type {

    @Id
    String name;
    
    @ElementCollection
    List<String> reqFields;
    
    @ElementCollection
    List<String> optFields;

    public Type() {

    }
    
    public Type(String name, List<String> req, List<String> opt) {
        this.name = name;
        this.reqFields = req;
        this.optFields = opt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getReqFields() {
        return reqFields;
    }

    public void setReqFields(List<String> reqFields) {
        this.reqFields = reqFields;
    }

    public List<String> getOptFields() {
        return optFields;
    }

    public void setOptFields(List<String> optFields) {
        this.optFields = optFields;
    }

}
