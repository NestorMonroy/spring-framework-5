package mx.nestor.ideas.error.app.errors;

public class UsuarioNoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 2892568597686347024L;

	public UsuarioNoEncontradoException(String id) {
		super("Usuario con ID: ".concat(id).concat(" no existe en el sistema"));
	}

}
