package by.mandrik.afisha.entity;


import java.math.BigDecimal; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Event {
	private String title;
	private BigDecimal cost;
	private Date date;
	
	protected Event() {
		super();
	}
	protected Event(String name, BigDecimal cost, Date date2) {
		super();
		this.title = name;
		this.cost = cost;
		this.date = date2;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
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
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Event [name=" + title + ", cost=" + cost + ", date=" + date
				+ "]";
	}
	public void setDate(String string) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(string);
			this.date = date;
		} catch (ParseException e) {
			System.out.println("");
			e.printStackTrace();
		}
	}
	public void setCost(String string) {
 
		BigDecimal cost = new BigDecimal(string.replaceAll(",", ""));
		this.cost = cost;
	}
}