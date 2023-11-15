package com.northwind.api.repositories;

import com.northwind.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // JPQL
    List<Customer> findByCountry(String country);

    // Native Query ;
    @Query(value="select * from dbo.customers where lower(country)=:country",nativeQuery=true)
    List<Customer> findCustomerByCountry(String country);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update dbo.customers set " +
            "companyname=:companyName," +
            "contactname=:customerName," +
            "contacttitle=:title," +
            "address=:address," +
            "city=:city," +
            "region=:region," +
            "postalCode=:postalCode," +
            "country=:country," +
            "phone=:phone," +
            "fax=:fax " +
            "where customerid=:id",nativeQuery = true)
    int updateCustomers(String id, String companyName, String customerName, String title, String address, String city, String region, String postalCode, String country, String phone, String fax);
}
