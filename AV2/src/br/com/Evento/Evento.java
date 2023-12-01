package br.com.Evento;
import java.util.ArrayList;
import java.util.Date;

// Classe Evento
class Evento {
    private String nomeEvento;
    private Date dataEvento;
    private double precoEvento;
    private String descEvento;
    private int qtdIngresso;
    private Categoria categoria;

    // Construtor
    public Evento(String nomeEvento, Date dataEvento, double precoEvento, String descEvento, int qtdIngresso, Categoria categoria) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.precoEvento = precoEvento;
        this.descEvento = descEvento;
        this.qtdIngresso = qtdIngresso;
        this.categoria = categoria;
    }

    // Getters e Setters
    // ...

    // Método buscarEvento
    public boolean buscarEvento(Evento evento) {
        return this.nomeEvento.equals(evento.getNomeEvento());
    }

    // Método inserirEvento
    public void inserirEvento(Evento evento) {
        // Implementação do método inserirEvento
    }
}
