import java.util.List;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args){
		Conexion p = new Conexion();
		Thread t1 = new Thread(p);
		t1.start();
	}

}
