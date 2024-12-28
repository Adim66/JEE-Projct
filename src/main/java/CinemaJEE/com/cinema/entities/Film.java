package CinemaJEE.com.cinema.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Film")
public class Film implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //najmou na3mlou autre strategy : suite fibonnacci 
	private int id ;
	@Column(nullable = false, length = 50) //colonne de type non nulle de max car 50 
    private String name;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SalleProgramme> salles_film;
	public int getId() {
		return id;
	}
	public List<SalleProgramme> getSalles_film() {
		return salles_film;
	}
	public void setSalles_film(List<SalleProgramme> salles_film) {
		this.salles_film = salles_film;
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
	public Film() {
		
	}

}
