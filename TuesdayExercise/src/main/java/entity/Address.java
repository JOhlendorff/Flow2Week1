/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author jenso
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Adding bidirectional one to one doesnt seem to have added customerID to the address table. I think it is because
    //the customer is still the owning side of the relationship
    /*@OneToOne(mappedBy = "address")*/
    /*@ManyToOne(fetch = FetchType.LAZY)
    private Customer2 customer2;*/
    @ManyToMany(mappedBy = "addresses")
    private List<Customer2> customer2s = new ArrayList();

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
    private String city;
    private String street;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Customer2> getCustomer2() {
        return customer2s;
    }

    public void setCustomer2(Customer2 customer2) {
        this.customer2s.add(customer2);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    
    
}
