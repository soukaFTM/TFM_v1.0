package org.TFM.Clients.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MORAL")
public class ClientMoral extends Client {
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
