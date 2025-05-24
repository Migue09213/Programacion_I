package co.edu.umanizales.myfirstapi.repository;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Seller;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
@RequiredArgsConstructor

public class SellerRepository {

    private List<Seller> sellersList;
    private final LocationRepository locationRepository;

    @Value("${seller_filename:Sellers_List.csv}")
    private String sellerFilename;

    @PostConstruct
    public void loadSellersFromCSV() throws IOException, URISyntaxException {
        sellersList = new ArrayList<>();

        Path filePath = Paths.get(ClassLoader.getSystemResource(sellerFilename).toURI());

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] tokens = line.split(",");
                String id = tokens[0];
                String name = tokens[1];
                String lastName = tokens[2];
                String cityCode = tokens[3];
                String sellerGender = tokens[4];
                byte sellerAge = Byte.parseByte(tokens[5]);

                Location city = locationRepository.getLocationByCode(cityCode);

                if (city == null) {
                    System.out.println("Ciudad no encontrada con código: " + cityCode);
                    continue;
                }

                sellersList.add(new Seller(id, name, lastName, city, sellerGender, sellerAge));
            }

            System.out.println("> Buscando Archivo: " + "|" + sellerFilename + "|");
            System.out.println("> Archivo cargado con éxito: " + sellersList.size() + " datos cargados");

        } catch(IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void writeSellerOnCSV(Seller s) throws IOException, URISyntaxException {
        Path filePath = Paths.get(ClassLoader.getSystemResource(sellerFilename).toURI());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {
            bw.write(s.getSellerID() + ","
                    + s.getSellerName() + ","
                    + s.getSellerLastName() + ","
                    + s.getCity().getCode() + ","
                    + s.getSellerGender() + ","
                    + s.getSellerAge() + "\n");
        }
    }

    public List<Seller> getSellers() {
        return sellersList;
    }
}
