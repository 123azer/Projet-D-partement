package com.example.demo.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@DiscriminatorValue("DemandeService")
public class DemandeS extends Demande implements Serializable  {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Demandeservice")
	private List<Service> services =new ArrayList<Service>();
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public DemandeS() {
		
	}
	
	public DemandeS(Date date, Enseignant enseigant, String Objet, EtatDemande Etat,String Commentaire) {
		super(date, enseigant, Objet, Etat,Commentaire);
	}

	public Service add(TypeService typeService,String commentaire) {
		Service s=new Service(typeService, EtatService.nonEffectue,this,commentaire);
		services.add(s);
		return s;
	}
	public void add(Service s) {
		services.add(s);
	}

	@Override
	public String toString() {
		return "    Demande de service:  date:" + date+", Objet: "+Objet+", Etat: "+Etat+ ", Commentaire: "+Commentaire+"\n        les services de la demande sont"+services+"";		  
	}
	
}
