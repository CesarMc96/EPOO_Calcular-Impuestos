
package GUI;

import Controller.BaseDatos;
import GUI.Listener.PersonaDialogListener;
import Modelo.Persona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class PrincipalFrame extends JFrame {

    private final JMenuBar menu;
    private final JPanel pnlBuscar;
    private final JLabel lblBuscarRFC;
    private final JLabel lblBuscarNombre;    
    private final TextField txtBuscarRFC;
    private final TextField txtBuscarNombre;
    private final JButton btnBuscar;
    private final JToolBar menuHerramientas;
    private final JPanel pnlTrabajo;
    private final JButton btnFisica;
    private final JButton btnMoral;
    private final ImageIcon FisicaPersona;
    private final Icon FisicaPersonaEscala;
    private final ImageIcon MoralPersona;
    private final ImageIcon MoralPersonaEscala;
    private BaseDatos datos;
    private final FisicaDialog dlgFisica;
    
    public PrincipalFrame() {
        
        super.setSize(800, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("Impuestos Lasallinos");
        super.getContentPane().setBackground(Color.WHITE);        
        super.setLocationRelativeTo(null);
        
        pnlBuscar = new JPanel();
        lblBuscarNombre = new JLabel("Nombre: ");
        txtBuscarNombre = new TextField(20);
        lblBuscarRFC = new JLabel("RFC: ");
        txtBuscarRFC = new TextField(20);
        btnBuscar = new JButton("Buscar");
        
        pnlBuscar.add(lblBuscarNombre);
        pnlBuscar.add(txtBuscarNombre);
        pnlBuscar.add(new JLabel("              "));
        pnlBuscar.add(lblBuscarRFC);
        pnlBuscar.add(txtBuscarRFC);
        pnlBuscar.add(new JLabel("                                                "));
        pnlBuscar.add(btnBuscar);
        
        menu = new JMenuBar();
        
        JMenu menuArchivo = new JMenu("Archivo");        
        JMenuItem itmGuardar = new JMenuItem("Guardar");
        JMenuItem itmBuscar = new JMenuItem("Buscar");  
        JMenuItem itmSalir = new JMenuItem("Salir");
        
        menuArchivo.add(itmGuardar);
        menuArchivo.add(itmBuscar);
        menuArchivo.addSeparator();
        menuArchivo.add(itmSalir);
        
        JMenu menuContribuyentes = new JMenu("Contribuyentes");
        JMenuItem itmFisica = new JMenuItem("Inscribir persona Fisica...");
        JMenuItem itmMoral = new JMenuItem("Inscribir persona Moral...");
        JMenuItem itmModificar = new JMenuItem("Modificar Datos...");
        JMenuItem imtDeclarar = new JMenuItem("Declarar...");
        JMenuItem itmVer = new JMenuItem("Ver Obligaciones...");
        
        menuContribuyentes.add(itmFisica);
        menuContribuyentes.add(itmMoral);        
        menuContribuyentes.add(itmModificar);
        menuContribuyentes.addSeparator();
        menuContribuyentes.add(itmVer);
        menuContribuyentes.add(imtDeclarar);
        
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itmAcerca = new JMenuItem("Acerca de..");
        
        menuAyuda.add(itmAcerca);
        
        menu.add(menuArchivo);
        menu.add(menuContribuyentes);
        menu.add(menuAyuda);
        
        menuHerramientas = new JToolBar();
        
        btnFisica = new JButton();
        FisicaPersona = new ImageIcon(getClass().getResource("/Iconos/imgres.jpg"));
        FisicaPersonaEscala = new ImageIcon(FisicaPersona.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        btnFisica.setIcon(FisicaPersonaEscala);
        btnFisica.setToolTipText("Persona Fisica");
        
        btnMoral= new JButton();
        MoralPersona = new ImageIcon(getClass().getResource("/Iconos/icono-c-empresarial.png"));
        MoralPersonaEscala = new ImageIcon(MoralPersona.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        btnMoral.setIcon(MoralPersonaEscala);
        btnMoral.setToolTipText("Persona Moral");
        
        menuHerramientas.add(btnFisica);
        menuHerramientas.add(btnMoral);
        
        btnFisica.addActionListener((ActionEvent ae) -> {
            inscribirPersonaFisicaClick();
        });
        
        itmFisica.addActionListener((ActionEvent ae) -> {
            inscribirPersonaFisicaClick();
        });
        
        btnMoral.addActionListener((ActionEvent ae) -> {
            inscribirPersonaMoralClick();
        });
        
        itmMoral.addActionListener((ActionEvent ae) -> {
            inscribirPersonaMoralClick();
        });
        
        itmAcerca.addActionListener((ActionEvent ae) -> {
            AcercaDialog ac = new AcercaDialog(this);
            ac.setVisible(true);
        });
        
        itmSalir.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        
        pnlTrabajo = new JPanel();
        pnlTrabajo.setBackground(Color.white);
        
        dlgFisica = new FisicaDialog(this);
        dlgFisica.setListener((Persona persona) -> {
            System.out.println(persona.getRfc());
            datos.agregar(persona);
        });
        
        setJMenuBar(this.menu);
        super.add(menuHerramientas, BorderLayout.PAGE_START);
        super.add(pnlTrabajo, BorderLayout.CENTER);
        super.add(pnlBuscar, BorderLayout.PAGE_END);
        super.setResizable(false);
        super.setVisible(true);
    }

    private void inscribirPersonaFisicaClick() {
        FisicaDialog f = new FisicaDialog(this);
        f.setVisible(true);
    }

    private void inscribirPersonaMoralClick() {
        MoralDialog d = new MoralDialog(this);
        d.setVisible(true);
    }

}
