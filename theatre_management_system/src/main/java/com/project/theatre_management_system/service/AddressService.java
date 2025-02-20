package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.AddressDao;
import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	@Autowired
	ResponseStructureList<Address> responseStructureList;

	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Address into db");
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}

	public ResponseStructure<Address> fetchAddressById(int addressId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully Address fetched by id from db");
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return responseStructure;
	}

	public ResponseStructureList<Address> fetchAllAddress() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully AllAddress fetched from db");
		responseStructureList.setData(addressDao.fetchAllAddress());
		return responseStructureList;
	}

	public ResponseStructure<Address> deleteAddressById(int addressId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address deleted by id from db");
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return responseStructure;
	}

	public ResponseStructure<Address> updateAddressById(int oldAddressId, Address newAddress) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Address updated by id in db");
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return responseStructure;
	}

}
