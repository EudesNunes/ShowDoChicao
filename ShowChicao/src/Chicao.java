import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Chicao {

    public Player Iniciar() {
        Scanner leitor = new Scanner(System.in);
        Player player = new Player();
        System.out.println("Tra la lá, oi, tralalá, oi, boa noite prezados telespectadores, estamos iniciando mais um " +
                "show do chicão!: ");
        System.out.println("Para iniciar, convidamos o primeiro jogador, o primeiro jogador é um jovem muito esperto," +
                "como você se chama jovem esperto?");
        String Nome = leitor.nextLine();
        player.setNome(Nome);
        System.out.println("Seja bem-vindo ao Show do Chicão " + Nome);
        System.out.println("Qual sua Profissão " + Nome + "?");
        String Profissao = leitor.nextLine();
        player.setProfissao(Profissao);
        System.out.println("E de onde você vem?");
        String Estado = leitor.nextLine();
        player.setEstado(Estado);
        System.out.println("Telespectadores, está começando o Show do Chicão com " + Nome + " que vem de " + Estado + " e é " + Profissao);
        return player;
    }
    public boolean FazerPergunta(QuestionModel pergunta, double valor){
        Scanner scanner = new Scanner(System.in);
        System.out.println("A pergunta valendo " +valor+ " em barras de ouro, que vale mais do que dinheiro!");
        System.out.println(pergunta.getDsPergunta());
        List<AnswerModel> respostas= pergunta.getListaRespostas();
        boolean continuar = true;
        boolean ganhou = false;
        while (continuar) {
            Collections.shuffle(respostas);
            for (int item =0; item <= 3; item++){
                System.out.println(item + ") " + respostas.get(item).getDsResposta());

            }
            String resposta = scanner.nextLine();

            System.out.println("Você está certo disso?");
            System.out.println("Digite M para mudar");
            System.out.println("ou enter para continuar");
            String confirmar= scanner.nextLine();

            if(!confirmar.equals("m") || !confirmar.equals("m")) {
                if (resposta.equals("0") || resposta.equals("1") || resposta.equals("2") || resposta.equals("3")) {
                    ganhou = (respostas.get(Integer.parseInt(resposta)).getCdResposta().equals(pergunta.getCdRespostaCorreta()));
                    continuar = false;
                } else {
                    System.out.println("Erro, valor inválido");
                    System.out.println(pergunta.getDsPergunta());
                }
            }

        }
        return ganhou;
    }

}
