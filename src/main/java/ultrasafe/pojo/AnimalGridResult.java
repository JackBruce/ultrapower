package ultrasafe.pojo;

public class AnimalGridResult {

	private String categories;
	private Integer data;
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public AnimalGridResult(String categories, Integer data) {
		super();
		this.categories = categories;
		this.data = data;
	}
	public AnimalGridResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
