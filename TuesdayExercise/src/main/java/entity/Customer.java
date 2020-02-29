/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

/**
 *
 * @author jenso
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> hobbies = new ArrayList();
    private String firstName;
    
    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "PHONE")
    @Column(name="Description")
    private Map<String, String> phones = new HashMap();
    
    public void addPhone(String phoneNo, String description){
        phones.put(phoneNo, description);
    }
    
    public String getDescription(String phoneNo){
        return phones.get(phoneNo);
    }
    
    public Long getId() {
        return id;
    }
    public Customer(){
        
    }
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void addHobbies(String hobby){
        hobbies.add(hobby);
    }
    
    public List getHobbies(){
        return hobbies;
    }

}
