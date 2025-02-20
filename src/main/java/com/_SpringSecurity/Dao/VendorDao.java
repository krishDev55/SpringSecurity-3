package com._SpringSecurity.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._SpringSecurity.entity.Vendors;
import java.util.List;


@Repository
public interface VendorDao  extends JpaRepository<Vendors, String>{

	Vendors findByEmail(String email);
	

}
