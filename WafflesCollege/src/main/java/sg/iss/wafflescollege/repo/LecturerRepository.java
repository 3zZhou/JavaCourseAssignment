package sg.iss.wafflescollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import antlr.collections.List;
import sg.iss.wafflescollege.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, String>, JpaSpecificationExecutor<Lecturer>  {
	
	/*@Query("SELECT Count(*) FROM Course where lecturer.lecId = :lecturerID AND cseStatus = :status")
	int check(@Param ("lecturerID") String lecturerID, @Param("status") String status);
*/
	@Query("SELECT Count(c.lecturer.lecId) FROM Lecturer l,Course c where l.lecId = c.lecturer.lecId and l.lecId =:lecturerID")
	int check(@Param ("lecturerID") String lecturerID);
}
