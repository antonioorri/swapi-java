package es.uma.rysd.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

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
		URL service = null;
    	try {
			 service = new URL(url_api+resource+"/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Cree la conexi�n a partir de la URL
    	HttpsURLConnection connection=null;;
    	try {
			connection = (HttpsURLConnection) service.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	connection.setRequestProperty("Accept", "application/json");
    	connection.setRequestProperty(app_name+"-"+year, "My simple application");
    	
    	// TODO: Indique que es una petici�n GET
    	try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	String response="";
    	try {
			 response = connection.getResponseMessage();
			 if(response.equalsIgnoreCase("2XX")) {
				 return 0;
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Deserialice la respuesta a ResourceCountResponse
        Gson parser = new Gson();
        InputStream in = null;
		try {
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; // TODO: Obtenga el InputStream de la conexi�n
        ResourceCountResult c = parser.fromJson(new InputStreamReader(in), ResourceCountResult.class);
        // TODO: Devuelva el n�mero de elementos
        
        return c.count;
	}
	
	public Person getPerson(String urlname) {
    	Person p = null;
    	URL service = null;
    	String response="";
    	HttpsURLConnection connection=null;
    	InputStream in = null;
    	// Por si acaso viene como http la pasamos a https
    	urlname = urlname.replaceAll("http:", "https:");
    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
    	// TODO: Cree la conexi�n a partir de la URL recibida
    	try {
			 service = new URL(urlname);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			connection = (HttpsURLConnection) service.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	connection.setRequestProperty("Accept", "application/json");
    	connection.setRequestProperty(app_name+"-"+year, "My simple application");
    	// TODO: Indique que es una petici�n GET
    	try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	try {
			 response = connection.getResponseMessage();
			 if(response.equalsIgnoreCase("2XX")) {
				 return null;
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Deserialice la respuesta a Person
    	Gson parser = new Gson();
		try {
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; // TODO: Obtenga el InputStream de la conexi�n
		p = parser.fromJson(new InputStreamReader(in), Person.class);
        // TODO: Para las preguntas 2 y 3 (no necesita completar esto para la pregunta 1)
    	// TODO: A partir de la URL en el campo homreworld obtenga los datos del planeta y almac�nelo en atributo homeplanet
		//System.out.println("Problemas????");
		p.homeplanet=getWorld(urlname);
		//System.out.println("no");
    	return p;
	}

	public World getWorld(String urlname) {
		World w = null;
    	URL service = null;
    	String response="";
    	HttpsURLConnection connection=null;
    	InputStream in = null;
    	// Por si acaso viene como http la pasamos a https
    	urlname = urlname.replaceAll("http:", "https:");
    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
    	// TODO: Cree la conexi�n a partir de la URL recibida
    	try {
			 service = new URL(urlname);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			connection = (HttpsURLConnection) service.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	connection.setRequestProperty("Accept", "application/json");
    	connection.setRequestProperty(app_name+"-"+year, "My simple application");
    	// TODO: Indique que es una petici�n GET
    	try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	try {
			 response = connection.getResponseMessage();
			 if(response.equalsIgnoreCase("2XX")) {
				 return null;
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Deserialice la respuesta a Person
    	Gson parser = new Gson();
		try {
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; // TODO: Obtenga el InputStream de la conexi�n
		w = parser.fromJson(new InputStreamReader(in), World.class);
        // TODO: Para las preguntas 2 y 3 (no necesita completar esto para la pregunta 1)
    	// TODO: A partir de la URL en el campo homreworld obtenga los datos del planeta y almac�nelo en atributo homeplanet

    	return w;
	}

	public Person search(String name){
    	Person p = null;
    	URL service = null;
    	HttpsURLConnection connection=null;
    	String response="";
    	InputStream in = null;
    	String urlname=url_api+"people/?search/"+name;
    	// TODO: Trate de forma adecuada las posibles excepciones que pueden producirse
		    	
    	// TODO: Cree la conexi�n a partir de la URL (url_api + name tratado - vea el enunciado)
    	try {
			URLEncoder.encode(name,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			 service = new URL(urlname);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			connection = (HttpsURLConnection) service.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: A�ada las cabeceras User-Agent y Accept (vea el enunciado)
    	
    	connection.setRequestProperty("Accept", "application/json");
    	connection.setRequestProperty(app_name+"-"+year, "My simple application");
    	// TODO: Indique que es una petici�n GET
    	try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Compruebe que el c�digo recibido en la respuesta es correcto
    	try {
			 response = connection.getResponseMessage();
			 if(response.equalsIgnoreCase("2XX")) {
				 return null;
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// TODO: Deserialice la respuesta a SearchResponse -> Use la primera posici�n del array como resultado
    	Gson parser = new Gson();
		try {
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QueryResponse q=parser.fromJson(new InputStreamReader(in), QueryResponse.class);
        // TODO: Para las preguntas 2 y 3 (no necesita completar esto para la pregunta 1)
    	// TODO: A partir de la URL en el campo homreworld obtenga los datos del planeta y almac�nelo en atributo homeplanet
		q.results[0].homeworld=getWorld(urlname).toString();
        return q.results[0];
    }

}
