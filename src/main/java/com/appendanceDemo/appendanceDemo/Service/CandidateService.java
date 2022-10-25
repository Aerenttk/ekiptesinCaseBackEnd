package com.appendanceDemo.appendanceDemo.Service;

import java.util.List;

import com.appendanceDemo.appendanceDemo.domain.Candidate;

public interface CandidateService {

	List<Candidate> listAll();
	Candidate insert(Candidate candidate);
	Candidate updateCandidate(Long id, Candidate candidate);
	Candidate getOne(Long id);
	String deleteCandidate(Long id);
}
