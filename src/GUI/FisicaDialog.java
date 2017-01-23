package GUI;

import Enum.TipoPersona;
import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Excepciones.RFCException;
import Modelo.Fisica;
import Modelo.Persona;
import Objetos.Fecha;
import Objetos.RFC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FisicaDialog extends PersonaDialog {

    private final JLabel lblNombre;
    private final JTextField txtNombre;
    private final JLabel lblApellidoPaterno;
    private final JLabel lblApellidoMaterno;
    private final JTextField txtApellidoPaterno;
    private final JTextField txtApellidoMaterno;
    private final JLabel lblFechaNacimiento;
    private final JComboBox FechaNacimientoDia;
    private final JComboBox FechaNacimientoMes;
    private final JComboBox FechaNacimientoAnio;
    private final Integer[] FNacimientodia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private final String[] FNacimentoMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final Integer[] FNacimientoAnio = {1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
    private final JPanel pnlFisica;
    private final JPanel pnlFisicaArriba;
    private final JPanel pnlFisicaEnmedio;

    public FisicaDialog(Frame frame) {
        super(frame);
        super.setTitle("Persona FISICA");

        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(10);

        lblApellidoPaterno = new JLabel("Apellido Paterno:");
        txtApellidoPaterno = new JTextField(8);

        lblApellidoMaterno = new JLabel("Apellido Materno:");
        txtApellidoMaterno = new JTextField(8);

        lblFechaNacimiento = new JLabel("Fecha Nacimiento: ");
        FechaNacimientoDia = new JComboBox(FNacimientodia);
        FechaNacimientoMes = new JComboBox(FNacimentoMes);
        FechaNacimientoAnio = new JComboBox(FNacimientoAnio);

        pnlFisica = new JPanel();
        pnlFisica.setLayout(new BorderLayout());

        pnlFisicaArriba = new JPanel();
        pnlFisicaArriba.add(lblNombre);
        pnlFisicaArriba.add(txtNombre);
        pnlFisicaArriba.add(lblApellidoPaterno);
        pnlFisicaArriba.add(txtApellidoPaterno);
        pnlFisicaArriba.add(lblApellidoMaterno);
        pnlFisicaArriba.add(txtApellidoMaterno);
        pnlFisicaArriba.setBackground(Color.WHITE);

        pnlFisicaEnmedio = new JPanel();
        pnlFisicaEnmedio.add(lblFechaNacimiento);
        pnlFisicaEnmedio.add(FechaNacimientoDia);
        pnlFisicaEnmedio.add(FechaNacimientoMes);
        pnlFisicaEnmedio.add(FechaNacimientoAnio);
        pnlFisicaEnmedio.setBackground(Color.WHITE);

        pnlFisica.add(pnlFisicaArriba, BorderLayout.PAGE_START);
        pnlFisica.add(pnlFisicaEnmedio, BorderLayout.CENTER);

        super.getPnlCentroArriba().add(pnlFisica);
    }

    public Integer ObtenerMes() {
        Integer mes = 0;

        if (FechaNacimientoMes.getSelectedItem() == "Enero") {
            mes = 1;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Febrero") {
            mes = 2;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Marzo") {
            mes = 3;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Abril") {
            mes = 4;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Mayo") {
            mes = 5;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Junio") {
            mes = 6;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Julio") {
            mes = 7;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Agosto") {
            mes = 8;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Septiembre") {
            mes = 9;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Octubre") {
            mes = 10;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Noviembre") {
            mes = 11;
        }
        if (FechaNacimientoMes.getSelectedItem() == "Diciembtre") {
            mes = 12;
        }

        return mes;
    }

    @Override
    protected Persona crearObjeto() throws IntervalosFechaException, PersonaFisicaException, RFCException {

        Integer mes = this.ObtenerMes();

        Integer dia = (Integer) FechaNacimientoDia.getSelectedItem();
        Integer anio = (Integer) FechaNacimientoAnio.getSelectedItem();

        Fecha FN = new Fecha(dia, mes, anio);

        Integer diaI = (Integer) super.getFechaInscripcionDia().getSelectedItem();
        Integer anioI = (Integer) super.getFechaInscripcionAnio().getSelectedItem();
        Integer mesI = super.ObtenerMesInscripcion();

        Fecha FInscripcion = new Fecha(diaI, mesI, anioI);

        Integer diaO = (Integer) super.getFechaInicioOperacionesDia().getSelectedItem();
        Integer anioO = (Integer) super.getFechaInicioOperacionesAnio().getSelectedItem();
        Integer mesO = super.ObtenerMesOperaciones();

        Fecha FOperaciones = new Fecha(diaO, mesO, anioO);

        Fisica fisica = new Fisica(
                new RFC(super.getTxtRFC().getText(),
                        TipoPersona.Fisica),
                txtNombre.getText(),
                txtApellidoPaterno.getText(),
                txtApellidoMaterno.getText(),
                FN,
                super.getTxtTelefono().getText(),
                FInscripcion,
                FOperaciones);

        return fisica;
    }

}
