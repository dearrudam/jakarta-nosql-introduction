package io.github.dearrudam.using_jnosql_only;

import org.eclipse.jnosql.communication.Settings;
import org.eclipse.jnosql.communication.document.Document;
import org.eclipse.jnosql.communication.document.DocumentCondition;
import org.eclipse.jnosql.communication.document.DocumentConfiguration;
import org.eclipse.jnosql.communication.document.DocumentDeleteQuery;
import org.eclipse.jnosql.communication.document.DocumentEntity;
import org.eclipse.jnosql.communication.document.DocumentManager;
import org.eclipse.jnosql.communication.document.DocumentManagerFactory;
import org.eclipse.jnosql.communication.document.DocumentQuery;
import org.eclipse.jnosql.mapping.config.MappingConfigurations;
import org.eclipse.jnosql.mapping.config.MicroProfileSettings;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

public class WithoutCDI {


    public static void main(String[] args) {

        /*
         * PS: activate one only document family configuration at microprofile-config.properties
         */

        var microProfileSettings = MicroProfileSettings.INSTANCE.toMap();

        Settings settings = Settings.builder()
                .putAll(microProfileSettings)
                .build();

        List<DocumentConfiguration> providers = new java.util.ArrayList<>(ServiceLoader.load(DocumentConfiguration.class).stream()
                .map(ServiceLoader.Provider::get).toList());

        settings.get(MappingConfigurations.DOCUMENT_PROVIDER, String.class)
                .ifPresent(providerClassName -> {
                    providers.removeIf(provider -> !providerClassName.equals(provider.getClass().getName()));
                });

        var database = settings.get(MappingConfigurations.DOCUMENT_DATABASE, String.class).orElse(null);
        Objects.requireNonNull(database, MappingConfigurations.DOCUMENT_DATABASE.get() + " property is missing");

        DocumentConfiguration configuration = providers.get(0);

        try (DocumentManagerFactory factory = configuration.apply(settings)) {

            DocumentManager manager = factory.apply(database);

            manager.delete(DocumentDeleteQuery.delete()
                    .from("developer")
                    .build());

            var entity = DocumentEntity.of("developer",
                    List.of(Document.of("_id", "1"),
                            Document.of("name", "Maximillian"),
                            Document.of("age", 40),
                            Document.of("birthday", LocalDate.of(1982, 10, 4))
                    ));

            manager.insert(entity);

            var data = DocumentQuery.builder()
                    .from("developer")
                    .select()
                    .where(DocumentCondition.eq(Document.of("_id", "1")))
                    .getResult(manager);


            data.forEach(doc -> {

                final Map<String, Object> row = new HashMap<>(doc.toMap());

                doc.find("_id", Long.class).ifPresent(v -> row.put("_id", v));
                doc.find("birthday", LocalDate.class).ifPresent(v -> row.put("birthday", v));

                System.out.println(row);

            });

        }

    }
}
