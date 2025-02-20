package com._SpringSecurity.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._SpringSecurity.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
