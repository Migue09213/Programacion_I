package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/location")

public class LocationController {

    /*
    @GetMapping
    public Location getLocation(){
        Location manizales = new Location("170001", "Manizales");

        return manizales;

    }
    */
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping(path = "/code/{code}")
    public Location getLocation(@PathVariable String code) {
        return locationService.getLocationByCode(code);
    }

    @GetMapping(path = "/name/{name}")
    public List<Location> getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping(path = "/initial/{letter}")
    public List<Location> getLocationByInitial(@PathVariable String letter) {
        return locationService.getLocationsByInitialLetter(letter);
    }

    @GetMapping(path = "/department_code/{dCode}")
    public Location getLocationByDepartmentCode(@PathVariable String dCode) {
        return locationService.getLocationByDepartmentCode(dCode);
    }

    @GetMapping(path = "/departments")
    public List<Location> getDepartments() {
        return locationService.getAllDepartments();
    }

    @GetMapping(path = "/department/{departmentCode}")
    public Location getDepartment(@PathVariable String departmentCode) {
        return locationService.getDepartmentByCode(departmentCode);
    }

    @GetMapping(path = "/capitals")
    public List<Location> getCapitals() {
        return locationService.getCapitals();
    }
}
