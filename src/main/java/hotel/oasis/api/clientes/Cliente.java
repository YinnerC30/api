package hotel.oasis.api.clientes;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "clients")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_client")
public class Cliente {

    @Id
    private Long id_client;
    private String name;
    private String last_name;
    private LocalDate date_of_birth;
    private String nacionality;
    private String telephone;
    private Boolean is_active;

    public Cliente(DatosRegistroReservacion datosRegistroReservacion) {
        this.id_client = datosRegistroReservacion.id_client();
        this.name = datosRegistroReservacion.name();
        this.last_name = datosRegistroReservacion.last_name();
        this.date_of_birth = datosRegistroReservacion.date_of_birth();
        this.nacionality = datosRegistroReservacion.nacionality();
        this.telephone = datosRegistroReservacion.telephone();
        this.is_active = datosRegistroReservacion.is_active();
    }

    public void actualizarDatos(DatosActualizarCliente datosActualizarCliente) {

        if (datosActualizarCliente.name() != null) {
            this.name = datosActualizarCliente.name();
        }

        if (datosActualizarCliente.last_name() != null) {
            this.last_name = datosActualizarCliente.last_name();
        }
        if (datosActualizarCliente.date_of_birth() != null) {
            this.date_of_birth = datosActualizarCliente.date_of_birth();
        }

        if (datosActualizarCliente.nacionality() != null) {
            this.nacionality = datosActualizarCliente.nacionality();
        }

    }

    public void desactivarCliente() {
        this.is_active = false;
    }
}
