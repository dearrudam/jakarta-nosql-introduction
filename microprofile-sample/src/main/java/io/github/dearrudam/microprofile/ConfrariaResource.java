package io.github.dearrudam.microprofile;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.UUID;


@Path("confraria")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ConfrariaResource {

    @Inject
    Confraria confraria;

    public record NewDeveloper(String name, LocalDate birthday){}

    @POST
    public Developer add(NewDeveloper newDeveloper) {
        return confraria.save(
                new Developer(UUID.randomUUID().toString(),
                        newDeveloper.name(), newDeveloper.birthday()));
    }

}
