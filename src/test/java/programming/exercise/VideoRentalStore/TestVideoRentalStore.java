package programming.exercise.VideoRentalStore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class TestVideoRentalStore {
	Film film1 = new Film("Lincoln", "New release");
	Film film2 = new Film("Gladiator", "Regular rental");
	Film film3 = new Film("Bean", "Old film");
	
	@Test
	public void TestFilmName(){
		assertEquals("Lincoln", film1.getName());
	}
	
	@Test
	public void TestFilmType(){
		assertEquals("New release", film1.getType());
		assertEquals("Regular rental", film2.getType());
		assertEquals("Old film", film3.getType());
	}
	
	@Test
	public void TestChangeFilmType(){
		film1.setType("Regular rental");
		film2.setType("Old film");
		film3.setType("New release");
		
		assertEquals("Regular rental", film1.getType());
		assertEquals("Old film", film2.getType());
		assertEquals("New release", film3.getType());
		
		/**
		 * Changing back to original types.
		 */
		film1.setType("New release");
		film2.setType("Regular rental");
		film3.setType("Old film");
	}
	
	Rent rent1 = new Rent(film1, 7, false);
	Rent rent2 = new Rent(film2, 7, false);
	Rent rent3 = new Rent(film3, 7, false);
	Rent rent4 = new Rent(film1, 1, false);
	Rent rent5 = new Rent(film2, 1, false);
	Rent rent6 = new Rent(film3, 1, false);
	Rent rent7 = new Rent(film1, 4, false);
	Rent rent8 = new Rent(film2, 4, false);
	Rent rent9 = new Rent(film3, 4, false);
	
	@Test
	public void TestRentFilmParameters(){
		assertEquals("Lincoln", rent1.getFilm().getName());
		assertEquals("New release", rent1.getFilm().getType());
	}
	
	@Test
	public void TestRentPrice(){
		assertEquals(28, rent1.getPrice());
		assertEquals(15, rent2.getPrice());
		assertEquals(9, rent3.getPrice());
		assertEquals(4, rent4.getPrice());
		assertEquals(3, rent5.getPrice());
		assertEquals(3, rent6.getPrice());
		assertEquals(16, rent7.getPrice());
		assertEquals(6, rent8.getPrice());
		assertEquals(3, rent9.getPrice());
	}
	
	@Test
	public void TestRentPriceLate(){
		DaysPassed dp = new DaysPassed(10);
		rent1.setPriceLate(dp.getDaysPassed());
		rent1.setPriceLate(dp.getDaysPassed());
		rent2.setPriceLate(dp.getDaysPassed());
		rent3.setPriceLate(dp.getDaysPassed());
		rent4.setPriceLate(dp.getDaysPassed());
		rent5.setPriceLate(dp.getDaysPassed());
		rent6.setPriceLate(dp.getDaysPassed());
		rent7.setPriceLate(dp.getDaysPassed());
		rent8.setPriceLate(dp.getDaysPassed());
		rent9.setPriceLate(dp.getDaysPassed());
		assertEquals(12, rent1.getPriceLate());
		assertEquals(9, rent2.getPriceLate());
		assertEquals(9, rent3.getPriceLate());
		assertEquals(36, rent4.getPriceLate());
		assertEquals(27, rent5.getPriceLate());
		assertEquals(27, rent6.getPriceLate());
		assertEquals(24, rent7.getPriceLate());
		assertEquals(18, rent8.getPriceLate());
		assertEquals(18, rent9.getPriceLate());
	}
	
	Customer customer = new Customer("Charlie");
	Rent rent10 = new Rent(film2, 2, true);
	
	@Test
	public void TestRentPaidWithBonusPoints(){
		customer.setBonusPoints(51);
		customer.getRents().add(rent10);
		customer.updateBonusPoints();
		assertEquals(2, customer.getBonusPoints());
	}
	
	Inventory inventory = new Inventory();
	
	@Test 
	public void FilmsInInventory(){
		inventory.getAllFilms().addAll((Arrays.asList(film1, film2, film3)));
		inventory.getFilmsInStore().addAll((Arrays.asList(film1, film2, film3)));
		assertEquals(inventory.listAllFilms(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean")));
		assertEquals(inventory.listFilmsInStore(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean")));
	}
	
	@Test 
	public void InventoryAddFilm(){
		inventory.getAllFilms().addAll((Arrays.asList(film1, film2, film3)));
		inventory.getFilmsInStore().addAll((Arrays.asList(film1, film2, film3)));
		inventory.addFilm(film1);
		assertEquals(inventory.listAllFilms(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean")));
		assertEquals(inventory.listFilmsInStore(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean")));
		inventory.addFilm(new Film("Godzilla", "New release"));
		assertEquals(inventory.listAllFilms(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean", "Godzilla")));
		assertEquals(inventory.listFilmsInStore(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean", "Godzilla")));
	}
	
	@Test 
	public void InventoryRemoveFilm(){
		inventory.getAllFilms().addAll((Arrays.asList(film1, film2, film3)));
		inventory.getFilmsInStore().addAll((Arrays.asList(film1, film2, film3)));
		inventory.removeFilm(new Film("Logan", "New release"));
		assertEquals(inventory.listAllFilms(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean")));
		assertEquals(inventory.listFilmsInStore(), new ArrayList<String>(Arrays.asList("Lincoln", "Gladiator", "Bean")));
		inventory.removeFilm(film1);
		assertEquals(inventory.listAllFilms(), new ArrayList<String>(Arrays.asList("Gladiator", "Bean")));
		assertEquals(inventory.listFilmsInStore(), new ArrayList<String>(Arrays.asList("Gladiator", "Bean")));
	}
	@Test
	public void InventoryChangeFilmType(){
		inventory.getAllFilms().addAll((Arrays.asList(film1, film2, film3)));
		inventory.getFilmsInStore().addAll((Arrays.asList(film1, film2, film3)));
		inventory.changeFilmType("Lincoln", "Old film");
		assertEquals(inventory.getAllFilms().get(0).getType(), "Old film");
		assertEquals(inventory.getFilmsInStore().get(0).getType(), "Old film");
	}
	
	/*
	 * NOTE: there is no test case for rental receipt. It is demonstrated in Main class.
	 */
}
