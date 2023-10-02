package br.com.tech4me.venda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.venda.httpClient.QuadroClient;
import br.com.tech4me.venda.model.*;
import br.com.tech4me.venda.repository.*;
import br.com.tech4me.venda.shared.*;

@Service
public class VendasServiceImpl implements VendasService {

    @Autowired
    private VendasRepository repositorio;
    @Autowired
    private QuadroClient client;

    @Override
    public VendasTotalDTO cadastrarVendas(VendasTotalDTO vendasDto) {
        Venda venda = Venda.fromVendasTotalDTO(vendasDto);
        repositorio.save(venda);
        return VendasTotalDTO.fromVendas(venda);
    }

    @Override
    public Optional<VendasTotalDTO> obterPorId(String id) {
        Optional<Venda> venda = repositorio.findById(id);
        if (venda.isPresent()) {
            VendasTotalDTO vendasTotalDTO = VendasTotalDTO.fromVendas(venda.get());
            QuadroDTO quadroDTO = client.buscarQuadroId(vendasTotalDTO.id());
            return Optional.of(vendasTotalDTO);
        }
    
        return Optional.empty();
    }


    @Override
    public List<VendasTotalDTO> obterTodos() {
        return repositorio.findAll().stream().map(p -> VendasTotalDTO.fromVendas(p)).toList();
    }

    @Override
    public Optional<VendasTotalDTO> atualizarPorId(String id, VendasTotalDTO vendaDTO) {
        Optional<Venda> vendaFeita = repositorio.findById(id);
    
        if (vendaFeita.isPresent()) {
            Venda vendaAtualizada = vendaFeita.get();
    
            vendaAtualizada.setClienteNome(vendaDTO.clienteNome());
            vendaAtualizada.setFormaDePagamento(vendaDTO.formaDePagamento());
            Venda vendaSalva = repositorio.save(vendaAtualizada);
            return Optional.of(VendasTotalDTO.fromVendas(vendaSalva));
        }
    
        return Optional.empty();
    }
    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }

}
