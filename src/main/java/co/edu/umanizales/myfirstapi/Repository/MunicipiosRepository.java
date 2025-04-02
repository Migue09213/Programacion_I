package co.edu.umanizales.myfirstapi.Repository;

import co.edu.umanizales.myfirstapi.model.Municipios;
import org.springframework.stereotype.Repository;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository

public class MunicipiosRepository {
    private List<Municipios> municipios = new ArrayList<>();

    public MunicipiosRepository() {
        cargarMunicipios();
    }

    private void cargarMunicipios() {
        String archivo = "DivipolaMunicipios";
        System.out.println("Intentando cargar archivo: " + archivo);

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(archivo);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String linea;
            boolean primeralinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeralinea) {
                    primeralinea = false;
                    continue; // Omitir la primera línea
                }
                String[] datos = linea.split(",");
                if (datos.length >= 4) {
                    municipios.add(new Municipios(datos[2].trim(), datos[3].trim(), datos[1].trim()));
                    System.out.println("Cargado: " + datos[2].trim() + " - " + datos[3].trim() + " - " + datos[1].trim());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public List<Municipios> getAllMunicipios() {
        return Collections.unmodifiableList(municipios);
    }

    public Optional<Municipios> getMunicipioByCodigo(String municipiosCode) {
        return municipios.stream()
                .filter(m -> m.getMunicipiosCode().equals(municipiosCode))
                .findFirst();
    }

    public List<Municipios> getMunicipiosByCapital() {
        return municipios.stream()
                .filter(m -> m.getMunicipiosCode().endsWith("001"))
                .toList();
    }
}
