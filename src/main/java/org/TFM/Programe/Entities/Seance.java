package org.TFM.Programe.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeSeance;
}
