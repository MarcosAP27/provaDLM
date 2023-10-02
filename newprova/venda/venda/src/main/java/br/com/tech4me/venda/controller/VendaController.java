package br.com.tech4me.venda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.venda.service.*;
import br.com.tech4me.venda.shared.*;


@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendasService vendas;

    @PostMapping
    public ResponseEntity<VendasTotalDTO> cadastrarQuadro
    (@RequestBody VendasTotalDTO vendaDto ) {
        return new ResponseEntity<>(vendas.cadastrarVendas(vendaDto), HttpStatus.CREATED);
    }

    @GetMapping
        private ResponseEntity<List<VendasTotalDTO>> obterTodos(){
            return new ResponseEntity<>(vendas.obterTodos(),HttpStatus.OK);
        }

    @GetMapping ("/{id}")
    private ResponseEntity<VendasTotalDTO> obterPorId(@PathVariable String id){
        if(vendas.obterPorId(id).isPresent()){
            return new ResponseEntity<>(vendas.obterPorId(id).get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    private ResponseEntity <VendasTotalDTO> atualizarPorId(@PathVariable String id, @RequestBody VendasTotalDTO venda){
        Optional <VendasTotalDTO> atualizarVenda = vendas.atualizarPorId(id, venda);
        if(atualizarVenda.isPresent()){
            return new ResponseEntity<VendasTotalDTO>(atualizarVenda.get(), null, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
   private ResponseEntity<Void> excluirPorId(@PathVariable String id){
    vendas.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   } 
}