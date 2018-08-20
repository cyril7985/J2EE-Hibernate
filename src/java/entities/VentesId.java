package entities;
// Generated 7 aot 2018 11:19:11 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VentesId generated by hbm2java
 */
@Embeddable
public class VentesId  implements java.io.Serializable {


     private int idVendeur;
     private int idProduit;
     private int vente;

    public VentesId() {
    }

    public VentesId(int idVendeur, int idProduit, int vente) {
       this.idVendeur = idVendeur;
       this.idProduit = idProduit;
       this.vente = vente;
    }
   


    @Column(name="id_vendeur", nullable=false)
    public int getIdVendeur() {
        return this.idVendeur;
    }
    
    public void setIdVendeur(int idVendeur) {
        this.idVendeur = idVendeur;
    }


    @Column(name="id_produit", nullable=false)
    public int getIdProduit() {
        return this.idProduit;
    }
    
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }


    @Column(name="vente", nullable=false)
    public int getVente() {
        return this.vente;
    }
    
    public void setVente(int vente) {
        this.vente = vente;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VentesId) ) return false;
		 VentesId castOther = ( VentesId ) other; 
         
		 return (this.getIdVendeur()==castOther.getIdVendeur())
 && (this.getIdProduit()==castOther.getIdProduit())
 && (this.getVente()==castOther.getVente());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdVendeur();
         result = 37 * result + this.getIdProduit();
         result = 37 * result + this.getVente();
         return result;
   }   


}


