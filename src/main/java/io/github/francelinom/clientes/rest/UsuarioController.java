package io.github.francelinom.clientes.rest;

import io.github.francelinom.clientes.exception.UsuarioCadastradoException;
import io.github.francelinom.clientes.model.entity.Usuario;
import io.github.francelinom.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
        try {
            usuarioService.salvar(usuario);
        } catch (UsuarioCadastradoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
