package com.ecommerce.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.user.dto.UserDto;
import com.ecommerce.user.entity.StateTax;
import com.ecommerce.user.entity.Users;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserDto getUserById(Integer userId) {
		Session session = sessionFactory.openSession();
		UserDto resultList = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			resultList = (UserDto)session.getNamedNativeQuery("Users.getUserById").setParameter("userid", userId).getSingleResult();
			tx.commit();
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			throw e;
		}finally {
			session.close();
		}
		return resultList;
	}
	
	public UserDto saveUser(UserDto userDto) throws Exception {
		
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			//do some work
			StateTax stateTax = sess.load(StateTax.class, userDto.getStateName());
			Users users = userDtoToUsers(userDto, stateTax);

			tx.commit();
		}
		catch (Exception e) {
			if (tx!=null) tx.rollback();
			throw e;
		}
		finally {
			sess.close();
		}


		return null;
	}

	private Users userDtoToUsers(UserDto userDto, StateTax stateTax) throws NoSuchAlgorithmException {
		Users users = new Users();
		users.setAddress(userDto.getAddress());
		users.setCity(userDto.getCity());
		users.setFirstName(userDto.getFirstName());
		users.setLastName(userDto.getLastName());
		users.setZip(userDto.getZip());
		users.setStateTax(stateTax);
		users.setPasswordUser(getHash(userDto.getPasswordUser()));
		users.setCountry(userDto.getCountry());
		users.setEmailAddress(userDto.getEmailAddress());
		users.setPhoneNumber(userDto.getPhoneNumber());
		return users;
	}

	private String getHash(String passwordUser) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(passwordUser.getBytes(StandardCharsets.UTF_8));
		// bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
	}

}
