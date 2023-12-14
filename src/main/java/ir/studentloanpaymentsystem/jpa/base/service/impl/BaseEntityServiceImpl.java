package ir.studentloanpaymentsystem.jpa.base.service.impl;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;
import ir.studentloanpaymentsystem.jpa.base.repository.BaseEntityRepository;
import ir.studentloanpaymentsystem.jpa.base.service.BaseEntityService;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public class BaseEntityServiceImpl<ID extends Serializable, T extends BaseEntity<ID>, R extends BaseEntityRepository<ID, T>>
        implements BaseEntityService<ID, T> {
    protected final R baseRepository;

    public BaseEntityServiceImpl(R baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public T update(T entity, ID id) {
        return baseRepository.update(entity,id);
    }

    @Override
    public Collection<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public void beginTransaction() {
        baseRepository.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        baseRepository.commitTransaction();
    }

    @Override
    public void rollBack() {
        baseRepository.rollBack();
    }
}
