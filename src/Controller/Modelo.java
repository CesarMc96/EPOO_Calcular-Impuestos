
package Controller;

import Modelo.Persona;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Modelo extends AbstractTableModel {

    private final ArrayList<Persona> coleccion;

    public Modelo(ArrayList<Persona> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getRfc();
            case 1:
                return temporal.getFechaInicioOperaciones();
            case 2:
                return temporal.getFechaInscripcion();
            case 3:
                return temporal.getTelefono();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "RFC";
            case 1:
                return "Inicio Operaciones";
            case 2:
                return "Inscripcion";
            case 3:
                return "Telefono";
            default:
                throw new AssertionError();
        }
    }

}
