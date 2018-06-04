package org.athoscastro.jsfCosmos.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.faces.application.FacesMessage;
import java.util.List;
import static javax.persistence.FetchType.EAGER;
import org.hibernate.annotations.GenericGenerator;

@Entity
@ManagedBean
public class Marca {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	private String nome;
	@OneToMany(mappedBy = "marcasFK", fetch = EAGER)
	private List<Modelo> modelos; 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", nome));
		System.out.println(nome);	
	}
}
