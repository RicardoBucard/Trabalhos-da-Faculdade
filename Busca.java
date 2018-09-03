package busca;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Busca {
  
    public static void main(String[] args) throws IOException {
        
        try{
            
            RandomAccessFile f = new RandomAccessFile("C:\\Users\\DELL\\Downloads\\cep_ordenado.dat", "r");
            
            Endereco e = new Endereco();
            
            long inicio = 0;
            
            long fim = f.length()/300 - 1;//usando .length sem subtrair um, acarretaria um out of bounds
            
            System.out.println("Digite o cep a ser procurado:\n");
            
            Scanner end = new Scanner(System.in);
            
            String procurado = end.nextLine();
            
            int count = 0;
            
            while( inicio <= fim){
            
                long meio = (inicio + fim)/ 2;
                
                f.seek(300*meio);
                
                e.leEndereco(f);
                //System.out.println(e.getCep());
                //System.exit(0);
                     
                if (procurado.compareTo(e.getCep()) == 0){//if 1 achou o endereço
              
                    break;
                }
                                
                else if(procurado.compareTo(e.getCep()) < 0){//if 2 o cep é menor do que o cep do meio
                
                    inicio = meio + 1;
                
                }   
                
                else if(procurado.compareTo(e.getCep()) > 0){//if 3 o cep é maior que o cep do meio
                
                    inicio = meio - 1;
                
                }
                
                count++;
             
            }
            
            System.out.println("Endereço do cep " + procurado + " , " + e.getLogradouro()+ " , " + e.getBairro() + " , " + e.getEstado() + " encontrado");
            System.out.println("Número de iterações " + count);
        }
        
        catch(IOException ex){
        
            System.out.println("Arquivo não encontrado");
        
        }
    
    }
}
