package co.edu.umanizales.myfirstapi.repository;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Store;
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

public class StoreRepository {

    private List<Store> storeList;
    private final LocationRepository locationRepository;

    public StoreRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Value("${store_filename}")
    private String storeFilename;

    @PostConstruct
    public void loadStoresFromCSV() throws IOException, URISyntaxException {
        storeList = new ArrayList<>();

        Path filePath = Paths.get(ClassLoader.getSystemResource(storeFilename).toURI());

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] tokens = line.split(",");
                String code = tokens[0];
                String name = tokens[1];
                String cityCode = tokens[3];
                String address = tokens[2];

                Location city = locationRepository.getLocationByCode(cityCode);

                if (city == null) {
                    System.out.println("Ciudad no encontrada con código: " + cityCode);
                    continue;
                }

                storeList.add(new Store(code, name, city, address));
            }

            System.out.println("> Buscando Archivo: " + "|" + storeFilename + "|");
            System.out.println("> Archivo cargado con éxito: " + storeList.size() + " datos cargados");

        } catch(IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Store> getStores() {
        return storeList;
    }
}
