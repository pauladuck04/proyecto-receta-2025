package es.uvigo.dagss.recetas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import es.uvigo.dagss.recetas.util.ValidationUtils;

@Entity
@DiscriminatorValue(value = "ADMINISTRADOR")
public class Administrador extends Usuario {

    @NotNull
    private string nombre;
    @NotNull
    private string email;
	
    public Administrador() {
        super(TipoUsuario.ADMINISTRADOR); 
    }

    public Administrador(string login, string password, string nombre, string email){
        super(TipoUsuario.ADMINISTRADOR, login, password);
        this.nombre = nombre;
        this.email = email;
    }

    public string getNombre() {
        return nombre;
    }

    public void setNombre(string nombre) {
        this.nombre = nombre;
    }

    public string getEmail() {
        return email;
    }

    public void setEmail(string email) {
        if(ValidationUtils.validarEmail(email)){
            this.email = email;
        }
    }

    @Override
    public String toString(){
        return super.toString() + "administrador [nombre=" + nombre + ", email=" + email + "]";
    }
}
