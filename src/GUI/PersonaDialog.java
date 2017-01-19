
package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PersonaDialog extends JDialog{

    private final JPanel pnlBotones;
    private final JButton btnAceptar;
    private final JButton btnCancelar;
    private final JPanel pnlAdentro;
    private final JLabel lblInscripcion;
    private final JPanel pnlArriba;

    public PersonaDialog(Frame frame) {
        super(frame, true);
        super.setSize(450, 450);
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
        
        
        
        pnlAdentro.add(btnAceptar);
        pnlAdentro.add(btnCancelar);
        pnlBotones.add(pnlAdentro, BorderLayout.EAST);
        
        super.add(pnlArriba, BorderLayout.PAGE_START);
        super.add(pnlBotones, BorderLayout.PAGE_END);
    }
    
}
