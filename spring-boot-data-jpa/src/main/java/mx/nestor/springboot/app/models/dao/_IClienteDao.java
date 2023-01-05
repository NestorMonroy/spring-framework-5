package mx.nestor.springboot.app.models.dao;

import java.util.List;

import mx.nestor.springboot.app.models.entity.Cliente;

public interface _IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
