package py.edu.ucom.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/clase-3")
public class ListasYMapsResource {

    @GET
    public List<Integer> getLista() {
        List<Integer> listaInteger = new ArrayList<>();
        listaInteger.add(1);
        listaInteger.add(2);
        listaInteger.add(3);
        return listaInteger;
    }

    @GET
    @Path("maps")
    public Map<String, Object> getMaps() {
        List<Integer> listaInteger = new ArrayList<>();
        listaInteger.add(1);
        listaInteger.add(2);
        listaInteger.add(3);

        Map<String, Object> mapsItem = new HashMap<>();
        mapsItem.put("clase-3", "25/09/2023");
        mapsItem.put("clase-4", 1000000);

        Map<String, Object> maps = new HashMap<>();
        maps.put("clase-3", "25/09/2023");
        maps.put("clase-4", 1000000);
        maps.put("clase-5", new Date());
        maps.put("clase-6", listaInteger);
        maps.put("clase-7", mapsItem);
        return maps;
    }

    @GET
    @Path("ejercicio-1")
    public Map<String, Integer> getFrecuencias() {
        return contadorDePalabras();
    }

    public Map<String, Integer> contadorDePalabras() {
        String texto = "Este es un ejemplo de texto. En este texto, queremos contar cuántas veces aparece cada palabra.";

        // Dividir el texto en palabras y almacenarlas en una lista
        String[] palabras = texto.split("\\s+");
        // [Este,es,un,ejemplo,texto. ..... palabra.]
        List<String> listaPalabras = new ArrayList<>();

        for (String palabra : palabras) {

            // Eliminar signos de puntuación y convertir a minúsculas
            // palabra = ".!"
            palabra = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
            // palabra = "";
            if (!palabra.isEmpty()) {
                listaPalabras.add(palabra);
            }
        }
        // [este, es, un, ejemplo, de, texto]

        // Crear un HashMap para contar la frecuencia de las palabras
        Map<String, Integer> contadorPalabras = new HashMap<>();
        // {}
        for (String palabra : listaPalabras) {

            if (contadorPalabras.containsKey(palabra)) {
                // Si la palabra ya está en el mapa, incrementar su frecuencia
                int frecuencia = contadorPalabras.get(palabra);
                contadorPalabras.put(palabra, frecuencia + 1);
            } else {
                // Si la palabra no está en el mapa, agregarla con una frecuencia inicial de 1
                contadorPalabras.put(palabra, 1);
                /*
                 * {
                 *  "este":1
                 * }
                 * 
                 */
            }
        }

        return contadorPalabras;
    }

}
