package io.github.dearrudam.jakartaee;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.LocalDate;

@Entity
public record Developer(@Id String id,
                        @Column String name,
                        @Column LocalDate birthday) {

}
