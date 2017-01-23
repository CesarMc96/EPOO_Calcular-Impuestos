package GUI;

import Controller.BaseDatos;
import Modelo.Direccion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Enum.TipoDireccion;
import Enum.TipoRegimen;
import Excepciones.DireccionException;
import Excepciones.RegimenException;
import Modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;

public class DireccionDialog extends JDialog {

    private final String[] TipoDireccionn = {"", "Fisica", "Fiscal", "Sucursal"};
    private final JLabel lblTipoDireccione;
    private final JComboBox TipoDirecciones;
    private final JLabel lblCalle;
    private final JTextField txtCalle;
    private final JLabel lblNumeroExterior;
    private final JTextField txtNumeroExterior;
    private final JLabel lblNumeroInterior;
    private final JTextField txtNumeroInterior;
    private final JLabel lblColonia;
    private final JTextField txtColonia;
    private final JLabel lblCP;
    private final JTextField txtCP;
    private final JTextField txtMunicipio;
    private final JLabel lblMunicipio;
    private final JPanel pnlArriba;
    private final JPanel pnlArribaArriba;
    private final JPanel pnlArribaCentro;
    private final JPanel pnlArribaAbajo;
    private final JPanel pnlBotones;
    private final JPanel pnlAdentro;
    private final JButton btnAceptar;
    private final JButton btnCancelar;
    private ArrayList<Persona> Usuarios;
    private final JPanel pnlArribaAbajoAbajo;
    private final JPanel pnlArribaAbajoArriba;
    private final JLabel lblTipoRegimen;
    private final JCheckBox checkCedular;
    private final JCheckBox checkIntermedio;
    private final JCheckBox checkIeps;
    private final JCheckBox checkHospedaje;
    private final JCheckBox checkIncorporacion;

    public DireccionDialog(Dialog dialog) {
        super(dialog, true);
        super.setSize(650, 220);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        super.setTitle("Agregar Direccion");

        pnlArriba = new JPanel();
        pnlArriba.setLayout(new BorderLayout());

        pnlArribaArriba = new JPanel();

        lblTipoDireccione = new JLabel("Tipo de Direccion:");
        TipoDirecciones = new JComboBox(TipoDireccionn);
        TipoDirecciones.setBackground(Color.WHITE);
        pnlArribaArriba.add(lblTipoDireccione);
        pnlArribaArriba.add(TipoDirecciones);
        pnlArribaArriba.setBackground(Color.WHITE);

        pnlArribaCentro = new JPanel();

        lblCalle = new JLabel("               Calle");
        txtCalle = new JTextField(15);
        pnlArribaArriba.add(lblCalle);
        pnlArribaArriba.add(txtCalle);
        pnlArriba.add(pnlArribaArriba, BorderLayout.PAGE_START);

        lblNumeroExterior = new JLabel("Numero Exterior: ");
        txtNumeroExterior = new JTextField(4);

        lblNumeroInterior = new JLabel("Numero Interior: ");
        txtNumeroInterior = new JTextField(4);

        lblCP = new JLabel("Codigo Postal: ");
        txtCP = new JTextField(7);

        pnlArribaCentro.add(lblNumeroExterior);
        pnlArribaCentro.add(txtNumeroExterior);
        pnlArribaCentro.add(new JLabel("               "));
        pnlArribaCentro.add(lblNumeroInterior);
        pnlArribaCentro.add(txtNumeroInterior);
        pnlArribaCentro.add(new JLabel("               "));
        pnlArribaCentro.add(lblCP);
        pnlArribaCentro.add(txtCP);
        pnlArribaCentro.setBackground(Color.WHITE);

        pnlArriba.add(pnlArribaCentro, BorderLayout.CENTER);

        lblColonia = new JLabel("Colonia");
        txtColonia = new JTextField(10);

        lblMunicipio = new JLabel("Municipio");
        txtMunicipio = new JTextField(10);

        pnlArribaAbajo = new JPanel();
        pnlArribaAbajo.setLayout(new BorderLayout());

        pnlArribaAbajoAbajo = new JPanel();
        pnlArribaAbajoArriba = new JPanel();

        pnlArribaAbajoArriba.add(lblColonia);
        pnlArribaAbajoArriba.add(txtColonia);
        pnlArribaAbajoArriba.add(new JLabel("               "));
        pnlArribaAbajoArriba.add(lblMunicipio);
        pnlArribaAbajoArriba.add(txtMunicipio);
        pnlArribaAbajoArriba.setBackground(Color.WHITE);

        lblTipoRegimen = new JLabel("Regimenes:    ");

        checkCedular = new JCheckBox("Cedular");
        checkCedular.setBackground(Color.WHITE);
        checkIntermedio = new JCheckBox("Intermedio");
        checkIntermedio.setBackground(Color.WHITE);
        checkIeps = new JCheckBox("Ieps");
        checkIeps.setBackground(Color.WHITE);
        checkHospedaje = new JCheckBox("Hospedaje");
        checkHospedaje.setBackground(Color.WHITE);
        checkIncorporacion = new JCheckBox("Incorporacion");
        checkIncorporacion.setBackground(Color.WHITE);

        pnlArribaAbajoAbajo.add(lblTipoRegimen);
        pnlArribaAbajoAbajo.add(checkCedular);
        pnlArribaAbajoAbajo.add(checkHospedaje);
        pnlArribaAbajoAbajo.add(checkIncorporacion);
        pnlArribaAbajoAbajo.add(checkIeps);
        pnlArribaAbajoAbajo.add(checkIntermedio);
        pnlArribaAbajoAbajo.setBackground(Color.WHITE);
        pnlArribaAbajoArriba.setBackground(Color.WHITE);

        pnlArribaAbajo.add(pnlArribaAbajoAbajo, BorderLayout.PAGE_END);
        pnlArribaAbajo.add(pnlArribaAbajoArriba, BorderLayout.PAGE_START);

        pnlArriba.add(pnlArribaAbajo, BorderLayout.PAGE_END);

        pnlBotones = new JPanel();
        pnlBotones.setLayout(new BorderLayout());
        pnlAdentro = new JPanel();
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        pnlAdentro.add(btnAceptar);
        pnlAdentro.add(btnCancelar);
        pnlBotones.add(pnlAdentro, BorderLayout.EAST);

        btnCancelar.addActionListener((ActionEvent e) -> {
            int n = JOptionPane.showConfirmDialog(
                    dialog,
                    "¿Quieres cancelar cambios?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                DireccionDialog.this.setVisible(false);
            }
        });

        btnAceptar.addActionListener((ActionEvent e) -> {
            try {
                Direccion direccion = crearObjeto();

                Usuarios = BaseDatos.cargarUsuarios();

                Persona p = Usuarios.get(Usuarios.size() - 1);
                p.AddDireccion(direccion);

                try {
                    if (checkCedular.isSelected()) {
                        p.addRegimen(TipoRegimen.Cedular);
                    }
                    if (checkHospedaje.isSelected()) {
                        p.addRegimen(TipoRegimen.Hospedaje);
                    }
                    if (checkIeps.isSelected()) {
                        p.addRegimen(TipoRegimen.Ieps);
                    }
                    if (checkIncorporacion.isSelected()) {
                        p.addRegimen(TipoRegimen.Incorporacion);
                    }
                    if (checkIntermedio.isSelected()) {
                        p.addRegimen(TipoRegimen.Intermedio);
                    }
                } catch (RegimenException ex) {
                    JOptionPane.showMessageDialog(dialog,
                        "No puedes estar en Incorporacion e Intermedio",
                        "Error Regimen",
                        JOptionPane.ERROR_MESSAGE);
                }
                Usuarios.remove(Usuarios.size() - 1);

                Usuarios.add(p);
                BaseDatos.escribirUsuarios(Usuarios);
                setVisible(false);

            } catch (DireccionException ex) {
                JOptionPane.showMessageDialog(dialog,
                        "La calle debe de ser solo en letras",
                        "Error en la calle",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(DireccionDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DireccionDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        super.add(pnlBotones, BorderLayout.PAGE_END);
        super.add(pnlArriba, BorderLayout.CENTER);
    }

    protected Direccion crearObjeto() throws DireccionException {
        TipoDireccion tp = null;

        if (TipoDirecciones.getSelectedItem() == "Fiscal") {
            tp = TipoDireccion.Fiscal;
        }
        if (TipoDirecciones.getSelectedItem() == "Fisica") {
            tp = TipoDireccion.Fisica;
        }
        if (TipoDirecciones.getSelectedItem() == "Sucursal") {
            tp = TipoDireccion.Sucursal;
        }

        Direccion direccion = new Direccion(
                tp,
                txtCalle.getText(),
                txtNumeroExterior.getText(),
                txtNumeroInterior.getText(),
                txtColonia.getText(),
                txtCP.getText(),
                txtMunicipio.getText());

        return direccion;
    }

}
