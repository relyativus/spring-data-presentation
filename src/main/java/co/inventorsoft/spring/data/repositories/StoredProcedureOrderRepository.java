package co.inventorsoft.spring.data.repositories;

import co.inventorsoft.spring.data.model.Order;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * @author anatolii
 */
public interface StoredProcedureOrderRepository extends Repository<Order, Long> {

    @Procedure
    Long[] binaryAdd(@Param("arg1") Long first, @Param("arg2") Long second);
}
