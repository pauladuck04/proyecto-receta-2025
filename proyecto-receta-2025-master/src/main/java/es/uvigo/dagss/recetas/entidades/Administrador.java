package es.uvigo.dagss.recetas.entidades;

import jakarta.persistence.Entity;
import es.uvigo.dagss.recetas.utils.ValidationUtils;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Administrador extends Usuario {
    @NotNull
    private String nombre;
    @NotNull
    private String email;
	
    public Administrador() {
        super(TipoUsuario.ADMINISTRADOR); 
    }

    public Administrador(String login, String password, String nombre, String email){
        super(TipoUsuario.ADMINISTRADOR, login, password);
        this.nombre = nombre;
        this.email = email;
    }

    public void setEmail(String email) {
        if(ValidationUtils.validarEmail(email)){
            this.email = email;
        }
    }

    @Override
    public String toString(){
        return super.toString() + "administrador [nombre=" + nombre + ", email=" + email + "]";
    }
}
