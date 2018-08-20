package entities;
// Generated 7 aot 2018 11:19:11 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pays generated by hbm2java
 */
@Entity
@Table(name="pays"
    ,catalog="cours"
)
public class Pays  implements java.io.Serializable {


     private String idPays;
     private String nomPays;
     private Set<Villes> villeses = new HashSet<Villes>(0);

    public Pays() {
    }

	
    public Pays(String idPays, String nomPays) {
        this.idPays = idPays;
        this.nomPays = nomPays;
    }
    public Pays(String idPays, String nomPays, Set<Villes> villeses) {
       this.idPays = idPays;
       this.nomPays = nomPays;
       this.villeses = villeses;
    }
   
     @Id 

    
    @Column(name="id_pays", unique=true, nullable=false, length=4)
    public String getIdPays() {
        return this.idPays;
    }
    
    public void setIdPays(String idPays) {
        this.idPays = idPays;
    }

    
    @Column(name="nom_pays", nullable=false, length=50)
    public String getNomPays() {
        return this.nomPays;
    }
    
    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pays")
    public Set<Villes> getVilleses() {
        return this.villeses;
    }
    
    public void setVilleses(Set<Villes> villeses) {
        this.villeses = villeses;
    }




}


