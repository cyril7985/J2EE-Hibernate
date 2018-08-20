package entities;
// Generated 7 aot 2018 11:19:11 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Villes generated by hbm2java
 */
@Entity
@Table(name="villes"
    ,catalog="cours"
)
public class Villes  implements java.io.Serializable {


     private String cp;
     private Pays pays;
     private String nomVille;
     private String site;
     private String photo;
     private Set<Vendeurs> vendeurses = new HashSet<Vendeurs>(0);
     private Set<VendeursVilles> vendeursVilleses = new HashSet<VendeursVilles>(0);
     private Set<Clients> clientses = new HashSet<Clients>(0);

    public Villes() {
    }

	
    public Villes(String cp, Pays pays, String nomVille) {
        this.cp = cp;
        this.pays = pays;
        this.nomVille = nomVille;
    }
    public Villes(String cp, Pays pays, String nomVille, String site, String photo, Set<Vendeurs> vendeurses, Set<VendeursVilles> vendeursVilleses, Set<Clients> clientses) {
       this.cp = cp;
       this.pays = pays;
       this.nomVille = nomVille;
       this.site = site;
       this.photo = photo;
       this.vendeurses = vendeurses;
       this.vendeursVilleses = vendeursVilleses;
       this.clientses = clientses;
    }
   
     @Id 

    
    @Column(name="cp", unique=true, nullable=false, length=5)
    public String getCp() {
        return this.cp;
    }
    
    public void setCp(String cp) {
        this.cp = cp;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pays", nullable=false)
    public Pays getPays() {
        return this.pays;
    }
    
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    
    @Column(name="nom_ville", nullable=false, length=50)
    public String getNomVille() {
        return this.nomVille;
    }
    
    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    
    @Column(name="site", length=50)
    public String getSite() {
        return this.site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }

    
    @Column(name="photo", length=50)
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="villes")
    public Set<Vendeurs> getVendeurses() {
        return this.vendeurses;
    }
    
    public void setVendeurses(Set<Vendeurs> vendeurses) {
        this.vendeurses = vendeurses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="villes")
    public Set<VendeursVilles> getVendeursVilleses() {
        return this.vendeursVilleses;
    }
    
    public void setVendeursVilleses(Set<VendeursVilles> vendeursVilleses) {
        this.vendeursVilleses = vendeursVilleses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="villes")
    public Set<Clients> getClientses() {
        return this.clientses;
    }
    
    public void setClientses(Set<Clients> clientses) {
        this.clientses = clientses;
    }




}


