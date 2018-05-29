package programming.exercise.VideoRentalStore;

public class Rent {
	public static final int PREMIUM_PRICE = 4;
	public static final int BASIC_PRICE = 3;
	
	private Film film;
	private int days;
	private int price;
	private int priceLate;
	private int daysLate;
	private boolean payedWithBonusPoints;
	private boolean filmReturned;
	
	public Rent(Film film, int days, boolean payedWithBonusPoints) {
		super();
		this.film = film;
		this.days = days;
		this.price = calculatePrice(film.getType(), days);
		this.priceLate = 0;
		this.daysLate = 0;
		this.payedWithBonusPoints = payedWithBonusPoints;
		this.filmReturned = false;
	}

	public Film getFilm() {
		return film;
	}

	public int getDays() {
		return days;
	}
	
	public int getPrice() {
		return price;
	}

	public int getPriceLate() {
		return priceLate;
	}
	
	public int getDaysLate() {
		return daysLate;
	}

	public void setPriceLate(int daysLate) {
		this.priceLate =  calculatePriceLate(film.getType(), daysLate - days);
		this.daysLate = daysLate - days;
	}

	public boolean isPayedWithBonusPoints() {
		return payedWithBonusPoints;
	}
	
	public void filmIsReturned(){
		filmReturned = true;
	}
	
	public boolean getFilmReturned(){
		return filmReturned;
	}

	public int calculatePrice(String filmType, int rentedDays){
		int price = 0;

		if(filmType.equals("New release")){
			price = rentedDays * PREMIUM_PRICE;
		}
		else if(filmType.equals("Regular rental")){
			if(rentedDays > 3){
				price = BASIC_PRICE + (rentedDays - 3) * BASIC_PRICE;
			}
			else{
				price = BASIC_PRICE;
			}
		}
		else if(filmType.equals("Old film")){
			if(rentedDays > 5){
				price = BASIC_PRICE + (rentedDays - 5) * BASIC_PRICE;
			}
			else{
				price = BASIC_PRICE;
			}
		}
		
		return price;
	}
	
	public int calculatePriceLate(String filmType, int lateDays){
		int price = 0;
		
		if(filmType.equals("New release")){
			price = lateDays * PREMIUM_PRICE;
		}
		else if(filmType.equals("Regular rental") || filmType.equals("Old film")){
			price = lateDays * BASIC_PRICE;
		}
		
		return price;
	}

}
