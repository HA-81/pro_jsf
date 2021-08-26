package com.sdzee.beans;

import java.io.Serializable;

import com.sdzee.dao.UtilisateurDao;
import com.sdzee.entities.Utilisateur;

import jakarta.annotation.ManagedBean;

@ManagedBean
@ViewScoped
public class InscrireBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Utilisateur       utilisateur;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private UtilisateurDao    utilisateurDao;

    // Initialisation de l'entit� utilisateur
    public InscrireBean() {
        utilisateur = new Utilisateur();
    }

    // M�thode d'action appel�e lors du clic sur le bouton du formulaire
    // d'inscription
    public void inscrire() {
        initialiserDateInscription();
        utilisateurDao.creer( utilisateur );
        FacesMessage message = new FacesMessage( "Succ�s de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        utilisateur.setDateInscription( date );
    }

}
