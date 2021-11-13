package com.jlcb.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jlcb.vendas.dtos.ClienteDTO;
import com.jlcb.vendas.entites.Cliente;
import com.jlcb.vendas.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(Integer id, Cliente newCliente) {
		return clienteRepository.findById(id).map(c -> {
			c.setNome(newCliente.getNome());
			c.setDataNascimento(newCliente.getDataNascimento());
			Cliente clienteAtualizado = clienteRepository.save(c);
			return clienteAtualizado;
		}).orElse(newCliente);
	}

	public void deleteCliente(Integer id) {
		try {
			if (clienteRepository.findById(id) != null) {
				clienteRepository.deleteById(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Você não pode deletar essa compra");
		}
	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		Cliente entidade = new Cliente(0, clienteDTO.getNome(), clienteDTO.getDataNascimento());
		return entidade;
	}

}