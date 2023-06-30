package io.github.dearrudam.using_spec.document;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Confraria extends CrudRepository<Developer, String> {

    List<Developer> findByBirthday(LocalDate birthday);

}
