package Objetos;

import java.util.Calendar;

public class Fecha {

    private Integer dia;
    private Integer mes;
    private Integer anio;

    public Fecha(Integer dia, Integer mes, Integer anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha() {
        Calendar c1 = Calendar.getInstance();

        dia = c1.get(Calendar.DAY_OF_MONTH);
        mes = c1.get(Calendar.MONTH) + 1;
        anio = c1.get(Calendar.YEAR);
//        Date date = new Date();
//        dia = date.getDay() + 1;
//        mes = date.getMonth() + 1;
//        anio = date.getYear() + 1900;
    }

    public boolean fechaValida() {
        int diaAuxiliar = 0;

        if ((anio >= 1900) && (anio <= 2100)) {
            if ((mes > 0) && (mes < 13)) {
                switch (mes) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        diaAuxiliar = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        diaAuxiliar = 30;
                        break;
                    case 2:
                        diaAuxiliar = anio % 4 == 0 ? 29 : 28;
                        break;
                }

                if ((dia >= 1) && (dia < diaAuxiliar)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void diaFeriado(Integer dia, Integer mes, Integer anio) {

    }

    public void aumentar() {
        int diaAuxiliar = 0;
        dia++;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diaAuxiliar = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaAuxiliar = 30;
                break;
            case 2:
                diaAuxiliar = anio % 4 == 0 ? 29 : 28;
                break;
        }

        if (dia > diaAuxiliar) {
            mes++;
        }
        if (mes > 12) {
            anio++;
        }
    }

    public void aumentar(Integer opcional) {
        int diaAuxiliar = 0;
        dia = dia + opcional;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diaAuxiliar = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaAuxiliar = 30;
                break;
            case 2:
                diaAuxiliar = anio % 4 == 0 ? 29 : 28;
                break;
        }

        if (dia > diaAuxiliar) {
            dia = dia - diaAuxiliar;
            mes++;
        }
        if (mes > 12) {
            anio++;
        }
    }

    public void disminuir() {
        int diaAuxiliar = 0;
        dia--;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diaAuxiliar = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaAuxiliar = 30;
                break;
            case 2:
                diaAuxiliar = anio % 4 == 0 ? 29 : 28;
                break;
        }

        if (dia <= 0) {
            mes--;
            dia = diaAuxiliar;
        }
        if (mes <= 0) {
            anio--;
            mes = 12;
        }
    }

    public void disminuir(Integer opcional) {
        int diaAuxiliar = 0;
        dia = dia - opcional;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diaAuxiliar = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaAuxiliar = 30;
                break;
            case 2:
                diaAuxiliar = anio % 4 == 0 ? 29 : 28;
                break;
        }

        if (dia <= 0) {
            mes--;
            dia = diaAuxiliar + dia;
        }
        if (mes <= 0) {
            anio--;
            mes = 12;
        }
    }

    public String diaSemana() {
        int a = 0, b = 0, c = 0, d = 0, e = 0, na = 0;

        if (anio >= 1900 && anio <= 1999) {
            a = 1;
            na = anio - 1900;
        }
        if (anio >= 2000 && anio <= 2099) {
            a = 0;
            na = anio - 2000;
        }
        if (anio >= 2100 && anio <= 2199) {
            a = -2;
            na = anio - 2100;
        }
        if (anio >= 2200 && anio <= 2299) {
            a = -4;
            na = anio - 2200;
        }

        b = (na / 4) + na;

        if (anio % 4 == 0 && mes == 1 || mes == 2) {
            c = -1;
        } else {
            c = 0;
        }

        switch (mes) {
            case 1:
            case 10:
                d = 6;
                break;
            case 2:
            case 3:
            case 11:
                d = 2;
                break;
            case 4:
            case 7:
                d = 5;
                break;
            case 5:
                d = 0;
                break;
            case 6:
                d = 3;
                break;
            case 8:
                d = 1;
                break;
            case 9:
            case 12:
                d = 4;
                break;
        }

        e = dia;

        int total = a + b + c + d + e;
        do {
            total = total - 7;
        } while (total > 0 && total < 8);

        String semana = null;

        switch (total) {
            case 1:
                semana = "lunes";
                break;
            case 2:
                semana = "martes";
                break;
            case 3:
                semana = "miercoles";
                break;
            case 4:
                semana = "jueves";
                break;
            case 5:
                semana = "viernes";
                break;
            case 6:
                semana = "sabado";
                break;
            case 7:
                semana = "domingo";
                break;
        }

        return semana;
    }

    @Override
    public String toString() {

        return String.format("%d/%d/%d", dia, mes, anio);
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

}

//agregar dias inhabiles
