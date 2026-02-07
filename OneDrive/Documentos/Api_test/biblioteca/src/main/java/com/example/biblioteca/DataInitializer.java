package com.example.biblioteca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LivroRepository livroRepository;

    public DataInitializer(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existe dados para evitar duplicatas
        if (livroRepository.count() == 0) {
            livroRepository.save(new Livro(null, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
            livroRepository.save(new Livro(null, "1984", "George Orwell", 1949));
            livroRepository.save(new Livro(null, "Dom Quixote", "Miguel de Cervantes", 1605));

            System.out.println("Dados iniciais carregados com sucesso!");
        } else {
            System.out.println("Dados iniciais já existem. Nada foi inserido.");
        }
    }
}