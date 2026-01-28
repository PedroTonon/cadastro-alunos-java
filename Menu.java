import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;
/**
 * A classe Menu tem a funcao de exibir ao usuario as opcoes de entrada do menu e realizar acoes baseadas na escolha desse.
 * 
 * @author Enzo Marasca, João Pedro Pedott, Pedro Paulo Tonon, Vinícius Queiroz 
 * @version 1405(14/05/2025)
 */
public class Menu extends Application
{
    CadAlunos cad = new CadAlunos();
    ArquivoBinario ab = new ArquivoBinario();  
    @Override
    public void start(Stage menu)
    {
        //******************************************************
        //Construção da cena que mostra o menu principal na Tela
        menu.setTitle("Cadastro de Alunos");
        
        //Criação dos botões e labels
        Button btnInserir = new Button("Inserir");
        Label lblInserir = new Label("Insere um aluno a lista");
        Button btnRemover = new Button("Remover");
        Label lblRemover = new Label("Remove um aluno da lista usando seu RA");
        Button btnListar = new Button("Listar");
        Label lblListar = new Label("Lista todos os alunos do cadastro");
        Button btnGravar = new Button("Gravar");
        Label lblGravar = new Label("Grava o cadastro no disco");
        Button btnCarregar = new Button("Carregar");
        Label lblCarregar = new Label("Carrega o cadastro do disco");
        Button btnSair = new Button("Sair");
        Label lblSair = new Label("Sai da aplicacao");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);       // Centraliza os elementos no painel
        grid.setHgap(10);                    // Espaçamento horizontal entre colunas
        grid.setVgap(10);                    // Espaçamento vertical entre linhas
        grid.setPadding(new Insets(20));     // Margem interna
        
        //Adiciona os elementos na GridPane com suas respectivas posições
        grid.add(btnInserir, 0, 0);
        grid.add(lblInserir, 1, 0);
        grid.add(btnRemover, 0, 1);
        grid.add(lblRemover, 1, 1);
        grid.add(btnListar, 0, 2);
        grid.add(lblListar, 1, 2);
        grid.add(btnGravar, 0, 3);
        grid.add(lblGravar, 1, 3);
        grid.add(btnCarregar, 0, 4);
        grid.add(lblCarregar, 1, 4);
        grid.add(btnSair, 0, 5);
        grid.add(lblSair, 1, 5);
        
        //Define o estilo do painel de inserção
        grid.setStyle("-fx-background-color: #0C0238;");
    
        //Criação da cena do menu
        Scene scene = new Scene(grid, 450, 300);
        scene.getStylesheets().add("estilo.css");
        
        //Exibe a cena de inserção no palco principal
        menu.setScene(scene);
        menu.show();
        
        //Aplica animação de hover aos botões
        animarBotao(btnInserir);
        animarBotao(btnRemover);
        animarBotao(btnListar);
        animarBotao(btnGravar);
        animarBotao(btnCarregar);
        animarBotao(btnSair);
        //******************************************************
        btnInserir.setOnAction(e -> {   // Ação do botão de inserir
            //****************************************************
            //Construção da cena que mostra o menu inserir na Tela
            GridPane ins = new GridPane();
            ins.setAlignment(Pos.CENTER);       // Centraliza os elementos no painel
            ins.setHgap(10);                    // Espaçamento horizontal entre colunas
            ins.setVgap(10);                    // Espaçamento vertical entre linhas
            ins.setPadding(new Insets(20));     // Margem interna
            
            //Criação dos campos de entrada e labels de erro para validação
            Label lblNome = new Label("Nome: ");
            TextField txtNome = new TextField();
            Label lblTesteNome = new Label("Nome invalido!");
            
            Label lblIdade = new Label("Idade: ");
            TextField txtIdade = new TextField();
            Label lblTesteIdade = new Label("Idade invalido!");
            
            Label lblRg = new Label("RG: ");
            TextField txtRg = new TextField();
            Label lblTesteRg = new Label("RG invalido!");
            Label lblTesteRgR = new Label("RG ja esta em uso!");
            
            Label lblRa = new Label("RA: ");
            TextField txtRa = new TextField();
            Label lblTesteRa = new Label("RA invalido!");
            Label lblTesteRaR = new Label("RA ja esta em uso!");
            
            Label lblCurso = new Label("Curso: ");
            TextField txtCurso = new TextField();
            Label lblTesteCurso = new Label("Curso invalido!");
            
            Label lblPeriodo = new Label("Periodo: ");
            TextField txtPeriodo = new TextField();
            Label lblTestePeriodo = new Label("Periodo invalido!");
            
            //Botões de ação
            Button btnConfirma = new Button("Confirma");
            Button btnCancela = new Button("Cancela");
            
            //Adiciona os elementos na GridPane com suas respectivas posições
            ins.add(lblNome, 0, 0);
            ins.add(txtNome, 1, 0);
            ins.add(lblTesteNome, 2, 0);
            lblTesteNome.setVisible(false);
    
            ins.add(lblIdade, 0, 1);
            ins.add(txtIdade, 1, 1);
            ins.add(lblTesteIdade, 2, 1);
            lblTesteIdade.setVisible(false);
    
            ins.add(lblRg, 0, 2);
            ins.add(txtRg, 1, 2);
            ins.add(lblTesteRg, 2, 2);
            ins.add(lblTesteRgR, 3, 2);
            lblTesteRgR.setVisible(false);
            lblTesteRg.setVisible(false);
    
            ins.add(lblRa, 0, 3);
            ins.add(txtRa, 1, 3);
            ins.add(lblTesteRa, 2, 3);
            ins.add(lblTesteRaR, 3, 3);
            lblTesteRaR.setVisible(false);
            lblTesteRa.setVisible(false);            
    
            ins.add(lblCurso, 0, 4);
            ins.add(txtCurso, 1, 4);
            ins.add(lblTesteCurso, 2, 4);
            lblTesteCurso.setVisible(false);
    
            ins.add(lblPeriodo, 0, 5);
            ins.add(txtPeriodo, 1, 5);
            ins.add(lblTestePeriodo, 2, 5);
            lblTestePeriodo.setVisible(false);
            
            ins.add(btnConfirma, 1, 6);
            ins.add(btnCancela, 0, 6);
            
            //Define o estilo do painel de inserção
            ins.setStyle("-fx-background-color: #0C0238;");
            
            //Criação da cena de inserção 
            Scene insert = new Scene(ins, 570, 350);
            insert.getStylesheets().add("estilo.css");
            
            //Exibe a cena de inserção no palco principal
            menu.setScene(insert);
            menu.show();
            
            //Aplica animação de hover aos botões
            animarBotao(btnConfirma);
            animarBotao(btnCancela);  
            //***************************************************************************
            //Construção da Cena que Mostra a Mensagem de Confirmacao de Cadastro na Tela
            GridPane list = new GridPane();
            list.setAlignment(Pos.CENTER);      // Centraliza os elementos no painel
            list.setHgap(10);                   // Espaçamento horizontal entre colunas
            list.setVgap(10);                   // Espaçamento vertical entre linhas
            list.setPadding(new Insets(20));    // Margem interna
            
            //Criação do botão e da label
            Label lblLista = new Label("Aluno Cadastrado!");            
            Button btnOk = new Button("Ok");
            
            //Adiciona os elementos na GridPane com suas respectivas posições
            list.add(lblLista, 0, 0);
            list.add(btnOk, 0, 1);
            
            //Define o estilo do painel de inserção
            list.setStyle("-fx-background-color: #0C0238;");
            
            //Criação da cena de confirmação
            Scene inserido = new Scene(list, 200, 200);
            inserido.getStylesheets().add("estilo.css");
            //***************************************************************************
            btnConfirma.setOnAction(f -> {
                String nome = "";               //nome do aluno
                int idade = 0;                 //idade em numero
                String rg = "";                 //rg do aluno
                String ra = "";                 //ra do aluno
                String curso = "";              //curso do aluno
                int periodo = 0;               //periodo em texto

                boolean ver = true; //verificacao dos dados
                if(!Verificacao.verificaVazio(txtNome.getText()))   //se o nome estiver vazio
                {
                    ver = false;    //dados invalidos
                    lblTesteNome.setVisible(true);  //avisa que o dados esta invalido
                }
                else    //tudo certo
                {
                    lblTesteNome.setVisible(false); //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if(!Verificacao.verificaIdade(txtIdade.getText()))  //se a idade nao e um numero
                {
                    ver = false;    //dados invalidos
                    lblTesteIdade.setVisible(true); //coloca a mensagem de aviso
                }
                else    //tudo certo
                {
                    lblTesteIdade.setVisible(false);    //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if (!Verificacao.verificaID(txtRg.getText()))   //se o rg nao existe
                {
                    ver = false;    //dados invalidos
                    lblTesteRg.setVisible(true);    //coloca a mensagem de aviso
                }
                else    //tudo certo
                {
                    lblTesteRg.setVisible(false);   //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if (cad.rgRepetido(txtRg.getText()))    //se o rg e repetido
                {
                    ver = false;    //dados invalidos
                    lblTesteRgR.setVisible(true);   //coloca a mensagem de aviso
                }
                else    //tudo certo
                {
                    lblTesteRgR.setVisible(false);  //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if (!Verificacao.verificaRA(txtRa.getText()))   //se o ra e invalido
                {
                    ver = false;    //dados invalidos
                    lblTesteRa.setVisible(true);    //coloca a mensagem de aviso
                }
                else    //tudo certo
                {
                    lblTesteRa.setVisible(false);   //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if (cad.raRepetido(txtRa.getText()))    //se o ra e repetido
                {
                    ver = false;    //dados invalidos
                    lblTesteRaR.setVisible(true);   //coloca a mensagem de aviso
                }
                else    //tudo certo
                {
                    lblTesteRaR.setVisible(false);  //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if(!Verificacao.verificaVazio(txtCurso.getText()))  //se o curso esta vazio
                {
                    ver = false;    //dados invalidos
                    lblTesteCurso.setVisible(true); //coloca a mensagem de aviso
                }
                else    //tudo certo
                {
                    lblTesteCurso.setVisible(false);    //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if(!Verificacao.verificaPeriodo(txtPeriodo.getText()))  //se o periodo e um numero
                {
                    ver = false;    //dados invalidos
                    lblTestePeriodo.setVisible(true);   //coloca a mensagem de aviso
                }
                else    //tudo certo
                {
                    lblTestePeriodo.setVisible(false);  //tira a mensagem de aviso (importanto caso seja a segunda vez cadastrando)
                }
                if(ver)
                {
                    //coleta todos os dados nas areas de texto
                    nome = txtNome.getText();
                    idade = Integer.parseInt(txtIdade.getText());
                    rg = txtRg.getText();
                    ra = txtRa.getText();
                    curso = txtCurso.getText();
                    periodo = Integer.parseInt(txtPeriodo.getText());
                    
                    cad.inserir(nome, idade, rg, ra, curso, periodo);   //insere o aluno no cadastro
                    
                    //mensagem de confirmacao na tela
                    menu.setScene(inserido);
                    menu.show();
                    //secao que coloca a animacao em cada botao
                    animarBotao(btnOk);   
                    
                    //trecho que sera executado ao primir o botao "ok"
                    btnOk.setOnAction(g -> {
                        //coloca o menu na tela
                        menu.setScene(scene);
                        menu.show();
                    });
                }
                else
                {
                    //caso alguma informacao esteja errada, coloca a cena de volta na tela
                    menu.setScene(insert);
                    menu.show();
                }
            });
            
            btnCancela.setOnAction(f -> {   //Ação do botão "Cancela" 
                menu.setScene(scene);   //Volta para o menu principal
                menu.show();
            });
        });

        btnRemover.setOnAction(e -> {   // Ação do botão de Remoção 
            //*********************************************
            //Construção que Mostra a Mensagem de Remoção na Tela
            GridPane rem = new GridPane();
            rem.setAlignment(Pos.CENTER);    // Centraliza os elementos no painel
            rem.setHgap(10);                 // Espaçamento horizontal entre colunas
            rem.setVgap(10);                 // Espaçamento vertical entre linhas
            rem.setPadding(new Insets(20));  // Margem interna
            
            //Criação do campo de entrada, labels e botões
            Label lblRa = new Label("RA do aluno a ser removido: ");
            TextField txtRa = new TextField();
            Label lblTesteRa = new Label("RA invalido!");
            Label lblTesteRaR = new Label("RA Nao Encontrado!");
            Button btnConfirma = new Button("Confirma");
            Button btnCancela = new Button("Cancela");
            
            //Adiciona os elementos na GridPane com suas respectivas posições
            rem.add(lblRa, 0, 0);
            rem.add(txtRa, 1, 0);
            rem.add(lblTesteRa, 2, 0);
            rem.add(lblTesteRaR, 3, 0);
            lblTesteRa.setVisible(false);
            lblTesteRaR.setVisible(false);
            rem.add(btnConfirma, 1, 2);
            rem.add(btnCancela, 0, 2);
            
            //Define o estilo do painel de inserção
            rem.setStyle("-fx-background-color: #0C0238;");
            
            //Criação da cena de remoção
            Scene remocao = new Scene(rem, 650, 150);
            remocao.getStylesheets().add("estilo.css");
            
            //Exibe a cena de inserção no palco principal
            menu.setScene(remocao);
            menu.show();
            
            //Aplica animação de hover aos botões
            animarBotao(btnConfirma);  
            animarBotao(btnCancela);  
            //***********************************************************************
            //Construção Cena que Mostra a Mensagem de Confirmacao de Remoção na Tela
            GridPane list = new GridPane();
            list.setAlignment(Pos.CENTER);      // Centraliza os elementos no painel
            list.setHgap(10);                   // Espaçamento horizontal entre colunas
            list.setVgap(10);                   // Espaçamento vertical entre linhas
            list.setPadding(new Insets(20));    // Margem interna
            
            //Criação do botões e label
            Label lblLista = new Label("Aluno Removido!");
            Button btnOk = new Button("Ok");
            
            //Adiciona os elementos na GridPane com suas respectivas posições
            list.add(lblLista, 0, 0);
            list.add(btnOk, 0, 1);
            
            //Define o estilo do painel de inserçã o
            list.setStyle("-fx-background-color: #0C0238;");
            
            //Criação da cena de confirmação
            Scene removido = new Scene(list, 200, 200);
            removido.getStylesheets().add("estilo.css");
            
            //***********************************************************************
            btnConfirma.setOnAction(f -> {  //Ação do botão de Confirmação
                String ra = "";                 //ra do aluno
             
                boolean ver = true;
                boolean remove; 
                
                lblTesteRa.setVisible(false);
                if(!Verificacao.verificaRA(txtRa.getText()))
                {
                    lblTesteRaR.setVisible(false);
                    ver = false;
                    lblTesteRa.setVisible(true);
                }
                else if (!cad.raRepetido(txtRa.getText()))   //Torna visivel a mensagem que o RA não foi encontrado
                {
                    lblTesteRa.setVisible(false);
                    ver = false;
                    lblTesteRaR.setVisible(true);
                }
                if(ver) //Se o ra foi encontrado e é valido
                {
                    ra = txtRa.getText();
                    
                    remove = cad.remover(ra);      //Recebe true se o aluno foi removido
                    if(remove)  //Se o aluno foi removido mostra a cena de confirmação
                    {
                       menu.setScene(removido); //Vai para a cena de confirmação
                       menu.show();  
                       //Aplica animação de hover ao botões
                       animarBotao(btnOk); 
                       btnOk.setOnAction(g -> { //Ação do botão do "Ok"
                           menu.setScene(scene);    //Volta para o menu principal
                           menu.show();
                       });
                    }
                    else
                    {
                       menu.setScene(remocao);  //Continua no menu de remoção caso o aluno não foi removido
                       menu.show(); 
                    }
                }
                else
                {
                    menu.setScene(remocao); //Continua no menu de remoção caso o ra não exista ou esteja incorreto
                    menu.show();
                }
            });
            
            btnCancela.setOnAction(f -> {   //Ação do botão de Remoção
                menu.setScene(scene);   //Volta para o menu principal
                menu.show();
            });
        });

        btnListar.setOnAction(e -> {    //Ação do botão Listar
            //****************************************************
            //Construção da Cena que Lista todos os alunos na Tela
            GridPane list = new GridPane();     
            list.setAlignment(Pos.CENTER);      // Centraliza os elementos no painel     
            list.setHgap(10);                   // Espaçamento horizontal entre colunas
            list.setVgap(10);                   // Espaçamento vertical entre linhas
            list.setPadding(new Insets(20));    // Margem interna
            
            //Define o estilo do painel de inserção
            list.setStyle("-fx-background-color: #0C0238;");
            
            int i=0; 
            int j=0; 
            int k;
            int cont = 0;
            
            String lista = "";
            //Criação da label que mostra os alunos cadastrados
            Label lblLista = new Label("");
            for(k = 0; k<cad.arm.getQtd(); k++)
            {
                lista = cad.listar(k);
                lblLista = new Label(lista);
                
                //Adiciona os Alunos na GridPane com suas respectivas posições
                list.add(lblLista, j, i);
                j++;
                if(j>=5)
                {
                    j=0;
                    i++;
                }
            }
            i++;
            //Criação do botão voltar
            Button btnVoltar = new Button("Voltar");
            
            //Adiciona o botão voltar no GridPane em sua respectiva posição
            list.add(btnVoltar, 0, i);
            
            //Criação da cena listar
            Scene listar = new Scene(list, 550, 450);
            listar.getStylesheets().add("estilo.css");
            
            //Exibe a cena de inserção no palco principal
            menu.setScene(listar);
            menu.show();
            
            //Aplica animação de hover ao botões
            animarBotao(btnVoltar);  
            //**************************************
            btnVoltar.setOnAction(f -> {    //Ação do botão de Remoção
                menu.setScene(scene);   //Volta para o menu principal
                menu.show();
            });
        });

        btnGravar.setOnAction(e -> {    //Ação do botão Gravar
            //**************************************************************************
            //Contrução da Cena que Mostra a Mensagem de Confirmacao de Cadastro na Tela
            GridPane list = new GridPane();
            list.setAlignment(Pos.CENTER);      // Centraliza os elementos no painel
            list.setHgap(10);                   // Espaçamento horizontal entre colunas
            list.setVgap(10);                   // Espaçamento vertical entre linhas
            list.setPadding(new Insets(20));    // Margem interna
                
            ab.gravarObj(cad, "Cadastro.bin");  //Salva o objeto cad em um arquivo binario
            
            //Criação do botão e da label
            Label lblLista = new Label("Arquivo Salvo!");
            Button btnOk = new Button("Ok");
            
            //Adiciona os elementos na GridPane com suas respectivas posições
            list.add(lblLista, 0, 0);
            list.add(btnOk, 0, 1);
            
            //Define o estilo do painel de inserção
            list.setStyle("-fx-background-color: #0C0238;");
            
            //Criação da cena de confirmação de gravação
            Scene listar = new Scene(list, 200, 200);
            listar.getStylesheets().add("estilo.css");
            
            //Exibe a cena de inserção no palco principal
            menu.setScene(listar);
            menu.show();
            //Aplica animação de hover ao botões
            animarBotao(btnOk);  
            //**************************************************************************
            btnOk.setOnAction(f -> {    //Ação do botão "Ok"
                menu.setScene(scene);   //Volta para o menu principal
                menu.show();
            });
        });

        btnCarregar.setOnAction(e -> {  //Ação do botão Carregar
            //**************************************************************************
            //Contrução da Cena que Mostra a Mensagem de Confirmacao de Cadastro na Tela
            GridPane list = new GridPane();
            list.setAlignment(Pos.CENTER);      // Centraliza os elementos no painel
            list.setHgap(10);                   // Espaçamento horizontal entre colunas
            list.setVgap(10);                   // Espaçamento vertical entre linhas
            list.setPadding(new Insets(20));    // Margem interna
            String mensagem = "";
            String arquivo = "cadastro.bin";    //Nome do arquivo que vai ser carregado
            
            //A mensagem exibida é alterada com base na existência ou não do arquivo 
            //O arquivo só é carregado caso seja encontrado
            if(Verificacao.arquivoExiste(arquivo))
            {
                mensagem = "Arquivo Carregado!";
                cad = (CadAlunos)ab.lerObj("Cadastro.bin");  //Carrega o objeto cad com um arquivo binario
            }
            else
            {
                mensagem = "Arquivo nao encontrado";
            }
            
            //Criação do botão e da label
            Label lblLista = new Label(mensagem);
            Button btnOk = new Button("Ok");
            
            //Adiciona os elementos na GridPane com suas respectivas posições
            list.add(lblLista, 0, 0);
            list.add(btnOk, 0, 1);
            
            //Define o estilo do painel de inserção
            list.setStyle("-fx-background-color: #0C0238;");
            
            //Criação da cena de gravação
            Scene listar = new Scene(list, 230, 200);
            listar.getStylesheets().add("estilo.css");

            //Exibe a cena de inserção no palco principal
            menu.setScene(listar);
            menu.show();
            //Aplica animação de hover ao botões
            animarBotao(btnOk);  
            //**************************************************************************
            btnOk.setOnAction(f -> {    //Ação do botão "Ok"
                menu.setScene(scene);   //Volta para o menu principal
                menu.show();
            });
        });

        btnSair.setOnAction(e -> {  //Ação do botão Sair
           menu.close();    //Fecha o Menu Principal
        });
    }
    
    /**
     * //Aplica uma animação de escala ao botão passado como parâmetro
     *
     * @param botão Button
     * @return (void) 
     */
    private void animarBotao(Button botao) {
        botao.setOnMouseEntered(e -> {  //Define a animação quando o mouse entra no botão
            ScaleTransition st = new ScaleTransition(Duration.millis(150), botao);
            st.setToX(1.08);    //Aumenta a largura em 8%
            st.setToY(1.08);    //Aumenta a altura em 8%
            st.play();  //Inicia a animação
        });
    
        botao.setOnMouseExited(e -> {   //Define a animação quando o mouse sai no botão
            ScaleTransition st = new ScaleTransition(Duration.millis(150), botao);
            st.setToX(1.0);     //Retorna à largura original
            st.setToY(1.0);     //Retorna à largura original
            st.play();  //Inicia a animação
        });
    }
}
