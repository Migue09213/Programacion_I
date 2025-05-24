package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Seller;
import co.edu.umanizales.myfirstapi.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public List<Seller> getAllSellers() {
        return sellerRepository.getSellers();
    }

    public String addSeller(Seller seller) {
        try {
            sellerRepository.writeSellerOnCSV(seller);
            sellerRepository.getSellers().add(seller);
            return "Vendedor agregado con éxito.";
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return "Error al agregar el vendedor: " + e.getMessage();
        }
    }

    public Seller getSellerById(String id) {
        List<Seller> sellers = sellerRepository.getSellers();
        for (Seller seller : sellers) {
            if (seller.getSellerID() != null && seller.getSellerID().equalsIgnoreCase(id)) {
                return seller;
            }
        }
        return null;
    }

    public List<Seller> getSellersByName(String name) {
        List<Seller> result = new ArrayList<>();
        List<Seller> sellers = sellerRepository.getSellers();
        for (Seller seller : sellers) {
            if (seller.getSellerName() != null && seller.getSellerName().equalsIgnoreCase(name)) {
                result.add(seller);
            }
        }
        return result;
    }

    public List<Seller> getSellersByLastName(String lastName) {
        List<Seller> result = new ArrayList<>();
        List<Seller> sellers = sellerRepository.getSellers();
        for (Seller seller : sellers) {
            if (seller.getSellerLastName() != null && seller.getSellerLastName().equalsIgnoreCase(lastName)) {
                result.add(seller);
            }
        }
        return result;
    }

    public List<Seller> getSellersByCity(String cityCode) {
        List<Seller> result = new ArrayList<>();
        List<Seller> sellers = sellerRepository.getSellers();
        for (Seller seller : sellers) {
            if (seller.getCity() != null && seller.getCity().getCode() != null
                    && seller.getCity().getCode().equalsIgnoreCase(cityCode)) {
                result.add(seller);
            }
        }
        return result;
    }

    public List<Seller> getSellersByGender(String gender) {
        List<Seller> result = new ArrayList<>();
        List<Seller> sellers = sellerRepository.getSellers();
        for (Seller seller : sellers) {
            if (seller.getSellerGender() != null && seller.getSellerGender().equalsIgnoreCase(gender)) {
                result.add(seller);
            }
        }
        return result;
    }

    // Método extra para filtrar por edad
    public List<Seller> getSellersByAge(byte age) {
        List<Seller> result = new ArrayList<>();
        List<Seller> sellers = sellerRepository.getSellers();
        for (Seller seller : sellers) {
            if (seller.getSellerAge() == age) {
                result.add(seller);
            }
        }
        return result;
    }
}
