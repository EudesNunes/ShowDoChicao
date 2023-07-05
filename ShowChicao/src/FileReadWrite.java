import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileReadWrite {

    public List<QuestionModel> ler(DifficultyLevel nivel) {
        String filePath ="";
        switch (nivel) {
            case FACIL:
                 filePath = "DadosPergunta/PerguntaFacil.txt";
                break;
            case MEDIO:
                filePath = "DadosPergunta/PerguntaMedio.txt";
                break;
            case DIFICIL:
                filePath = "DadosPergunta/PerguntaDificil.txt";
                break;
        }

        List<QuestionModel> Linhas = new ArrayList<>();
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String cdPergunta = line.substring(0, line.indexOf("/"));
                String dsPergunta = line.substring(line.indexOf("/") + 1);
                List<AnswerModel> Listarespostas = LerRespostas(cdPergunta);
                String cdRespostaCorreta = LerRespostaCorreta(cdPergunta);
                    Linhas.add(new QuestionModel(cdPergunta,dsPergunta,Listarespostas,cdRespostaCorreta));
            }
            return Linhas;
        }
        catch (IOException e) {
            e.printStackTrace();
            return Linhas;
        }
    }

    private List<AnswerModel> LerRespostas(String CdPergunta) {
        String filePath = "C:DadosPergunta/Respostas.txt";
        List<AnswerModel> Linhas = new ArrayList<>();
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String cdPergunta = line.substring(0, line.indexOf("/"));
                if(cdPergunta.equals(CdPergunta)) {
                    String cdResposta = line.substring(line.indexOf("/") + 1, line.indexOf("="));
                    String dsResposta = line.substring(line.indexOf("=") + 1);
                    Linhas.add(new AnswerModel(cdPergunta, cdResposta, dsResposta));
                }
            }
            return Linhas;
        }
        catch (IOException e) {
            e.printStackTrace();
            return Linhas;
        }
    }
    private String LerRespostaCorreta(String CdPergunta) {
        String filePath = "C:DadosPergunta/RespostaCorreta.txt";
        String resposta =null;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String cdPergunta = line.substring(0, line.indexOf("/"));
                if(cdPergunta.equals(CdPergunta)) {
                    return  resposta = line.substring(line.indexOf("/") + 1);
                }
            }
            return resposta;
        }
        catch (IOException e) {
            e.printStackTrace();
            return resposta;
        }
    }

    public void Escrever(QuestionModel pergunta, DifficultyLevel nivel) {

        String filePath ="";
        switch (nivel) {
            case FACIL:
                filePath = "DadosPergunta/PerguntaFacil.txt";
                break;
            case MEDIO:
                filePath = "DadosPergunta/PerguntaMedio.txt";
                break;
            case DIFICIL:
                filePath = "DadosPergunta/PerguntaDificil.txt";
                break;
        }
        File arquivoPergunta = new File(filePath);

        EscreverRespostas(pergunta.getListaRespostas());
        EscreverRespostasCorretas(pergunta.getCdPergunta(),pergunta.getCdRespostaCorreta());
        String cdPergunta = pergunta.getCdPergunta();
        String dsPergunta = pergunta.getDsPergunta();
        String texto = String.format("%s/%s",cdPergunta,dsPergunta);
        System.out.println(texto);

        try {
            if (!arquivoPergunta.exists()) {
                arquivoPergunta.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(arquivoPergunta, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(texto);
            writer.newLine();
            writer.close();
            System.out.println("Pergunta escrito com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private void EscreverRespostas(List<AnswerModel> answerModel) {

        File arquivoRespostas = new File("DadosPergunta/Respostas.txt");


        try {
            if (!arquivoRespostas.exists()) {
                arquivoRespostas.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(arquivoRespostas, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (AnswerModel resposta : answerModel) {
                String linha = String.format("%s/%s=%s", resposta.getCdPergunta(),resposta.getCdResposta(), resposta.getDsResposta());
                writer.write(linha);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }
    private void EscreverRespostasCorretas(String cdPergunta, String cdresposta) {

        File arquivoRespostas = new File("DadosPergunta/RespostaCorreta.txt");

        String texto = String.format("%s/%s",cdPergunta,cdresposta);
        System.out.println(texto);

        try {
            if (!arquivoRespostas.exists()) {
                arquivoRespostas.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(arquivoRespostas, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(texto);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
