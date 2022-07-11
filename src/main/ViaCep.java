package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Stream;

public class ViaCep {
    public static String buscarCep(String cep) {
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            Stream<String> lines = br.lines();
            lines.forEach(line -> jsonSb.append(line.trim()));
          
            json = jsonSb.toString();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return json;
    }	

}
