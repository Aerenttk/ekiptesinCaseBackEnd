package com.appendanceDemo.appendanceDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appendanceDemo.appendanceDemo.dao.CandidateRepository;
import com.appendanceDemo.appendanceDemo.domain.Candidate;

@Service
public class ImplCandidateService implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public List<Candidate> listAll() {
		return candidateRepository.findAll();
	}

	@Override
	public Candidate insert(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public Candidate updateCandidate(Long id, Candidate candidate) {
		Optional<Candidate> optional = this.candidateRepository.findById(id);

		if(optional.isPresent()) {

			Candidate canData = new Candidate();

			canData.setId(optional.get().getId());
			canData.setName(candidate.getName());
			canData.setLastName(candidate.getLastName());
			canData.setEmail(candidate.getEmail());
			canData.setCandidateStatus(candidate.getCandidateStatus());

			return candidateRepository.save(canData);
		}

		return null;
	}

	@Override
	public Candidate getOne(Long id) {
		Optional<Candidate> optional = candidateRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public String deleteCandidate(Long id) {
		Optional<Candidate> optional = candidateRepository.findById(id);
		
		if(optional.isPresent()) {
			candidateRepository.deleteById(id);
			return "Deleted";
		}
		
		return "Cannot find ID: "+id.toString();
	}
	
	

}
