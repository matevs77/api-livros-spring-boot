package com.example.biblioteca;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    // 1. Listar todos os livros
    @GetMapping
    public List<Livro> listarTodos() {
        return service.listarTodos();
    }

    // 2. Buscar um livro pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Criar um novo livro
    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return service.salvar(livro);
    }

    // 4. Atualizar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(
            @PathVariable Long id,
            @RequestBody Livro livroAtualizado) {

        return service.buscarPorId(id)
                .map(livroExistente -> {
                    livroExistente.setTitulo(livroAtualizado.getTitulo());
                    livroExistente.setAutor(livroAtualizado.getAutor());
                    livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
                    return ResponseEntity.ok(service.salvar(livroExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Excluir um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}