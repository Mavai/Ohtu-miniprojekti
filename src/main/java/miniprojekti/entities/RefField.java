/*
 */

package miniprojekti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RefField {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    String name;
    String content;
    boolean isRequired;
    
    public RefField() {
        
    }
    
    public RefField(String name, String content, boolean isRequired) {
        this.name = name;
        this.content = content;
        this.isRequired = isRequired;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIsRequired() {
        return isRequired;
    }

    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }
}
