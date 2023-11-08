package vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.Order;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.Product;


import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
