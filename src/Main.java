import java.util.List;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args){
		int n = askInt("Numero de poste: "); //103 poste de los enlaces
		
		Poste p = new Poste(n);
		List<Poste.Bus> buses = p.getBuses();
		Thread t1 = new Thread(p);
		t1.start();
		
		Display d = new Display(buses,n);
		Thread t2 = new Thread(d);
		t2.start();
	}
	
	
	private static int askInt(String str){
		try{
			return Integer.parseInt(JOptionPane.showInputDialog(str));
		}
		catch (Exception e){
			return askInt(str);
		}
	}

}
