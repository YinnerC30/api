package hotel.oasis.api.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_user")
public class Usuario {

    @Id
    private Integer id_user;
    private String name;
    private String last_name;
    private String password;
    private Boolean is_active;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.id_user = datosRegistroUsuario.id_user();
        this.name = datosRegistroUsuario.name();
        this.last_name = datosRegistroUsuario.last_name();
        this.password = datosRegistroUsuario.password();
        this.is_active = datosRegistroUsuario.is_active();
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        if (datosActualizarUsuario.name() != null) {
            this.name = datosActualizarUsuario.name();
        }

        if (datosActualizarUsuario.last_name() != null) {
            this.last_name = datosActualizarUsuario.last_name();
        }

        if (datosActualizarUsuario.password() != null) {
            this.password = datosActualizarUsuario.password();
        }

    }
    public void desactivarUsuario() {
        this.is_active = false;
    }
}
