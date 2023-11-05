public class Program{
    public static void main(String[] args) {
        Senha senha = new Senha();
        String gerarSenha = senha.gerarSenha(8);
        
        System.out.println("Só minusculos: ");
        System.out.println(gerarSenha);
        System.out.println();
        System.out.println("Maiusculos e minusculos: ");
        System.out.println(senha.gerarSenha(8, true));


    }
}
