package CinemaJEE.com.cinema.dao;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.mysql.cj.Query;

import CinemaJEE.com.cinema.entities.Compte;
import jakarta.persistence.EntityManager;

public class UtilisateurBean implements Utilisateur {
	  public EntityManager getEm() {
		return em;
	}
	@Override
	public void setEm(EntityManager em) {
		this.em = em;
	}
	private int user_id; 
	  private EntityManager em; 
	  public UtilisateurBean() {  
	        super(); 
	        
	       }  
	@Override
	public void init(String name, String passwd)  {
		// TODO Auto-generated method stub
		  jakarta.persistence.Query q = em.createNamedQuery("findCompteByName");  
	        q.setParameter("cname",name);  
	        List<Compte> res = (List<Compte>)q.getResultList();  
	          
	        if (res==null || res.size()==0) {  
	         // throw new UserNotFoundException();  
	        }else{  
	          if (res.get(0).getName().equals(name) && res.get(0).getPassword().equals(passwd)){  
	            user_id = res.get(0).getId();  
	          }else {  
	            //throw new UserNotFoundException();  
	          }  
	        } 
	}

	@Override
	public String getName(){  
		  jakarta.persistence.Query q = em.createNamedQuery("findCompteById");  
		    q.setParameter("cid",user_id);  
		  List<Compte> res = (List<Compte>)(q.getResultList());  
		  if(res.size()==0){  
		     // throw new UserNotFoundException();  
		        }else{  
		      //nom = res.get(0).getName();  
		  }  
		   
		    return res.get(0).getName();  
		    }  


	@Override
	public float solde() {
		// TODO Auto-generated method stub
		 float sld;  
		    jakarta.persistence.Query q = em.createNamedQuery("findCompteById");  
		      q.setParameter("cid",user_id);  
		    List<Compte> res = (List<Compte>)(q.getResultList());  
		     
		     // if(res.size()==0)  
		        // throw new UserNotFoundException();  
		     // else  
		        sld = res.get(0).getSolde(); 
		        return sld;  
	}

	@Override
	public void debite(float f) {
		// TODO Auto-generated method stub
		float solde ;
		solde=solde();
		if(solde<=f) {
		//	throws  new SoldeNegatifException() ;
		}
		else {
			  Compte compte;  
		      jakarta.persistence.Query q = em.createNamedQuery("findCompteById");  
		      q.setParameter("cid",user_id);  
		      List<Compte> res = (List<Compte>)(q.getResultList());  
		      if(res.size()==0){  
	
		    	   
		    	            //throw new UserNotFoundException();  
		    	        }else{  
		    	            compte = res.get(0);  
		    	            compte.setSolde(solde-f);  
		    	            em.merge(compte);  
		    	        }  
		    	        
		    	        }  
		    	       
}
	public Compte save(Compte compte)  {
		try {
		em.getTransaction().begin();
		em.persist(compte);
		em.getTransaction().commit();
		jakarta.persistence.Query q = em.createNamedQuery("select c from comptes c where c.name:a and c.password:p ");
		q.setParameter(compte.getName(), "a");
		Compte c =(Compte) q.getResultList().get(0);
		if (c.getPassword().equals(compte.getPassword())){
			
			compte.setId(c.getId()); //hhhhhhhhhhhhhh 
		}
		}catch(Exception e) {
			//manage execption
		}
		
		return compte;
		
		
		
	}
}