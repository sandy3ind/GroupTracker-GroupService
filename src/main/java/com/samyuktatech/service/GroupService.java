package com.samyuktatech.service;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samyuktatech.model.Group;


@RestController
@RequestMapping("/")
public class GroupService {

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody Group group, Errors errors) {
		
		if (errors.hasErrors()) {			
			// get all errors
            String msg = (errors.getAllErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(msg);
		}
		else {
			//TODO Save object
		}
		
		return ResponseEntity.ok(group);
		
	}
}
