/*
 */

package miniprojekti.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reference {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    String type;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RefField> fields;

    public Reference() {
        
    }
    
    public Reference(String type, List<RefField> fields) {
        this.type = type;
        this.fields = fields;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RefField> getFields() {
        return fields;
    }

    public void setFields(List<RefField> fields) {
        this.fields = fields;
    }
}