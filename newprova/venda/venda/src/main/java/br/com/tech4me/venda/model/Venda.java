package br.com.tech4me.venda.model;

import br.com.tech4me.venda.shared.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "loja", name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String clienteNome;
    private String cpf;
    private Double formaDePagamento;

    public Venda() {
    }

    public static Venda fromVendasTotalDTO (VendasTotalDTO vendasTotalDTO) {
        Venda venda = new Venda();
        venda.setId(vendasTotalDTO.id());
        venda.setClienteNome(vendasTotalDTO.clienteNome());
        venda.setCpf(vendasTotalDTO.cpf());
        venda.setFormaDePagamento(vendasTotalDTO.formaDePagamento());

        return venda;
    }

    public static Venda fromVendaDTO (VendasDTO vendasDTO) {
        Venda venda = new Venda();
        venda.setId(vendasDTO.id());
        venda.setClienteNome(vendasDTO.clienteNome());
        venda.setFormaDePagamento(vendasDTO.formaDePagamento());

        return venda;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(Double formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

}
