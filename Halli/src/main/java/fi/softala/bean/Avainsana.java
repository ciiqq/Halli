package fi.softala.bean;

public class Avainsana {
	
	private int id;
	private String avainsana;
	
	public Avainsana() {
		super();
	}

	public Avainsana(int id, String avainsana) {
		super();
		this.id = id;
		this.avainsana = avainsana;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvainsana() {
		return avainsana;
	}
	public void setAvainsana(String avainsana) {
		this.avainsana = avainsana;
	}
	
	@Override
	public String toString() {
		return "Avainsana [id=" + id + ", avainsana=" + avainsana + "]";
	}
	
	

}
