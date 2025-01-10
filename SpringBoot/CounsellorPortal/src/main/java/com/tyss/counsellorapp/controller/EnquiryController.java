package com.tyss.counsellorapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.counsellorapp.entity.Enquiry;
import com.tyss.counsellorapp.enums.ClassMode;
import com.tyss.counsellorapp.enums.Course;
import com.tyss.counsellorapp.enums.Status;
import com.tyss.counsellorapp.service.EnquiryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	private EnquiryService enquiryService;

	public EnquiryController(EnquiryService enquiryService) {
		this.enquiryService = enquiryService;
	}

	/*
	 * Used to add enquiry 
	 * @Param : Integer cid
	 * @Param : Enquiry enquire
	*/
	@PostMapping("/add/{cid}")
	public ResponseEntity<String> addEnquiry(@PathVariable Integer cid, @RequestBody Enquiry enquiry) {

		String added = enquiryService.addEnquiry(cid, enquiry);

		return new ResponseEntity<String>(added, HttpStatus.CREATED);
	}
	
	/*
	 * Updates Status of existing Enquiry
	 * @param : Enquiry id
	 * @param : Status (Enum data)
	*/
	@PutMapping("/status")
	public ResponseEntity<String> updateStatus(@RequestParam Integer eid, @RequestParam Status status) {
		String updateStatus = enquiryService.updateStatus(eid,status);
		return new ResponseEntity<String>(updateStatus, HttpStatus.OK);
	}
	
	
	/*
	 * Updates Course of existing Enquiry
	 * @param : Enquiry id
	 * @param : Course (Enum data)
	*/
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestParam Integer eid, @RequestParam Course course) {
	    String updateCourse = enquiryService.updateCourse(eid, course);
	    return new ResponseEntity<String>(updateCourse, HttpStatus.OK);
	}
	
	/*
	 * Updates ClassMode of existing Enquiry
	 * @param : Enquiry id
	 * @param : ClassMode (Enum data)
	*/
	@PutMapping("/mode")
	public ResponseEntity<String> updateClassMode(@RequestParam Integer eid, @RequestParam ClassMode mode) {
	    String updateMode = enquiryService.updateClassMode(eid, mode);
	    return new ResponseEntity<String>(updateMode, HttpStatus.OK);
	}
	
	/*
	 * Updates Phone of existing Enquiry
	 * @param : Enquiry id
	 * @param : phone, Long number.
	*/
	@PutMapping("/phn")
	public ResponseEntity<String> updatePhone(@RequestParam Integer eid, @RequestParam Long phone) {
	    String updatePhone = enquiryService.updatePhone(eid, phone);
	    return new ResponseEntity<String>(updatePhone, HttpStatus.OK);
	}
	
	/*
	 * Get enquiries based course
	*/
	@GetMapping("/bycourse")
	public ResponseEntity<List<Enquiry>> getByCourse(@RequestParam Course course) {
		List<Enquiry> enquiries = enquiryService.getByCourse(course);
		return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}
	
	/*
	 * Get enquiries based Status
	*/
	@GetMapping("/bystatus")
	public ResponseEntity<List<Enquiry>> getByStatus(@RequestParam Status status) {
	    List<Enquiry> enquiries = enquiryService.getByStatus(status);
	    return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}
	
	
	/*
	 * Get enquiries based Stats
	*/
	@GetMapping("/bymode")
	public ResponseEntity<List<Enquiry>> getByClassMode(@RequestParam ClassMode mode) {
	    List<Enquiry> enquiries = enquiryService.getByClassMode(mode);
	    return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}
	
	/*
	 * Delete Enquiry
	 * @param : enquiry id
	*/
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEnquiry(@RequestParam Integer eid){
	    String deleted = enquiryService.deleteEnquiry(eid);
	    return new ResponseEntity<String>(deleted, HttpStatus.OK);
	}
}
