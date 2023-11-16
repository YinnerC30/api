package hotel.oasis.api.usuarios;


public record DatosListadoUsuario(

        Integer id_user,

        String name,

        String last_name,

        String password,
        Boolean is_active) {

    public DatosListadoUsuario(Usuario usuario) {
        this(
                usuario.getId_user(),
                usuario.getName(),
                usuario.getLast_name(),
                usuario.getPassword(),
                usuario.getIs_active()
        );
    }
}

