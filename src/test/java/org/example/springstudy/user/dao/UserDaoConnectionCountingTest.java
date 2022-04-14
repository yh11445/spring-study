package org.example.springstudy.user.dao;

import org.example.springstudy.user.dao.CountingConnectionMaker;
import org.example.springstudy.user.dao.CountingDaoFactory;
import org.example.springstudy.user.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.example.springstudy.user.domain.User;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("whiteship3");
		user.setName("백기선");
		user.setPassword("married");

		dao.add(user);

		User user2 = dao.get((user.getId()));

		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter : " + ccm.getCounter());

	}
}
