package com.mx.iquey.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface GenericDAO<T, ID> {

    public void guardar(final T vo);

    public void actualizar(final T vo);

    public void borrar(final T vo);

    public List<T> buscar();

    public T executeQuery(String query);

    public List<T> executeQueryGetList(String query);

    public T getTByCriteria(DetachedCriteria criteria);

    public List<T> getListByCriteria(DetachedCriteria criteria);

    public List<Integer> getIntegerByCriteria(DetachedCriteria criteria);
}
