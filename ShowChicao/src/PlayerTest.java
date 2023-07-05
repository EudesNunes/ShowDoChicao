import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void SomarPremioTest(){
        Player j = new Player();
        j.somarpremio(10,j);
        j.somarpremio(25,j);
        Assert.assertEquals("Total Premio", 35,j.getTotalPremio());
        Assert.assertEquals("Acertos", 2,j.getAcertos());

    }
}
