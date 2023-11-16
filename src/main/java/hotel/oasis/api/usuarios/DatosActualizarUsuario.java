package hotel.oasis.api.usuarios;

public record DatosActualizarUsuario(

        Integer id_user,
        String name,

        String last_name,

        String password
) {
};

