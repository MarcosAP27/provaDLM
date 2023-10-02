package br.com.tech4me.venda.service;

import java.util.List;
import java.util.Optional;
import br.com.tech4me.venda.shared.*;

public interface VendasService {
   VendasTotalDTO cadastrarVendas(VendasTotalDTO vendas);
   Optional<VendasTotalDTO> obterPorId(String id);
   List<VendasTotalDTO> obterTodos();
   Optional<VendasTotalDTO> atualizarPorId(String id, VendasTotalDTO venda);
   void excluirPorId(String id);
    
}
