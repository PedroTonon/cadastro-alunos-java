import java.io.File;
import armazenador.*;
/**
 * Essa classe verifica se os dados fornecidos pelo usuario (como rg, ra, etc.) sao validos e podem prosseguir para o andamento do programa.
 * 
 * @author Enzo Marasca, João Pedro Pedott, Pedro Paulo Tonon, Vinícius Queiroz 
 * @version 1004(10/04/2025)
 */
public class Verificacao implements java.io.Serializable
{
    IArmazenador arm = new VetDin();
    //IArmazenador arm = new ListaArray();
    /**
     * //Verifica se o RG é válido
     *
     * @return (boolean) 
     */
    public static boolean verificaID(String rg) 
    {
        boolean ok = true;
        int digitos[] = new int[9];
        int registro = 0;
        int n = 9;
        int teste = 0;
        int tamanho = 8;
        if(rg.length() != 9)
        {
            ok = false;
        }
        else
        {
            if(isNumeric(rg))
            {
                registro = Integer.parseInt(rg);
            }
            else if(rg.charAt(tamanho) == 'x' || rg.charAt(tamanho) == 'X')
            {
                digitos[8] = 10;
                String treco = "";
                tamanho = 7;
                for(int y = 0; y<= tamanho; y++)
                {
                    treco = treco + rg.charAt(y);
                }
                registro = Integer.parseInt(treco);
            }
            else
            {
                ok = false;
            }
            if(ok)
            {
                for(int i = tamanho; i >= 0; i--)
                {
                    digitos[i] = registro%10;
                    registro = registro / 10;
                }
                digitos[8] = digitos[8] * 100;
                for(int k = 7; k >= 0; k--)
                {
                    digitos[k] = digitos[k] * n;
                    n--;
                }
                for(int j =0 ; j <= 8; j++)
                {
                    teste = teste + digitos[j];
    
                }
                if(teste % 11 != 0)
                {
                    ok = false;
                }
            }
        }
        return ok;
    }
    
    /**
     * //Verifica se a idade é um valor númerico
     *
     * @return (boolean) 
     */
    public static boolean verificaIdade(String idade)   
    {
        boolean ok = true;
        ok = isNumeric(idade);
        return ok;
    }
    
    /**
     * //Verifica se o operador é vazio ou númerico
     *
     * @return (boolean) 
     */
    public static boolean verificaVazio(String nome)   
    {
        boolean ok = true;
        ok = !isNumeric(nome);
        if(nome.equals(""))
        {
            ok = false;
        }
        return ok;
    }
    
    /**
     * //Verifica se o RA é númerico e se possui a quantidade correta de digitos
     *
     * @return (boolean) 
     */
    public static boolean verificaRA(String ra)
    {
        boolean ok = true;
        ok = isNumeric(ra);
        if(ok)
        {
            if(ra.length() != 8)
            {
                ok = false;
            }
        }
        return ok;
    }
    
    /**
     * //Verifica se o periodo é númerico
     *
     * @return (boolean) 
     */
    public static boolean verificaPeriodo(String periodo)   
    {
        boolean ok = true;
        ok = isNumeric(periodo);
        return ok;
    }
    
    /**
     * //Verifica se os operadores sao numericos
     *
     * @return (boolean) 
     */
    private static boolean isNumeric(String str)    
    {
        if (str == null || str.length() == 0)
        {
            return false;
        }
            
        boolean foundDecimal = false;
        for (char c : str.toCharArray())
        { // percorre a string
            if (!Character.isDigit(c)) 
            { // verifica se eh digito
                if (c == '.' && !foundDecimal)
                { // verifica se existe um unico ponto
                    foundDecimal = true;
                } 
                else
                {
                    return false;
                }
            }
        }            
        return true;
    }
    
    /**
     * //Verifica se o arquivo com o cadastro existe
     *
     * @return (boolean) 
     */
    public static boolean arquivoExiste(String caminho)    
    {
        File arquivo = new File(caminho);
        
        return arquivo.exists();
    }
    
}
