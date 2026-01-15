package programmerJDBC;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentClient {

    public static void main(String[] args) {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF); 
        Scanner sc = new Scanner(System.in); 

        
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(employee.class);
        SessionFactory sf = cfg.buildSessionFactory();

        while (true) {
        	
            System.out.println("\n===== Employee Management Driven system =====");
//            System.out.println("1) Add Employee");
//            System.out.println("2) Find Employee");
//            System.out.println("3) Remove Employee");
//            System.out.println("4) Update Employee");
//            System.out.println("5) Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Session session1 = sf.openSession();
                    Transaction tx1 = session1.beginTransaction();

                    employee emp1 = new employee();

                    System.out.print("Enter ID: ");
                    emp1.setSid(sc.nextInt());

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    emp1.setSname(sc.nextLine());

                    System.out.print("Enter Phone: ");
                    emp1.setSphone(sc.nextLong());

                    sc.nextLine();
                    System.out.print("Enter Gender: ");
                    emp1.setGender(sc.nextLine());
                    System.out.print("Enter Salary: ");
                    emp1.setSalary(sc.nextDouble());

                    sc.nextLine();
                    System.out.print("Enter Email: ");
                    emp1.setEmail(sc.nextLine());

                    session1.persist(emp1);
                    tx1.commit();
                    session1.close();

                    System.out.println(" Employee data has been added.");
                    break;
                    
                case 2:
                    Session session2 = sf.openSession();
                    System.out.print("Enter ID to find: ");
                    int findId = sc.nextInt();

                    employee found = session2.get(employee.class, findId);

                    if (found != null) {
                        System.out.println(" Employee data found:");
                        System.out.println(found);
                    } else {
                        System.out.println("The Employee of particular " + findId + " not found data into database.");
                    }

                    session2.close();
                    break;
                    
                case 3: {
                    Session session = sf.openSession();
                    Transaction tx = session.beginTransaction();

                    System.out.print("Enter ID to remove: ");
                    int id = sc.nextInt();

                    employee emp2 = session.get(employee.class, id);
                    if (emp2 != null) {
                        session.remove(emp2);
                        System.out.println("Employee removed successfully.");
                    } else {
                        System.out.println("Employee with ID " + id + " not found.");
                    }

                    tx.commit();
                    session.close();
                    break;
                }

                case 4: {
                    Session session = sf.openSession();
                    Transaction tx = session.beginTransaction();

                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();

                    employee emp3 = session.get(employee.class, id);
                    if (emp3 != null) {
                        sc.nextLine();
//                        System.out.print("Enter ID: ");
//                        emp3.setSid(sc.nextInt());
                        System.out.print("New Name: ");
                        emp3.setSname(sc.nextLine());

                        System.out.print("New Phone: ");
                        emp3.setSphone(sc.nextLong());

                        sc.nextLine();
                        System.out.print("New Gender: ");
                        emp3.setGender(sc.nextLine());

                        System.out.print("New Salary: ");
                        emp3.setSalary(sc.nextDouble());

                        sc.nextLine();
                        System.out.print("New Email: ");
                        emp3.setEmail(sc.nextLine());

                        session.merge(emp3);
                        System.out.println(" Employee updated successfully.");
                    } else {
                        System.out.println(" Employee with ID " + id + " not found.");
                    }

                    tx.commit();
                    session.close();
                    break;
                
                }
                case 5: {
                    System.out.println("The programe is over!");
                    sf.close();
                    sc.close();
                    System.exit(0); 
                    
                }
               
                default:
                	System.out.println("invalid choice");

            }
        }
    }
}

