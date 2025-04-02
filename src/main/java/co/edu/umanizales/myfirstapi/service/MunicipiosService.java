package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.Repository.MunicipiosRepository;
import co.edu.umanizales.myfirstapi.model.Municipios;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.spi.ToolProvider.findFirst;

@Service

public class MunicipiosService {
    private MunicipiosRepository municipiosRepository;

    public MunicipiosService(MunicipiosRepository municipiosRepository) {
        this.municipiosRepository = municipiosRepository;
    }

    public void imprimirMunicipios() {
        municipiosRepository.getAllMunicipios().forEach(municipio -> System.out.println(
                "Municipio: " + municipio.getMunicipiosCode() + " - " + municipio.getMunicipiosName() + " - " + municipio.getMunicipiosDepartamento()
        ));
    }

    public List<Municipios> getAllMunicipios() {
        return municipiosRepository.getAllMunicipios();
    }

    public List<Municipios> getMunicipiosByDepartamento(String departamento) {
        return municipiosRepository.getAllMunicipios().stream()
                .filter(m -> m.getMunicipiosDepartamento().equalsIgnoreCase(departamento))
                .toList();
    }

    /*public List<Municipios> getMunicipiosByMunicipio(String municipio) {
        return municipiosRepository.getAllMunicipios().stream()
                .filter(m -> m.getMunicipiosMunicipio().equalsIgnoreCase(municipio))
                .toList();
    }*/
}
