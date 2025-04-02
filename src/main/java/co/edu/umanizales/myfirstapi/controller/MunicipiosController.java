package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.Repository.MunicipiosRepository;
import co.edu.umanizales.myfirstapi.model.Municipios;
import co.edu.umanizales.myfirstapi.service.MunicipiosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/municipios")
public class MunicipiosController {

    private final MunicipiosService municipiosService;

    // Inyección de dependencia a través del constructor
    public MunicipiosController(MunicipiosService municipiosService) {
        this.municipiosService = municipiosService;
    }

    // Endpoint para obtener todos los municipios
    @GetMapping
    public List<Municipios> getAllMunicipios() {
        municipiosService.imprimirMunicipios();
        return municipiosService.getAllMunicipios();
    }

    @GetMapping(path = "/imprimir")
    public List<Municipios> imprimirMunicipios() {
        municipiosService.imprimirMunicipios();
        return municipiosService.getAllMunicipios();
    }

    @GetMapping(path = "/departamento/{departamento}")
    public List<Municipios> departamento(@PathVariable String departamento) {
        municipiosService.imprimirMunicipios();
        return municipiosService.getMunicipiosByDepartamento(departamento);
    }

    @GetMapping(path = "/capitales")
    public List<Municipios> getMunicipiosByCapitales() {
        return municipiosService.getMunicipiosByCapital();
    }
}
