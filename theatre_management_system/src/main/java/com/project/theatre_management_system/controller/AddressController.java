package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.service.AddressService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}

	@GetMapping("/fetchAllAddress")
	public ResponseStructureList<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}

	@DeleteMapping("/deleteAddressById")
	public ResponseStructure<Address> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}

	@PutMapping("/updateAddressById")
	public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId,
			@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
}
