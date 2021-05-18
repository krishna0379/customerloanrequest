package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entites.CustomerLoanRequest;
import com.capgemini.exception.CustomerLoanRequestNotFoundException;
import com.capgemini.repository.CustomerLoanRequestRepository;
import com.capgemini.service.ICustomerLoanRequestService;

@RestController
@RequestMapping("api/custmoerloanrequest/")
public class CustomerLoanRequestController {

	@Autowired
	CustomerLoanRequestRepository customerLoanRequestRepository;

	@Autowired
	ICustomerLoanRequestService icustomerLoanRequestService;

	@PostMapping("/addloandetails")
	public ResponseEntity<String> createloandetails(@RequestBody CustomerLoanRequest customerLoanRequest) {
		icustomerLoanRequestService.addCustomerLoanRequest(customerLoanRequest);
		return new ResponseEntity<>("Added", HttpStatus.OK);
	}

	@PutMapping("/{loan_id}")
	public ResponseEntity<String> updateloandetails(@PathVariable int id,
			@RequestBody CustomerLoanRequest customerLoanRequest) throws CustomerLoanRequestNotFoundException {
		icustomerLoanRequestService.updateCustomerLoanRequest(id, customerLoanRequest);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}

	@DeleteMapping("/{loanid}")
	public ResponseEntity<String> deleteLoan_details(@PathVariable int id) {
		icustomerLoanRequestService.deleteCustomerLoanRequest(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}
}
