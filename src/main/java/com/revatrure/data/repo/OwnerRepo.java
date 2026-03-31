package com.revatrure.data.repo;

import com.revatrure.data.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/* you can create a Java class and manually change it to 'interface' and IntelliJ will make the necessary assumptions.
    Additionally, when we extend the JpaRepository, we provide 2 generics 1. The entity that is managed by the repository and the
    ID type of the first entity, the primary key of the entity we are tracking in our database
 */
@Repository // stereotype annotation
public interface OwnerRepo extends JpaRepository<Owner, UUID> {
}
