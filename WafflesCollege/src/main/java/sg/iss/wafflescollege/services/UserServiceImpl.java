package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.wafflescollege.model.User;
import sg.iss.wafflescollege.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserRepository urepo;

	@Override
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ulist = (ArrayList<User>)urepo.findAll();
		return ulist;
	}

	@Override
	public User findUserById(String use_id) {
		return urepo.findById(use_id).get();
	}

	@Override
	public ArrayList<User> findUsersByCriteria(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(User u) {
		urepo.save(u);
		return 0;
	}

	@Override
	public int updateUser(User u) {
		urepo.saveAndFlush(u);
		return 0;
	}

	@Override
	public int removeUser(User u) {
		urepo.delete(u);
		return 0;
	}
	
	@Override
	@Transactional
	public User authenticate(String use_id, String use_password) {
		User u = urepo.authenticateUserById(use_id, use_password);
		return u;
	}
}
