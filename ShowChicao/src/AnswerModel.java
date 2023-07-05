import java.util.UUID;

public class AnswerModel {
    String CdPergunta;
    String CdResposta;
    String DsResposta;

    public AnswerModel(String cdPergunta, String dsResposta) {
        UUID guid = UUID.randomUUID();

        CdPergunta = cdPergunta;
        CdResposta = guid.toString();
        DsResposta = dsResposta;
    }
    public AnswerModel(String cdPergunta, String cdResposta, String dsResposta) {
        CdPergunta = cdPergunta;
        CdResposta = cdResposta;
        DsResposta = dsResposta;
    }


    public String getCdPergunta() {
        return CdPergunta;
    }

    public String getCdResposta() {
        return CdResposta;
    }

    public String getDsResposta() {
        return DsResposta;
    }
}

