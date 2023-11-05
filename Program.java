public class Program {
    public static void main(String[] args) {
        Senha senha = new Senha();
        String gerarSenha = senha.gerarSenha(8);
        String gerarSenhaMaiusculoMinusculo = senha.gerarSenha(8, true);
        String gerarSenhaMaiusculoMinusculoNumero = senha.gerarSenha(8, true, true);
        String gerarSenhaMaiusculoMinusculoNumeroEspecial = senha.gerarSenha(8, true, true, true);

        System.out.println("Senha Minusculos: ");
        System.out.println(gerarSenha);
        System.out.println("Senha Maiusculos e minusculos: ");
        System.out.println(gerarSenhaMaiusculoMinusculo);
        System.out.println("Senha Maiusculos, minusculos e numero: ");
        System.out.println(gerarSenhaMaiusculoMinusculoNumero);
        System.out.println("Senha Maiusculos, minusculos, numero e especial: ");
        System.out.println(gerarSenhaMaiusculoMinusculoNumeroEspecial);

    }
}
