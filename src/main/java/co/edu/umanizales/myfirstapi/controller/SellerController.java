package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Seller;
import co.edu.umanizales.myfirstapi.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }

    @PostMapping
    public ResponseEntity<String> addSeller(@RequestBody Seller seller) {
        String result = sellerService.addSeller(seller);
        if (result.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable("id") String id) {
        Seller seller = sellerService.getSellerById(id);
        if (seller == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seller);
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<Seller>> getSellersByName(@PathVariable("name") String name) {
        List<Seller> sellers = sellerService.getSellersByName(name);
        if (sellers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sellers);
    }

    @GetMapping(path = "/lastName/{lastName}")
    public ResponseEntity<List<Seller>> getSellersByLastName(@PathVariable("lastName") String lastName) {
        List<Seller> sellers = sellerService.getSellersByLastName(lastName);
        if (sellers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sellers);
    }

    @GetMapping(path = "/cityCode/{cityCode}")
    public ResponseEntity<List<Seller>> getSellersByCity(@PathVariable("cityCode") String cityCode) {
        List<Seller> sellers = sellerService.getSellersByCity(cityCode);
        if (sellers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sellers);
    }

    @GetMapping(path = "/gender/{gender}")
    public ResponseEntity<List<Seller>> getSellersByGender(@PathVariable("gender") String gender) {
        List<Seller> sellers = sellerService.getSellersByGender(gender);
        if (sellers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sellers);
    }

    @GetMapping(path = "/age/{age}")
    public ResponseEntity<List<Seller>> getSellersByAge(@PathVariable("age") byte age) {
        List<Seller> sellers = sellerService.getSellersByAge(age);
        if (sellers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sellers);
    }
}
