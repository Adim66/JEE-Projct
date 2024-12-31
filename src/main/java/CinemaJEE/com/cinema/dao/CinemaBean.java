package CinemaJEE.com.cinema.dao;

import java.util.HashSet;
import java.util.Set;

import CinemaJEE.com.cinema.entities.Film;
import CinemaJEE.com.cinema.entities.Salle;
import CinemaJEE.com.cinema.entities.SalleProgramme;
import CinemaJEE.com.cinema.entities.Seance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class CinemaBean implements Cinema {
	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	private Seance seance;

	public CinemaBean() {
	}

	@Override
	public Set<Film> list() {
		// TODO Auto-generated method stub
		Set<Film> set = new HashSet();
		Query query = em.createQuery("select f from film f");
		set.addAll(query.getResultList());
		return set;
	}

	@Override
	public Set<Film> findByPattern(String pattern) {
		// TODO Auto-generated method stub
		Set<Film> set = new HashSet();
		Query query = em.createQuery("select f from film f where name = :a ");
		query.setParameter(pattern, "a");
		set.addAll(query.getResultList());
		return set;
	}

	@Override
	public Film findFilm(int id) {
		// TODO Auto-generated method stub
		Film film = em.find(Film.class, id);
		// exception here
		
		return film;
	}

	@Override
	public void reserve(Seance seance, Utilisateur u) {
		// TODO Auto-generated method stub
		try {
		    // Récupérer SalleProgramme en fonction de l'ID de la séance
		    Query queryone = em.createQuery("SELECT s FROM SalleProgramme s WHERE s.id = :id");
		    queryone.setParameter("id", seance.getId());
		    SalleProgramme salleprog = (SalleProgramme) queryone.getSingleResult();

		    // Récupérer Salle en fonction de la SalleProgramme
		    Query querytwo = em.createQuery("SELECT s FROM Salle s WHERE s.salleProg = :salleProg");
		    querytwo.setParameter("salleProg", salleprog);
		    Salle salle = (Salle) querytwo.getSingleResult();

		    // Vérification de la capacité
		    if (salle.getCapacite() == seance.getPlaces()) {
		        throw new IllegalStateException("La salle est pleine. Impossible de réserver plus de places.");
		    } else {
		        // Mise à jour des places disponibles et débit utilisateur
		        seance.setPlaces(seance.getPlaces() + 1);
		        u.debite(seance.getTarif());
		    }
		} catch (NoResultException e) {
		    System.err.println("Aucun résultat trouvé : " + e.getMessage());
		    // Gérer l'exception si aucune SalleProgramme ou Salle n'est trouvée
		} catch (IllegalStateException e) {
		    System.err.println("Erreur logique : " + e.getMessage());
		    // Gérer l'exception si la salle est pleine
		} catch (Exception e) {
		    System.err.println("Une erreur inattendue s'est produite : " + e.getMessage());
		    e.printStackTrace();
		}
	}


	@Override
	public Set<SalleProgramme> getAllSalleProg() {
		// TODO Auto-generated method stub
		Query queryone = em.createQuery("select s from SalleProgramme s ");//maj
		Set<SalleProgramme> set = new HashSet();
		set.addAll(queryone.getResultList());
		  System.out.println("yyyyyyyyyyyyyyyyyy");
        System.out.println(set.size());
		return set;
	}

	@Override
	public Film createFilm(String name) {
		// TODO Auto-generated method stub
		Film film = new Film();
		film.setName(name);
		em.getTransaction().begin();
		em.persist(film);
		em.getTransaction().commit();
		Query q = em.createQuery("select f from film f where f.name:n ");
		q.setParameter(name, "n");

		return (Film) q.getResultList();
	}

	@Override
	public void update(Film f) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
	}

	@Override
	public float getTarif() {
		// TODO Auto-generated method stub
		return seance.getTarif();
	}



}
