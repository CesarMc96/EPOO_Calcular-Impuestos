
package GUI;

import Controller.BaseDatos;
import Controller.Modelo;
import GUI.Listener.PersonaDialogListener;
import Modelo.Persona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class PrincipalFrame extends JFrame {

    private final JMenuBar menu;
    private final JPanel pnlBuscar;
    private final JLabel lblBuscarRFC;
    private final JLabel lblBuscarNombre;    
    private final TextField txtBuscarRFC;
    private final TextField txtBuscarNombre;
    private final JButton btnBuscar;
    private final JToolBar menuHerramientas;
    private final JButton btnFisica;
    private final JButton btnMoral;
    private final ImageIcon FisicaPersona;
    private final Icon FisicaPersonaEscala;
    private final ImageIcon MoralPersona;
    private final ImageIcon MoralPersonaEscala;
    private final ArrayList<Persona> Usuarios;
    private Modelo modelo;
    private final JTable tblExamenes;
    private final JButton btnVerObligaciones;
    private final ImageIcon VerObligaciones;
    private final ImageIcon VerObligacionesEscala;
    private final JButton btnDeclarar;
    private final ImageIcon Declarar;
    private final ImageIcon DeclararEscala;
    private final JButton btnAcerca;
    private final ImageIcon Acerca;
    private final ImageIcon AcercaEscala;
    private final JButton btnSalir;
    private final ImageIcon Salir;
    private final ImageIcon SalirEscala;
    private TableRowSorter trsFiltro;
    
    public PrincipalFrame() throws IOException, FileNotFoundException, ClassNotFoundException {
        
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
        
        btnVerObligaciones = new JButton();
        VerObligaciones = new ImageIcon(getClass().getResource("/Iconos/url.png"));
        VerObligacionesEscala = new ImageIcon(VerObligaciones.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        btnVerObligaciones.setIcon(VerObligacionesEscala);
        btnVerObligaciones.setToolTipText("Ver Obligaciones");
        
        btnDeclarar = new JButton();
        Declarar = new ImageIcon(getClass().getResource("/Iconos/iconos_caracteristicas_08.png"));
        DeclararEscala = new ImageIcon(Declarar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        btnDeclarar.setIcon(DeclararEscala);
        btnDeclarar.setToolTipText("Declarar");
        
        btnAcerca = new JButton();
        Acerca = new ImageIcon(getClass().getResource("/Iconos/icono-informacion-general-blanco-azul_0.png"));
        AcercaEscala = new ImageIcon(Acerca.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        btnAcerca.setIcon(AcercaEscala);
        btnAcerca.setToolTipText("Declarar");
        
        btnSalir = new JButton();
        Salir = new ImageIcon(getClass().getResource("/Iconos/IconoSalir.jpg"));
        SalirEscala = new ImageIcon(Salir.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        btnSalir.setIcon(SalirEscala);
        btnSalir.setToolTipText("Salir");
        
        menuHerramientas.add(btnFisica);
        menuHerramientas.add(btnMoral);
        menuHerramientas.add(btnVerObligaciones);
        menuHerramientas.add(btnDeclarar);
        menuHerramientas.add(btnAcerca);
        menuHerramientas.add(btnSalir);
        
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
        
        btnAcerca.addActionListener((ActionEvent ae) -> {
            AcercaDialog ac = new AcercaDialog(this);
            ac.setVisible(true);
        });
        
        itmSalir.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        
        btnSalir.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });
        
        setJMenuBar(this.menu);
        
        Usuarios = BaseDatos.cargarUsuarios();
        modelo = new Modelo(Usuarios);
        tblExamenes = new JTable(modelo);
        
        super.add(new JScrollPane(tblExamenes));
        super.add(menuHerramientas, BorderLayout.PAGE_START);
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

    public void filtro() {
        int columnaABuscar = 0;
        
        trsFiltro.setRowFilter(RowFilter.regexFilter(txtBuscarRFC.getText(), columnaABuscar));
    }
    
    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        
        txtBuscarRFC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscarRFC.getText());
                txtBuscarRFC.setText(cadena);
                repaint();
                filtro();
            }
        });
        
        trsFiltro = new TableRowSorter(tblExamenes.getModel());
        tblExamenes.setRowSorter(trsFiltro);

    }
    
}
