package vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291;

import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.Product;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.repositories.ProductRepository;

import static vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.enums.ProductStatus.*;

@SpringBootApplication
public class Week7LabPhamThiBichNgoc20026291Application {

    public static void main(String[] args) {
        SpringApplication.run(Week7LabPhamThiBichNgoc20026291Application.class, args);
    }

    @Autowired
    private ProductRepository productRepository;
    CommandLineRunner createListProduct(){
        return args -> {
            Faker faker = new Faker();
            Device device = faker.device();
            for (int i = 0; i < 200; i++){
                Product product = new Product(
                        device.modelName(),
                        faker.lorem().paragraph(30),
                        "piece",
                        device.manufacturer(),
                        ACTIVE
                );
                productRepository.save(product);
            }
        };
    }
}
