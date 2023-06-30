package io.github.dearrudam.using_spec.column;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.time.LocalDate;
import java.util.List;

public class ColumnApp2 {

    public static void main(String[] args) {

        /*
         * PS: activate one only column family configuration at microprofile-config.properties
         */

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Confraria confraria = container.select(Confraria.class).get();

            confraria.deleteAll();

            var max = Developer.newDeveloper("Max", LocalDate.of(1982, 10, 4));
            var elder = Developer.newDeveloper("Elder Moraes", LocalDate.of(1979, 6, 12));

            confraria.saveAll(List.of(max, elder));

            var devs = confraria.findAll().toList();

            System.out.println(devs);

            var devDe19821004 = confraria.findByBirthday(max.getBirthday());

            System.out.println(devDe19821004);
        }
    }
}
