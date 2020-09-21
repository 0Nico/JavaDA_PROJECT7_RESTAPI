package com.nnk.springboot;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void userTest() {
		User user = new User();
		user.setFullname("Harry Pottier");
		user.setUsername("User-blue");
		user.setRole("USER");
		user.setPassword("wingardium");

		// Save
		userService.saveUser(user);
		user = userService.getUser(user.getId());
		Assert.assertNotNull(user.getId());
		Assert.assertTrue(user.getFullname().equals("Harry Pottier"));

		// Update
		user.setFullname("Ron Weasley");
		userService.saveUser(user);
		user = userService.getUser(user.getId());
		Assert.assertTrue(user.getFullname().equals("Ron Weasley"));

		// Find
		List<User> listResult = userService.getAllUsers();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = user.getId();
		userService.deleteUser(id);
		assertThrows(IllegalArgumentException.class , () ->  userService.getUser(id));
	}
}
