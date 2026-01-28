import javax.swing.JOptionPane;
import armazenador.*;
/**
 * Essa Classe tem como funcao realizar de forma dinamica a insercao, remocao e listagem dos alunos cadastrados.
 * 
 * @author Enzo Marasca, João Pedro Pedott, Pedro Paulo Tonon, Vinícius Queiroz 
 * @version 1405(14/05/2025)
 */
public class CadAlunos implements java.io.Serializable
{
    private String nome;               //nome do aluno
    private int idade;                 //idade em numero
    private String rg;                 //rg do aluno
    private String ra;                 //ra do aluno
    private String curso;              //curso do aluno
    private int periodo;               //periodo em texto

    IArmazenador arm = new VetDin();
    //IArmazenador arm = new ListaArray();
    /**
     * //Insere um aluno na lista
     *
     * @param  String nome  curso, periodo 
     * @param  idade Int
     * @param  rg String
     * @param  ra String
     * @param  curso String
     * @param  periodo Int 
     * @return (void) 
     */
    public void inserir(String nome, int idade, String rg, String ra, String curso, int periodo)
    {
        arm.adicionar(new Aluno(nome, idade, rg, ra, curso, periodo));
    }
    
    /**
     * //Lista todos os alunos
     *
     * @param int i uma posição do array 
     * @return (String) 
     */
    public String listar(int i)
    {
        int tamanho = arm.getQtd() - 1; //tamanho da lista
        String lista = "";
        lista = lista + arm.buscar(i).toString() + "\n\n";     
        if(tamanho < 0)
        {
          lista = lista + "Nenhum aluno cadastrado";
        }
        return lista;
    }
    
    /**
     * //Remove um aluno da lista
     *
     * @param ra String
     * @return (boolean) true para remoção executada false caso ocorra um fracasso ao remover 
     */
    public boolean remover(String ra)
    {
        int tamanho = arm.getQtd() - 1; //tamanho da lista
        boolean remocao = false;
        Object cada = arm.buscar(0);
        Aluno cad = (Aluno) cada;
        if(tamanho >= 0)
        {   
            int i = 0;  //inicio da lista
            while(i<=tamanho && !ra.equals(cad.getRa()))  //varre a lista ate achar o ra ou ate acabar a lista
            {
                i++;
                cada = arm.buscar(i);
                cad = (Aluno) cada;
            }
            if(i <= tamanho)
            {
                if(ra.equals(cad.getRa()))   //se achou
                {
                    arm.remover(i);
                }
                remocao = true;
            }
            else
            {
                remocao = false;
            }
        }
        return remocao;
    }
    
    /**
     * //Verifica se o ra ja esta em uso
     *
     * @param ra String
     * @return (boolean) true para ja exista o ra recebido como parametro false caso não exista
     */
    public boolean raRepetido(String ra)
    {
        int tamanho = arm.getQtd() - 1; //tamanho da lista
        boolean repetido = false;
        if(tamanho >= 0)
        {
            
            Object cada = arm.buscar(0);
            Aluno cad = (Aluno) cada;
            int i = 0;  //inicio da lista
            while(i<=tamanho && !ra.equals(cad.getRa()))  //varre a lista ate achar o ra ou ate acabar a lista
            {
                i++;
                cada = arm.buscar(i);
                cad = (Aluno) cada;
            }
            if(i <= tamanho)
            {
                repetido = true;
            }
            else
            {
                repetido = false;
            }
        }
        return repetido;
    }
    
     /**
     * //Verifica se o Rg ja esta em uso
     *
     * @param rg String
     * @return (boolean)    true para ja exista o rg recebido como parametro false caso não exista   
     */
    public boolean rgRepetido(String rg)
    {
        int tamanho = arm.getQtd() - 1; //tamanho da lista
        boolean repetido = false;    
        if(tamanho >= 0)
        {   
            Object cada = arm.buscar(0);
            Aluno cad = (Aluno) cada;
            int i = 0;  //inicio da lista
            while(i<=tamanho && !rg.equals(cad.getId()))  //varre a lista ate achar o rg ou ate acabar a lista
            {
                i++;
                cada = arm.buscar(i);
                cad = (Aluno) cada;
            }
            if(i <= tamanho)
            {
                repetido = true;
            }
            else
            {
                repetido = false;
            }
        }
        return repetido;
    }
    
}


