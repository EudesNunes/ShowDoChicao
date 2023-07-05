import java.util.*;

public class Main {
    public static void main(String[] args) {

        Question gerencia = new Question();
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Digite:");
        System.out.println("J: Para Jogar");
        System.out.println("N: Para Adicionar nova pergunta");
        System.out.println("Enter: Para sair");

        String digitoInicio = leitor.nextLine();

        if(digitoInicio.equals("N") || digitoInicio.equals("n")){
            while (continuar){
                gerencia.NovaPergunta();
                System.out.println("Deseja sair? Digite S para sim");
                String digito = leitor.nextLine();
                if(digito.equals("S") ||digito.equals("s")){
                    continuar = false;
                }
            }
        } else if (digitoInicio.equals("J") || digitoInicio.equals("j")) {
            ToPlay jogar = new ToPlay();

            jogar.Play();

        }else{
            System.out.println("Saindo");
        }





    }
}