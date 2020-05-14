package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Macchinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nome;

    @OneToOne(mappedBy = "macchinario")
    Manutenzione manutenzione;

    @OneToMany(mappedBy = "macchinario")
    List<Zona> zonaList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Manutenzione getManutenzione() {
        return manutenzione;
    }

    public void setManutenzione(Manutenzione manutenzione) {
        this.manutenzione = manutenzione;
    }

    public List<Zona> getZonaList() {
        return zonaList;
    }

    public void setZonaList(List<Zona> zonaList) {
        this.zonaList = zonaList;
    }
}
