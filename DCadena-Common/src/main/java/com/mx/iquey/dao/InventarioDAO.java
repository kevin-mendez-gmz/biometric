package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.InventarioTO;

public interface InventarioDAO {
	
	public static final String QUERY_DELETE_INVENTARIO = "delete from InventarioTO where fecha is not null AND fecha != :fecha ";

	public void insert(InventarioTO inventarioTO);

	public void update(InventarioTO inventarioTO);

	public void delete(InventarioTO inventarioTO);

	public List<InventarioTO> getAll();

	public List<InventarioTO> getInventarioByPieza(int idTipoPieza);
	
	public InventarioTO getInventarioByPiezaAndLote(int idTipoPieza , int lote);
	
	public InventarioTO getInventarioByPiezaAndComentario(int idTipoPieza , String comentario);
	
	public void deleteInventarioIsNotDate(InventarioTO inventarioTO);

}
