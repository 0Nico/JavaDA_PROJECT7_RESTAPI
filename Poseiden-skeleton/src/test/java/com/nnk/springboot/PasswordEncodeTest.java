package com.nnk.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordEncodeTest {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @Test
    public void testPassword() {
        String pw = passwordEncoder.encode("123456");
        System.out.println("[ "+ pw + " ]");
    }
}
