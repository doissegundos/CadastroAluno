package alunocadastro;

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

        //aqui vamos calculcar o mes atual
        SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
        String mesForm = formatarMes.format(data);
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
        int idade = -1;
        if (anoNas <= anoAtual && mesNas <= 12) {
            if (diaVeridico(diaNas, mesNas, anoNas) == true) {
                idade = anoAtual - anoNas;
                if (mesAtual < mesNas) {
                    idade--;
                }
                if (mesAtual == mesNas && diaAtual < diaNas) {
                    idade--;
                }
            }
        }
        return idade;
    }

    public String dataDeNascimento() {
        return dia + "/" + mes + "/" + ano;
    }

    public boolean diaVeridico(int diaNas, int mesNas, int anoNas) {
        boolean retorno = false;
        if (mesNas == 2) {
            if (diaNas <= 29 && (anoNas % 4 == 0) || diaNas <= 28) {
                retorno = true;
            } else {
                retorno = false;
            }
        }
        if (mesNas == 1 || mesNas == 3 || mesNas == 5 || mesNas == 7 || mesNas == 8 || mesNas == 10 || mesNas == 12) {
            if (diaNas <= 31) {
                retorno = true;
            } else {
                retorno = false;
            }
        }
        if (mesNas == 4 || mesNas == 6 || mesNas == 9 || mesNas == 11) {
            if (diaNas <= 30) {
                retorno = true;
            } else {
                retorno = false;
            }
        }
        return retorno;
    }

}
