import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Display extends javax.swing.JFrame implements Runnable{

	List<Poste.Bus> buses;
    
	public Display(List<Poste.Bus> buses, int poste) {
		this.buses = buses;
        initComponents();
        updateTable();
        setTitle("Poste " + poste);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>               

    private void updateTable() {
        Object[] title = {"Línea", "Destino", "Minutos", "Rampa de minusválidos"};
        table.setModel(new DefaultTableModel(tableObjects(),title));
    }
    
    private Object[][] tableObjects(){
    	Object[][] ret = new Object[buses.size()][4];
    	for (int i = 0; i < buses.size(); i++) {
    		ret[i][0] = buses.get(i).numero;
    		ret[i][1] = buses.get(i).direccion;
    		ret[i][2] = buses.get(i).tiempo;
    		ret[i][3] = buses.get(i).minusvalidos;
    	}
    	return ret;
    	
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration                   

	@Override
	public void run() {
		while (true) {
			try {
				updateTable();
				Thread.sleep(10000);
			} catch (Exception e) {}
		}
	}

}
