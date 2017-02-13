import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Poste implements Runnable{
	
	private int n;
	private HttpURLConnection connection;
	private List<Bus> buses;

	public Poste(int n) {
		this.n = n;
		buses = new ArrayList<Bus>();
		try {
			update();
		} catch (Exception e) {}
	}
	
	public List<Bus> getBuses(){ return buses; }

	private String fillBolsa(String response) {
		return response.split("<span id=\"yfs_l84_bbva.mc\">")[1].split("</span>")[0];
	}

	private String getResponse() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	private int connect() throws MalformedURLException, IOException, ProtocolException {
		final String USER_AGENT = "Mozilla/5.0";
		String url = "https://es.finance.yahoo.com/q/hp?s=BBVA.MC";

		URL obj = new URL(url);
		connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = connection.getResponseCode();
		return responseCode;
	}
	
	public class Bus{
		String numero;
		String direccion;
		String tiempo;
		boolean minusvalidos;
	}

	@Override
	public void run() {
		while (true) {
			try {
				update();
				Thread.sleep(10000);
			} catch (Exception e) {}
		}
	}

	private void update() throws MalformedURLException, IOException, ProtocolException {
		connect();
		String response = getResponse();
		buses.clear();
		System.out.println(fillBolsa(response));
	}

}
