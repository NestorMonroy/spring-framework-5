package mx.nestor.ideas.error.app.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.nestor.ideas.error.app.models.domain.Usuario;
@Service
public class UsuarioServiceImpl implements IUsuarioService{

	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1,"Usuario1", "Usuario1"));
		this.lista.add(new Usuario(2,"Usuario2", "Usuario2"));
		this.lista.add(new Usuario(3,"Usuario3", "Usuario3"));
		this.lista.add(new Usuario(4,"Usuario4", "Usuario4"));
		this.lista.add(new Usuario(5,"Usuario5", "Usuario5"));
		this.lista.add(new Usuario(6,"Usuario6", "Usuario6"));
		this.lista.add(new Usuario(7,"Usuario7", "Usuario7"));

	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for(Usuario u : this.lista) {
			if(u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}
		
		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
