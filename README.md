# 📚 Sistema de Gerenciamento de Biblioteca

Bem-vindo ao repositório do projeto **Sistema de Gerenciamento de Biblioteca**! Este sistema permite o cadastro de
livros, autores, membros, além de operações de empréstimos e devoluções, e geração de relatórios. O objetivo é aplicar
conceitos avançados de programação, como Orientação a Objetos e persistência de dados com JPA/Hibernate.

## 📌 Descrição do Projeto

O sistema utiliza os seguintes conceitos e tecnologias:

- **Orientação a Objetos**: Encapsulamento, Herança, Polimorfismo
- **Programação Funcional**: Expressões Lambda e Streams
- **Estruturas de Dados**: Uso de `Set` e `Map`
- **Datas e Horas**: Gerenciamento de datas de empréstimo e devolução
- **Enumerações e Tratamento de Exceções**
- **Interfaces e Generics**
- **Persistência de Dados**: JPA/Hibernate
- **Validação e Tratamento de Erros**

## 📋 Requisitos

- 📖 Cadastro e gerenciamento de livros, autores, membros.
- 🔄 Empréstimos e devoluções.
- 📊 Geração de relatórios personalizados.

## ✨ Funcionalidades

1. **Cadastro de Livros**
    - Valida ISBN único.
    - Realiza operações de busca, remoção e listagem.
    - Geração de relatórios de livros.

2. **Cadastro de Autores**
    - Verifica duplicidade de nomes.
    - Realiza operações de busca, remoção e listagem.
    - Geração de relatórios de autores.

3. **Cadastro de Membros**
    - Valida e-mail único.
    - Permite a verificação e aplicação de multas.
    - Realiza operações de busca, remoção e listagem.

4. **Multa por Atraso**
    - Calcula multas por atraso e atualização de estado do empréstimo.

5. **Relatórios**
    - Gera relatórios de livros emprestados, membros com multas, etc.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal.
- **JPA/Hibernate**: Persistência de dados.
- **MySQL**: Banco de dados utilizado.

## 🚀 Rodando o Projeto

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/felipe0365/SP_SpringBoot_AWS_Desafio_01.git
    ```

2. **Configure o banco de dados MySQL**:
    - Certifique-se de que o servidor MySQL está rodando e as tabelas necessárias estão criadas.


3. **Execute o projeto**:
    - Execute a clase Main localizado em:
    ```bash
    SP_SpringBoot_AWS_Desafio_01\src\main\java\biblioteca\application.
    ```

## 💼 Estrutura de Classes e Métodos

### Classes Principais

#### `AutorImp`

Implementa operações relacionadas ao gerenciamento de autores e geração de relatórios.

- **Métodos**:
    - `cadastrar(Autor autor)`: Persiste um novo autor no banco de dados.
    - `deletarPorId(Long id)`: Remove um autor pelo ID.
    - `buscarPorId(Long id)`: Retorna detalhes do autor pelo ID.
    - `buscarPorNome(String nome)`: Retorna detalhes do autor pelo nome.
    - `listarTodos()`: Lista todos os autores cadastrados.
    - `autorExiste(String nome)`: Verifica se já existe um autor com o nome especificado.
    - `gerarRelatorio()`: Gera um relatório detalhado dos autores.

#### `LivroImp`

Implementa operações relacionadas ao gerenciamento de livros e geração de relatórios.

- **Métodos**:
    - `cadastrar(Livro livro)`: Persiste um novo livro no banco de dados.
    - `deletarPorId(Long id)`: Remove um livro pelo ID.
    - `buscarPorId(Long id)`: Retorna detalhes do livro pelo ID.
    - `buscarPorIsbn(String isbn)`: Retorna detalhes do livro pelo ISBN.
    - `listarTodos()`: Lista todos os livros cadastrados.
    - `gerarRelatorio()`: Gera um relatório detalhado dos livros.

#### `MembroImp`

Responsável pelo gerenciamento de membros, incluindo o controle de multas.

- **Métodos**:
    - `cadastrar(Membro membro)`: Persiste um novo membro no banco de dados.
    - `deletarPorId(Long id)`: Remove um membro pelo ID.
    - `buscarPorId(Long id)`: Retorna detalhes do membro pelo ID.
    - `buscarPorEmail(String email)`: Retorna detalhes do membro pelo e-mail.
    - `listarTodos()`: Lista todos os membros cadastrados.
    - Métodos auxiliares:
        - `temMultaPendente(Membro membro)`: Verifica se o membro possui multas pendentes.
        - `aplicarMulta(Long membroId, BigDecimal multa)`: Aplica uma multa ao membro especificado.

---
