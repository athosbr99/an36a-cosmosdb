package org.athoscastro.jsfCosmos.ejb;

import org.athoscastro.jsfCosmos.entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ManagerEJB {
	@PersistenceContext(unitName = "mongo-ogm")
	private EntityManager em;
	
	public void createMarca(String nome) {
		Marca marca = new Marca();
		marca.setNome(nome);
		em.persist(marca);
	}
	
	public void createModelo(String idMarca, String nomeModelo, String versao) {
		Marca marca = findMarcaById(idMarca);
		Modelo modelo = new Modelo();
		modelo.setMarca(marca);
		modelo.setNome(nomeModelo);
		modelo.setVersao(versao);
		em.persist(modelo);
	}
	
	public Marca findMarcaById(String id) {
		Query query = em.createQuery("FROM Marca where id=:id");
		query.setParameter("id", id);
		Marca marca = (Marca) query.getSingleResult();
		return marca;
	}
}
