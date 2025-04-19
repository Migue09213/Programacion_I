package co.edu.umanizales.myfirstapi.repository;

import co.edu.umanizales.myfirstapi.model.Location;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository

public class LocationRepository {

    private List<Location> locations;

    @Value("${locations_filename}")
    private String locationsFileName;

    @PostConstruct
    public void loadLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();

        Path filePath = Paths.get(ClassLoader.getSystemResource(locationsFileName).toURI());

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) { //<- esto evita usar un br.close

            String[] tokens;
            String code, name, department;

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) { //hace el bucle hasta que no haya más lineas llenas
                if (firstLine) {
                    firstLine = false; //salta el encabezado
                    continue;
                }
                tokens = line.split(",");
                if (tokens.length >= 4) {
                    code = tokens[2];
                    name = tokens[3];
                    department = tokens[1];
                    locations.add(new Location(code, name));
                }
            }

            System.out.println("> Buscando Archivo: " + "|" + locationsFileName + "|");
            System.out.println("> Archivo Cargado: " + locations.size() + " Elementos encontrados");

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Location> getAllLocations() {
        return locations;
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocationsByName(String name) {
        List<Location> results = new ArrayList<>();
        for (Location location : locations) {
            if (location.getName().equalsIgnoreCase(name)) {
                results.add(location);
            }
        }
        return results;
    }
}