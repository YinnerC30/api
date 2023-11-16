package hotel.oasis.api.usuarios;

public record DatosRegistroUsuario(

        Integer id_user,

        String name,

        String last_name,

        String password,

        Boolean is_active) {
};

