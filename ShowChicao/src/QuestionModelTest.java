import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionModelTest {

    @Test
    public void QuentionTest(){
        List<AnswerModel> respostas = new ArrayList<>();
        respostas.add(new AnswerModel("P1", "a1"));
        respostas.add(new AnswerModel("P1", "a2"));
        respostas.add(new AnswerModel("P1", "a3"));

        QuestionModel pergunta1 = new QuestionModel("P1", "Qual é a capital do Brasil?", respostas);

        Assert.assertEquals("Codigo Pergunta","P1", pergunta1.getCdPergunta());
        Assert.assertEquals("Descricao Pergunta","Qual é a capital do Brasil?", pergunta1.getDsPergunta());
        Assert.assertEquals("Respostas da Pergunta",respostas, pergunta1.getListaRespostas());

        QuestionModel pergunta2 = new QuestionModel("P2", "Qual é a capital da França?", respostas, "R2");

        Assert.assertEquals("Codigo Pergunta","P2", pergunta2.getCdPergunta());
        Assert.assertEquals("Descricao Pergunta", "Qual é a capital da França?", pergunta2.getDsPergunta());
        Assert.assertEquals("Respostas da Pergunta", respostas, pergunta2.getListaRespostas());
        Assert.assertEquals("Respota correta Pergunta", "R2", pergunta2.getCdRespostaCorreta());

    }
}
