package com.restful.accountapp.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restful.accountapp.bean.Account;
import com.restful.accountapp.persistence.*;
/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class AccountService {
	public AccountService() {
		super();
	}
 
	public Account getAccount(String a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Account account = null;
		
		try {
			tx = session.beginTransaction();
			account = (Account) session.get(Account.class, a);
		} catch(HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		} finally {
			session.close();
		}
		
		return account;
	}
	
//	public Account getCountry(int id) {
//		Account country= null;
//		return country;	 
//	}
	public Account addAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(account);
			
			tx.commit();
		} catch(HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		} finally {
			session.close();
		}
		return account;
	}
 
	public Account updateAccount(Account a) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			session.update(a);
			
			tx.commit();
		} catch(HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		} finally {
			session.close();
		}
		return a;
		
	}
//	public void deleteCountry(int id) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		
//		Transaction tx = null;
//		
//		try {
//			tx = session.beginTransaction();
//			Account cont = (Account) session.get(Account.class, id);
//			session.delete(cont);
//			
//			tx.commit();
//		} catch(HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//		} finally {
//			session.close();
//		}
//	}
 
}
