package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional

public class appointmentService {
	@Autowired
     private appointmentRepository appointmentrepository;
 public List<appointment> listAll() {
     return appointmentrepository.findAll();
 }

}
