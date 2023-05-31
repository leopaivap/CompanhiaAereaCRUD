package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Passageiro extends Pessoa implements Serializable{
    private Integer codPassageiro;
    private double pesoBagagem;
    private boolean elegivel;

    public Integer getCodPassageiro() {
        return codPassageiro;
    }

    public void setCodPassageiro(Integer codPassageiro) {
        this.codPassageiro = codPassageiro;
    }

    public double getPesoBagagem() {
        return pesoBagagem;
    }

    public void setPesoBagagem(double pesoBagagem) {
        this.pesoBagagem = pesoBagagem;
    }

    public boolean isElegivel() {
        return elegivel;
    }

    public void setElegivel(boolean elegivel) {
        this.elegivel = elegivel;
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codPassageiro);
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
        final Passageiro other = (Passageiro) obj;
        if (!Objects.equals(this.codPassageiro, other.codPassageiro)) {
            return false;
        }
        return true;
    }
}
