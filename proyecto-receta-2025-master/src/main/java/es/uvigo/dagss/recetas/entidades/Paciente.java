package es.uvigo.dagss.recetas.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PACIENTE")
public class Paciente extends Usuario {

	
    @NotNull
    private String telefono;

    @NotNull
    private String dni;

    @NotNull
    private String nss;

    @NotNull
    private String nombre;

    @ManyToOne(targetEntity = CentroSalud.class)
    @NotNull
    private CentroSalud centroSalud;
   
    public Paciente() {
        super(TipoUsuario.PACIENTE);        
    }

    public Paciente(String login, String password, String telefono, Direccion direccion, String dni, String nss, String email, String nombre, boolean activo) {
        super(TipoUsuario.PACIENTE, login, password);
        this.telefono = telefono;
        this.dni = dni;
        this.nss = nss;
        this.email = email;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        if(medico.getCentroSalud().getId() == this.getCentroSalud().getId()){
            this.medico = medico;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(ValidationUtils.validarTelefono(telefono)){
            this.telefono = telefono;
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if(ValidationUtils.validarDni(dni)){
            this.dni = dni;
        }
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(ValidationUtils.ValidarEmail(email)){
            this.email = email;
        }
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return super.toString + "paciente [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
                + ", nss=" + nss + ", DNI=" + dni + "]";
    }
}
