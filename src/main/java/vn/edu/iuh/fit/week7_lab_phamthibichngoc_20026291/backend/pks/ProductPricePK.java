package vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.Product;


import java.io.Serializable;
import java.time.LocalDateTime;

@Setter @Getter
public class ProductPricePK implements Serializable {
    private Product product;
    private LocalDateTime price_date_time;
}
