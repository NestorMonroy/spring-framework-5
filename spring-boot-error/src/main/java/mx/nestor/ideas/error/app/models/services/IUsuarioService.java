package mx.nestor.ideas.error.app.models.services;

import java.util.List;
import java.util.Optional;

import mx.nestor.ideas.error.app.models.domain.Usuario;

public interface IUsuarioService {
	public List<Usuario> listar();
	public Usuario obtenerPorId(Integer id);
	public Optional<Usuario> obtenerPorIdOptional(Integer id);

}
