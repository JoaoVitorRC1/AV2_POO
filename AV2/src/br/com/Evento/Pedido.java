package br.com.Evento;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

class Pedido {
    private int numeroPedido;
    private Date dataHorarioPedido;
    private double precoTotal;
    private int statusPedido;
    private ArrayList<PedidoItem> itensPedido = new ArrayList<>();

    // Construtor
    public Pedido(int numeroPedido, Date dataHorarioPedido, double precoTotal, int statusPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHorarioPedido = dataHorarioPedido;
        this.precoTotal = precoTotal;
        this.statusPedido = statusPedido;
    }

    // Getters e Setters
    // ...

    // Método inserirPedido
    public void inserirPedido(Pedido pedido) {
        // Implementação do método inserirPedido
    }

    // Método alterarStatus
    public void alterarStatus(int novoStatus) {
        this.statusPedido = novoStatus;
    }

    // Método consultarPedido
    public boolean consultarPedido(Pedido pedido) {
        return this.numeroPedido == pedido.getNumeroPedido();
    }

    // Método inserirItensPedido
    public void inserirItensPedido(PedidoItem item) {
        itensPedido.add(item);
    }

    // Método excluirItensPedido
    public void excluirItensPedido(PedidoItem item) {
        itensPedido.remove(item);
    }

    // Método calculaTotalPagar
    public double calculaTotalPagar() {
        double total = 0;
        for (PedidoItem item : itensPedido) {
            total += item.getPrecoIngresso();
        }
        return total;
    }
}
