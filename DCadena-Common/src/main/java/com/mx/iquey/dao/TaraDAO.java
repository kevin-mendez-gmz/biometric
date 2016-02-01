package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.TaraTO;

public interface TaraDAO {

	public void insert(TaraTO taraTO);

	public void update(TaraTO taraTO);

	public void delete(TaraTO taraTO);

	public List<TaraTO> getAll();

}
