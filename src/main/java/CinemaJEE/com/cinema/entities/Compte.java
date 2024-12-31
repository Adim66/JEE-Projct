package CinemaJEE.com.cinema.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name = "comptes")
@NamedQueries({  
	  @NamedQuery(name = "findAllComptes",   query = "SELECT c FROM Compte c"),  
	    @NamedQuery(name = "findCompteByName", query = "SELECT c FROM Compte c WHERE c.name = :cname"),  
	  @NamedQuery(name = "findCompteById", query = "SELECT c FROM Compte c WHERE c.id =  :cid")      
	})  
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

	public Compte(String string, String pass, int solde) {
		// TODO Auto-generated constructor stub
		this.name=string;
		this.password=pass;
		this.solde=solde;
	}

	public int getId() {
		return id;
	}
    public Compte() {}
    
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
