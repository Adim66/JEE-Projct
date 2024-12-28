package CinemaJEE.com.cinema.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import CinemaJEE.com.cinema.entities.Compte;
import CinemaJEE.com.cinema.entities.Film;
import CinemaJEE.com.cinema.entities.Salle;
import CinemaJEE.com.cinema.entities.SalleProgramme;
import CinemaJEE.com.cinema.entities.Seance;

@WebServlet("/users") // Maps the servlet to /users
public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;

	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("myPU"); // persistence.xml unit name
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();

        try {
            Long id = Long.valueOf(req.getParameter("id"));
            System.out.println("id estttt");
            System.out.println(id);
           Compte adim =new Compte("yallla","madrid");
         
           
            em.getTransaction().begin();
         
            em.persist(adim);
   
            em.getTransaction().commit();
            System.out.println("succcess to load ");
            if (adim != null) {
                resp.setContentType("application/json");
                resp.getWriter().write("{\"id\": " + adim.getId() + ", \"name\": \"" + adim.getName() + "\", \"email\": \"" + adim.getName() + "\"}");
                req.getRequestDispatcher("Vue.jsp").forward(req,resp);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            }
        } catch (Exception e) {
        	  System.out.println(e);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
        } finally {
            em.close();
        }
    }

	
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();

		
	}
	@Override
	public void destroy() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}