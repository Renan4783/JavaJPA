package exemplo;

import java.util.List;
import java.util.Map;
import javax.persistence.*;

public class principal {
	public static void main(String args[]){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/pontos.odb");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for (int i = 0; i<100; i++){
			Ponto p = new Ponto(i, i);
			em.persist(p);
		}
		em.getTransaction().commit();
		Query query = em.createQuery("SELECT AVG(p.x) FROM Ponto p");
		System.out.println("Média de x: " + query.getSingleResult());
		TypedQuery<Ponto> query2 = em.createQuery("SELECT p FROM Ponto p", Ponto.class);
		List<Ponto> results = query.getResultList();
		em.getTransaction().begin();
		for (Ponto p: results){
			em.remove(p);
		}
		em.getTransaction().commit();
		
	}
}
