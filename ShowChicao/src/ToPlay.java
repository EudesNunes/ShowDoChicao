import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ToPlay {

    public void Play()
    {
        FileReadWrite arquivos = new FileReadWrite();
        Chicao chicao = new Chicao();
        Random random = new Random();
        List<QuestionModel> PerguntasFacil = arquivos.ler(DifficultyLevel.FACIL);
        List<QuestionModel> PerguntasMedio = arquivos.ler(DifficultyLevel.MEDIO);
        List<QuestionModel> PerguntasDificil = arquivos.ler(DifficultyLevel.DIFICIL);
        DifficultyLevel nivel = DifficultyLevel.FACIL;
        boolean Fim = false;
        boolean Ganhou = false;
        int erros = 0;
        int cont = 1;
        double premio = 0;
        Player player = chicao.Iniciar();

        while (!Fim) {
            QuestionModel PerguntaAleatoria;
            boolean acerto = false;
            System.out.println(cont == 1 ? "Primeira Pergunta!" : "Próxima pergunta!");
            System.out.println("--------------------------------");
            if (nivel == DifficultyLevel.FACIL) {
                System.out.println("Nível 1");
                int index = random.nextInt(PerguntasFacil.size());
                PerguntaAleatoria = PerguntasFacil.remove(index);
                premio = 1000;
                acerto = chicao.FazerPergunta(PerguntaAleatoria, premio);

            } else if (nivel == DifficultyLevel.MEDIO) {
                System.out.println("Nível 2");
                int index = random.nextInt(PerguntasMedio.size());
                PerguntaAleatoria = PerguntasMedio.remove(index);
                premio = 10000;
                acerto = chicao.FazerPergunta(PerguntaAleatoria, premio);

            } else if (nivel == DifficultyLevel.DIFICIL) {
                int index = random.nextInt(PerguntasDificil.size());
                PerguntaAleatoria = PerguntasDificil.remove(index);
                if (cont == 16) {
                    System.out.println("Agora, a pergunta que vale um milhão de reais");
                    System.out.println("Chegamos na pergunta decisiva, valendo o prêmio máximo");
                    premio = 1000000;

                } else {
                    System.out.println("Nível 3");
                    premio = 100000;
                }
                acerto = chicao.FazerPergunta(PerguntaAleatoria, premio);

            }
            if (!acerto) {
                if (cont < 16) {
                    if (erros < 3) {
                        System.out.println("---------------------------");
                        System.out.println("Infelizmente, você errou");
                        System.out.println("---------------------------");


                    } else {
                        System.out.println("---------------------------");
                        System.out.println("Infelizmente, você errou. Mas você vai levar para casa o valor de R$"+ player.getTotalPremio());
                        System.out.println("Fim");
                        System.out.println("---------------------------");
                        Fim = true;
                    }
                } else {
                    System.out.println("---------------------------");
                    System.out.println("Infelizmente,Você perdeu tudo");
                    System.out.println("Fim");
                    System.out.println("---------------------------");
                    Fim = true;
                }
                erros += 1;

            } else {
                player = player.somarpremio(premio, player);
                if (cont == 16) {
                    System.out.println("---------------------------");
                    System.out.println("Você acertou! Parabéns, você ganhou um milhão de reais!");
                    System.out.println("Você vai levar para casa o valor de R$" + player.getTotalPremio());

                    System.out.println("---------------------------");
                    Fim = true;
                } else {
                    System.out.println("---------------------------");
                    System.out.println("Maaaa Oi, você acertou!");
                    System.out.println("---------------------------");
                }

            }

            cont += 1;
            nivel = cont <= 5 ? DifficultyLevel.FACIL : cont <= 10 ? DifficultyLevel.MEDIO : DifficultyLevel.DIFICIL;

            if(player.getAcertos() > 5){
                Scanner scanner = new Scanner(System.in);

                System.out.println("Deseja continuar, ou parar com prêmio de R$"+ player.getTotalPremio());
                System.out.println("Digite S para sair ou Enter para continuar");
                String Parar = scanner.nextLine();
                if(Parar.equals("S") || Parar.equals("s")){
                    System.out.println("---------------------------");
                    System.out.println("Muito bem! Você optou por encerrar o jogo e levar o prêmio garantido de R$"+ player.getTotalPremio());
                    System.out.println("---------------------------");
                    Fim = true;
                }

            }
        }
    }

}
