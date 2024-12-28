package CinemaJEE.com.cinema.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="seance")
public class Seance implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //najmou na3mlou autre strategy : suite fibonnacci 

	private int id ;
	private Date horaire;
	@Column(nullable = false) 
	private int places ;
	@Column(nullable = false) 
	private float tarif;
	@ManyToOne
    @JoinColumn(name = "salle_id", nullable = false)
	private SalleProgramme salle;
	public SalleProgramme getSalle() {
		return salle;
	}
	public void setSalle(SalleProgramme salle) {
		this.salle=salle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getHoraire() {
		return horaire;
	}
	public void setHoraire(Date horaire) {
		this.horaire = horaire;
	}
	public int getPlaces() {
		return places;
	}
	public void setPlaces(int places) {
		this.places = places;
	}
	public float getTarif() {
		return tarif;
	}
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	

	
	
}
