package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Passaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nome;
    String descrizione;

    @OneToMany(mappedBy = "passaggio")
    List<Allegato> allegatoList;

    @ManyToOne
    Manutenzione manutenzione;

    @ManyToOne
    Zona zona;

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Allegato> getAllegatoList() {
        return allegatoList;
    }

    public void setAllegatoList(List<Allegato> allegatoList) {
        this.allegatoList = allegatoList;
    }

    public Manutenzione getManutenzione() {
        return manutenzione;
    }

    public void setManutenzione(Manutenzione manutenzione) {
        this.manutenzione = manutenzione;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
