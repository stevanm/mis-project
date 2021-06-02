package rs.ac.uns.pmf.mis.restaurantguest.domain.model.employee;

import java.util.List;

public class Employees {

	private List<EmployeeItem> employee;

	public List<EmployeeItem> getEmployee() {
		return employee;
	}

	@Override
	public String toString() {
		return
				"Employees{" +
						"employee = '" + employee + '\'' +
						"}";
	}
}