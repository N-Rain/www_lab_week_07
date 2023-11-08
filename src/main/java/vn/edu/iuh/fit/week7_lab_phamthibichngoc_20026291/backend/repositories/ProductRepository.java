package vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}