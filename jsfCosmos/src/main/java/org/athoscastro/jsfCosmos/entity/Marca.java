package org.athoscastro.jsfCosmos.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean
public class Marca {
	private String nome;

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
