package org.TFM.Formateur.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeFormateur;
}
