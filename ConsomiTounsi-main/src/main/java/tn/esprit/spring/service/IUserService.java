package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IUserService {
	public User save(User user);
List<User> retrieveAllUser();
void deleteUser(long id);
User updateUser(User user);

}
