package com.tads.ecommerce.services;

import com.tads.ecommerce.dtos.ProductDTO;
import com.tads.ecommerce.entities.Product;
import com.tads.ecommerce.repositories.ProductRepository;
import com.tads.ecommerce.services.exceptions.DatabaseException;
import com.tads.ecommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return new ProductDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado.")));
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(), productDTO.getImgUrl());
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso nao encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integrigadade referencial");
        }
    }


    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }

}
