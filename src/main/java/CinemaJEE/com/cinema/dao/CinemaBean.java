package CinemaJEE.com.cinema.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		Query query = em.createQuery("select f from Film f where f.name like : a ");
		query.setParameter("a","%" + pattern + "%");
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
		    queryone.setParameter("id", seance.getSalle().getId());
		    SalleProgramme salleprog = (SalleProgramme) queryone.getSingleResult();
            //seance.getSalle().getSalle_mere();
		    // Récupérer Salle en fonction de la SalleProgramme
		   // Query querytwo = em.createQuery("SELECT s FROM Salle s WHERE s.salleProg = :salleProg");
		   // querytwo.setParameter("salleProg", salleprog);
		   // Salle salle = (Salle) querytwo.getSingleResult();
                 Salle salle=seance.getSalle().getSalle_mere();
		    // Vérification de la capacité
		    if (salle.getCapacite() <= seance.getPlaces()) {
		        throw new IllegalStateException("La salle est pleine. Impossible de réserver plus de places.");
		    } else {
		        // Mise à jour des places disponibles et débit utilisateur
		        seance.setPlaces(seance.getPlaces() + 1);
		        em.getTransaction().begin();
		        em.merge(seance);
		        em.getTransaction().commit();
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
	public Set<Salle> getAllSalle(int choix, String [] tab_ids) {
		// TODO Auto-generated method stub
		Set<Salle> set = new HashSet();
		if(choix==0) {
		Query queryone = em.createQuery("select s from Salle s ");//maj
		set.addAll(queryone.getResultList());
		}
		else {
			List<Integer> ids = new ArrayList<>();
			for (String id : tab_ids) {
			    ids.add(Integer.parseInt(id));
			}
			Query queryone = em.createQuery("select s from Salle s where s.id in :ids");
			queryone.setParameter("ids",ids);
			set.addAll(queryone.getResultList());
		}
		
        System.out.println(set.size());
		return set;
	}


	@Override
	public Film createFilm(Film film) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(film);
		em.getTransaction().commit();
		//Query q = em.createQuery("select f from film f where f.name =:n ");
		//q.setParameter("n", film.getName());
		System.out.println("filmadded");
		return film;
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
