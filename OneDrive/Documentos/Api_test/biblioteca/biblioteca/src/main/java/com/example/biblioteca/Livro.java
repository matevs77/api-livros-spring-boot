package com.example.biblioteca;        // Diz em qual "pasta lógica" essa classe está

import jakarta.persistence.Entity;         // Importa ferramentas que o Spring usa
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity                                  // ← Marca: "essa classe vira uma tabela no banco de dados"
@Data                                    // ← Magia do Lombok: cria automaticamente getTitulo(), setTitulo(), etc.
@NoArgsConstructor                      // ← Construtor vazio (exigido pelo JPA)
@AllArgsConstructor                     // ← Construtor com todos os campos (para new Livro(id, titulo, autor, ano))
public class Livro {                     // Nome da nossa "tabela" / ficha

    @Id                                  // ← Este campo é a chave única (como RG ou número da ficha)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ← O banco cria o número sozinho (1, 2, 3...)
    private Long id;                     // Número único do livro

    private String titulo;               // Nome do livro
    private String autor;                // Quem escreveu
    private Integer anoPublicacao;       // Ano que foi publicado
}