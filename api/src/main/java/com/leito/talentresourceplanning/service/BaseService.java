package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.entity.LifeState;
import javassist.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity> {
    private JpaRepository<T, Long> repository;

    public BaseService(JpaRepository repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        List<T> list = repository.findAll();

        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    public T getById(Long id) throws NotFoundException {
        Optional<T> item = repository.findById(id);

        if (item.isPresent()) {
            return item.get();
        } else {
            throw new NotFoundException("No record exist for given id");
        }
    }

    public T create(T item) {
        T newItem = repository.save(item);

        return newItem;
    }

    public T update(T item) throws NotFoundException {
        Optional<T> optionalUser = repository.findById(item.getId());

        if (optionalUser.isPresent()) {
            T newItem = repository.save(item);

            return newItem;
        } else {
            throw new NotFoundException("No record exist for given id");
        }
    }

    public void trash(Long id) throws NotFoundException {
        Optional<T> optionalItem = repository.findById(id);
        if (!optionalItem.isPresent()) {
            throw new NotFoundException("No record exist for given id");
        }

        T item = optionalItem.get();
        item.setLifeState(LifeState.TRASHED, "TRASHED");
        item.setTrashedAt(new Date());

        repository.save(item);
    }

    public void remove(Long id) throws NotFoundException {
        Optional<T> optionalItem = repository.findById(id);
        if (!optionalItem.isPresent()) {
            throw new NotFoundException("No record exist for given id");
        }

        T item = optionalItem.get();
        item.setLifeState(LifeState.REMOVED, "REMOVED");
        item.setRemovedAt(new Date());

        repository.save(item);
    }
}
