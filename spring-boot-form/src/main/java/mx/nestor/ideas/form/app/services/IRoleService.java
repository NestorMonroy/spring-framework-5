package mx.nestor.ideas.form.app.services;

import java.util.List;

import mx.nestor.ideas.form.app.models.domain.Role;


public interface IRoleService {

	public List<Role> listar();
	public Role obtenerPorId(Integer id);
}
