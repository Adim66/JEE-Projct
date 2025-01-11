package CinemaJEE.com.cinema.dao;

import javax.security.auth.login.AccountNotFoundException;

import CinemaJEE.com.cinema.entities.Compte;
import jakarta.persistence.EntityManager;

public interface Utilisateur {
	public void init(String name, String passwd);
	public String getName() ; 
	public float  solde() ; 
	public void   debite(float f);
	public Compte save(Compte c);
	public void setEm(EntityManager em);
	public int getUser_id();
	public void setUser_id(int id);
}   
