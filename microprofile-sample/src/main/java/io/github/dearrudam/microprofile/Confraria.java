package io.github.dearrudam.microprofile;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface Confraria extends CrudRepository<Developer,String> {
}
