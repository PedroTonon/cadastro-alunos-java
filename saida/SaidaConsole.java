package saida; 
/**
 * Escreva uma descrição da classe SaidaConsole aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class SaidaConsole implements ISaida, java.io.Serializable {
    public void mostrarMsg(String s){
        System.out.println(s);
    }
}
