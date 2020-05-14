package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Manutenzione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String status;
    Date data;

    @OneToOne
    Macchinario macchinario;

    @ManyToOne
    Utente utente;

    @OneToMany(mappedBy = "manutenzione")
    List<Passaggio> passaggioList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Macchinario getMacchinario() {
        return macchinario;
    }

    public void setMacchinario(Macchinario macchinario) {
        this.macchinario = macchinario;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Passaggio> getPassaggioList() {
        return passaggioList;
    }

    public void setPassaggioList(List<Passaggio> passaggioList) {
        this.passaggioList = passaggioList;
    }
}
