package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sg.iss.wafflescollege.model.User;

@Service
public interface UserService {
	
	ArrayList<User> findAllUsers();

	User findUserById(String use_id);

	ArrayList<User> findUsersByCriteria(User u);

	int createUser(User u);

	int updateUser(User u);

	int removeUser(User u);

	//ArrayList<Role> findRolesForUser(String use_id);

	//ArrayList<String> findRoleNamesForUser(String userId);
	
	User authenticate(String use_id, String use_password);

}