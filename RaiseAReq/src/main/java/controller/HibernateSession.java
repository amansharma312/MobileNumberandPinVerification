package controller;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

	public static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		
		if(factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
	public void closeFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}
	
	public static User getUserDbConnection(String mobileNumber, String mpin) {
		
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		Session session = factory.openSession();
		
		Session session = HibernateSession.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		String sql = "from Users "
				+ "where mobileNumber =" + mobileNumber
				+ ", mpin ="+ mpin ;
		
		Query q1 = session.createQuery(sql);
		User u =  (User)q1.list().get(0);		
		
		tx.commit();
		session.close();
		
		return u;
	}


}
