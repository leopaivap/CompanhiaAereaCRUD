package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Aeroporto implements Serializable{
    private String nomeAeroporto;
    private Integer codAeroporto;

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public void setNomeAeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public Integer getCodAeroporto() {
        return codAeroporto;
    }

    public void setCodAeroporto(int codAeroporto) {
        this.codAeroporto = codAeroporto;
    }
     
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codAeroporto);
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
        final Aeroporto other = (Aeroporto) obj;
        if (!Objects.equals(this.codAeroporto, other.codAeroporto)) {
            return false;
        }
        return true;
    }
}
