package com.sdzee.beans;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.io.FilenameUtils;

import com.sdzee.entities.Fichier;

import jakarta.annotation.ManagedBean;

@ManagedBean
@RequestScoped
public class UploadBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Fichier           fichier;

    // Initialisation du bean fichier
    public UploadBean() {
        fichier = new Fichier();
    }

    public void envoyer() throws IOException {
        String nomFichier = FilenameUtils.getName( fichier.getContenu().getName() );
        String tailleFichier = FileUtils.byteCountToDisplaySize( fichier.getContenu().getSize() );
        String typeFichier = fichier.getContenu().getContentType();
        byte[] contenuFichier = fichier.getContenu().getBytes();

        /*
         * Effectuer ici l'enregistrement du contenu du fichier sur le disque,
         * ou dans la BDD (accompagné du type du contenu, éventuellement), ou
         * tout autre traitement souhaité...
         */

        FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(
                String.format( "Fichier '%s', de taille '%s' et de type '%s' envoyé avec succès !",
                        nomFichier, tailleFichier, typeFichier ) ) );
    }

    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier( Fichier fichier ) {
        this.fichier = fichier;
    }

}
