/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jenso
 */
@Entity
public class Customer2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String firstName;
    private String lastName; 
    
    /*@OneToOne
    private Address address;*/
    //This way of generating a one to many relationship (One to many without JoinColumn) generates an additional table to map Customer ID to an Address ID
    //One to many makes customer able to have multiple addresses
    /*@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer2")
    @JoinColumn(name = "id")*/
    //Many to many allows both customers and addresses to have multiple customers and addresses
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList();

    public List<Address> getAdresses() {
        return addresses;
    }

    public void setAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer2(this);
        
    }

    public Customer2() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}
