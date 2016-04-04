package com.appdeveloper.appgasagua.paulohenrique.appgasagua.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/*
	 * private static SessionFactory sessionFactory; private static
	 * ServiceRegistry serviceRegistry;
	 * 
	 * private static SessionFactory configureSessionFactory() throws
	 * HibernateException { Configuration configuration = new Configuration();
	 * configuration.configure(); configuration.addAnnotatedClass(Pedido.class);
	 * configuration.addAnnotatedClass(AvaliacaoPedido.class);
	 * configuration.addAnnotatedClass(DadosGas.class);
	 * configuration.addAnnotatedClass(DadosAgua.class);
	 * 
	 * serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	 * configuration.getProperties()).build(); sessionFactory =
	 * configuration.buildSessionFactory(serviceRegistry); return
	 * sessionFactory; }
	 * 
	 * public static SessionFactory getSessionFactory() { return
	 * configureSessionFactory(); }
	 * 
	 * private static Connection getConnection() throws URISyntaxException,
	 * SQLException { String username = "tuwednlgqyfeho"; String password =
	 * "L_oMkVJRSkTfBkt9OdU5lHTHuJ"; String dbUrl =
	 * "postgres://tuwednlgqyfeho:L_oMkVJRSkTfBkt9OdU5lHTHuJ@ec2-54-235-246-67.compute-1.amazonaws.com:5432/dd7277vcv8p2hc";
	 * 
	 * return DriverManager.getConnection(dbUrl, username, password); }
	 */

	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration();
			sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			Logger.getLogger(HibernateUtil.class.getName()).log(Level.ERROR, null, ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static DataSource getDataSource() throws NamingException {
		// Get a context for the JNDI look up
		Context ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		// Look up a data source
		javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/aplgasaguaPool");
		return ds;
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		// Get a connection object
		try {
			conn = getDataSource().getConnection();
		} catch (NamingException e) {
			
		}
		return conn;
	}
}