package org.TFM.Clients.Entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("MORAL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ClientMoral extends Client implements Serializable{
	private String nomClient;
	private String statutJuridique;
	public ClientMoral() {
		super();
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getStatutJuridique() {
		return statutJuridique;
	}
	public void setStatutJuridique(String statutJuridique) {
		this.statutJuridique = statutJuridique;
	}
	
	
}
