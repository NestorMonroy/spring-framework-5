package mx.nestor.ideas.form.app.services;

import java.util.List;

import mx.nestor.ideas.form.app.models.domain.Pais;

public interface IPaisService {
	public List<Pais> listar();
	public Pais obtenerPorId(Integer id);
}
