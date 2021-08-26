package com.sdzee.validators;

import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.tomcat.jdbc.pool.Validator;

@FacesValidator( "tailleMaxFichierValidator" )
public class TailleMaxFichierValidator implements Validator {

    private static final long   TAILLE_MAX_FICHIER = 1 * 1024 * 1024;                          // 1Mo
    private static final String MESSAGE_ERREUR     = "La taille maximale autorisée est de 1Mo";

    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
        if ( value != null && ( (UploadedFile) value ).getSize() > TAILLE_MAX_FICHIER ) {
            throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, MESSAGE_ERREUR, null ) );
        }
    }

}
