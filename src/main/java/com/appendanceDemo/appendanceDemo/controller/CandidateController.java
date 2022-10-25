package com.appendanceDemo.appendanceDemo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appendanceDemo.appendanceDemo.Service.CandidateService;
import com.appendanceDemo.appendanceDemo.domain.Candidate;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get_all")
	public ResponseEntity<List<Candidate>> getAll(){
		return ResponseEntity.ok(candidateService.listAll());
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get_one/{id}")
	public ResponseEntity<Candidate> getOne(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(candidateService.getOne(id));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/insert")
	public ResponseEntity<Candidate> insertOne(@RequestBody Candidate candidate){
		return ResponseEntity.ok(candidateService.insert(candidate));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/update/{id}")
	public ResponseEntity<Candidate> updateOne(@RequestBody Candidate candidate,@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(candidateService.updateCandidate(id, candidate));
	}

	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> deleteOne(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(candidateService.deleteCandidate(id));
	}
	
}
