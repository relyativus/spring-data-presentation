package co.inventorsoft.spring.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author anatolii vakaliuk
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersCountDTO {

    private Long userId;

    private Long ordersCount;
}
