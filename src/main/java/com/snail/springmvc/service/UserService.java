package com.snail.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.snail.springmvc.entity.User;

@Service("userService")
public class UserService {
	private static List<User> users;

	static {
		users = new ArrayList<>();
		User user = null;
		String[] address = { "成都", "北京", "贵阳", "天津" };
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setId(i+1);
			user.setUserName("第" + (i + 1) + "个数据");
			user.setSex((char) (i % 2));
			user.setAddress(address[random.nextInt(address.length)]);
			user.setAge(random.nextInt(45));

			users.add(user);
			user = null;
		}
	}

	public List<User> findUsers() {
		return users;
	}
	
	public User findUserInfoById(int id){
		return users.get(id-1);
	}
	
	public void deleteUserInfoById(int id){
		users.remove(id-1);
	}

	public void saveUserInfo(User user) {
		if(user.getId()==0){
			user.setId(users.size());
			users.add(users.size(), user);
		}else{
			users.remove(user.getId()-1);
			users.add(user.getId()-1, user);
		}
	}

}
