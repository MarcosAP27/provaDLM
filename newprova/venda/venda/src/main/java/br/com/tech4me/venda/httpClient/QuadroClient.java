package br.com.tech4me.venda.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.tech4me.venda.shared.QuadroDTO;


@FeignClient("venda")
public interface QuadroClient {
    @RequestMapping(method = RequestMethod.GET, value ="/quadros/{id}")
    QuadroDTO buscarQuadroId(@PathVariable String id);
    
}
