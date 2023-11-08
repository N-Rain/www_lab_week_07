package vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.Order;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order>, JpaSpecificationExecutor<OrderDetail> {
}