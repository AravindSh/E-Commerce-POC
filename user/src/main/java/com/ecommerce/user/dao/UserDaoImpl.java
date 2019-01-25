package com.ecommerce.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.user.dto.UserDto;
import com.ecommerce.user.entity.StateTax;
import com.ecommerce.user.entity.User;
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
			resultList = (UserDto)session.getNamedNativeQuery("User.getUserById").setParameter("userid", userId).getSingleResult();
			tx.commit();
		}catch(Exception e) {
			if (tx!=null) tx.rollback();
			throw e;
		}finally {
			session.close();
		}
		return resultList;
	}
	
	@Override
	public UserDto saveUser(UserDto userDto) throws Exception {
		
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			StateTax stateTax = sess.load(StateTax.class, userDto.getStateName());
			Integer id  = (Integer)sess.save(userDtoToUsers(userDto, stateTax));
			User user = sess.get(User.class, id);
			tx.commit();
			return userToUserDto(user);
		}
		catch (Exception e) {
			if (tx!=null) tx.rollback();
			throw e;
		}
		finally {
			sess.close();
		}
	}

	private UserDto userToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserid(user.getUserid());
		userDto.setAddress(user.getAddress());
		userDto.setCity(user.getCity());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setZip(user.getZip());
		userDto.setStateName(user.getStateTax().getStateName());
		userDto.setCountry(user.getCountry());
		userDto.setEmailAddress(user.getEmailAddress());
		userDto.setPhoneNumber(user.getPhoneNumber());
		return userDto;
	}

	private User userDtoToUsers(UserDto userDto, StateTax stateTax) throws NoSuchAlgorithmException {
		User user = new User();
		user.setAddress(userDto.getAddress());
		user.setCity(userDto.getCity());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setZip(userDto.getZip());
		user.setStateTax(stateTax);
		user.setPasswordUser(getHash(userDto.getPasswordUser()));
		user.setCountry(userDto.getCountry());
		user.setEmailAddress(userDto.getEmailAddress());
		user.setPhoneNumber(userDto.getPhoneNumber());
		return user;
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
