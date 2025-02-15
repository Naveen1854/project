package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId) {
		return addressRepo.findById(addressId).get();
	}
	
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
	
	public Address deleteAddressById(int addressId) {
		Address address = fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
	public Address updateAddressById(int oldAddressId, Address newAddress) {
		newAddress.setAddressId(oldAddressId);
		return saveAddress(newAddress);
	}
}
