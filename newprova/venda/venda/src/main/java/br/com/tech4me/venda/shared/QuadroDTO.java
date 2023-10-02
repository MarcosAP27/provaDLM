package br.com.tech4me.venda.shared;

import br.com.tech4me.venda.model.Quadro;

public record QuadroDTO(String id, String nomeQuadro, Double valor) {
    public static QuadroDTO fromQuadroDTO(Quadro dto){
        return new QuadroDTO(dto.getId(), dto.getNomeQuadro(), dto.getValor());
    }
}
