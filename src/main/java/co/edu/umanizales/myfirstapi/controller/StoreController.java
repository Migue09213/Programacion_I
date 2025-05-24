package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Store;
import co.edu.umanizales.myfirstapi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@RestController //es para que el sistema espere el tipo de pedido
@RequestMapping(path = "/store") //para brindarle una ruta nombre
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
     /*

    @GetMapping
    public Store getStore(){



        Location manizales = new Location("17001", "Manizales");

        Store StoreA = new Store ("0001", "MercaSeguro", manizales, "Kr. 23 #35 - 24a");

        return StoreA;

        */
    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @PostMapping
    public ResponseEntity<String> addStore(@RequestBody Store store) {
        String result = storeService.addStore(store);
        if (result.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(path = "/code/{code}")
    public ResponseEntity<Store> getStoreByCode(@PathVariable("code") String code) {
        Store store = storeService.getStoreByCode(code);
        if (store == null) {
            return ResponseEntity.notFound().build(); //error de tipo HTTP 404
        }
        return ResponseEntity.ok(store);
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<Store>> getStoreByName(@PathVariable("name") String name) {
        List<Store> stores = storeService.getStoresByName(name);
        if (stores.isEmpty()) {
            return ResponseEntity.noContent().build(); //error de tipo HTTP 204
        }
        return ResponseEntity.ok(stores);
    }

    @GetMapping(path = "address/{address}")
    public ResponseEntity<List<Store>> getStoreByAddress(@PathVariable("address") String address) {
        List<Store> stores = storeService.getStoresByAddress(address);
        if (stores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stores);
    }

    @GetMapping(path = "cityCode/{cityCode}")
    public ResponseEntity<List<Store>> getStoreByCityCode(@PathVariable("cityCode") String cityCode) {
        List<Store> stores = storeService.getStoresByCity(cityCode);
        if (stores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stores);
    }
}
