import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Interfaz i = new Interfaz();
        Conexion p = new Conexion(i);
        Thread t1 = new Thread(p);
        t1.start();
    }

}
