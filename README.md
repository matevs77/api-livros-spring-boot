# API CRUD de Livros com Spring Boot

API REST simples para gerenciamento de livros, implementando operações CRUD (Create, Read, Update, Delete).

## Tecnologias utilizadas

- Java 25

- Spring Boot 3.x

- Spring Data JPA

- H2 Database (em memória para desenvolvimento)

- Lombok

## Endpoints principais

- `GET /livros` → Lista todos os livros  

- `POST /livros` → Cadastra um novo livro (envie JSON no body)  

- `GET /livros/{id}` → Busca livro por ID  

- `PUT /livros/{id}` → Atualiza livro existente  

- `DELETE /livros/{id}` → Exclui livro  

Exemplo de body JSON para POST/PUT:

```json

{

  "titulo": "1984",

  "autor": "George Orwell",

  "anoPublicacao": 1949

}
