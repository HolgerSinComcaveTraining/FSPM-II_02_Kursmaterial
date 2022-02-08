package url;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public class URLGetRequest {

	public static void main(String[] args) throws Exception {
		// https://nominatim.openstreetmap.org/search.php?q=Sonsbeck
		
		String search = args.length > 0 ? String.join("_", args) : "sonsbeck";
		search = URLEncoder.encode(search, StandardCharsets.UTF_8.name());
		String baseURL = "https://nominatim.openstreetmap.org/search.php?q=";
		URL url = new URL(baseURL + search);
		System.out.println(url);
		Pattern pattern = Pattern.compile("<span class=\"name\">(.+?)</span>");
		
		Scanner scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8.name());
		System.out.println( scanner.useDelimiter("\\Z").next() );
//		scanner.findAll(pattern).map(matchresult -> matchresult.group(1)).forEach(System.out::println);
		
	}

}
