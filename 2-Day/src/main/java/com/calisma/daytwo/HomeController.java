package com.calisma.daytwo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;


@Controller
public class HomeController {
		
	@Autowired DataSource dataSource;
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		/*
		try {
			
			String query = "select * from user";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			
		} catch (Exception e) {
			System.err.println("Connection Error : " + e);
		}
		*/
		
		// hibernate
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		User us = new User();
		us.setName("Erkan");
		us.setSurname("Bilmem");
		us.setMail("ali@ali.com");
		us.setPass("12345");
		
		sesi.save(us);
		tr.commit();
		sesi.close();
		
		
		return "home";
	}
	
	
}
