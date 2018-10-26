import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/* READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * 
 * Resources:
 * 	- Tutorial Series on Java Collections (ArrayList and HashMap):
 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#java_collections
 *	- Recording of lecture on implementing compareTo and using Arrays.sort(...):
 *		https://youtu.be/mDpDRLEy-7Y
 */

public class Database {
	/*
	 * Each entry in a 'departments' map contains
	 * a unique department id and its associated information object.
	 */
	HashMap<Integer, DepartmentInfo> departments;

	/*
	 * Each entry in a 'employees' map contains
	 * a unique employee id and its associated information object.
	 */
	HashMap<String, EmployeeInfo> employees;

	/**
	 * Initialize an empty database.
	 */
	public Database() {
		departments = new HashMap<>();
		employees = new HashMap<>();

	}

	/**
	 * Add a new employee entry.
	 * @param id id of the new employee
	 * @param info information object of the new employee
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing employee id
	 */
	public void addEmployee(String id, EmployeeInfo info) throws IdAlreadyExistsExceptoin {
		if ((employees.containsKey(id))) {
			IdAlreadyExistsExceptoin ex = new IdAlreadyExistsExceptoin("ID is an existing employee ID");
			throw ex;
		}
		employees.put(id, info);

	}

	/**
	 * Remove an existing employee entry.
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public void removeEmployee(String id) throws IdNotFoundException {
		if (!(employees.containsKey(id))) {
			IdNotFoundException ex = new IdNotFoundException("ID is not an existing employee ID");
			throw ex;
		}
		employees.remove(id);
	}

	/**
	 * Add a new department entry.
	 * @param id id of the new department
	 * @param info information object of the new department
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing department id
	 */
	public void addDepartment(Integer id, DepartmentInfo info) throws IdAlreadyExistsExceptoin {
		if (departments.containsKey(id)) {
			IdAlreadyExistsExceptoin ex = new IdAlreadyExistsExceptoin("ID is an existing department ID");
			throw ex;
		}
		departments.put(id, info);
	}

	/**
	 * Remove an existing department entry.
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public void removeDepartment(Integer id) throws IdNotFoundException {
		if (!(departments.containsKey(id))) {
			IdNotFoundException ex = new IdNotFoundException("ID is not an existing employee ID");
			throw ex;
		}
		departments.remove(id);
	}

	/**
	 * Change the department of employee with id 'eid' to a new department with id 'did'.
	 * 
	 * You can assume that 'did' denotes a department different from
	 * the current department of the employee denoted by 'eid'.
	 * @param eid id of some employee
	 * @param did id of some department
	 * @throws IdNotFoundException if either eid is a non-existing employee id or did is a non-existing department id.
	 */
	public void changeDepartment(String eid, Integer did) throws IdNotFoundException {
		if (!(employees.containsKey(eid))) {
			IdNotFoundException ex = new IdNotFoundException("Non-existing employee ID");
			throw ex;
		}
		if (!(departments.containsKey(did))) {
			IdNotFoundException exe = new IdNotFoundException("Non-existing department ID");
			throw exe;
		}
		employees.get(eid).setDepartmentId(did);
	}

	/**
	 * Retrieve the name of employee with id 'id'.
	 * @param id id of some employee
	 * @return name of the employee with id 'id'
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public String getEmployeeName(String id) throws IdNotFoundException {
		if (!(employees.containsKey(id))) {
			IdNotFoundException ex = new IdNotFoundException("Non-existing employee ID");
			throw ex;
		}
		return employees.get(id).getName();
	}

	/**
	 * Retrieve the names of all employees of the department with id 'id'.
	 * If 'id' a non-existing department id, then return an empty list.
	 * @param id id of some department
	 * @return List of names of employees whose home department has id 'id'
	 */
	public ArrayList<String> getEmployeeNames(Integer id) {
		ArrayList<String> names = new ArrayList<String>();

		for (Entry<String, EmployeeInfo> x : employees.entrySet()) {
			EmployeeInfo employee = x.getValue();

			if (employee.getDepartmentId() == id) {
				names.add(employee.getName());
			}
		}
		return names;
	}

	/**
	 * Retrieve an employee's department's information object.  
	 * @param id id of some existing employee
	 * @return The information object of the employee's home department
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public DepartmentInfo getDepartmentInfo(String id) throws IdNotFoundException {
		if (!(employees.containsKey(id))) {
			IdNotFoundException ex = new IdNotFoundException("Non-existing employee ID");
			throw ex;
		}
		return departments.get(employees.get(id).getDepartmentId());
	}

	/**
	 * Retrieve a list, sorted in increasing order, 
	 * the information objects of all stored employees.
	 * 
	 * Hints: 
	 * 1. Override the 'comareTo' method in EmployeeInfo class. 
	 * 2. Look up the Arrays.sort method in Java API. 
	 * @return A sorted list of information objects of all employees.
	 */
	public EmployeeInfo[] getSortedEmployeeInfo() {
		EmployeeInfo[] list = new EmployeeInfo[employees.size()];
		int count = 0;

		for (Entry<String, EmployeeInfo> x : employees.entrySet()) {
			list[count] = x.getValue();
			count++;
		}
		Arrays.sort(list);
		return list;
	}

	/**
	 * Retrieve the average salary of all employees in department with id 'id'.
	 * @param id id of some department 
	 * @return average salary of all employees in department with id 'id'
	 * @throws IdNotFoundException if id is not an existing department id
	 */
	public double getAverageSalary(Integer id) throws IdNotFoundException {
		if (!(departments.containsKey(id))) {
			IdNotFoundException ex = new IdNotFoundException("Non-existing department ID");
			throw ex;
		}
		double salary = 0;
		int count = 0;
		for (Entry<String, EmployeeInfo> x : employees.entrySet()) {
			EmployeeInfo employee = x.getValue();

			if (employee.getDepartmentId() == id) {
				salary += employee.getSalary();
				count++;
			}
		}
		return (salary / count);

	}

	/**
	 * Retrieve the information object of the department with the highest average salary among its employees.
	 * @return the information object of the department with the highest average salary among its employees
	 * 
	 * Hint: Use 'getAverageSalary(Integer id)' as a helper method.
	 * @throws IdNotFoundException 
	 */
	public DepartmentInfo getDepartmentOfHighestAverageSalary() {

		double sal = 0;
		DepartmentInfo info = null;
		try {
			for (Entry<Integer, DepartmentInfo> x : departments.entrySet()) {
				int key = x.getKey();
				DepartmentInfo dep = x.getValue();

				if (this.getAverageSalary(key) > sal) {
					sal = this.getAverageSalary(key);
					info = dep;
				}
			}
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		return info;
	}
}
