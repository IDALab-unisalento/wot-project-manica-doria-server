package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nome;

    @OneToMany(mappedBy = "zona")
    List<Passaggio> passaggioList;

    @ManyToOne
    Macchinario macchinario;

    @OneToOne
    Beacon beacon;

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

    public List<Passaggio> getPassaggioList() {
        return passaggioList;
    }

    public void setPassaggioList(List<Passaggio> passaggioList) {
        this.passaggioList = passaggioList;
    }

    public Macchinario getMacchinario() {
        return macchinario;
    }

    public void setMacchinario(Macchinario macchinario) {
        this.macchinario = macchinario;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = beacon;
    }
}
