package it.unisalento.server.entities;

import javax.persistence.*;

@Entity
public class Beacon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nome;
    String mac;

    @OneToOne(mappedBy = "beacon")
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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
