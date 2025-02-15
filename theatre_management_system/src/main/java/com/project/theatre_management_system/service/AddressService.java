package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.AddressDao;
import com.project.theatre_management_system.dto.Address;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	public Address saveAddress(Address address) {
		return addressDao.saveAddress(address);
	}

	public Address fetchAddressById(int addressId) {
		return addressDao.fetchAddressById(addressId);
	}

	public List<Address> fetchAllAddress() {
		return addressDao.fetchAllAddress();
	}

	public Address deleteAddressById(int addressId) {
		return addressDao.deleteAddressById(addressId);
	}

	public Address updateAddressById(int oldAddressId, Address newAddress) {
		return addressDao.updateAddressById(oldAddressId, newAddress);
	}

}
