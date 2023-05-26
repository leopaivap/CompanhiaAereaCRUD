package modelo;

import java.util.Calendar;
import java.util.Objects;

public class Piloto extends Pessoa {
    private int codPiloto;
    private double salario;
    private Calendar dataAdmissao;

    public int getCodPiloto() {
        return codPiloto;
    }

    public double getSalario() {
        return salario;
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setCodPiloto(int codPiloto) {
        this.codPiloto = codPiloto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codPiloto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piloto other = (Piloto) obj;
        if (!Objects.equals(this.codPiloto, other.codPiloto)) {
            return false;
        }
        return true;
    }
}
