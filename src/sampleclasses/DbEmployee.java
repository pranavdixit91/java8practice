package sampleclasses;

import java.util.Arrays;

public class DbEmployee {
	private String designation;
	private String name;
	private String[] citiesLivedIn; 

	public String[] getCitiesLivedIn() {
		return citiesLivedIn;
	}

	public void setCitiesLivedIn(String[] citiesLivedIn) {
		this.citiesLivedIn = citiesLivedIn;
	}

	public Boolean isSeniorAnalyst() {
		return "Senior Analyst".equalsIgnoreCase(this.designation);
	}

	public DbEmployee(String designation, String name) {
		super();
		this.designation = designation;
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DbEmployee(String designation, String name, String[] citiesLivedIn) {
		super();
		this.designation = designation;
		this.name = name;
		this.citiesLivedIn = citiesLivedIn;
	}

	public DbEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(citiesLivedIn);
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DbEmployee other = (DbEmployee) obj;
		if (!Arrays.equals(citiesLivedIn, other.citiesLivedIn))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DbEmployee [designation=" + designation + ", name=" + name + ", citiesLivedIn="
				+ Arrays.toString(citiesLivedIn) + "]";
	}
	
}

