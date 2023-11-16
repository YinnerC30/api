package hotel.oasis.api.clientes;

import java.time.LocalDate;

public record DatosRegistroReservacion(

        Long id_client,

        String name,

        String last_name,

        LocalDate date_of_birth,

        String nacionality,

        String telephone,

        Boolean is_active) {
}


