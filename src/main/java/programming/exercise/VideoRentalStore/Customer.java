package programming.exercise.VideoRentalStore;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Rent> rents;
	private int bonusPoints;

	public Customer(String name) {
		super();
		this.rents = new ArrayList<Rent>();
		this.bonusPoints = 0;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<Rent> getRents() {
		return rents;
	}

	public int getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
	public void updateBonusPoints(){
		if(rents.get(rents.size() - 1).getFilm().getType().equals("New release")){
			this.bonusPoints += 2;
		}
		else if(rents.get(rents.size() - 1).getFilm().getType().equals("Regular rental") ||
				rents.get(rents.size() - 1).getFilm().getType().equals("Old film")){
			this.bonusPoints += 1;
		}
		if(rents.get(rents.size() - 1).isPayedWithBonusPoints()){
			this.bonusPoints -= (rents.get(rents.size() - 1).getDays() * 25);
		}
	}
	
	public String getReceipt(){
		String output = "";
		String outputOnTime = "";
		String outputLate = "";
		int priceOnTime = 0;
		int priceLate = 0;
		boolean bonusPointsUsed = false;
		for(Rent rent : rents){
			if(!rent.isPayedWithBonusPoints()){
				String r = rent.getFilm().getName() + " (" + rent.getFilm().getType() + ") " + rent.getDays() + " days " + rent.getPrice() + " EUR\n";
				outputOnTime += r;
				priceOnTime += rent.getPrice();
			}
			else{
				String rr = rent.getFilm().getName() + " (" + rent.getFilm().getType() + ") " + rent.getDays() + " days (Paid with " + rent.getDays() * 25 + " Bonus points)\n";
				outputOnTime += rr;
				bonusPointsUsed = true;
			}
			
			if(rent.getDaysLate() > 0){
				String rrr = rent.getFilm().getName() + " (" + rent.getFilm().getType() + ") " + rent.getDaysLate() + " extra days " + rent.getPriceLate() + " EUR\n";
				outputLate += rrr;
				priceLate += rent.getPriceLate();
			}
		}
		
		outputOnTime += "Total price: " + priceOnTime + " EUR\n\n";
		
		if(outputLate.length() > 0){
			outputLate += "Total late charge: " + priceLate + " EUR\n\n";
		}
		
		output = "RECEIPT\n-------\n" + outputOnTime + outputLate;
		
		if(bonusPointsUsed){
			output += "Remaining Bonus points: " + getBonusPoints();
		}
		
		
		return output;
	}
	
	
	
	
	

}
