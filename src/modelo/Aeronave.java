package modelo;

import java.io.Serializable;
import java.util.Objects;


public class Aeronave implements Serializable{
    private String nomeAviao;
    private int qtdAssento;
    private Integer codAeronave;
    private double autonomia, capacidadeCarga;

    public String getNomeAviao() {
        return nomeAviao;
    }

    public void setNomeAviao(String nomeAviao) {
        this.nomeAviao = nomeAviao;
    }

    public int getQtdAssento() {
        return qtdAssento;
    }

    public void setQtdAssento(int qtdAssento) {
        this.qtdAssento = qtdAssento;
    }

    public Integer getCodAeronave() {
        return codAeronave;
    }

    public void setCodAeronave(int codAeronave) {
        this.codAeronave = codAeronave;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    
     
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codAeronave);
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
        final Aeronave other = (Aeronave) obj;
        if (!Objects.equals(this.codAeronave, other.codAeronave)) {
            return false;
        }
        return true;
    }
}
