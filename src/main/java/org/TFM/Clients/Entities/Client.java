package org.TFM.Clients.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeClient",
discriminatorType=DiscriminatorType.STRING,length=7)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public abstract class Client implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeClient;
	private String adress;
	private String numTelePortable;
	private String numTeleFixe;
	
	@ManyToOne
	@JoinColumn(name = "CodeType")
	public TypeClient typeClient;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "EnfantClient", 
			joinColumns = @JoinColumn(name = "codeClient"),
			inverseJoinColumns = @JoinColumn(name = "codeEnfant"))
	private Collection<Enfant> ListEnfant;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client( String adress, String numTelePortable, String numTeleFixe) {
		super();
		
		this.adress = adress;
		this.numTelePortable = numTelePortable;
		this.numTeleFixe = numTeleFixe;
	}
	public long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(long codeClient) {
		this.codeClient = codeClient;
	}

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getNumTelePortable() {
		return numTelePortable;
	}
	public void setNumTelePortable(String numTelePortable) {
		this.numTelePortable = numTelePortable;
	}
	public String getNumTeleFixe() {
		return numTeleFixe;
	}
	public void setNumTeleFixe(String numTeleFixe) {
		this.numTeleFixe = numTeleFixe;
	}
	public Collection<Enfant> getListEnfant() {
		return ListEnfant;
	}
	public void setListEnfant(Collection<Enfant> listEnfant) {
		ListEnfant = listEnfant;
	}
	
	
}

