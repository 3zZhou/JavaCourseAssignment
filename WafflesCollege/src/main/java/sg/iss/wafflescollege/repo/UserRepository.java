package sg.iss.wafflescollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query("SELECT u FROM User u WHERE u.useId=:use_id AND u.usePassword=:use_password")
	User authenticateUserById(@Param("use_id") String use_id, @Param("use_password") String use_password);
	
}
