package br.com.fiap.aula04.exercicio.controller;

import br.com.fiap.aula04.exercicio.dto.autenticacao.DadosAutenticacaoDto;
import br.com.fiap.aula04.exercicio.dto.autenticacao.DadosTokenJwtDto;
import br.com.fiap.aula04.exercicio.model.user.Usuario;
import br.com.fiap.aula04.exercicio.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJwtDto> login(@RequestBody DadosAutenticacaoDto dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = authenticationManager.authenticate(token);
        var tokenJwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJwtDto(tokenJwt));
    }
}

