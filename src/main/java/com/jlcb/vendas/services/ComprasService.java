package com.jlcb.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jlcb.vendas.dtos.ComprasDTO;
import com.jlcb.vendas.dtos.RankingComprasDTO;
import com.jlcb.vendas.entites.Cliente;
import com.jlcb.vendas.entites.Compras;
import com.jlcb.vendas.repositories.ClienteRepository;
import com.jlcb.vendas.repositories.ComprasRepository;

@Service
public class ComprasService {
	
	@Autowired
	private ComprasRepository comprasRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ComprasDTO> findAll() {
		clienteRepository.findAll();
		List<Compras> compras = comprasRepository.findAll();
		return compras.stream().map(c -> new ComprasDTO(c)).collect(Collectors.toList());
	}

	public Compras saveCompras(Compras compras) {
		return comprasRepository.save(compras);
	}
	
	public Compras updateCompras(Integer id, Compras newCompras) {
		return comprasRepository.findById(id).map(c -> {
			c.setTotalCompra(newCompras.getTotalCompra());
			c.setDataCompra(newCompras.getDataCompra());
			Compras comprasAtualizada = comprasRepository.save(c);
			return comprasAtualizada;
		}).orElse(null);
	}
	
	public void deleteCompras(Integer id) {
		try {
			if (comprasRepository.findById(id) != null) {
				comprasRepository.deleteById(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Você não pode deletar um cliente que possui compras");
		}
	}
	
	public List<RankingComprasDTO> findRanking() {
		List<RankingComprasDTO> rankingComprasDTOs = comprasRepository.findRanking();
		return rankingComprasDTOs;
	}
	
	public Compras fromDTO(ComprasDTO comprasDTO) {
		Compras entidade = new Compras(0, comprasDTO.getTotalCompra(), comprasDTO.getDataCompra(), new Cliente(comprasDTO.getCliente().getId(), null, null));
		return entidade;
	}

}
