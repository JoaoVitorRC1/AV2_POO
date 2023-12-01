package br.com.Evento;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando categorias
        Categoria categoriaConcerto = new Categoria("Concerto");
        Categoria categoriaTeatro = new Categoria("Teatro");

        // Criando eventos
        Evento eventoConcerto = new Evento("Concerto A", new Date(), 50.0, "Descrição Concerto A", 100, categoriaConcerto);
        Evento eventoTeatro = new Evento("Peça de Teatro B", new Date(), 30.0, "Descrição Peça de Teatro B", 150, categoriaTeatro);

        // ArrayList de Eventos
        ArrayList<Evento> eventos = new ArrayList<>();
        eventos.add(eventoConcerto);
        eventos.add(eventoTeatro);

        // Criando pedidos e itens de pedido
        PedidoItem item1 = new PedidoItem("Concerto A", 2, 50.0);
        PedidoItem item2 = new PedidoItem("Peça de Teatro B", 3, 30.0);

        ArrayList<PedidoItem> itensPedido1 = new ArrayList<>();
        itensPedido1.add(item1);

        ArrayList<PedidoItem> itensPedido2 = new ArrayList<>();
        itensPedido2.add(item2);

        Pedido pedido1 = new Pedido(1, new Date(), 0.0, 1);
        pedido1.inserirItensPedido(item1);

        Pedido pedido2 = new Pedido(2, new Date(), 0.0, 1);
        pedido2.inserirItensPedido(item2);

        // ArrayList de Pedidos
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);

        // Testando as validações
        System.out.println("Validações:");
        System.out.println("1. Ao inserir um PedidoItem este deverá existir como Evento:");
        for (PedidoItem item : itensPedido1) {
            Evento eventoRelacionado = eventos.stream()
                    .filter(e -> e.getNomeEvento().equals(item.getNomeEvento()))
                    .findFirst()
                    .orElse(null);

            if (eventoRelacionado != null) {
                System.out.println("PedidoItem válido para o evento: " + eventoRelacionado.getNomeEvento());
            } else {
                System.out.println("Erro: PedidoItem inválido para o evento.");
            }
        }

        System.out.println("\n2. A qtdeIngresso deverá ser atualizada após a inserção do Item:");
        for (PedidoItem item : itensPedido1) {
            Evento eventoRelacionado = eventos.stream()
                    .filter(e -> e.getNomeEvento().equals(item.getNomeEvento()))
                    .findFirst()
                    .orElse(null);

            if (eventoRelacionado != null) {
                eventoRelacionado.setQtdIngresso(eventoRelacionado.getQtdIngresso() - item.getQtdIngresso());
                System.out.println("QtdeIngresso atualizada para o evento: " + eventoRelacionado.getNomeEvento());
            } else {
                System.out.println("Erro ao atualizar a qtdeIngresso.");
            }
        }

        System.out.println("\n3. O status do pedido deverá ser atualizado para 2, após a inserção dos itens e atualização do estoque:");
        for (Pedido pedido : pedidos) {
            pedido.alterarStatus(2);
            System.out.println("Status do Pedido " + pedido.getNumeroPedido() + " atualizado para " + pedido.getStatusPedido());
        }

        System.out.println("\n4. Para cada pedido deverá ser calculado o valor total a pagar:");
        for (Pedido pedido : pedidos) {
            pedido.setPrecoTotal(pedido.calculaTotalPagar());
            System.out.println("Total a pagar para o Pedido " + pedido.getNumeroPedido() + ": " + pedido.getPrecoTotal());
        }
    }
}
