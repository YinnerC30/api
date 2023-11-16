package hotel.oasis.api.reservaciones;

import java.time.LocalDate;

public record DatosActualizarReservacion(

        Long id_reservation,
        Long id_client,
        LocalDate date_of_entry,
        LocalDate date_of_exit,
        Double value_stay_price,
        String form_payment,
        Double total

) {
}
