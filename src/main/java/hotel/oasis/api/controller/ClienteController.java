package hotel.oasis.api.controller;

import hotel.oasis.api.clientes.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void guardarCliente(@RequestBody DatosRegistroReservacion datosRegistroReservacion) {
        clienteRepository.save( new Cliente(datosRegistroReservacion));
    }

    /*
    @GetMapping
    public List<DatosListadoCliente> listadoClientes() {
        return clienteRepository.findAll().stream().map(DatosListadoCliente::new).toList();
    }
    */

    @GetMapping
    public Page<DatosListadoClientes> listadoClientes(@PageableDefault(size = 5) Pageable pageable) {
        return clienteRepository.findAll(pageable).map(DatosListadoClientes::new);
    }

    @PutMapping
    @Transactional
    public void actualizarCliente(@RequestBody DatosActualizarCliente datosActualizarCliente) {
        Cliente cliente = clienteRepository.getReferenceById(Math.toIntExact(datosActualizarCliente.id_client()));
        cliente.actualizarDatos(datosActualizarCliente);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(Math.toIntExact(id));
        cliente.desactivarCliente();
    }

}
