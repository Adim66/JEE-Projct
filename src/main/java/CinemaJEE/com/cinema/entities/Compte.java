package CinemaJEE.com.cinema.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "comptes")
public class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false)
	private float solde;

	public Compte(String string, String pass) {
		// TODO Auto-generated constructor stub
		this.name=string;
		this.password=pass;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("Compte[id=").append(getId()).append(", name=").
		append(getName()).append("]");
		return sb.toString(); 
		
		
	}

}
