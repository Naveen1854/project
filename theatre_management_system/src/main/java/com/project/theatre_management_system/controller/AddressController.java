package com.project.theatre_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/saveAddress")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping("/fetchAddressById")
	public Address fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}

	@GetMapping("/fetchAddressOwner")
	public List<Address> fetchAllAddresses() {
		return addressService.fetchAllAddress();
	}

	@DeleteMapping("/deleteAddressById")
	public Address deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}

	@PutMapping("/updateAddressById")
	public Address updateAddressById(@RequestParam int oldAddressId, @RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
}
