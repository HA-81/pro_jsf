package com.sdzee.entities;

import org.apache.myfaces.custom.fileupload.UploadedFile;

public class Fichier {

    @Size( min = 15, message = "La phrase de description du fichier doit contenir au moins 15 caract?res" )
    private String       description;
    @NotNull( message = "Merci de s?lectionner un fichier ? envoyer" )
    private UploadedFile contenu;

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public UploadedFile getContenu() {
        return contenu;
    }

    public void setContenu( UploadedFile contenu ) {
        this.contenu = contenu;
    }

}
