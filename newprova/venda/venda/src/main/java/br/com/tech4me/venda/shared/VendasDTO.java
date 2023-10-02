package br.com.tech4me.venda.shared;

import br.com.tech4me.venda.model.*;

public record VendasDTO(String id,
        String clienteNome,
        Double formaDePagamento) {

    public static VendasDTO fromVendas(Venda venda) {
        return new VendasDTO(venda.getId(),venda.getClienteNome(),
                venda.getFormaDePagamento());
    }
}
