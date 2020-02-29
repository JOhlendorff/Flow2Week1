package entity;

import entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-28T13:41:08")
@StaticMetamodel(Customer2.class)
public class Customer2_ { 

    public static volatile SingularAttribute<Customer2, String> firstName;
    public static volatile SingularAttribute<Customer2, String> lastName;
    public static volatile ListAttribute<Customer2, Address> addresses;
    public static volatile SingularAttribute<Customer2, Integer> id;

}