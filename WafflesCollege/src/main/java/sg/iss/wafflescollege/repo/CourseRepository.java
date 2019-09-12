package sg.iss.wafflescollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;

public interface CourseRepository extends JpaRepository<Course, String> {

	@Modifying
	@Query("UPDATE Course c SET c.cseCredit = :courseCredit, c.cseDesc = :courseDescription, c.cseMaxSize = :courseMaxSize, c.cseStartdate = :courseStartDate, c.cseStatus = :courseStatus WHERE c.cseId = :courseId ")
	int updateCSE(@Param ("courseId") String courseId,@Param ("courseCredit") int courseCredit,@Param ("courseDescription") String courseDescription, @Param ("courseMaxSize") int courseMaxSize, @Param ("courseStartDate") Date courseStartDate, @Param("courseStatus") String courseStatus);
	
	@Query("SELECT Count(*) FROM Enrollment where course.cseId = :courseID AND enrStatus = :status")
	int pricoursecheck(@Param("courseID") String courseID,  @Param("status") String status);

	@Query("SELECT Count(*) FROM Enrollment where course.cseId = :courseID")
	int seccoursecheck(@Param("courseID") String courseID);
	
	@Query("SELECT c FROM Course c where c.lecturer.lecId = :lecId")
	ArrayList<Course> findCourseByLecId(@Param("lecId") String lecId);
	
	@Query("SELECT c FROM Course c where c.cseId = :cseId")
	Course findCourseByCseId(@Param("cseId") String cseId);
	
	@Query("SELECT c FROM Course c")
	ArrayList<Course> AllCourseIDs();
	
	@Query("SELECT c FROM Course c, Enrollment e WHERE c.cseId = e.course.cseId AND e.enrStatus != 'Not Approved' AND e.student.stuId = :stuID")
	ArrayList<Course> getEnrolledCourseIDs(@Param("stuID") String stuID);
	


}
