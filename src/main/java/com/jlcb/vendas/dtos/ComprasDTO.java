package com.jlcb.vendas.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.jlcb.vendas.entites.Compras;

public class ComprasDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private Double totalCompra;

	private LocalDate dataCompra;

	private ClienteDTO cliente;

	public ComprasDTO() {

	}

	public ComprasDTO(Compras entidade) {
		this.id = entidade.getId();
		this.totalCompra = entidade.getTotalCompra();
		this.dataCompra = entidade.getDataCompra();
		this.cliente = new ClienteDTO(entidade.getCliente());
	}

	public ComprasDTO(int id, Double totalCompra, LocalDate dataCompra, ClienteDTO cliente) {
		this.id = id;
		this.totalCompra = totalCompra;
		this.dataCompra = dataCompra;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

}
