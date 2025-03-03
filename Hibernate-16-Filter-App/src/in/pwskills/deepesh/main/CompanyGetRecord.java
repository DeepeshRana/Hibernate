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

import org.hibernate.Filter;
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
				
				//Enabling the filter on entity class called "CompanyFilter"
				
				Filter enableFilter = session.enableFilter("FILTER_COMPANY");
				enableFilter.setParameter("param1", 16);
				
				
				// HQL
				
				Query query = session.createQuery("from Company where age>=:input");
				query.setParameter("input" , 16);
				
				System.out.println("\n");
				List<Company> record = query.getResultList();
				
				record.forEach(result ->  System.out.println(result));
				
				//Disable the filter
				session.disableFilter("FILTER_COMPANY");
												
				
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
