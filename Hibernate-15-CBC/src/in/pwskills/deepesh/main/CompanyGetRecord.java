package in.pwskills.deepesh.main;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.mysql.cj.xdevapi.Schema.CreateCollectionOptions;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanyGetRecord {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				
				/*
				//Create a builder object
				CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
				
				//Create a cricteriaquery object
				CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
				
				//Create Root object specifying the entity class
				Root<Company> root = query.from(Company.class);
				
				//adding root object to query object
				//query.select(root);
				
				
				//prepare  a query object having query
				Query<Company> query2 = session.createQuery(query);
				
				//execute JPA QBC Logic
				query2.getResultList().forEach(System.out::println); 
				
				*/
				
				CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
				CriteriaQuery<Object> query = criteriaBuilder.createQuery();
				Root<Company> root = query.from(Company.class);
				query.select(root); //select from object
				
				//create a parameters
				ParameterExpression<Integer> parameter = criteriaBuilder.parameter(Integer.class);
				
				//creating condition objects
				Predicate ge = criteriaBuilder.ge(root.get("age") , parameter);
				
				//creating a final condition
				CriteriaQuery<Object> where = query.where(ge);
				
				Order desc = criteriaBuilder.desc(root.get("age"));
				
				query.orderBy(desc);
				
				Query<Object> query2 = session.createQuery(query);
				query2.setParameter(parameter, 15);
				
				query2.getResultList().forEach(System.out::println);
												
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
