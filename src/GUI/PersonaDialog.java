package GUI;

import Controller.BaseDatos;
import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Excepciones.RFCException;
import GUI.Listener.PersonaDialogListener;
import Modelo.Persona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class PersonaDialog extends JDialog {

    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JButton btnCancelar;
    private final JPanel pnlAdentro;
    private final JLabel lblInscripcion;
    private final JPanel pnlArriba;
    private final JLabel lblRFC;
    private JTextField txtRFC;
    private final JLabel lblTelefono;
    private JTextField txtTelefono;
    private final JLabel lblFechaInscripcion;
    private final Integer[] FOperacionesdia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private final Integer[] FInscripciondia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private final String[] FOperacionesMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final String[] FInscripcionsMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final Integer[] FOperacionesAnio = {1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
    private final Integer[] FInscripcionAnio = {1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
    private JComboBox FechaInscripcionDia;
    private final JLabel lblFechaOperacion;
    private JComboBox FechaInicioOperacionesDia;
    private JComboBox FechaInscripcionMes;
    private JComboBox FechaInscripcionAnio;
    private JComboBox FechaInicioOperacionesMes;
    private JComboBox FechaInicioOperacionesAnio;
    private final JPanel pnlCentro;
    private final JPanel pnlCentroAbajo;
    private final JPanel pnlCentroAbajoArriba;
    private final JPanel pnlCentroAbajoEnmedio;
    private final JPanel pnlCentroAbajoAbajo;
    private final JPanel pnlCentroAbajoAbajoArriba;
    private final JPanel pnlCentroAbajoAbajoAbajo;
    private final JPanel pnla;
    JPanel pnlCentroArriba;
    private BaseDatos bd;
    private ArrayList<Persona> Usuarios;

    public PersonaDialog(Frame frame) {
        super(frame, true);
        super.setSize(650, 300);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());

        pnlBotones = new JPanel();
        pnlBotones.setLayout(new BorderLayout());
        pnlAdentro = new JPanel();
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        pnlArriba = new JPanel();
        pnlArriba.setLayout(new BorderLayout());
        lblInscripcion = new JLabel("    Inscripcion");
        lblInscripcion.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));
        pnlArriba.add(lblInscripcion, BorderLayout.WEST);

        pnlCentro = new JPanel();
        pnlCentro.setLayout(new BorderLayout());

        pnlCentroArriba = new JPanel();
        pnlCentroArriba.setLayout(new BorderLayout());
        pnlCentroAbajo = new JPanel();
        pnlCentroAbajo.setLayout(new BorderLayout());

        pnlCentroAbajoArriba = new JPanel();
        lblRFC = new JLabel("RFC:");
        txtRFC = new JTextField(15);
        pnlCentroAbajoArriba.add(lblRFC);
        pnlCentroAbajoArriba.add(txtRFC);
        //pnlCentroAbajoArriba.add(new JLabel("                                                         "));
        pnlCentroAbajo.add(pnlCentroAbajoArriba, BorderLayout.PAGE_START);

        pnlCentroAbajoEnmedio = new JPanel();
        lblTelefono = new JLabel("Telefono: ");
        txtTelefono = new JTextField(10);
        pnlCentroAbajoEnmedio.add(lblTelefono);
        pnlCentroAbajoEnmedio.add(txtTelefono);
        //pnlCentroAbajoEnmedio.add(new JLabel("                                                                  "));
        pnlCentroAbajo.add(pnlCentroAbajoEnmedio, BorderLayout.CENTER);

        pnlCentroAbajoAbajo = new JPanel();
        pnlCentroAbajoAbajo.setLayout(new BorderLayout());
        
        pnlCentroAbajoAbajoArriba = new JPanel();
        lblFechaInscripcion = new JLabel("Fecha Inscripcion: ");
        FechaInscripcionDia = new JComboBox(FInscripciondia);
        FechaInscripcionMes = new JComboBox(FInscripcionsMes);
        FechaInscripcionAnio = new JComboBox(FInscripcionAnio);
        pnlCentroAbajoAbajoArriba.add(lblFechaInscripcion);
        pnlCentroAbajoAbajoArriba.add(FechaInscripcionDia);
        pnlCentroAbajoAbajoArriba.add(FechaInscripcionMes);
        pnlCentroAbajoAbajoArriba.add(FechaInscripcionAnio);
        //pnlCentroAbajoAbajoArriba.add(new JLabel("                   "));

        pnlCentroAbajoAbajoAbajo = new JPanel();
        lblFechaOperacion = new JLabel("Fecha Inicio Operaciones: ");
        FechaInicioOperacionesDia = new JComboBox(FOperacionesdia);
        FechaInicioOperacionesMes = new JComboBox(FOperacionesMes);
        FechaInicioOperacionesAnio = new JComboBox(FOperacionesAnio);
        pnlCentroAbajoAbajoAbajo.add(lblFechaOperacion);
        pnlCentroAbajoAbajoAbajo.add(FechaInicioOperacionesDia);
        pnlCentroAbajoAbajoAbajo.add(FechaInicioOperacionesMes);
        pnlCentroAbajoAbajoAbajo.add(FechaInicioOperacionesAnio);
        //pnlCentroAbajoAbajoAbajo.add(new JLabel("     "));

        
        pnlCentroAbajoAbajo.add(pnlCentroAbajoAbajoArriba, BorderLayout.PAGE_START);
        pnlCentroAbajoAbajo.add(pnlCentroAbajoAbajoAbajo, BorderLayout.CENTER);
        pnlCentroAbajoAbajo.add(pnla = new JPanel(), BorderLayout.PAGE_END);
        pnla.setBackground(Color.WHITE);        

        
        pnlCentroAbajo.add(pnlCentroAbajoAbajo, BorderLayout.PAGE_END);

        pnlAdentro.add(btnAceptar);
        pnlAdentro.add(btnCancelar);
        pnlBotones.add(pnlAdentro, BorderLayout.EAST);

        pnlCentro.add(pnlCentroAbajo, BorderLayout.PAGE_END);
        pnlCentro.add(pnlCentroArriba, BorderLayout.CENTER);
        
        pnlCentroAbajoAbajoArriba.setBackground(Color.WHITE);
        pnlCentroAbajoAbajoAbajo.setBackground(Color.WHITE);
        pnlCentroAbajoEnmedio.setBackground(Color.WHITE);
        pnlCentroAbajoArriba.setBackground(Color.WHITE);
        pnlCentro.setBackground(Color.WHITE);
        
        btnAceptar.addActionListener((ActionEvent e) -> {
            try {
                Persona persona = crearObjeto();
                
                Usuarios = BaseDatos.cargarUsuarios();
                Usuarios.add(persona);
                
                BaseDatos.escribirUsuarios(Usuarios);
                System.out.println(Usuarios);
                setVisible(false);
                
                DireccionDialog u = new DireccionDialog(this);
                u.setVisible(true);
                
            } catch (IntervalosFechaException ex) {
                JOptionPane.showMessageDialog(frame,
                        "La fecha de inscripcion debe ser menor al inicio de operaciones",
                        "Error en las Fechas",
                        JOptionPane.ERROR_MESSAGE);
            } catch (PersonaFisicaException ex) {
                JOptionPane.showMessageDialog(frame,
                        "La persona debe ser mayor de edad para inscribirse",
                        "",
                        JOptionPane.WARNING_MESSAGE);
            } catch (RFCException ex) {
                JOptionPane.showMessageDialog(frame,
                        "RFC mal escrito",
                        "",
                        JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(PersonaDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PersonaDialog.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            
            
        });

        btnCancelar.addActionListener((ActionEvent e) -> {
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "¿Quieres cancelar cambios?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                PersonaDialog.this.setVisible(false);
            }
        });

        super.add(pnlArriba, BorderLayout.PAGE_START);
        super.add(pnlCentro, BorderLayout.CENTER);
        super.add(pnlBotones, BorderLayout.PAGE_END);
        super.setResizable(false);
    }

    public JPanel getPnlCentroArriba() {
        return pnlCentroArriba;
    }

    public void setPnlCentroArriba(JPanel pnlCentroArriba) {
        this.pnlCentroArriba = pnlCentroArriba;
    }

    public JTextField getTxtRFC() {
        return txtRFC;
    }

    public void setTxtRFC(JTextField txtRFC) {
        this.txtRFC = txtRFC;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JComboBox getFechaInscripcionDia() {
        return FechaInscripcionDia;
    }

    public void setFechaInscripcionDia(JComboBox FechaInscripcionDia) {
        this.FechaInscripcionDia = FechaInscripcionDia;
    }

    public JComboBox getFechaInicioOperacionesDia() {
        return FechaInicioOperacionesDia;
    }

    public void setFechaInicioOperacionesDia(JComboBox FechaInicioOperacionesDia) {
        this.FechaInicioOperacionesDia = FechaInicioOperacionesDia;
    }

    public JComboBox getFechaInscripcionMes() {
        return FechaInscripcionMes;
    }

    public void setFechaInscripcionMes(JComboBox FechaInscripcionMes) {
        this.FechaInscripcionMes = FechaInscripcionMes;
    }

    public JComboBox getFechaInscripcionAnio() {
        return FechaInscripcionAnio;
    }

    public void setFechaInscripcionAnio(JComboBox FechaInscripcionAnio) {
        this.FechaInscripcionAnio = FechaInscripcionAnio;
    }

    public JComboBox getFechaInicioOperacionesMes() {
        return FechaInicioOperacionesMes;
    }

    public void setFechaInicioOperacionesMes(JComboBox FechaInicioOperacionesMes) {
        this.FechaInicioOperacionesMes = FechaInicioOperacionesMes;
    }

    public JComboBox getFechaInicioOperacionesAnio() {
        return FechaInicioOperacionesAnio;
    }

    public void setFechaInicioOperacionesAnio(JComboBox FechaInicioOperacionesAnio) {
        this.FechaInicioOperacionesAnio = FechaInicioOperacionesAnio;
    }
    
    protected abstract Persona crearObjeto() throws IntervalosFechaException, PersonaFisicaException, RFCException;
    
    public Integer ObtenerMesOperaciones(){
        Integer mes = 0;
        
        if(FechaInicioOperacionesMes.getSelectedItem() == "Enero"){
            mes = 1;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Febrero"){
            mes = 2;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Marzo"){
            mes = 3;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Abril"){
            mes = 4;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Mayo"){
            mes = 5;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Junio"){
            mes = 6;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Julio"){
            mes = 7;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Agosto"){
            mes = 8;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Septiembre"){
            mes = 9;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Octubre"){
            mes = 10;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Noviembre"){
            mes = 11;
        }
        if(FechaInicioOperacionesMes.getSelectedItem() == "Diciembtre"){
            mes = 12;
        }
        
        return mes;
    }

    public Integer ObtenerMesInscripcion(){
        Integer mes = 0;
        
        if(FechaInscripcionMes.getSelectedItem() == "Enero"){
            mes = 1;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Febrero"){
            mes = 2;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Marzo"){
            mes = 3;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Abril"){
            mes = 4;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Mayo"){
            mes = 5;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Junio"){
            mes = 6;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Julio"){
            mes = 7;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Agosto"){
            mes = 8;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Septiembre"){
            mes = 9;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Octubre"){
            mes = 10;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Noviembre"){
            mes = 11;
        }
        if(FechaInscripcionMes.getSelectedItem() == "Diciembtre"){
            mes = 12;
        }
        
        return mes;
    }
    
}
