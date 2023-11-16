package hotel.oasis.api.controller;

import hotel.oasis.api.reservaciones.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservaciones")
public class ReservacionController {

    @Autowired
    private ReservacionRepository reservacionRepository;

    @PostMapping
    public void guardarReservacion(@RequestBody DatosRegistroReservacion datosRegistroReservacion) {
        reservacionRepository.save(new Reservacion(datosRegistroReservacion));
    }

    /*
    @GetMapping
    public List<DatosListadoCliente> listadoClientes() {
        return clienteRepository.findAll().stream().map(DatosListadoCliente::new).toList();
    }
    */

    @GetMapping
    public Page<DatosListadoReservacion> listadoReservaciones(@PageableDefault(size = 5) Pageable pageable) {
        return reservacionRepository.findAll(pageable).map(DatosListadoReservacion::new);
    }

    @PutMapping
    @Transactional
    public void actualizarReservacion(@RequestBody DatosActualizarReservacion datosActualizarReservacion) {
        Reservacion reservacion = reservacionRepository.getReferenceById((long) Math.toIntExact(datosActualizarReservacion.id_reservation()));
        reservacion.actualizarDatos(datosActualizarReservacion);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarReservacion(@PathVariable Long id) {
        Reservacion reservacion = reservacionRepository.getReferenceById((long) Math.toIntExact(id));
        reservacion.desactivarReservacion();
    }

}
