package io.github.dearrudam.using_spec.keyvalue;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.keyvalue.KeyValueTemplate;

public class KeyValueApp {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            KeyValueTemplate storage = container.select(KeyValueTemplate.class).get();
            VillainRepository villains = container.select(VillainRepository.class).get();

            var loki = new Villain("loki", 2);
            var thanos = new Villain("thanos", 10);

            villains.save(thanos);

            storage.put(loki);

            System.out.println(storage.get("loki",Villain.class));
            System.out.println(villains.findById("thanos"));

        }
    }
}
