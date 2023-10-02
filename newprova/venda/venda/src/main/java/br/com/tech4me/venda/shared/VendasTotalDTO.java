package br.com.tech4me.venda.shared;

import br.com.tech4me.venda.model.*;

public record VendasTotalDTO(String clienteNome,
        String cpf,
        String id,
        Double formaDePagamento) {

            public static VendasTotalDTO fromVendas(Venda venda){
                return new VendasTotalDTO(venda.getClienteNome(),venda.getCpf(),
                venda.getId(),venda.getFormaDePagamento());
            }
}