package programming.exercise.VideoRentalStore;

import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		/*
		 * Creating films for New release, Regular rental and Old film section. 
		 */
		Film film1 = new Film("The Martian", "New release");
		Film film2 = new Film("The Imitation Game", "New release");
		Film film3 = new Film("The Texas Chainsaw Massacre", "Regular rental");
		Film film4 = new Film("Home Alone 1", "Old film");
		Film film5 = new Film("Forrest Gump", "Old film");
		Film film6 = new Film("Transformers", "Regular rental");
		Film film7 = new Film("12 Years a Slave", "New release");
		Film film8 = new Film("Behind Enemy Lines", "Regular rental");
		Film film9 = new Film("Ghostbusters", "Old film");
		Film film10 = new Film("Avatar", "Regular rental");
		Film film11 = new Film("Die Hard 3", "Old film");
		Film film12 = new Film("Star Wars: The Last Jedi", "New release");
		/*
		 * Creating a new inventory and adding the 12 films to the store.
		 */
		Inventory inventory = new Inventory();
		inventory.getAllFilms().addAll((Arrays.asList(film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, 
		film11, film12)));
		inventory.getFilmsInStore().addAll((Arrays.asList(film1, film2, film3, film4, film5, film6, film7, film8, film9, film10,
		film11, film12)));
		/*
		 * We can now list all the films and all the films, which are available (both are the same at the beginning).
		 */
		System.out.println("All films:");
		System.out.println(inventory.listAllFilms());
		System.out.println("Films in store:");
		System.out.println(inventory.listFilmsInStore());
		System.out.println();
		/*
		 * Let's say there's a customer, whose name is Peter Griffin.
		 */
		Customer PeterGriffin = new Customer("Peter Griffin");
		/*
		 * Peter Griffin rents "The Imitation Game" film for 5 days. He doesn't have bonus points to use, 
		 * so he pays 20 EUR. *We don't keep track of customer's budget.
		 * 
		 */
		Rent rent1_byPeterGriffin = new Rent(inventory.getAllFilms().get(1), 5, false);
		PeterGriffin.getRents().add(rent1_byPeterGriffin);
		PeterGriffin.updateBonusPoints();
		/*
		 * As "The Imitation Game" is rented out, we will remove it from the list, which shows available films.
		 */
		inventory.removeFilmFromStore(inventory.getAllFilms().get(1));
		/*
		 * Let's make sure the film exists now only in the first (all films) list.
		 */
		System.out.println("All films:");
		System.out.println(inventory.listAllFilms());
		System.out.println("Films in store:");
		System.out.println(inventory.listFilmsInStore());
		System.out.println();
		/*
		 * Let's assume "Avatar" film isn't available anymore. So it can be removed from the inventory.
		 */
		inventory.removeFilm(inventory.getAllFilms().get(9));
		/*
		 * Let's make sure the "Avatar" film doesn't exist at the store.
		 */
		System.out.println("All films:");
		System.out.println(inventory.listAllFilms());
		System.out.println("Films in store:");
		System.out.println(inventory.listFilmsInStore());
		System.out.println();
		/*
		 * We can also add films.
		 */
		inventory.addFilm(new Film("Prometheus", "New release"));
		/*
		 * Let's make sure the "Prometheus" film is there. *It goes at the end of the list by default.
		 */
		System.out.println("All films:");
		System.out.println(inventory.listAllFilms());
		System.out.println("Films in store:");
		System.out.println(inventory.listFilmsInStore());
		System.out.println();
		/*
		 * It's also possible to change the type of a film. "The Martian" is a New release right now, 
		 * but a couple of years later it would be Regular rental. So first we make sure "The Martian"
		 * is still a New release and after the change it will be a Regular rental.
		 */
		System.out.println("The Martian is a "  + inventory.getAllFilms().get(0).getType() + " by type.");
		inventory.changeFilmType("The Martian", "Regular rental");
		System.out.println("UPDATE: The Martian is now a " + inventory.getAllFilms().get(0).getType() + " by type.");
		System.out.println();
		/*
		 * Let's make sure that Peter Griffin has payed 20 EUR for the film, the film he rented 
		 * was "The Imitation Game" and because the film was "New release", he has therefore 2 bonus points. 
		 */
		System.out.println("Peter Griffin payed " + rent1_byPeterGriffin.getPrice() + " EUR for the film.");
		System.out.println("The title of the film was " + '"' + rent1_byPeterGriffin.getFilm().getName() + '"' + ".");
		System.out.println("Peter Griffin has now " + PeterGriffin.getBonusPoints() + " bonus point(s).");
		/*
		 * Peter Griffin has returned the film and the receipt is the following:
		 */
		rent1_byPeterGriffin.filmIsReturned();
		System.out.println();
		System.out.println(PeterGriffin.getReceipt());
		/*
		 * Let's imagine another scenario and say 7 days have passed after Peter Griffin rented the film.
		 * That means he was 2 days late, so the late charge is 8 EUR.
		 * Now the receipt shows the first payment and also late charge: 
		 */
		DaysPassed dp = new DaysPassed(7);
		rent1_byPeterGriffin.setPriceLate(dp.getDaysPassed());
		System.out.println(PeterGriffin.getReceipt());
		/*
		 * Let's assume Peter Griffin has rented many films before and he has already 80 bonus points.
		 */
		PeterGriffin.setBonusPoints(80);
		/*
		 * He wants to rent "Ghostbusters" movie for 2 days and pays with bonus points.
		 * Now the receipt shows the first payment, late charge and also the bonus points payment part: 
		 */
		Rent rent2_byPeterGriffin  = new Rent(inventory.getAllFilms().get(8), 2, true);
		PeterGriffin.getRents().add(rent2_byPeterGriffin);
		PeterGriffin.updateBonusPoints();
		System.out.println(PeterGriffin.getReceipt());

	}
	

}
