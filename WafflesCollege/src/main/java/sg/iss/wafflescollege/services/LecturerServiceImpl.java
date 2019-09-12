package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.model.User;
import sg.iss.wafflescollege.repo.CourseRepository;
import sg.iss.wafflescollege.repo.EnrollmentRepository;
import sg.iss.wafflescollege.repo.LecturerRepository;
import sg.iss.wafflescollege.repo.StudentRepository;
import sg.iss.wafflescollege.repo.StudentgradeRepository;
import sg.iss.wafflescollege.repo.UserRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepo;
	
	@Resource
	CourseRepository crepo;

	@Resource
	EnrollmentRepository erepo;

	@Resource
	StudentgradeRepository sgrepo;

	@Resource
	StudentRepository srepo;
	
	@Resource
	UserRepository uRepo;


	@Override
	@Transactional
	public ArrayList<Lecturer> findAllLecturers() {
		return (ArrayList<Lecturer>) lrepo.findAll();
	}

	@Override
	public Lecturer findLecturer(String lecId) {

		Lecturer lec = lrepo.findById(lecId).get();

		System.out.println(lec.toString());

		return lec;
	}


	@Override
	@Transactional
	public Lecturer createLecturer(Lecturer l) {
		User u = new User();
		u.setUseId(l.getLecId());
		u.setUsePassword("12345");
		u.setUseRole("Lecturer");
		System.out.println(l.getLecId());
		//srepo.createNewUser(s.getStuId(),"12345","Student");
		uRepo.saveAndFlush(u);
		return lrepo.saveAndFlush(l);
	}

	@Override
	@Transactional
	public Lecturer updateLecturer(Lecturer l) {
		return lrepo.saveAndFlush(l);
	}

	@Override
	@Transactional
	public int removeLecturer(Lecturer l) {
		int lecturercountcheck = lrepo.check(l.getLecId());
		System.out.println("Number of lecturer-id  : "+lecturercountcheck);
		if(lecturercountcheck > 0) {
			System.out.println("Cannot delete!!!!");
		}
		else {
			lrepo.delete(l);
		}
		return lecturercountcheck;
		
	}
	
	@Override
	@Transactional
	public ArrayList<Lecturer> findLecturersByCriteria(Lecturer l) {

		return null;
	}
	
	@Override
	@Transactional
	public ArrayList<Student> findSpecificCourseStudents(String cseId) {
		ArrayList<Enrollment> enrollments = erepo.findEnrollmentByCseId(cseId);
		ArrayList<Student> students = new ArrayList<Student>();
		for (Enrollment enrollment : enrollments) {
			String stuId = enrollment.getStudent().getStuId();
			Student newstu = srepo.findStudentByStuId(stuId);
			students.add(newstu);
		}
		return students;
}
	
	
	@Override
	@Transactional
	public ArrayList<Course> findCourseTaught(String lecId) {
		return (ArrayList<Course>) crepo.findCourseByLecId(lecId);
	}

	@Override
	@Transactional

	public ArrayList<Course> findAllCourse() {
		return (ArrayList<Course>) crepo.findAll();

	}

	@Override
	@Transactional

	public ArrayList<Enrollment> findSpecificCourseEnrollment(String cseId) {
		return (ArrayList<Enrollment>) erepo.findEnrollmentByCseId(cseId);
	}

	@Override
	@Transactional
	public Course findCourse(String cseId) {
		return crepo.findCourseByCseId(cseId);
	}

	@Override
	@Transactional
	public ArrayList<Studentgrade> findSpecificCourseStudentgrade(String cseId) {
		ArrayList<Enrollment> enlist1 = (ArrayList<Enrollment>) erepo.findApprovedEnrollmentByCseId(cseId);
		ArrayList<Enrollment> enlist2 = (ArrayList<Enrollment>) erepo.findCompletedEnrollmentByCseId(cseId);
		for (Enrollment enrollment : enlist2) {
			enlist1.add(enrollment);
		}
		ArrayList<Studentgrade> result = new ArrayList<Studentgrade>();
		for (Enrollment enrollment : enlist1) {
			int sgId = enrollment.getEnrId();
			result.add(sgrepo.findStudentgradeByStgId(sgId));
		}
		return result;
	}

	@Override
	@Transactional
	public Studentgrade updateStudentgrade(Studentgrade studentgrade) {
		return sgrepo.saveAndFlush(studentgrade);
	}

	@Override
	@Transactional
	public ArrayList<Student> findActiveSpecificCourseStudents(String cseId) {
		ArrayList<Enrollment> enrollments = erepo.findEnrollmentByCseId(cseId);
		ArrayList<Student> students = new ArrayList<Student>();
		for (Enrollment enrollment : enrollments) {
			String stuId = enrollment.getStudent().getStuId();
			Student newstu = srepo.findActiveStudentByStuId(stuId);
			students.add(newstu);
		}
		return students;
	}

	@Override
	@Transactional
	public Studentgrade findStudentgradeByStgId(int stgId) {

		return sgrepo.findStudentgradeByStgId(stgId);
	}

	@Override
	@Transactional
	public String convertToGrade(String score) {
		int number = Integer.parseInt(score);
		String result = "";
		if (number >= 0 && number < 40) {
			result = "F";
		}
		if (number >= 40 && number < 45) {
			result = "D";
		}
		if (number >= 45 && number < 50) {
			result = "D+";
		}
		if (number >= 50 && number < 55) {
			result = "C";
		}
		if (number >= 55 && number < 60) {
			result = "C+";
		}
		if (number > 60 && number < 65) {
			result = "B-";
		}
		if (number >= 65 && number < 70) {
			result = "B";
		}
		if (number >= 70 && number < 75) {
			result = "B+";
		}
		if (number >= 75 && number < 80) {
			result = "A-";
		}
		if (number >= 80 && number < 85) {
			result = "A";
		}
		if (number >= 85 && number < 100) {
			result = "A+";
		}
		return result;
	}
	
	@Override
	@Transactional
	public ArrayList<Studentgrade> findStudentgradeByStuIdCseId(String stuId, String cseId) {
		return sgrepo.findStudentgradeByStuIdCseId(stuId, cseId);
	}
	
	@Override
	@Transactional
	public Student findStudentByStuId(String stuId) {
		return srepo.findStudentByStuId(stuId); 
	}
	
	@Override
	@Transactional
	public Studentgrade updateStudentGrade(Studentgrade studentgrade) {
		String score = studentgrade.getStgGrade();
		int number = Integer.parseInt(score);
		String grade = "";
		if (number >= 0 && number < 40) {
			grade = "F";
		}
		if (number >= 40 && number < 45) {
			grade = "D";
		}
		if (number >= 45 && number < 50) {
			grade = "D+";
		}
		if (number >= 50 && number < 55) {
			grade = "C";
		}
		if (number >= 55 && number < 60) {
			grade = "C+";
		}
		if (number > 60 && number < 65) {
			grade = "B-";
		}
		if (number >= 65 && number < 70) {
			grade = "B";
		}
		if (number >= 70 && number < 75) {
			grade = "B+";
		}
		if (number >= 75 && number < 80) {
			grade = "A-";
		}
		if (number >= 80 && number < 85) {
			grade = "A";
		}
		if (number >= 85 && number < 100) {
			grade = "A+";
		}
		studentgrade.setStgGrade(grade);
		return sgrepo.saveAndFlush(studentgrade);
}

}
