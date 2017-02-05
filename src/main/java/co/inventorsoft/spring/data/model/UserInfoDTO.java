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
public class UserInfoDTO {

    private Long id;

    private String firstName;

    private String lastName;
}
