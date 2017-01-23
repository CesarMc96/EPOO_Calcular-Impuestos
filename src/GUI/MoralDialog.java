
package GUI;

import Enum.TipoPersona;
import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Excepciones.RFCException;
import Modelo.Moral;
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

public class MoralDialog extends PersonaDialog{

    private final Integer[] FCreacionDia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private final String[] FCreacionMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final Integer[] FCreacionAnio = {1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
    private final JLabel lblRazonSocial;
    private final JTextField txtRazonSocial;
    private final JLabel lblTipoSociedad;
    private final JTextField txtTipoSociedad;
    private final JLabel lblFechaCreacion;
    private final JComboBox FechaCreacionDia;
    private final JComboBox FechaCreacionAnio;
    private final JComboBox FechaCreacionMes;
    private final JPanel pnlMoral;
    private final JPanel pnlMoralArriba;
    private final JPanel pnlMoralEnmedio;
    
    public MoralDialog(Frame frame) {
        super(frame);
        super.setTitle("Persona MORAL");
        
        lblRazonSocial = new JLabel("Razon Social: ");
        txtRazonSocial = new JTextField(10);

        lblTipoSociedad = new JLabel("Tipo de Sociedad: ");
        txtTipoSociedad = new JTextField(8);
        
        lblFechaCreacion = new JLabel("Fecha Nacimiento: ");
        FechaCreacionDia = new JComboBox(FCreacionDia);
        FechaCreacionMes = new JComboBox(FCreacionMes);
        FechaCreacionAnio = new JComboBox(FCreacionAnio);
        
        pnlMoral = new JPanel();
        pnlMoral.setLayout(new BorderLayout());
        
        pnlMoralArriba = new JPanel();
        pnlMoralArriba.add(lblRazonSocial);
        pnlMoralArriba.add(txtRazonSocial);
        pnlMoralArriba.add(lblTipoSociedad);
        pnlMoralArriba.add(txtTipoSociedad);
        pnlMoralArriba.setBackground(Color.WHITE);
        
        pnlMoralEnmedio = new JPanel();
        pnlMoralEnmedio.add(lblFechaCreacion);
        pnlMoralEnmedio.add(FechaCreacionDia);
        pnlMoralEnmedio.add(FechaCreacionMes);
        pnlMoralEnmedio.add(FechaCreacionAnio);
        pnlMoralEnmedio.setBackground(Color.WHITE);
        
        pnlMoral.add(pnlMoralArriba, BorderLayout.PAGE_START);
        pnlMoral.add(pnlMoralEnmedio, BorderLayout.CENTER);
       
        
        super.getPnlCentroArriba().add(pnlMoral);
    }

    public Integer ObtenerMes() {
        Integer mes = 0;

        if (FechaCreacionMes.getSelectedItem() == "Enero") {
            mes = 1;
        }
        if (FechaCreacionMes.getSelectedItem() == "Febrero") {
            mes = 2;
        }
        if (FechaCreacionMes.getSelectedItem() == "Marzo") {
            mes = 3;
        }
        if (FechaCreacionMes.getSelectedItem() == "Abril") {
            mes = 4;
        }
        if (FechaCreacionMes.getSelectedItem() == "Mayo") {
            mes = 5;
        }
        if (FechaCreacionMes.getSelectedItem() == "Junio") {
            mes = 6;
        }
        if (FechaCreacionMes.getSelectedItem() == "Julio") {
            mes = 7;
        }
        if (FechaCreacionMes.getSelectedItem() == "Agosto") {
            mes = 8;
        }
        if (FechaCreacionMes.getSelectedItem() == "Septiembre") {
            mes = 9;
        }
        if (FechaCreacionMes.getSelectedItem() == "Octubre") {
            mes = 10;
        }
        if (FechaCreacionMes.getSelectedItem() == "Noviembre") {
            mes = 11;
        }
        if (FechaCreacionMes.getSelectedItem() == "Diciembtre") {
            mes = 12;
        }

        return mes;
    }

    @Override
    protected Persona crearObjeto() throws IntervalosFechaException, PersonaFisicaException, RFCException {

        Integer mes = this.ObtenerMes();

        Integer dia = (Integer) FechaCreacionDia.getSelectedItem();
        Integer anio = (Integer) FechaCreacionAnio.getSelectedItem();

        Fecha FC = new Fecha(dia, mes, anio);

        Integer diaI = (Integer) super.getFechaInscripcionDia().getSelectedItem();
        Integer anioI = (Integer) super.getFechaInscripcionAnio().getSelectedItem();
        Integer mesI = super.ObtenerMesInscripcion();

        Fecha FInscripcion = new Fecha(diaI, mesI, anioI);

        Integer diaO = (Integer) super.getFechaInicioOperacionesDia().getSelectedItem();
        Integer anioO = (Integer) super.getFechaInicioOperacionesAnio().getSelectedItem();
        Integer mesO = super.ObtenerMesOperaciones();

        Fecha FOperaciones = new Fecha(diaO, mesO, anioO);

        Moral moral = new Moral(
                new RFC(super.getTxtRFC().getText(),TipoPersona.Fisica),
                txtRazonSocial.getText(),
                txtTipoSociedad.getText(),
                null,
                super.getTxtTelefono().getText(),
                FInscripcion,
                FOperaciones,
                FC);

        return moral;
    }

}
