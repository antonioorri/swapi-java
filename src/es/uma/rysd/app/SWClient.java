package es.uma.rysd.app;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import es.uma.rysd.entities.*;

public class SWClient {
	// TODO: Complete el nombre de la aplicaci�n
    private final String app_name = "antonio-api";
    private final int year = 2022;
    
    private final String url_api = "https://swapi.dev/api/";

    // M�todos auxiliares facilitados
    
    // Obtiene la URL del recurso id del tipo resource
	public String generateEndpoint(String resource, Integer id){
		return url_api + resource + "/" + id + "/";
	}
	
	// Dada una URL de un recurso obtiene su ID
	public Integer getIDFromURL(String url){
		String[] parts = url.split("/");

		return Integer.parseInt(parts[parts.length-1]);
	}
	
	// Consulta un recurso y devuelve cu�ntos elementos tiene
	public int getNumberOfResources(String resource){    	
		// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		
    	// TODO: Cree la URL correspondiente: https://swapi.dev/api/{recurso}/ reemplazando el recurso por el par�metro 
    	
    	// TODO: Cree la conexi�n a partir de la URL
    	
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	
    	// TODO: Indique que es una petici�n GET
    	
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	
    	// TODO: Deserialice la respuesta a ResourceCountResponse
        Gson parser = new Gson();
        InputStream in = null; // TODO: Obtenga el InputStream de la conexi�n
        ResourceCountResult c = parser.fromJson(new InputStreamReader(in), ResourceCountResult.class);
        // TODO: Devuelva el n�mero de elementos
        return 0;
	}
	
	public Person getPerson(String urlname) {
    	Person p = null;
    	// Por si acaso viene como http la pasamos a https
    	urlname = urlname.replaceAll("http:", "https:");

    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		    	
    	// TODO: Cree la conexi�n a partir de la URL recibida
    	
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	
    	// TODO: Indique que es una petici�n GET
    	
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	
    	// TODO: Deserialice la respuesta a Person
    	
        // TODO: Para las preguntas 2 y 3 (no necesita completar esto para la pregunta 1)
    	// TODO: A partir de la URL en el campo homreworld obtenga los datos del planeta y almac�nelo en atributo homeplanet

    	return p;
	}

	public World getWorld(String urlname) {
    	World p = null;
    	// Por si acaso viene como http la pasamos a https
    	urlname = urlname.replaceAll("http:", "https:");

    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		    	
    	// TODO: Cree la conexi�n a partir de la URL recibida
    	
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	
    	// TODO: Indique que es una petici�n GET
    	
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	
    	// TODO: Deserialice la respuesta a Planet
    	
        return p;
	}

	public Person search(String name){
    	Person p = null;
    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		    	
    	// TODO: Cree la conexi�n a partir de la URL (url_api + name tratado - vea el enunciado)
    	
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	
    	// TODO: Indique que es una petici�n GET
    	
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	
    	// TODO: Deserialice la respuesta a SearchResponse -> Use la primera posici�n del array como resultado
    	
        // TODO: Para las preguntas 2 y 3 (no necesita completar esto para la pregunta 1)
    	// TODO: A partir de la URL en el campo homreworld obtenga los datos del planeta y almac�nelo en atributo homeplanet

        return p;
    }

}
