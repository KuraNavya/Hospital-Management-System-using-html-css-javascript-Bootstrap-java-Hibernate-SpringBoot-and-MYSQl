package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class patientService {
	@Autowired
    private patientRepository patientrepository;
public List<patient> listAll() {
    return patientrepository.findAll();
}

}
