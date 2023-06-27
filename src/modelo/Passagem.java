package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Passagem implements Serializable{
    private Integer codPassagem;
    private int numeroPoltrona;
    private double pesoBagagem, valorPassagem;
    private Voo voo;

    public Integer getCodPassagem() {
        return codPassagem;
    }

    public void setCodPassagem(Integer codPassagem) {
        this.codPassagem = codPassagem;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public int getNumeroPoltrona() {
        return numeroPoltrona;
    }

    public void setNumeroPoltrona(int numeroPoltrona) {
        this.numeroPoltrona = numeroPoltrona;
    }

    public double getPesoBagagem() {
        return pesoBagagem;
    }

    public void setPesoBagagem(double pesoBagagem) {
        this.pesoBagagem = pesoBagagem;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.codPassagem);
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
        final Passagem other = (Passagem) obj;
        if (!Objects.equals(this.codPassagem, other.codPassagem)) {
            return false;
        }
        return true;
    }
    
}
