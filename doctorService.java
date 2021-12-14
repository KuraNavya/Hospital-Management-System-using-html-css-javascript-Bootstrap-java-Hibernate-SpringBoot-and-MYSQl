package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional

public class doctorService {
	@Autowired
	 private doctorRepository doctorrepository;
	 public List<doctor> listAll() {
	     return doctorrepository.findAll();
	 }
	 public void delete(int id) {
		 doctorrepository.deleteById(id);
	    }
	 public doctor get(int id) {
	        return doctorrepository.findById(id).get();
	    }
	 public void save(doctor doctor) {
		 doctorrepository.save(doctor);
	    }
}
