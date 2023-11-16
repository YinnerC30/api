package hotel.oasis.api.clientes;

import java.time.LocalDate;

public record DatosActualizarCliente(

        Long id_client,

        String name,

        String last_name,


        LocalDate date_of_birth,

        String nacionality
) {
}
