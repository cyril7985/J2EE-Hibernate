package entities;
// Generated 7 aot 2018 11:19:11 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vendeurs generated by hbm2java
 */
@Entity
@Table(name="vendeurs"
    ,catalog="cours"
)
public class Vendeurs  implements java.io.Serializable {


     private Integer idVendeur;
     private Vendeurs vendeurs;
     private Villes villes;
     private String nom;
     private Set<VendeursVilles> vendeursVilleses = new HashSet<VendeursVilles>(0);
     private Set<Ventes> venteses = new HashSet<Ventes>(0);
     private Set<Vendeurs> vendeurses = new HashSet<Vendeurs>(0);

    public Vendeurs() {
    }

	
    public Vendeurs(Vendeurs vendeurs, Villes villes, String nom) {
        this.vendeurs = vendeurs;
        this.villes = villes;
        this.nom = nom;
    }
    public Vendeurs(Vendeurs vendeurs, Villes villes, String nom, Set<VendeursVilles> vendeursVilleses, Set<Ventes> venteses, Set<Vendeurs> vendeurses) {
       this.vendeurs = vendeurs;
       this.villes = villes;
       this.nom = nom;
       this.vendeursVilleses = vendeursVilleses;
       this.venteses = venteses;
       this.vendeurses = vendeurses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_vendeur", unique=true, nullable=false)
    public Integer getIdVendeur() {
        return this.idVendeur;
    }
    
    public void setIdVendeur(Integer idVendeur) {
        this.idVendeur = idVendeur;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="chef", nullable=false)
    public Vendeurs getVendeurs() {
        return this.vendeurs;
    }
    
    public void setVendeurs(Vendeurs vendeurs) {
        this.vendeurs = vendeurs;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cp", nullable=false)
    public Villes getVilles() {
        return this.villes;
    }
    
    public void setVilles(Villes villes) {
        this.villes = villes;
    }

    
    @Column(name="nom", nullable=false, length=45)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vendeurs")
    public Set<VendeursVilles> getVendeursVilleses() {
        return this.vendeursVilleses;
    }
    
    public void setVendeursVilleses(Set<VendeursVilles> vendeursVilleses) {
        this.vendeursVilleses = vendeursVilleses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vendeurs")
    public Set<Ventes> getVenteses() {
        return this.venteses;
    }
    
    public void setVenteses(Set<Ventes> venteses) {
        this.venteses = venteses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vendeurs")
    public Set<Vendeurs> getVendeurses() {
        return this.vendeurses;
    }
    
    public void setVendeurses(Set<Vendeurs> vendeurses) {
        this.vendeurses = vendeurses;
    }




}

