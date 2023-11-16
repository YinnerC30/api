package hotel.oasis.api.clientes;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DatosListadoClientes(
        @NotBlank
        Long id_client,
        @NotBlank
        String name,
        @NotBlank
        String last_name,
        @NotBlank
        LocalDate date_of_birth,
        @NotBlank
        String nacionality,
        @NotBlank
        String telephone,

        @NotBlank
        Boolean is_active

) {
    public DatosListadoClientes(Cliente cliente) {
        this(
                cliente.getId_client(),
                cliente.getName(),
                cliente.getLast_name(),
                cliente.getDate_of_birth(),
                cliente.getNacionality(),
                cliente.getTelephone(),
                cliente.getIs_active()
        );

    }


}
