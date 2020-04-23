package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.entity.BaseEntity;
import com.leito.talentresourceplanning.service.BaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Get item list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200)
    })
    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> list = service.getAll();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update item")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200),
            @ApiResponse(code = 404, message = StatusCodesMessages.STATUS_CODE_404),
            @ApiResponse(code = 409, message = StatusCodesMessages.STATUS_CODE_409),
            @ApiResponse(code = 500, message = StatusCodesMessages.STATUS_CODE_500)
    })
    @PutMapping
    public ResponseEntity<T> update(@RequestBody @Valid T item) {
        try {
            T updatedItem = (T) service.update(item);
            return new ResponseEntity<>(updatedItem, new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Trash item")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200),
            @ApiResponse(code = 404, message = StatusCodesMessages.STATUS_CODE_404),
            @ApiResponse(code = 500, message = StatusCodesMessages.STATUS_CODE_500)
    })
    @PostMapping(Mappings.TRASH)
    public ResponseEntity<T> trash(@PathVariable("id") Long id) {
        try {
            service.trash(id);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Remove item")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200),
            @ApiResponse(code = 404, message = StatusCodesMessages.STATUS_CODE_404),
            @ApiResponse(code = 500, message = StatusCodesMessages.STATUS_CODE_500)
    })
    @PostMapping(Mappings.REMOVE)
    public ResponseEntity<T> remove(@PathVariable("id") Long id) {
        try {
            service.remove(id);
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
