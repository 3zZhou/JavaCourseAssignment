package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {

	
	@Query("select e from Enrollment e where e.enrStatus ='Pending'")
	ArrayList<Enrollment> findAllNewEnrollments();

	@Query("SELECT e FROM Enrollment e where e.course.cseId = :cseId")
	ArrayList<Enrollment> findEnrollmentByCseId(@Param("cseId") String cseId);

	@Query("select e from Enrollment e where e.enrId = :eid")
	ArrayList<Enrollment> findEnrollmentById(@Param("eid") String eid);

	@Query("select e from Enrollment e where e.course.cseId = :cseId AND e.enrStatus = 'Approved'")
	ArrayList<Enrollment> findApprovedEnrollmentByCseId(@Param("cseId") String cseId);

	@Query("select e from Enrollment e where e.course.cseId = :cseId AND e.enrStatus = 'Completed'")
	ArrayList<Enrollment> findCompletedEnrollmentByCseId(@Param("cseId") String cseId);
	
	@Query("select distinct e.enrStatus from Enrollment e")
	ArrayList<String> findAllStatus();
	
	@Query("select distinct e.course.cseId from Enrollment e")
	ArrayList<String> findAllCourse();
	
	@Query("select distinct e.student.stuId from Enrollment e")
	ArrayList<String> findAllStudent();
	
	
	
	
	
	
	
	
}
