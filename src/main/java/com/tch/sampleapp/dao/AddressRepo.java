package com.tch.sampleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tch.sampleapp.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
