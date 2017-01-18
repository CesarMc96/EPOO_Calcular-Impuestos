
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PrincipalFrame extends JFrame {

    private final JMenuBar menu;
    private final JPanel pnlBuscar;
    private final JLabel lblBuscar;
    private final TextField txtBuscar;
    private final JButton btnBuscar;
    
    public PrincipalFrame() {
        
        super.setSize(800, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("Impuestos Lasallinos");
        super.getContentPane().setBackground(Color.WHITE);        
        super.setLocationRelativeTo(null);
        
        pnlBuscar = new JPanel();
        lblBuscar = new JLabel("Buscar: ");
        txtBuscar = new TextField(40);
        btnBuscar = new JButton("Buscar");
        
        pnlBuscar.add(lblBuscar);
        pnlBuscar.add(txtBuscar);
        pnlBuscar.add(btnBuscar);
        
        menu = new JMenuBar();
        
        JMenu menuArchivo = new JMenu("Inscripcion");
        JMenuItem itmFisica = new JMenuItem("Persona Fisica");
        JMenuItem itmMoral = new JMenuItem("Persona Moral");
        JMenuItem itmSalir = new JMenuItem("Salir");
        
        menuArchivo.add(itmFisica);
        menuArchivo.add(itmMoral);
        menuArchivo.addSeparator();
        menuArchivo.add(itmSalir);
        
        JMenu menuObligaciones = new JMenu("Impuestos");
        JMenuItem itmCedular = new JMenuItem("Cedular");
        JMenuItem itmHospedaje = new JMenuItem("Hospedaje");
        JMenuItem itmIeps = new JMenuItem("Ieps");
        JMenuItem itmIncorporacion = new JMenuItem("Incorporacion");
        JMenuItem itmIntermedio = new JMenuItem("Intermedio");
        
        menuObligaciones.add(itmCedular);
        menuObligaciones.add(itmHospedaje);
        menuObligaciones.add(itmIeps);
        menuObligaciones.add(itmIncorporacion);
        menuObligaciones.add(itmIntermedio);
        
        
        menu.add(menuArchivo);
        menu.add(menuObligaciones);
        
        super.add(menu, BorderLayout.PAGE_START);
        super.add(pnlBuscar, BorderLayout.PAGE_END);
        super.setVisible(true);
    }

}
