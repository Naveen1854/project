package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@Operation(summary = "fetch Address", description = "API is used to fetch the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}

	@Operation(summary = "fetch all Address", description = "API is used to fetch all the Addresses")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully fetched") })
	@GetMapping("/fetchAllAddress")
	public ResponseEntity<ResponseStructureList<Address>> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}

	@Operation(summary = "delete Address", description = "API is used to delete the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully deleted"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}

	@Operation(summary = "update Address", description = "API is used to update the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully updated"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@RequestParam int oldAddressId,
			@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
}
