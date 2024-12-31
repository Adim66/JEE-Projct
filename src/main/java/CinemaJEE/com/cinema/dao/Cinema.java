package CinemaJEE.com.cinema.dao;

import java.util.Set;

import CinemaJEE.com.cinema.entities.Film;
import CinemaJEE.com.cinema.entities.SalleProgramme;
import CinemaJEE.com.cinema.entities.Seance;
import jakarta.persistence.EntityManager;

public interface Cinema {
	// Lister l'ensemble de films disponible au cinema.
	public Set<Film> list();

	// Trouver les films correspondants au pattern donné en entrée.
	public Set<Film> findByPattern(String pattern);

	// Trouver un film à partir d'un id.
	public Film findFilm(int id);

	// Réserver une séance pour un utilisateur.
	public void reserve(Seance seance, Utilisateur u);

	public Set<SalleProgramme> getAllSalleProg();

	public Film createFilm(String name);

	public void update(Film f);

	public float getTarif();

	public void setEm(EntityManager em);
}
