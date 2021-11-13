package com.jlcb.vendas.dtos;

import com.jlcb.vendas.entites.Cliente;

public class ClienteDTO {
	

	private int id;
	
	private String nome;
	
	private String dataNascimento;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.dataNascimento = entidade.getDataNascimento();
	}

	
	public ClienteDTO(int id, String nome, String dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
