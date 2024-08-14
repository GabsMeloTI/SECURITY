package br.com.fiap.aula04.exercicio.controller;

import br.com.fiap.aula04.exercicio.dto.usuario.CadastroUsuarioDto;
import br.com.fiap.aula04.exercicio.dto.usuario.DetalhesUsuarioDto;
import br.com.fiap.aula04.exercicio.model.user.Usuario;
import br.com.fiap.aula04.exercicio.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;


}
