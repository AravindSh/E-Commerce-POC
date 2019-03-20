package com.ecommerce.user.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommerce.user.dto.UserDto;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {
	
	@InjectMocks
	private UserDaoImpl mockUserDao;
	
	@Mock
	private SessionFactory mockSessionFactory;
	
	@Test
	public void testLoginUser() throws Exception {
		String password = "Aravind1234";
		String hash = "af39a3d9473afd7c83952595467a48c189f494e60871226beb418b68694e8940";
		UserDto userDto = new UserDto();
		userDto.setEmailAddress("aravind@gmail.com");
		userDto.setPasswordUser(password);
		
		Session mockSession = mock(Session.class);
		when(mockSessionFactory.openSession()).thenReturn(mockSession);
		Transaction mockTransaction = mock(Transaction.class);
		when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		Query mockQuery = mock(Query.class);
		when(mockSession.createNamedQuery(anyString())).thenReturn(mockQuery);
		when(mockQuery.setParameter(anyString(), anyString())).thenReturn(mockQuery);
		when(mockQuery.getSingleResult()).thenReturn(hash);
		
		assertTrue(mockUserDao.loginUser(userDto));
		
		
	}

}
