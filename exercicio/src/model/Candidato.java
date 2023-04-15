package model;

import model.Cargo;
import model.Partido;
public class Candidato {
    private int numero;
    private String nome;
    private Partido partido;
    private Cargo cargo;

    public void mostrarDadosCandidato(){
        System.out.println("\n Nemero: " + getNumero() +
                "\n Nome: " + getNome()+
                "\n Partido: "+
                        "\n Nome: "+ getPartido().getNome()+
                        "\n Sigla: "+ getPartido().getSigla()+
                        "\n Numero: "+ getPartido().getNumero()+
                "\n Cargo: "+ getCargo().getCargo()
                );
    }

    public Candidato() {
    }

    public Candidato(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public Candidato(int numero, String nome, Partido partido, Cargo cargo) {
        this.numero = numero;
        this.nome = nome;
        this.partido = partido;
        this.cargo = cargo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
