package ir.studentloanpaymentsystem.jpa.base.service;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface BaseEntityService<ID extends Serializable, T extends BaseEntity<ID>> {
    T save(T entity);

    void deleteById(ID id);

    public T update(T entity, ID id);

    Collection<T> findAll();

    Optional<T> findById(ID id);

    void beginTransaction();

    void commitTransaction();

    void rollBack();
}
