package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.repository.LocationRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter

@Service

public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.getAllLocations();
    }

    public Location getLocationByCode(String code) {
        return locationRepository.getLocationByCode(code);
    }

    public List<Location> getLocationByName(String name) {
        return locationRepository.getLocationsByName(name);
    }

    public List<Location> getLocationsByInitialLetter(String initialLetter) {
        List<Location> locationsByInitial = new ArrayList<>();
        for (Location location : locationRepository.getAllLocations()) {
            if (location.getName().startsWith(initialLetter)){
                locationsByInitial.add(location);
            }
        }
        return locationsByInitial;
    }

    public Location getLocationByDepartmentCode(String departmentCode) {
        List<Location> locationsByDepartment = new ArrayList<>();
        for (Location location : locationRepository.getAllLocations()) {
            if (location.getCode().startsWith(departmentCode)){
                locationsByDepartment.add(location);
            }
        }

        if (!locationsByDepartment.isEmpty()){
            return locationsByDepartment.get(0); //devolverá lo primero que encuentre y coincida
        } else {
            System.out.println("No existe localidad con código: " + departmentCode);
            return null;
        }
    }

    public List<Location> getAllDepartments() {
        List<Location> departments = new ArrayList<>();
        for (Location location : locationRepository.getAllLocations()) {
            if (location.getCode().length() == 2) {
                departments.add(location);
            }
        }
        return departments;
    }

    public Location getDepartmentByCode(String code) {
            if (code.length() != 2){
                System.out.println("Código: " + code + " no es válido para buscar departamentos. por favor ingrese un código de 2 dígitos"); //Si el código es inválido mostrará un error
                return null;
            }
        for (Location location : locationRepository.getAllLocations()) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        System.out.println("Departmento no encontrado con código: " + code);
        return null;
    }
}
