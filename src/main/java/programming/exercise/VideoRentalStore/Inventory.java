package programming.exercise.VideoRentalStore;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Film> allFilms;
	private List<Film> filmsInStore;
	
	public Inventory() {
		super();
		this.allFilms = new ArrayList<Film>();
		this.filmsInStore = new ArrayList<Film>();
	}

	public List<Film> getAllFilms() {
		return allFilms;
	}

	public List<Film> getFilmsInStore() {
		return filmsInStore;
	}

	public ArrayList<String> listAllFilms(){
		ArrayList<String> films = new ArrayList<String>();
		for(Film film : allFilms){
			films.add(film.getName());
		}
		return films;
	}
	
	public ArrayList<String> listFilmsInStore(){
		ArrayList<String> films = new ArrayList<String>();
		for(Film film : filmsInStore){
			films.add(film.getName());
		}
		return films;
	}
	
	public void changeFilmType(String filmName, String newType){
		for(Film f : allFilms){
			if(f.getName().equals(filmName)){
				f.setType(newType);
			}
		}
		for(Film f : filmsInStore){
			if(f.getName().equals(filmName)){
				f.setType(newType);
			}
		}
	}
	
	public void addFilm(Film filmAdd){
		if(!listAllFilms().contains(filmAdd.getName()) && !listAllFilms().contains(filmAdd.getType())){
			this.allFilms.add(filmAdd);
			this.filmsInStore.add(filmAdd);
		}
	}
	
	public void removeFilm(Film film){
		getAllFilms().remove(film);
		getFilmsInStore().remove(film);
	}
	
	public void removeFilmFromStore(Film film){
		getFilmsInStore().remove(film);
	}
	
}
