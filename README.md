# Cadastro de Alunos

Projeto acadêmico em Java que implementa um sistema de cadastro de alunos
com interface gráfica desenvolvida em JavaFX. O sistema permite inserir,
remover, listar e persistir os dados dos alunos em arquivo binário.

---

## Objetivo
Desenvolver um sistema de cadastro de alunos com interface gráfica, aplicando conceitos de programação orientada a objetos, validação de dados e persistência em arquivo.

---

## Tecnologias Utilizadas
- Java 8
- JavaFX (incluso no Java 8)
- BlueJ

---

## Aprendizados
- Desenvolvimento de aplicações Java com interface gráfica utilizando JavaFX.
- Implementação de operações de cadastro (CRUD) em aplicações desktop.
- Validação de dados de entrada para garantir integridade das informações.
- Persistência de dados utilizando arquivos binários.
- Organização do código em múltiplas classes com responsabilidades bem definidas.
- Integração entre lógica de negócio e interface gráfica.
  
---

## Funcionalidades
- Inserção de alunos com validação dos dados
- Remoção de alunos utilizando o RA
- Listagem de alunos cadastrados
- Gravação dos dados em arquivo binário
- Carregamento dos dados previamente salvos
- Interface gráfica com JavaFX e estilização via CSS

---

### Validação de Dados
- O sistema realiza validação do RG informado no cadastro
- RGs inválidos ou gerados aleatoriamente podem não ser aceitos

---

## Como Executar o Projeto

### Requisitos
- Java 8
- BlueJ

### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/PedroTonon/cadastro-alunos-java
   ```

2. Abra o Bluej

3. Em Project -> Open Project, selecione a pasta do projeto

4. Execute a classe Menu, que contém o método main e inicia a aplicação JavaFX

---

## Estrutura do Projeto
 - Menu - classe principal responsável pela interface gráfica e navegação do sistema
 - Classes auxiliares responsáveis pelo cadastro, validação e persistência dos dados
 - estilo.css - arquivo responsável pela estilização da interface gráfica

---

## Observações Importantes
 - O sistema utiliza um arquivo binário (Cadastro.bin) para persistência dos dados
 - O arquivo é criado ao utilizar a opção Gravar no menu
 - O arquivo .bin não faz parte do repositório
 - Projeto desenvolvido e testado utilizando o BlueJ

---

## Status do Projeto
- Finalizado

---

## Autores
- Enzo Marasca Soranz Saragiotto
- João Pedro Pedott Rocha
- Pedro Paulo Martins de Oliveira Tonon
- Vinícius Queiroz e Silva Soares
