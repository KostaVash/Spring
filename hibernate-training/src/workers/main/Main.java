package workers.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import workers.entity.Worker;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Worker worker=new Worker("aa","bb","cc");
		
		addWorker(worker);

		getWorkerById(1);

		showWorkers();

		searchByComapnyName("cc");
		
		deleteById(1);

		System.out.println("Done");
	}


	public static void addWorker(Worker worker) {
		
		//creating session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class).buildSessionFactory();

		//create session 
		Session session = factory.getCurrentSession();

		try {
			
			//begin transaction
			session.beginTransaction();
			//add the worker to the database
			System.out.println("\n\nAdding worker to data base\n\n");
			session.save(worker);
			System.out.println("adding worker: "+worker);
			//commit transaction
			session.getTransaction().commit();


		}
		finally {
			//close the factory
			factory.close();

		}


	}
	
	
	
	public static void getWorkerById(int Id) {
		
		
		//creating session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class).buildSessionFactory();

		//create session 
		Session session = factory.getCurrentSession();
	

		try {
			//begin transaction
			session.beginTransaction();
			
			System.out.println("\n\nGet Worker By Id\n\n");
			
			Worker worker = session.get(Worker.class, Id);
			
			System.out.println(worker);
			
			//commit transaction
			session.getTransaction().commit();

			}
		
		finally {
			//close the factory
			factory.close();

		}
	}
	
	private static void displayWorkers(List<Worker> theWorkers) {
		
		for (Worker tmp:theWorkers)
		System.out.println(tmp);
	}
	
	public static void showWorkers() {
	
		//creating session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class).buildSessionFactory();

		//create session 
		Session session = factory.getCurrentSession();
				
				try {
					
					//start a transaction
					session.beginTransaction();
			
					List<Worker> theWorkers = session.createQuery("from Worker").getResultList();
				
					System.out.println("\n\nShow All The Workers:\n\n");
					
					displayWorkers(theWorkers);
					
					//commit transaction
					session.getTransaction().commit();
					
				}
				finally {
					
					factory.close();
				}
				
			
	}
	
	public static void searchByComapnyName(String company) {
		
		//creating session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class).buildSessionFactory();

		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
	
			List<Worker> theWorkers = session.createQuery("from Worker w where w.Company='"+company+"'").getResultList();
		
			System.out.println("\n\nShow All The Workers from Company "+company+":\n\n");
			
			displayWorkers(theWorkers);
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			factory.close();
		}
		
		
	}
	
	public static void deleteById(int Id) {
		//creating session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class).buildSessionFactory();

		//create session 
		Session session = factory.getCurrentSession();
		

		try {
			
			//start a transaction
			session.beginTransaction();
			
			Worker worker = session.get(Worker.class, Id);
			
			System.out.println("Deleting the worker: "+worker);
			//deleting the worker 
			if(worker !=null) {
			session.delete(worker);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			factory.close();
		}
		
		
		
	}
	
}
