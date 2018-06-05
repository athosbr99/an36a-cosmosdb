package org.athoscastro.jsfCosmos.entity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;;

@ManagedBean
public class Marca {
	private String id;
	private String nome;
	private final static String URI = "mongodb://172.17.0.2:27017";
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void createModelo() {
		try {
			MongoClient mongo = new MongoClient(new MongoClientURI(URI));
			DB db = mongo.getDB("jsfCosmosDB");
			DBCollection coll = db.getCollection("carros");
			DBObject doc = new BasicDBObject("nome", nome);
			coll.insert(doc);
			FacesContext context = FacesContext.getCurrentInstance();
	 		context.addMessage(null, new FacesMessage("Sucesso", "Cadastro feito com sucesso."));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}