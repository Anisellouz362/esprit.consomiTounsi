package tn.esprit.spring.entity.statistique;

public class PieChart {
	
	protected String name;
    protected Integer amount;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public PieChart() {
		super();
	}
	public PieChart(String name, Integer amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
    
    

}
