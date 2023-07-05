import java.util.List;

public class QuestionModel {
    private String CdPergunta;
    private String DsPergunta;
    private String CdRespostaCorreta;
    private List<AnswerModel> ListaRespostas;

    public QuestionModel(String cdPergunta, String dsPergunta, List<AnswerModel> listaRespostas) {
        CdPergunta = cdPergunta;
        DsPergunta = dsPergunta;
        ListaRespostas = listaRespostas;
    }
    public QuestionModel(String cdPergunta, String dsPergunta, List<AnswerModel> listaRespostas, String cdRespostaCorreta) {
        CdPergunta = cdPergunta;
        DsPergunta = dsPergunta;
        ListaRespostas = listaRespostas;
        CdRespostaCorreta = cdRespostaCorreta;

    }

    public String getCdPergunta() {
        return CdPergunta;
    }

    public String getDsPergunta() {
        return DsPergunta;
    }

    public List<AnswerModel> getListaRespostas() {
        return ListaRespostas;
    }

    public String getCdRespostaCorreta() {
        return CdRespostaCorreta;
    }
}
