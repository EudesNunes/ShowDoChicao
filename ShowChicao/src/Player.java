public class Player {
    String Nome;
    String Profissao;
    String Estado;
    int Acertos;
    int TotalPremio;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public int getAcertos() {
        return Acertos;
    }

    public void setAcertos(int acertos) {
        this.Acertos = acertos;
    }

    public int getTotalPremio() {
        return TotalPremio;
    }

    public void setTotalPremio(int totalPremio) {
        this.TotalPremio = totalPremio;
    }

    public String getProfissao() {
        return Profissao;
    }

    public void setProfissao(String profissao) {
        this.Profissao = profissao;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Player somarpremio(double premio, Player player){
        int acertos = player.getAcertos() + 1;
        int valor = (int) (player.getTotalPremio() + premio);
        player.setAcertos(acertos);
        player.setTotalPremio(valor);
        return player;
    }
}
