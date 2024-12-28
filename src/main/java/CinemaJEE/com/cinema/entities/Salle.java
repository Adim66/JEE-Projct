package CinemaJEE.com.cinema.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="salles")
public class Salle implements Serializable {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //najmou na3mlou autre strategy : suite fibonnacci 

	private int id ;
	@Column(nullable = false, length = 50) 
	private String name;
	@Column(nullable = false, length = 50) 
	private String adress;
	@Column(nullable = false) 
	private int capacite ;
	public SalleProgramme getSalle_prog() {
		return salle_prog;
	}
	public void setSalle_prog(SalleProgramme salle_prog) {
		this.salle_prog = salle_prog;
	}
	@OneToOne(mappedBy = "salle_mere")
	private SalleProgramme salle_prog;
	

}
