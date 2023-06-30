package io.github.dearrudam.using_spec.keyvalue;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public record Villain(@Id String name, @Column int level) {
}
