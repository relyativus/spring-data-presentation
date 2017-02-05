package co.inventorsoft.spring.data.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author anatolii
 */
public interface UserInfo {

    Long getId();

    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();
}
