package com.arsouzas.minhasfinancas.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.arsouzas.minhasfinancas.exception.RegraNegocioException;
import com.arsouzas.minhasfinancas.model.entity.Usuario;
import com.arsouzas.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	//@Test(expected = Test.None.class)

	@Test
	public void deveValidarEmail() {
		assertDoesNotThrow(() -> {
		//cenario
		repository.deleteAll();
		
		//acao
		service.validarEmail("usuario@usuario.com");
		});
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		
		RuntimeException exception = assertThrows( RegraNegocioException.class, () -> {
			//cenario
			Usuario usuario= Usuario.builder().nome("usuario").email("usuario@usuario.com").build();
			repository.save(usuario);
			//acao
			service.validarEmail("usuario@usuario.com");
		});
		
	}

}
