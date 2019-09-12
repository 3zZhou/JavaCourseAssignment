package sg.iss.wafflescollege.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.wafflescollege.controllers.UserSession;
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
public class StudentServiceImpl implements StudentService {

	@Resource
	StudentRepository srepo;
	@Resource
	CourseRepository cRepo;
	@Resource
	UserRepository uRepo;
	@Resource
	EnrollmentRepository eRepo;
	@Resource
	StudentgradeRepository gRepo;
	@Resource
	LecturerRepository lRepo;

	@Override
	@Transactional
	public Double CalculateCGPAByStudentID(String studentID) {
		return null;
	}

	@Override
	public ArrayList<Course> getEnrolledCoursesList(String studentID, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getNewCourses(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int enrollIntoCourse(Student s, String courseID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void viewCourseDetails(String courseID) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Student> findAllStudents() {
		ArrayList<Student> slist = (ArrayList<Student>)srepo.findAll();
		return slist;
	
	}
	
	

	@Override
	public Student findStudent(String stuId) {

		return srepo.findById(stuId).get();
	}

	

	@Override
	public Student createStudent(Student s) {
		
		
		User u = new User();
		u.setUseId(s.getStuId());
		u.setUsePassword("12345");
		u.setUseRole("Student");
		System.out.println(s.getStuId());
		//srepo.createNewUser(s.getStuId(),"12345","Student");
		uRepo.saveAndFlush(u);
		return srepo.saveAndFlush(s);
		
	}

	@Override
	public Student updateStudent(Student s) {
		return srepo.saveAndFlush(s);
	}

	@Override
	@Transactional
	public void removeStudent(Student s) {
		
		//srepo.delete(s);
		if(srepo.CountEnrollmentByStuId(s.getStuId())>0) {
		
		srepo.updateStudentStatusByStuId("Inactive", s.getStuId());
		ArrayList<Enrollment> enrollments = srepo.findEnrollmentByStuId(s.getStuId());
		for (int j = 0; j < enrollments.size(); j++)
		{
			if (!enrollments.get(j).getEnrStatus().equals("Completed"))
			{
				srepo.updateEnrollmentStatusByStuId("Inactive", s.getStuId());
			}
		}
		}else {
			srepo.delete(s);
		}
	}
	
	@Override
	public ArrayList<Student> findStudentsByCriteria(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double convertGradeToGPA(String grade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	@Transactional
	public Double CalculateCGPA(String studentID) {

		Double[] Credits = srepo.GPACourseCredits(studentID);
		String[] Grades = srepo.GPAGrades(studentID);
		Double G = 0.0;
		Double G2 = 0.0;
		int g = 0;
		for (int i = 0; i < Credits.length; i++) {
			switch (Grades[i]) {
			case "A+":
				G = 5.0;
				break;
			case "A":
				G = 5.0;
				break;
			case "A-":
				G = 4.5;
				break;
			case "B+":
				G = 4.0;
				break;
			case "B":
				G = 3.5;
				break;
			case "B-":
				G = 3.0;
				break;
			case "C+":
				G = 2.5;
				break;
			case "C":
				G = 2.0;
				break;
			case "D+":
				G = 1.5;
				break;
			case "D":
				G = 1.0;
				break;
			default:
				G = 0.0;
				break;
			}
			G2 += G * Credits[i];

			g += Credits[i];
		}

		return (G2 / g);
	}

	@Override
	public ArrayList<String> getEnrolledCourseIDs(String stuID) {
		return srepo.getEnrolledCourseIDs(stuID);
	}

	@Override
	public List<String[]> getNewCourses(String stuID) {
		ArrayList<String> AllCourseList = srepo.AllCourseIDs();
		ArrayList<String> EnrolledCourses = srepo.getEnrolledCourseIDs(stuID);
		AllCourseList.removeAll(EnrolledCourses);
		Iterator<String> I = AllCourseList.iterator();

		List<String[]> Display = new ArrayList<String[]>();
		// cseID, cseDesc, cseLecturer, cseCredits

		while (I.hasNext()) {
			String cID = I.next();
			Course c = srepo.retrieveCourse(cID);
			String[] S = new String[4];

			S[0] = c.getCseId();
			S[1] = c.getCseDesc();
			S[3] = String.valueOf(c.getCseCredit());
			Lecturer L = c.getLecturer();
			S[2] = L.getLecFirstmidname() + " " + L.getLecLastname();

			Display.add(S);
		}

		return Display;
	}

	@Override
    public ArrayList<Course> getNewCoursesList(String stuID) {

        ArrayList<String> AllCourseList = srepo.AllCourseIDs();
        ArrayList<String> EnrolledCourses = srepo.getEnrolledCourseIDs(stuID);
        AllCourseList.removeAll(EnrolledCourses);
        Iterator<String> I = AllCourseList.iterator();

        ArrayList<Course> Display = new ArrayList<Course>();

        while (I.hasNext()) {
            String cID = I.next();
            Course c = srepo.retrieveCourse(cID);
            Display.add(c);
        }

        return Display;
    }

	
	@Override
	@Transactional
	public List<String[]> getStudentGrades(String stuID) {
		System.out.println(stuID);
		ArrayList<String> EnrList = srepo.getEnrolledCourseIDs(stuID);
		Iterator<String> I = EnrList.iterator();

		List<String[]> Display = new ArrayList<String[]>();
		// cseID, cseDesc, cseCredits, studentGrade

		while (I.hasNext()) {
			String cID = I.next();
			Course c = srepo.retrieveCourse(cID);
			String[] S = new String[4];
			S[0] = c.getCseId();
			S[1] = c.getCseDesc();
			S[2] = String.valueOf(c.getCseCredit());
			Studentgrade G = srepo.findStudentgrade(stuID, cID);
			if(G!=null) {
			String g = G.getStgGrade();
			S[3] = (g.equals(null) || g.equals("")) ? " " : g;
			}else {
				S[3] = " ";
			}
			Display.add(S);
		}

		return Display;
	}

	@Override
	public List<String[]> getEnrolledCourses(String stuID) {
		ArrayList<String> EnrList = srepo.getEnrolledCurrentCourseIDs(stuID);
		Iterator<String> I = EnrList.iterator();

		List<String[]> Display = new ArrayList<String[]>();
		// cseID, cseDesc, cseCredits, enrStatus, lecturerName

		while (I.hasNext()) {
			String cID = I.next();
			Course c = srepo.retrieveCourse(cID);
			String[] S = new String[5];
			String e = srepo.retrieveEnrollmentStatus(cID, stuID);
			switch (e) {
			case "Completed":
				S[3] = "";
				break;
			case "Pending":
				S[3] = "Pending";
				break;
			case "Approved":
				S[3] = "Approved";
				break;
			case "Not Approved":
				S[3] = "";
				break;
			default:
				S[3] = "";
			}
			S[0] = c.getCseId();
			S[1] = c.getCseDesc();
			S[2] = String.valueOf(c.getCseCredit());
			String lID = c.getLecturer().getLecId();
			Lecturer L = srepo.retrieveLecturer(lID);
			S[4] = L.getLecFirstmidname() + " " + L.getLecLastname();

			if (S[3] != "") {
				Display.add(S);
			}
		}
		return Display;

	}

	
	@Override
	@Transactional
	public Student findStudentbyID(String stuID) {
		Student student = srepo.findStudentByStuId(stuID);
		return student;
	}
	
	@Override
	@Transactional
	public void createnewEnrollment(String courseId) {
		// TODO Auto-generated method stub
		
		Course cs = new Course();
		cs.setCseId(courseId);
		
		Student s = new Student();
		s.setStuId(UserSession.studentId);
		
		Enrollment en = new Enrollment();
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			d = sdf.parse("2018-11-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		en.setEnrDate(d);
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String eDate = dateFormat.format(enrolldate);
		
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(eDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eDate = dateFormat.format(c.getTime());
		try {
			enrolldate = dateFormat.parse(eDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		en.setEnrDate(enrolldate);*/
		en.setEnrStatus("Pending");
		en.setCourse(cs);
		en.setStudent(s);
		eRepo.saveAndFlush(en);
		
	}
}
