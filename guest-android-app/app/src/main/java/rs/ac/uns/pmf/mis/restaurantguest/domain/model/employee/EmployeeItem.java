package rs.ac.uns.pmf.mis.restaurantguest.domain.model.employee;

public class EmployeeItem{

	private String firstName;

	private String lastName;

	private String photo;

	private String id;

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getPhoto(){
		return photo;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"EmployeeItem{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",photo = '" + photo + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}