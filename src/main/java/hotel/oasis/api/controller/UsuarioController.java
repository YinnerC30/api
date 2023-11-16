package hotel.oasis.api.controller;


import hotel.oasis.api.usuarios.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void guardarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        usuarioRepository.save( new Usuario(datosRegistroUsuario));
    }

    @GetMapping
    public Page<DatosListadoUsuario> listadoUsuarios(@PageableDefault(size = 5) Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(DatosListadoUsuario::new);
    }

    @PutMapping
    @Transactional
    public void actualizarCliente(@RequestBody DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(Math.toIntExact(datosActualizarUsuario.id_user()));
        usuario.actualizarDatos(datosActualizarUsuario);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(Math.toIntExact(id));
        usuario.desactivarUsuario();
    }
}
