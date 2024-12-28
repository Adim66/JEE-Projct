package CinemaJEE.com.cinema.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="salle_Prog")
public class SalleProgramme implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Seance> seance;
	@ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salle_mere_id", referencedColumnName = "id")
	private Salle salle_mere;
	
	public int getId() {
		return id;
	}

	public Film getFilm() {
		return film;
	}

	public Salle getSalle_mere() {
		return salle_mere;
	}

	public void setSalle_mere(Salle salle_mere) {
		this.salle_mere = salle_mere;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Seance> getSeance() {
		return seance;
	}

	public void setSeance(List<Seance> seance) {
		this.seance = seance;
	}

	
	

}
