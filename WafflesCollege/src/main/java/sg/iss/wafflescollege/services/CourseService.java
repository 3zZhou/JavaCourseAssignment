package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Course;

public interface CourseService {
	
	ArrayList<Course> findAllCourses();
	ArrayList<Course> findAllCourses(String courseId);
	Course findCourseById(String courseId);
	int updateCourse(Course course);
	Course createCourse(Course course);
	void removeCourse(Course course);
	ArrayList<Course> findCoursesByCriteria(String criteria);


}
