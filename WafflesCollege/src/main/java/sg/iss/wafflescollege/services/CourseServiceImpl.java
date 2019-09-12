 package sg.iss.wafflescollege.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.net.SyslogOutputStream;
import sg.iss.wafflescollege.controllers.UserSession;
import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.repo.CourseRepository;
import sg.iss.wafflescollege.repo.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService {

	
	@Resource
	CourseRepository srepo;
	@Resource
	StudentRepository crepo;
	@Override
	public ArrayList<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return (ArrayList<Course>) srepo.findAll();
	}
	
	@Override
	public ArrayList<Course> findAllCourses(String courseId) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Course> AllCourseList = srepo.AllCourseIDs();
		ArrayList<Course> EnrolledCourses = srepo.getEnrolledCourseIDs(UserSession.studentId);
		AllCourseList.removeAll(EnrolledCourses);
		//Iterator<Course> I = AllCourseList.iterator();
/*
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
		}*/

		return AllCourseList;
		
	}

	@Override
	public Course findCourseById(String courseId) {
		// TODO Auto-generated method stub
		return srepo.findById(courseId).get();
		
	}

	@Override
	@Transactional
	public int updateCourse(Course course) {
		// TODO Auto-generated method stub
		String courseId= course.getCseId();
		int courseCredit = course.getCseCredit();
		String courseDescription = course.getCseDesc();
		int courseMaxSize = course.getCseMaxSize();
		
		Date courseStartDate = course.getCseStartdate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strDate = dateFormat.format(courseStartDate);
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(strDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DAY_OF_MONTH, 1);
		strDate = dateFormat.format(c.getTime());
		try {
			courseStartDate = dateFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String courseStatus = course.getCseStatus();
		return srepo.updateCSE(courseId,courseCredit,courseDescription,courseMaxSize,courseStartDate,courseStatus);
		//return srepo.saveAndFlush(course);
	}

	@Override
	@Transactional
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		String courseId= course.getCseId();
		int courseCredit = course.getCseCredit();
		String courseDescription = course.getCseDesc();
		int courseMaxSize = course.getCseMaxSize();
		
		Date courseStartDate = course.getCseStartdate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strDate = dateFormat.format(courseStartDate);
		String courseStatus = course.getCseStatus();
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(strDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DAY_OF_MONTH, 1);
		strDate = dateFormat.format(c.getTime());
		try {
			courseStartDate = dateFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		course.setCseStartdate(courseStartDate);
		return srepo.saveAndFlush(course);
	}

	@Override
	@Transactional
	public void removeCourse(Course course) {
		// TODO Auto-generated method stub
		int primarycoursechk = srepo.pricoursecheck(course.getCseId(),"Attending");
		int secondarycoursechk = srepo.seccoursecheck(course.getCseId());
		System.out.println(primarycoursechk);
		System.out.println(secondarycoursechk);
		if (primarycoursechk>0)
		{
			String courseId= course.getCseId();
			int courseCredit = course.getCseCredit();
			String courseDescription = course.getCseDesc();
			int courseMaxSize = course.getCseMaxSize();
			Date courseStartDate = course.getCseStartdate();
			String courseStatus = course.getCseStatus();
			course.setCseStatus("Active");
			srepo.updateCSE(courseId,courseCredit,courseDescription,courseMaxSize,courseStartDate,courseStatus);
		}
		
			if (secondarycoursechk>0)
			{
				String courseId= course.getCseId();
				int courseCredit = course.getCseCredit();
				String courseDescription = course.getCseDesc();
				int courseMaxSize = course.getCseMaxSize();
				Date courseStartDate = course.getCseStartdate();
				
				course.setCseStatus("Inactive");
				String courseStatus = course.getCseStatus();
				srepo.updateCSE(courseId,courseCredit,courseDescription,courseMaxSize,courseStartDate,courseStatus);
			}
			else
			{
				srepo.delete(course);
			}
			}
			
		
	@Override
	@Transactional
	public ArrayList<Course> findCoursesByCriteria(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
