import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Senha {
    private Character[] alfabetoMaiusculo = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };

    private Character[] alfabetoMinusculo = {
        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    };

    private Character[] especiais = {'!','@','#','$','%','_','-'};

    private Character[] numeros = {'0','1','2','3','4','5','6','7','8','9'};


    public String gerarSenha(int maximoCaracteres){
        Random letraRandomica = new Random();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < maximoCaracteres; i++){
            Integer posicao = letraRandomica.nextInt(alfabetoMinusculo.length);
            sb.append(alfabetoMinusculo[posicao]);
        }
        return sb.toString();
    }

    public String gerarSenha(int maximoCaracteres,boolean isAlfabetoMaiusculoMinusculo){
        Random letraRandomica = new Random();
        StringBuilder sb = new StringBuilder();
        List<Character> maiusculasEMinusculas = new ArrayList<>();
        maiusculasEMinusculas.addAll(Arrays.asList(alfabetoMaiusculo));
        maiusculasEMinusculas.addAll(Arrays.asList(alfabetoMinusculo));

        Collections.shuffle(maiusculasEMinusculas);
        for(int i = 0; i < maximoCaracteres; i++){
            Integer posicao = letraRandomica.nextInt(maiusculasEMinusculas.size());
            sb.append(maiusculasEMinusculas.get(posicao));
        }
        return sb.toString();
    }

    public String gerarSenha(int maximoCaracteres, boolean isAlfabetoMaiusculoMinusculo, boolean isNumeros){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        List<Character> maiusculasMinusculasNumeros = new ArrayList<>();
        maiusculasMinusculasNumeros.addAll(Arrays.asList(alfabetoMaiusculo));
        maiusculasMinusculasNumeros.addAll(Arrays.asList(alfabetoMinusculo));
        maiusculasMinusculasNumeros.addAll(Arrays.asList(numeros));
        
        Collections.shuffle(maiusculasMinusculasNumeros);

        for(int i = 0; i < maximoCaracteres; i++){
            Integer posicao = random.nextInt(maiusculasMinusculasNumeros.size());
            sb.append(maiusculasMinusculasNumeros.get(posicao));
        }
        return sb.toString();
    }

    //criar metodos abaixo para contar se tem 2 numeros pelo menos 
    //isso é para que o gerador de senha seja eficaz adicionando minimo 2 numeros!


}
