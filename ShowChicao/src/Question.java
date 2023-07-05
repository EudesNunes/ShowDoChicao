import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Question {

    public void NovaPergunta(){
        boolean continuar= true;
        List<AnswerModel> respotasLista = new ArrayList<>();
        FileReadWrite FileReadWrite = new FileReadWrite();
        Scanner scanner = new Scanner(System.in);

            UUID guidPergunta = UUID.randomUUID();
            DifficultyLevel nivel = DifficultyLevel.FACIL;
            while (continuar) {
                System.out.println("Qual o nivel da Pergunta: F=Facil, M=Medio,D=Dicil");
                String nivelString = scanner.nextLine();
                String filePath ="";
                if(nivelString.equals("F") || nivelString.equals("f")){
                    nivel = DifficultyLevel.FACIL;
                    continuar = false;
                }else if(nivelString.equals("M") || nivelString.equals("m")){
                    nivel = DifficultyLevel.MEDIO;
                    continuar = false;
                }else if(nivelString.equals("D") || nivelString.equals("d")){
                    nivel = DifficultyLevel.DIFICIL;
                    continuar = false;
                }else {
                    System.out.println("Erro, não encontrado valor " + nivelString);
                }

                System.out.println("-----------");
            }
            System.out.println("Digite a Pergunta:");
            String dsPergunta = scanner.nextLine();
            System.out.println("-----------");

            System.out.println("Digite a Resposta Correta:");
            String dsRespostaCorreta = scanner.nextLine();
            AnswerModel RespostaCorreta = new AnswerModel(guidPergunta.toString(),dsRespostaCorreta);
            respotasLista.add(RespostaCorreta);
            System.out.println("-----------");

            for (int i = 0; i < 3; i++){
                System.out.println("Digite a Resposta Secundaria:");
                String dsResposta = scanner.nextLine();
                respotasLista.add(new AnswerModel(guidPergunta.toString(),dsResposta));
                System.out.println("-----------");
            }

        QuestionModel pergunta = new QuestionModel(guidPergunta.toString(),dsPergunta,respotasLista,RespostaCorreta.getCdResposta());

        FileReadWrite.Escrever(pergunta,nivel);
    }
}
