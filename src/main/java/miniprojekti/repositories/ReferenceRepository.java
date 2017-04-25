/*
 */
package miniprojekti.repositories;

import java.util.List;
import miniprojekti.entities.Reference;
import org.springframework.data.repository.CrudRepository;

public interface ReferenceRepository extends CrudRepository<Reference, Long> {
    
//    @Query("delete From Reference r Where r.name = ?1")
//    void deleteReferenceByName(String name);

    List<Reference> findByRefType(String refType);

}
