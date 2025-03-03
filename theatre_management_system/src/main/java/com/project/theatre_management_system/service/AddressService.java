package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.AddressDao;
import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.exception.AddressIdNotFound;
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

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully Saved the Address into db");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully Address fetched by id from db");
			responseStructure.setData(addressDao.fetchAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Address>> fetchAllAddress() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully All Address fetched from db");
		responseStructureList.setData(addressDao.fetchAllAddress());
		return new ResponseEntity<ResponseStructureList<Address>>(responseStructureList, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Address deleted by id from db");
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressDao.fetchAddressById(oldAddressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Address updated by id in db");
			responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

}
