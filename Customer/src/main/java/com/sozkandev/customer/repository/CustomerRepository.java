package com.sozkandev.customer.repository;

import com.sozkandev.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //@Query("SELECT c.customerId FROM Customer c JOIN c.account a WHERE a.iban = :ibanNo")
    //long findCustomerIdByIban(@Param("ibanNo") long ibanNo);
   // @Query("SELECT c.customerId FROM Customer c WHERE c.account.iban = :ibanNo")
    //Long findCustomerIdByIban(@Param("ibanNo") long ibanNo);

    @Query("SELECT c.customerId FROM Customer c WHERE c.account.iban = :ibanNo")
    Long findCustomerIdByIban(@Param("ibanNo") long ibanNo);


}