package com.appendanceDemo.appendanceDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appendanceDemo.appendanceDemo.domain.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
