package med.voll.api.endereco;

public class DadosEndereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;
    
    DadosEndereco(String logradouro, String bairro , String cep, String cidade, String uf, String numero, String complemento){
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "DadosEndereco [logradouro=" + logradouro + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
                + ", uf=" + uf + ", numero=" + numero + ", complemento=" + complemento + "]";
    }

    
}
