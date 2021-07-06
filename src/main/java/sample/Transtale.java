package sample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Transtale {
    public static String translate ( String s , String in , String out ) throws ParseException {

        HttpRequest request = HttpRequest.newBuilder ()
                .uri ( URI.create ( "https://rapidapi.p.rapidapi.com/translate?text=" + s + "&tl=" + in + "&sl=" + out + "" ) )
                .header ( "x-rapidapi-host" , "google-translate20.p.rapidapi.com" )
                .header ( "x-rapidapi-key" , "d5187ae4femsha463feea0619d31p144c47jsn1646ff88fc27" )
                .method ( "GET" , HttpRequest.BodyPublishers.noBody () )
                .build ();
        HttpResponse <String> response = null;
        try {
            response = HttpClient.newHttpClient ().send ( request , HttpResponse.BodyHandlers.ofString () );
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        //System.out.println ( response.body () );
        String value = null;
        Object obj = new JSONParser ().parse ( response.body () );
        JSONObject jo = (JSONObject) obj;
        Map address = ((Map) jo.get ( "data" ));
        return deString ( (String) address.get ( "translation" ) );
    }

    public static String encodeValue ( String value ) {
        try {
            return URLEncoder.encode ( value , StandardCharsets.UTF_8.toString () );
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException ( ex.getCause () );
        }
    }

    public static String deString ( String s ) {
        String t = "";
        int k = 0;
        for (int i = 0; i < s.length (); i++) {
            t += s.charAt ( i );
            if ( k > 38 && s.charAt ( i ) == ' ' ) {
                t += '\n';
                k = 0;
            }
            k++;
        }
        return t;
    }
}
