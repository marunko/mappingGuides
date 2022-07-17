package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TestDao;
import com.example.entity.tester.Tester;

@RestController
public class TestController {

	@Autowired
	private TestDao tdao;
	
	@GetMapping("/tester/create")
	public ResponseEntity<Tester> resiterTester(@RequestBody Tester tester){
		 
		tdao.createTester(tester);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/tester/update")
	public ResponseEntity<Tester> updateTester(@RequestBody Tester tester, @RequestParam String oldName){
		 
		tdao.updateTester(oldName, tester);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/tester/remove")
	public ResponseEntity<Tester> deleteTester(@RequestParam Long id){
		 
		tdao.removeTester(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
