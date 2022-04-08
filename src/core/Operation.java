package core;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import empresa.Departamento;
import empresa.Empregado;
import empresa.Horas;
import empresa.Telefono;
import ui.Messages;
import utils.HibernateUtil;

public class Operation {
	public static void createDepartment(String name) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Departamento departamento = new Departamento(name);
		try {
			session.save(departamento);
			transaction.commit();	
		} catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void createEmployee(Empregado employee) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(employee);
			transaction.commit();	
		} catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void showEmployee(String nss) {
		Session session = HibernateUtil.openSession();
		Empregado employee = (Empregado) session.get(Empregado.class, nss);
		if(null != employee) {
			System.out.println(Messages.OPERATION_RESULT);
			System.out.println(employee.getNome() + " " + employee.getApelido1());
		} else {
			System.out.println(Messages.NO_DATA);
		}
		session.close();
	}
	
	public static void deleteDepartment(String nomeDepartamento) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Departamento departamento = (Departamento) session.get(Departamento.class, nomeDepartamento);
		try {
			session.delete(departamento);
			transaction.commit();	
		} catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void modifyDepartment(String nomeDepartamento, String numDepartamento) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Departamento departamento = (Departamento) session.get(Departamento.class, numDepartamento);
		try {
			departamento.setNumDepartamento(Integer.parseInt(numDepartamento));
			transaction.commit();	
		}catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} catch(NumberFormatException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void createEmployeeAndPhone(Empregado employee) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(employee);
			transaction.commit();	
		} catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} catch(Exception e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void addPhoneToEmployee(String nss, int phone, String description) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Empregado employee = (Empregado) session.get(Empregado.class, nss); 
		try {
			//employee.getTelefonos().add(phone));
			//employee.getTelefonos().add(new Telefono(phone));
			//employee.getTelefonos().put(phone, description);
			employee.getTelefonos().add(new Telefono(phone, description));
			transaction.commit();	
		}catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void deleteEmployee(String nss) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Empregado employee = (Empregado) session.get(Empregado.class, nss);
		try {
			session.delete(employee);
			transaction.commit();	
		} catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void deletePhone(String nss) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Empregado employee = (Empregado) session.get(Empregado.class, nss);
		try {
			employee.setTelefonos(null);
			transaction.commit();	
		} catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void deletePhoneOfEmployee(String nss, int phone) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Empregado employee = (Empregado) session.get(Empregado.class, nss);
		try {
			List<Telefono> telefonos = employee.getTelefonos();
			telefonos.remove(new Telefono(phone));
			employee.setTelefonos(telefonos);
			transaction.commit();	
		} catch(HibernateException e) {
			if(null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public static void addHoursToEmployee(String nss, String date, int hours) {
		Date myDate = null;
		try {
			myDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			Session session = HibernateUtil.openSession();
			Transaction transaction = session.beginTransaction();
			Empregado employee = (Empregado) session.get(Empregado.class, nss);
			try {
				employee.getHorasExtra().add(new Horas(myDate, hours));
				transaction.commit();	
			}catch(HibernateException e) {
				if(null != transaction) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateHoursToEmployee(String nss, String date, int id,  int hours) {
		Date myDate = null;
		try {
			myDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			Session session = HibernateUtil.openSession();
			Transaction transaction = session.beginTransaction();
			Empregado employee = (Empregado) session.get(Empregado.class, nss);
			
			try {	
				if(!employee.getHorasExtra().contains(new Horas(myDate))) {
					employee.getHorasExtra().add(new Horas(myDate, hours));
				} else {
					for (Horas hora : employee.getHorasExtra()) {
						if(hora.getId() == id) {
							hora.setHoras(hours);
						}
					}					
				}
				transaction.commit();	
			}catch(HibernateException e) {
				if(null != transaction) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
		
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getSortedHoursByEmployee(String nss) {
		Session session = HibernateUtil.openSession();
		Empregado employee = (Empregado) session.get(Empregado.class, nss);
		if(null != employee) {
			System.out.println(Messages.OPERATION_RESULT);
			SortedSet<Horas> horasExtra = employee.getHorasExtra();
			Iterator<Horas> i = horasExtra.iterator();
			while(i.hasNext()) {
				Horas hora = (Horas)i.next();
				System.out.println(hora.getHoras());
			}
		} else {
			System.out.println(Messages.NO_DATA);
		}
		session.close();
	}
}
