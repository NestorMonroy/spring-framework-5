package mx.nestor.ideas.di.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import mx.nestor.ideas.di.app.models.service.IServicio;
import mx.nestor.ideas.di.app.models.service.MiServicio;
import mx.nestor.ideas.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {
	
	
	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
}
