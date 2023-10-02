package br.com.tech4me.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.venda.model.*;

@Repository
public interface VendasRepository extends JpaRepository <Venda, String>{

    
    
}
