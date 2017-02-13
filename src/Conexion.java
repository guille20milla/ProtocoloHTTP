import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Conexion implements Runnable {

    Interfaz i;
    private HttpURLConnection conexion;
    ArrayList<Empresa> datos = new ArrayList<Empresa>();

    public Conexion(Interfaz i) {
        this.i = i;
    }

    private ArrayList cargarTabla(String response) {
        ArrayList<Empresa> datos = new ArrayList<Empresa>();
        for (int i = 1; i <= 10; i++) {
            String id = response.split("<tbody>")[1].split("<tr>")[i].split("<a")[1].split(">")[1].split("<")[0];
            String nombre = response.split("<tbody>")[1].split("<tr>")[i].split("<td class=\"second name\">")[1].split("<")[0];
            String cambio = response.split("<tbody>")[1].split("<tr>")[i].split("<td")[4].split("<b")[1].split(">")[1].split("<")[0];
            String porcentaje = response.split("<tbody>")[1].split("<tr>")[i].split("<td")[4].split("<b")[2].split(">")[1].split("<")[0];
            boolean verde = response.split("<tbody>")[1].split("<tr>")[i].split("<td")[4].split("<b")[1].contains("color:#008800;");
            Empresa e = new Empresa(id, nombre, cambio, porcentaje, verde);
            datos.add(e);
            //System.out.println(response.split("<tbody>")[1].split("<tr>")[i].split("<td")[4].split("<b")[2].split(">")[1].split("<")[0]);
        }
        return datos;
    }

    private String getResponse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private int conectar() throws MalformedURLException, IOException, ProtocolException {
        final String USER_AGENT = "Mozilla/5.0";
        String url = "https://es.finance.yahoo.com/actives?e=mc";

        URL obj = new URL(url);
        conexion = (HttpURLConnection) obj.openConnection();

        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = conexion.getResponseCode();
        return responseCode;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cargar();
                Thread.sleep(5000);
            } catch (Exception e) {
            }
        }
    }

    private void cargar() throws MalformedURLException, IOException, ProtocolException {
        conectar();
        String response = getResponse();
        datos.clear();
        datos.addAll(cargarTabla(response));
        Collections.sort(datos);
        i.actualizarTabla(datos);
        i.setVisible(true);
    }

}
