package com.example.biblioteca;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service                               // Diz ao Spring: "sou uma classe de regras de negócio"
public class LivroService {

    private final LivroRepository repository;   // Pedimos o bibliotecário

    // O Spring entrega automaticamente o repositório para nós
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();           // Pede todos os livros da prateleira
    }

    public Optional<Livro> buscarPorId(Long id) {
        return repository.findById(id);        // Procura um livro específico
    }

    public Livro salvar(Livro livro) {
        return repository.save(livro);         // Guarda ou atualiza o livro
    }

    public void deletar(Long id) {
        repository.deleteById(id);             // Apaga o livro
    }
}
