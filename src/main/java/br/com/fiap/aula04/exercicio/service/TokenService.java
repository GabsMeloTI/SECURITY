package br.com.fiap.aula04.exercicio.service;

import br.com.fiap.aula04.exercicio.model.user.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.token.secret}")
    private String senhaToken;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algoritimo = Algorithm.HMAC256(senhaToken);
            return JWT.create().withIssuer("API FIAP")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(Instant.now().plus(Duration.ofHours(2))).sign(algoritimo);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token JWT");
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algoritimo = Algorithm.HMAC256(senhaToken);
            return JWT.require(algoritimo)
                    .withIssuer("API FIAP")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e) {
            throw new RuntimeException("Não foi possível validar o tokenJWT");
        }
    }
}
