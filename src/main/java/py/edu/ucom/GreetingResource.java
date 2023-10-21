package py.edu.ucom;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get a hello message", description = "Returns a simple hello message")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)))
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/seb")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get a test message", description = "Returns a test message")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)))
    public String test() {
        return obtenerNombre();
    }

    public String obtenerNombre(){
        return "Seb";
    }
}
