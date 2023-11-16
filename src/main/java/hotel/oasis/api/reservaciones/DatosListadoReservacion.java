package hotel.oasis.api.reservaciones;

import java.time.LocalDate;

public record DatosListadoReservacion(
        Long id_reservation,
        Long id_client,
        LocalDate date_of_entry,
        LocalDate date_of_exit,
        Double value_stay_price,
        String form_payment,
        Double total,
        Boolean is_active

) {
    public DatosListadoReservacion(Reservacion reservacion) {
        this(
                reservacion.getId_reservation(),
                reservacion.getId_client(),
                reservacion.getDate_of_entry(),
                reservacion.getDate_of_exit(),
                reservacion.getValue_stay_price(),
                reservacion.getForm_payment(),
                reservacion.getTotal(),
                reservacion.getIs_active()
        );

    }
}
