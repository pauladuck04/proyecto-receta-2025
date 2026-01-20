package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import es.uvigo.dagss.recetas.utils.ValidationUtils;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  // Una tabla propia para cada subclase
public abstract class Usuario implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "USUARIO_GEN")
    @TableGenerator(
            name = "USUARIO_GEN",
            table = "GENERADOR_IDS",          // Nombre de la tabla de control
            pkColumnName = "NOMBRE_CONTADOR",
            valueColumnName = "VALOR_ACTUAL",
            pkColumnValue = "USUARIO_ID",      // Fila específica para esta jerarquía
            allocationSize = 1
    )
    private Long id;

    @Transient
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_USUARIO", length = 20)
    protected TipoUsuario tipo;

    @NotNull
    private String login;

    @NotNull
    @JsonIgnore
    private String password;

    @NotNull
    private LocalDate fechaAlta;

    @NotNull
    private LocalDate ultimoAcceso;

    @NotNull
	private Boolean activo = true;
	
    public Usuario() {
        this.fechaAlta = LocalDate.now();
        this.ultimoAcceso = LocalDate.now();
		this.activo = true;
    }

    public Usuario(TipoUsuario tipo) {
    	this();
        this.tipo = tipo;
    }

    public Usuario(TipoUsuario tipo, String login, String password) {
    	this();
        this.tipo = tipo;
        this.login = login;
        this.password = password;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(LocalDate ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}


	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void activar() {
        this.activo = true;
    }

    public void desactivar() {
        this.activo = false;
    }

	@Override
	public int hashCode() {
		if (this.id !=null)
			return Objects.hash(id);
		return Objects.hash(fechaAlta, login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (this.id !=null)
			return this.id.equals(other.getId());
		return Objects.equals(fechaAlta, other.fechaAlta)
				&& Objects.equals(login, other.login);
	}

	@Override
	public String toString(){
		return "id=" + id + "login=" + login + ", fecha alta=" + fechaAlta + ", ultimo acceso=" + ultimoAcceso + ", activo=" + activo + ", tipo= ";
	}
}

