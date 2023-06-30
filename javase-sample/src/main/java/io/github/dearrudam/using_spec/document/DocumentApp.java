package io.github.dearrudam.using_spec.document;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;

import java.time.LocalDate;

public class DocumentApp {

    public static void main(String[] args) {

        /*
         * PS: activate one only document family configuration at microprofile-config.properties
         */

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Template template = container.select(Template.class).get();

            template.delete(Developer.class).execute();

            var max = Developer.newDeveloper("Max", LocalDate.of(1982, 10, 4));
            var elder = Developer.newDeveloper("Elder Moraes", LocalDate.of(1979, 6, 12));

            template.insert(max);
            template.insert(elder);

            var sohMax = template.select(Developer.class)
                    .where("name").eq("Max").result();

            System.out.println(sohMax);

        }
    }
}
