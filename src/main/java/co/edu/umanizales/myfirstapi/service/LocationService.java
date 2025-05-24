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

    public List<Location> getLocationsByInitialLetter(char initialLetter) {
        List<Location> locationsByInitial = new ArrayList<>();
        for (Location location : locationRepository.getAllLocations()) {
            if (location.getDescription().startsWith(String.valueOf(initialLetter))) {
                locationsByInitial.add(location);
            }
        }
        return locationsByInitial;
    }

    public List<Location> getLocationsByDepartmentCode(String departmentCode) {
        List<Location> locationsByDepartment = new ArrayList<>();
        for (Location location : locationRepository.getAllLocations()) {
            if (location.getCode().startsWith(departmentCode)) {
                locationsByDepartment.add(location);
            }
        }
        return locationsByDepartment;
    }

    public List<Location> getAllDepartments() {
        return locationRepository.getAllDepartments();
    }

    public Location getDepartmentByCode(String code) {
        if (code.length() != 2) {
            System.out.println("Código: " + code + " no es válido para buscar departamentos. por favor ingrese un código de 2 dígitos"); //Si el código es inválido mostrará un error
            return null;
        }
        for (Location location : locationRepository.getAllDepartments()) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        System.out.println("Departmento no encontrado con código: " + code);
        return null;
    }

    public List<Location> getCapitals() {
        List<Location> capitals = new ArrayList<>();
        for (Location location : locationRepository.getAllLocations()) {
            if (location.getCode().endsWith("001")) {
                capitals.add(location);
            }
        }
        return capitals;
    }

    public List<Location> getLocationByParameters(char initialLetter, char finalLetter) {
        List<Location> locations = new ArrayList<>();
        for (Location location : locationRepository.getAllLocations()) {
                if (location.getDescription().startsWith(String.valueOf(initialLetter)) && location.getDescription().endsWith(String.valueOf(finalLetter))) {
                    locations.add(location);
            }
        }
            return locations;
    }
}
