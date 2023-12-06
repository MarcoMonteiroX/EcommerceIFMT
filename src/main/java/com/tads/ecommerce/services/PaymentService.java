package com.tads.ecommerce.services;

import com.tads.ecommerce.dtos.PaymentDTO;
import com.tads.ecommerce.entities.Order;
import com.tads.ecommerce.entities.Payment;
import com.tads.ecommerce.repositories.OrderRepository;
import com.tads.ecommerce.repositories.PaymentRepository;
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
public class PaymentService {

    @Autowired
    private PaymentRepository repository;
    @Autowired
    private OrderRepository orderRepository;

    public PaymentDTO findById(Long id) {
        return new PaymentDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado")));
    }

    @Transactional(readOnly = true)
    public Page<PaymentDTO> findAll(Pageable pageable) {
        Page<Payment> payments = repository.findAll(pageable);
        return payments.map(PaymentDTO::new);
    }

    @Transactional
    public PaymentDTO insert(PaymentDTO dto) {
        Payment entity = new Payment();
        entity.setMoment(dto.getMoment());
        //entity.setOrder(dto.getOrder());

        entity = repository.save(entity);
        return new PaymentDTO(entity);
    }


    @Transactional
    public PaymentDTO update(Long id, PaymentDTO dto) {
        try {
            Payment entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new PaymentDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
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

    private void copyDtoToEntity(PaymentDTO dto, Payment entity) {
        Order order = orderRepository.getReferenceById(dto.getOrder());
        entity.setMoment(dto.getMoment());
        entity.setOrder(order);
    }
}
