package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  // Una tabla propia para cada subclase
public abstract class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "USUARIO_SEQUENCE", allocationSize = 1)
    private Long id;

    @Transient
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_USUARIO", length = 20)
    protected TipoUsuario tipo;

    @NotNull
    private String login;

    @NotNull
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

    public void setId(Long id) {
		this.id = id;
	}

    public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

    public void setUltimoAcceso(LocalDate ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}


    public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

    public void setLogin(String login) {
		this.login = login;
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
	public String toString(){
		return "id=" + id + "login=" + login + ", fecha alta=" + fechaAlta + ", ultimo acceso=" + ultimoAcceso + ", activo=" + activo + ", tipo= ";
	}
}

