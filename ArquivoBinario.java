import java.io.*;
import saida.*;
/**
 * @author julio
 * Classe para gravar e ler arquivo binario
 */
public class ArquivoBinario{
    //ISaida sai = new SaidaConsole();
    ISaida sai = new SaidaGrafica();
        
    /**
     * Method gravarObj grava um objeto em arquivo
     *
     * @param objeto objeto a ser gravado
     * @param nomeArq nome do arquivo
     */
    public void gravarObj(Object objeto, String nomeArq){
        ObjectOutputStream output = null;
        try {
            File file = new File(nomeArq);
            output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(objeto);  // escreve o objeto no arquivo
        } catch(Exception e){
            sai.mostrarMsg("Erro ao salvar o arquivo");
        } finally {
            try {
                output.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }

    /**
     * Method lerObj
     *
     * @param nomeArq nome do arquivo a ser lido
     * @return Object o objeto lido
     */
    public Object lerObj(String nomeArq){
        Object objeto = null;
        ObjectInputStream input = null;
        try {
            File file = new File(nomeArq);
            input = new ObjectInputStream(new FileInputStream(file));
            objeto = (Object)input.readObject();  // le o objeto do arquivo
        }
        catch(Exception e){
            sai.mostrarMsg("Erro ao carregar o arquivo");
        } finally {
            try {
                input.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
        return objeto;
    }
}
