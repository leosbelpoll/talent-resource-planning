package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.service.BaseService;
import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

public class BaseController<T extends BaseEntity> {

    BaseService service;

    public BaseController(BaseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> list = service.getAll();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<T> updateRole(@RequestBody @Valid T item) {
        try {
            T updatedItem = (T) service.update(item);
            return new ResponseEntity<>(updatedItem, new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Item already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping(Mappings.TRASH)
    public ResponseEntity<T> trash(@PathVariable("id") Long id) {
        try {
            service.trash(id);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Item already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping(Mappings.REMOVE)
    public ResponseEntity<T> remove(@PathVariable("id") Long id) {
        try {
            service.remove(id);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Item already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
