package by.mandrik.afisha.entity;
import java.math.BigDecimal;
import java.util.Date;

public class Film extends Event{
	private Double rating;

	public Film(String name, BigDecimal price, Date date,
			Double rating) {
		super(name, price, date);
		this.rating = rating;
	}

	public Film() {
		super();
		
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "Film [rating=" + rating + "]";
	}
	
}
