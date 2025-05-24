package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Store;
import co.edu.umanizales.myfirstapi.repository.LocationRepository;
import co.edu.umanizales.myfirstapi.repository.StoreRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@RequiredArgsConstructor

public class StoreService {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;

    public String addStore(Store s) {
        Location city = locationRepository.getLocationByCode(s.getCity().getCode());
        if (city == null) {
            return "Error: City with code " + s.getCity().getCode() + " not found";
        }

        s.setCity(city); // se asegura que la instancia de Store agregada tenga el objeto "city" completo

        storeRepository.getStoreList().add(s); //aggrega la instancia de Store "s" a la lista

        try {
            storeRepository.writeStoreOnCSV(s);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return "Error while trying to add store: " + e.getMessage();
        }
        return "Successfully added store";
    }

    public List<Store> getAllStores() {
        return storeRepository.getStores();
    }

    public Store getStoreByCode(String code) {
        for (Store store : getAllStores()) {
            if (store.getStoreCode().equals(code)) {
                return store;
            }
        }
        System.out.println("No store with code " + code + " found");
        return null;
    }

    public List<Store> getStoresByName(String name) {
        List<Store> stores = new ArrayList<>();
        for (Store store : getAllStores()) {
            if (store.getStoreName().equals(name)) {
                stores.add(store);
            }
        }
        if (stores.isEmpty()) {
            System.out.println("No store with name " + name + " found");

        }
        return stores;
    }

    public List<Store> getStoresByAddress(String address) {
        List<Store> stores = new ArrayList<>();
        for (Store store : getAllStores()) {
            if (store.getAddress().equals(address)) {
                stores.add(store);
            }
        }
        if (stores.isEmpty()) {
            System.out.println("No store with address " + address + " found");

        }
        return stores;
    }

    public List<Store> getStoresByCity(String city) {
        List<Store> stores = new ArrayList<>();
        for (Store store : getAllStores()) {
            if (store.getCity().getCode().equals(city)) {
                stores.add(store);
            }
        }
        if (stores.isEmpty()) {
            System.out.println("No store with city code " + city + " found");

        }
        return stores;
    }

}
