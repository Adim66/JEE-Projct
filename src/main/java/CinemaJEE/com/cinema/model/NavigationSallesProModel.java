package CinemaJEE.com.cinema.model;

import java.util.Set;

import CinemaJEE.com.cinema.entities.SalleProgramme;

public class NavigationSallesProModel {
	private int id ;
	private Set<SalleProgramme> salles_prog;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<SalleProgramme> getSalles_prog() {
		return salles_prog;
	}
	public void setSalles_prog(Set<SalleProgramme> salles_prog) {
		this.salles_prog = salles_prog;
	}
	
	

}
