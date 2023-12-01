package br.com.Evento;

class PedidoItem {
    private String nomeEvento;
    private int qtdIngresso;
    private double precoIngresso;

    // Construtor
    public PedidoItem(String nomeEvento, int qtdIngresso, double precoIngresso) {
        this.nomeEvento = nomeEvento;
        this.qtdIngresso = qtdIngresso;
        this.precoIngresso = precoIngresso;
    }

    // Getters e Setters
    // ...

    // Método atualizaEstoqueIngresso
    public boolean atualizaEstoqueIngresso() {
        // Implementação do método atualizaEstoqueIngresso
        return true;
    }
}