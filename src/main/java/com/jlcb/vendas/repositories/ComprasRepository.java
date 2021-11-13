package com.jlcb.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jlcb.vendas.dtos.RankingComprasDTO;
import com.jlcb.vendas.entites.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Integer> {
	
	@Query("SELECT new com.jlcb.vendas.dtos.RankingComprasDTO(compras.cliente, SUM(compras.totalCompra)) "
			+ "FROM Compras AS compras GROUP BY compras.cliente ORDER BY SUM(compras.totalCompra) DESC")
	List<RankingComprasDTO> findRanking();

}
