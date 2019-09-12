package sg.iss.wafflescollege.services;

import java.util.ArrayList;
import java.util.List;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Student;

public interface StudentService {

	Double CalculateCGPAByStudentID(String studentID);
	
	ArrayList<Course> getEnrolledCoursesList(String studentID, String status);

	ArrayList<Course> getNewCourses(Student s);

	Double CalculateCGPA(String studentID);
	
	Double convertGradeToGPA(String grade);

	ArrayList<String> getEnrolledCourseIDs(String stuID);

	List<String[]> getNewCourses(String stuID);
	
	List<String[]> getStudentGrades(String stuID);

	int enrollIntoCourse(Student s, String courseID);

	void viewCourseDetails(String courseID);
	
	ArrayList<Student> findAllStudents();

	Student findStudent(String nric);
	
	Student findStudentbyID(String stuID);

	Student createStudent(Student s);

	Student updateStudent(Student s);

	void removeStudent(Student s);

	ArrayList<Student> findStudentsByCriteria(Student student);

	List<String[]> getEnrolledCourses(String stuID);
	
	void createnewEnrollment(String courseId);

	ArrayList<Course> getNewCoursesList(String stuID);
	
}