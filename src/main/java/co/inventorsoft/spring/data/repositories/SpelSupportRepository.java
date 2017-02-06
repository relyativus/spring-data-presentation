package co.inventorsoft.spring.data.repositories;

import org.springframework.data.jpa.repository.Query;

/**
 * @author anatolii vakaliuk
 */
public interface SpelSupportRepository {

    @Query("select max(e.id) from #{#entityName} e")
    int getMaxId();

}
