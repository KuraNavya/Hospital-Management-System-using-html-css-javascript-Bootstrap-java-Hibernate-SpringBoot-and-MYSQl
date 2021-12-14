package com;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private doctorRepository dRepo;

	@RequestMapping("/")
	public String checklogin() {
		return "index";
	}

	@RequestMapping("/home")
	public String checkhome() {
		return "index";
	}

	@RequestMapping("/login")
	public String checkAdmin() {
		return "login";

	}

	@RequestMapping("/admin")
	public String checkAdminn() {
		return "admin";
	}

	@PostMapping("/adddoctor")
	public String doctorRegister(doctor doctor) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(doctor.getPassword());
		doctor.setPassword(encodedPassword);

		dRepo.save(doctor);

		return "index";
	}

	@RequestMapping("/doctorlogin")
	public String checkdoctor() {
		return "doctorlogin";

	}

	@RequestMapping("/doctor")
	public String checkAdmn() {
		return "doctor";
	}

	@RequestMapping("/patient")
	public String checkpatient() {
		return "patient";

	}

	@Autowired
	private patientRepository pRepo;

	@RequestMapping("/plogin")
	public String checkplogin() {
		return "plogin";

	}

	@PostMapping("/plogin")
	public String processRegister(patient patient) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(patient.getPassword());
		patient.setPassword(encodedPassword);

		pRepo.save(patient);

		return "plogin";
	}

	@RequestMapping("/appointment")
	public String checkappointmentt() {
		return "appointment";

	}

	@Autowired
	private appointmentRepository aRepo;

	@RequestMapping("/appointment_success")
	public String checkappointment() {
		return "appointment_success";

	}

	@PostMapping("/appointment_success")
	public String appointmentRegister(appointment appointment) {
		aRepo.save(appointment);
		return "appointment_success";
	}

	@Autowired
	private appointmentService service;

	@RequestMapping("/viewappointment")
	public String viewHomePage(Model model) {
		List<appointment> listappointment = service.listAll();
		model.addAttribute("listappointment", listappointment);

		return "viewappointment";
	}

	@Autowired
	private doctorService doctorservice;

	@RequestMapping("/viewdoctors")
	public String viewDoctorPage(Model model) {
		List<doctor> listdoctor = doctorservice.listAll();
		model.addAttribute("listdoctor", listdoctor);

		return "viewdoctors";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		doctorservice.delete(id);
		return "redirect:/viewdoctors";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView updateProduct(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editdoctor");
		doctor doctor = doctorservice.get(id);
		return mav;
	}

	@RequestMapping("/contact")
	public String checkcontact() {
		return "contact";
	}

	@Autowired
	private contactRepository Crepo;

	@PostMapping("/home")
	public String query(contact contact) {
		Crepo.save(contact);
		return "index";
	}
}
