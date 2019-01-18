package com.ecommerce.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.user.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserDto getUserById(Integer userId) {
		Session session = sessionFactory.openSession();
		UserDto resultList = null;
		try {
			resultList = (UserDto)session.getNamedNativeQuery("Users.getUserById").setParameter("userid", userId).getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return resultList;
	}

}
