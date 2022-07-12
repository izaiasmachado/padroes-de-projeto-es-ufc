import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {	
	public static Map<String, String> fromJsonToMap(String json) {
        Map<String,String> mapa = new HashMap<>();

        Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
        while (matcher.find()) {
            String[] group = matcher.group().split(":");
            mapa.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
        }
        
        return mapa;
	}
}
