package io.github.dearrudam.using_spec.keyvalue;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface VillainRepository extends CrudRepository<Villain,String> {
}
