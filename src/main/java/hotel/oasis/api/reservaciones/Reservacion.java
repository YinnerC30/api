package hotel.oasis.api.reservaciones;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "reservations")
@Entity(name = "Reservation")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_reservation")
public class Reservacion {

    @Id
    private Long id_reservation;
    private Long id_client;
    private LocalDate date_of_entry;
    private LocalDate date_of_exit;
    private Double value_stay_price;
    private String form_payment;
    private Double total;
    private Boolean is_active;

    public Reservacion(DatosRegistroReservacion datosRegistroReservacion) {
        this.id_reservation = datosRegistroReservacion.id_reservation();
        this.id_client = datosRegistroReservacion.id_client();
        this.date_of_entry = datosRegistroReservacion.date_of_entry();
        this.date_of_exit = datosRegistroReservacion.date_of_exit();
        this.value_stay_price = datosRegistroReservacion.value_stay_price();
        this.form_payment = datosRegistroReservacion.form_payment();
        this.total = datosRegistroReservacion.total();
        this.is_active = datosRegistroReservacion.is_active();
    }


    public void actualizarDatos(DatosActualizarReservacion datosActualizarReservacion) {

        if (datosActualizarReservacion.id_client() != null) {
            this.id_client = datosActualizarReservacion.id_client();
        }

        if (datosActualizarReservacion.date_of_entry() != null) {
            this.date_of_entry = datosActualizarReservacion.date_of_entry();
        }
        if (datosActualizarReservacion.date_of_exit() != null) {
            this.date_of_exit = datosActualizarReservacion.date_of_exit();
        }

        if (datosActualizarReservacion.value_stay_price() != null) {
            this.value_stay_price = datosActualizarReservacion.value_stay_price();
        }

        if (datosActualizarReservacion.form_payment() != null) {
            this.form_payment = datosActualizarReservacion.form_payment();
        }

        if (datosActualizarReservacion.total() != null) {
            this.total = datosActualizarReservacion.total();
        }
    }

    public void desactivarReservacion() {
        this.is_active = false;
    }
}
