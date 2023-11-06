import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Senha {
    private Character[] alfabetoMaiusculo = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'
    };

    private Character[] alfabetoMinusculo = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'
    };

    private Character[] especiais = { '!', '@', '#', '$', '%', '_', '-' };

    private Character[] numeros = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public String gerarSenha(int maximoCaracteres) {
        Random letraRandomica = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maximoCaracteres; i++) {
            Integer posicao = letraRandomica.nextInt(alfabetoMinusculo.length);
            sb.append(alfabetoMinusculo[posicao]);
        }
        return sb.toString();
    }

    public String gerarSenha(int maximoCaracteres, boolean isAlfabetoMaiusculoMinusculo) {
        Random letraRandomica = new Random();
        StringBuilder sb = new StringBuilder();
        List<Character> maiusculasEMinusculas = new ArrayList<>();
        maiusculasEMinusculas.addAll(Arrays.asList(alfabetoMaiusculo));
        maiusculasEMinusculas.addAll(Arrays.asList(alfabetoMinusculo));

        Collections.shuffle(maiusculasEMinusculas);
        for (int i = 0; i < maximoCaracteres; i++) {
            Integer posicao = letraRandomica.nextInt(maiusculasEMinusculas.size());
            sb.append(maiusculasEMinusculas.get(posicao));
        }
        return sb.toString();
    }

    public String gerarSenha(int maximoCaracteres, boolean isAlfabetoMaiusculoMinusculo, boolean isNumeros) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        List<Character> maiusculasMinusculasNumeros = new ArrayList<>();

        maiusculasMinusculasNumeros.addAll(Arrays.asList(alfabetoMaiusculo));
        maiusculasMinusculasNumeros.addAll(Arrays.asList(alfabetoMinusculo));
        maiusculasMinusculasNumeros.addAll(Arrays.asList(numeros));

        Collections.shuffle(maiusculasMinusculasNumeros);

        for (int i = 0; i < maximoCaracteres; i++) {
            Integer posicao = random.nextInt(maiusculasMinusculasNumeros.size());

            if (i < maximoCaracteres && peloMenos1Numero(sb) == false) {
                sb.append(random.nextInt(9));
            } else {
                sb.append(maiusculasMinusculasNumeros.get(posicao));
            }
        }
        return sb.toString();
    }

    public String gerarSenha(int maximoCaracteres, boolean isAlfabetoMaiusculoMinusculo, boolean isNumeros,
            boolean isEspecial) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        List<Character> maiusculasMinusculasNumerosEspecial = new ArrayList<>();

        maiusculasMinusculasNumerosEspecial.addAll(Arrays.asList(alfabetoMaiusculo));
        maiusculasMinusculasNumerosEspecial.addAll(Arrays.asList(alfabetoMinusculo));
        maiusculasMinusculasNumerosEspecial.addAll(Arrays.asList(numeros));
        maiusculasMinusculasNumerosEspecial.addAll(Arrays.asList(especiais));

        Collections.shuffle(maiusculasMinusculasNumerosEspecial);

        Integer numeroRandom = random.nextInt(especiais.length);

        for (int i = 0; i < maximoCaracteres; i++) {
            Integer posicao = random.nextInt(maiusculasMinusculasNumerosEspecial.size());

            if (i < maximoCaracteres && peloMenos1Numero(sb) == false) {
                if (peloMenos1Especial(sb) == false) {
                    sb.append(especiais[numeroRandom]);
                }
            } else {
                sb.append(maiusculasMinusculasNumerosEspecial.get(posicao));
            }
        }
        return sb.toString();
    }

    // UTILS

    private boolean peloMenos1Numero(StringBuilder list) {
        int contador = 0;
        for (Character c : list.toString().toCharArray()) {
            if (!Character.isLetter(c)) {
                contador++;
            }
        }
        if (contador < 1) {
            return false;
        } else {
            return true;
        }

    }

    private boolean peloMenos1Especial(StringBuilder list) {
        int contador = 0;
        for (Character c : list.toString().toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                contador++;
            }
        }
        if (contador < 1) {
            return false;
        } else {
            return true;
        }

    }

}
