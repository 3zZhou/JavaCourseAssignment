package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Studentgrade;

public interface StudentgradeRepository extends JpaRepository<Studentgrade, Integer> {
	
	@Query("SELECT s FROM Studentgrade s where s.course.cseId = :cseId")
	ArrayList<Studentgrade> findStudentgradeByCseId(@Param("cseId") String cseId);
	
	@Query("SELECT s FROM Studentgrade s where s.course.cseId = :cseId")
	ArrayList<Studentgrade> findApprovedStudentgradeByCseId(@Param("cseId") String cseId);
	
	@Query("SELECT s FROM Studentgrade s where s.stgId = :stgId")
	Studentgrade findStudentgradeByStgId(@Param("stgId") int stgId);

	@Query("SELECT s FROM Studentgrade s where s.student.stuId = :stuId AND s.course.cseId = :cseId")
ArrayList<Studentgrade> findStudentgradeByStuIdCseId(@Param("stuId") String stuId, @Param("cseId") String cseId);
}