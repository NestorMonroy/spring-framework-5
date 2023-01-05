package mx.nestor.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.nestor.springboot.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

}
