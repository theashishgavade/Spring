package com.tyss.counsellorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tyss.counsellorapp.entity.Counsellor;
import com.tyss.counsellorapp.entity.Enquiry;
import com.tyss.counsellorapp.enums.ClassMode;
import com.tyss.counsellorapp.enums.Course;
import com.tyss.counsellorapp.enums.Status;
import com.tyss.counsellorapp.exception.CounsellorNotFound;
import com.tyss.counsellorapp.exception.EnquiryNotFoundException;
import com.tyss.counsellorapp.repository.CounsellorRepository;
import com.tyss.counsellorapp.repository.EnquiryRepository;

@Service
public class EnquiryService {

	private EnquiryRepository enquiryRepository;

	private CounsellorRepository counsellorRepository;

	public EnquiryService(EnquiryRepository enquiryRepository, CounsellorRepository counsellorRepository) {
		this.enquiryRepository = enquiryRepository;
		this.counsellorRepository = counsellorRepository;
	}

	public String addEnquiry(Integer cid, Enquiry enquiry) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Not Found"));
		enquiry.setCounsellor(counsellor);
		enquiryRepository.save(enquiry);
		return "added";
	}

	public String updateStatus(Integer eid, Status status) {
		Enquiry enquiry = enquiryRepository.findById(eid)
				.orElseThrow(() -> new EnquiryNotFoundException("Enquiry Not Found"));
		enquiry.setStatus(status);
		Enquiry save = enquiryRepository.save(enquiry);
		return "status updated to " + save.getStatus();
	}

	public String updateCourse(Integer eid, Course course) {
		Optional<Enquiry> enquiryOpt = enquiryRepository.findById(eid);
		if (enquiryOpt.isPresent()) {
			Enquiry enquiry = enquiryOpt.get();
			enquiry.setCourse(course);
			enquiryRepository.save(enquiry);
			return "Course updated successfully";
		}
		return "Enquiry not found";
	}

	public String updateClassMode(Integer eid, ClassMode mode) {
		Optional<Enquiry> enquiryOpt = enquiryRepository.findById(eid);
		if (enquiryOpt.isPresent()) {
			Enquiry enquiry = enquiryOpt.get();
			enquiry.setClassMode(mode);
			enquiryRepository.save(enquiry);
			return "Class Mode updated successfully";
		}
		return "Enquiry not found";
	}

	public String updatePhone(Integer eid, Long phone) {
		Optional<Enquiry> enquiryOpt = enquiryRepository.findById(eid);
		if (enquiryOpt.isPresent()) {
			Enquiry enquiry = enquiryOpt.get();
			enquiry.setPhone(phone);
			enquiryRepository.save(enquiry);
			return "Phone number updated successfully";
		}
		return "Enquiry not found";
	}

	public List<Enquiry> getByStatus(Status status) {
		return enquiryRepository.findByStatus(status);
	}

	public List<Enquiry> getByClassMode(ClassMode mode) {
		return enquiryRepository.findByClassMode(mode);
	}

	public List<Enquiry> getByCourse(Course course) {
		return enquiryRepository.findByCourse(course);
	}

	public String deleteEnquiry(Integer eid) {
		Optional<Enquiry> enquiryOpt = enquiryRepository.findById(eid);
		if (enquiryOpt.isPresent()) {
			enquiryRepository.deleteById(eid);
			return "Enquiry deleted successfully";
		}
		return "Enquiry not found";
	}

}
