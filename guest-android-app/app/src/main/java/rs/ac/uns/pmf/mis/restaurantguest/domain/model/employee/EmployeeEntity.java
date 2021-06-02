package rs.ac.uns.pmf.mis.restaurantguest.domain.model.employee;

public class EmployeeEntity {

	private Employees employees;

	public Employees getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return
				"EmployeeEntity{" +
						"employees = '" + employees + '\'' +
						"}";
	}
}