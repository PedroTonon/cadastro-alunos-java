# Cadastro de Alunos

Projeto acadêmico em Java que implementa um sistema de cadastro de alunos
com interface gráfica desenvolvida em JavaFX. O sistema permite inserir,
remover, listar e persistir os dados dos alunos em arquivo binário.

## Tecnologias Utilizadas
- Java 8
- JavaFX (incluso no Java 8)
- BlueJ

## Funcionalidades
- Inserção de alunos com validação dos dados
- Remoção de alunos utilizando o RA
- Listagem de alunos cadastrados
- Gravação dos dados em arquivo binário
- Carregamento dos dados previamente salvos
- Interface gráfica com JavaFX e estilização via CSS

### Validação de Dados
- O sistema realiza validação do RG informado no cadastro
- RGs inválidos ou gerados aleatoriamente podem não ser aceitos

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

## Estrutura do Projeto
 - Menu - classe principal responsável pela interface gráfica e navegação do sistema
 - Classes auxiliares responsáveis pelo cadastro, validação e persistência dos dados
 - estilo.css - arquivo responsável pela estilização da interface gráfica

## Observações Importantes
 - O sistema utiliza um arquivo binário (Cadastro.bin) para persistência dos dados
 - O arquivo é criado ao utilizar a opção Gravar no menu
 - O arquivo .bin não faz parte do repositório
 - Projeto desenvolvido e testado utilizando o BlueJ

## Status do Projeto
- Finalizado

## Autores
- Enzo Marasca Soranz Saragiotto
- João Pedro Pedott Rocha
- Pedro Paulo Martins de Oliveira Tonon
- Vinícius Queiroz e Silva Soares
