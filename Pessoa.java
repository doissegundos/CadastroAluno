package cadastro;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String email;
    private String dia;
    private String mes;
    private String ano;

    public Pessoa(String nome, String Sobrenome, String email, String dia, String mes, String ano) {
        this.nome = nome;
        this.sobrenome = Sobrenome;
        this.email = email;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.sobrenome = Sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String nomeCompleto() {
        return nome + " " + sobrenome;
    }

    public int idade() {
        //aqui vamos calculcar o ano atual
        Date data = new Date();
        SimpleDateFormat formatarAno = new SimpleDateFormat("y");
        String anoForm = formatarAno.format(data);
        int anoAtual = Integer.parseInt(anoForm);

        //aqui vamos calculcar o dia atual
        SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
        String mesForm = formatarAno.format(data);
        int mesAtual = Integer.parseInt(mesForm);

        //aqui vamos calculcar o dia atual
        SimpleDateFormat formatarDia = new SimpleDateFormat("dd");
        String diaForm = formatarDia.format(data);
        int diaAtual = Integer.parseInt(diaForm);

        //aqui vamos converter o dia, mes e ano que estão em String e foram recebidos como parametro da classe FXMLDOCUMENTCONTROLER para inteiro
        int diaNas = Integer.parseInt(dia);
        int mesNas = Integer.parseInt(mes);
        int anoNas = Integer.parseInt(ano);

        //aqui está sendo feito o calculo da idade
        int idade = anoAtual - anoNas;
        if(mesAtual<mesNas){
            if(diaAtual<diaNas){
                idade--;
            }        
        }
        return idade;
    }

    public String dataDeNascimento() {
        return dia + "/" + mes + "/" + ano;
    }

}
