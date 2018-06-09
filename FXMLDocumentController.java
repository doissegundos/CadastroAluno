package cadastro;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField sobrenomeTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField diaTextField;
    @FXML
    private TextField mesTextField;
    @FXML
    private TextField anoTextField;
    @FXML
    private TextField matriculaTextField;
    @FXML
    private ComboBox<String> cursoComboBox;
    @FXML
    private Button cadastarButton;
    @FXML
    private TextField nota2TextField;
    @FXML
    private TextField nota3TextField;
    @FXML
    private TextField nota1TextField;
    @FXML
    private Button anteriorButton;
    @FXML
    private Button proximoButton;

    private List<String> listaDeCursos = new ArrayList<String>(); // nessa linha é criado um vetor que vai armazenar a lista dos cursos no ComboBox
    private ObservableList<String> observableListCursos; // nessa linha é criado um observablelist que vai armazenar o vetor arraylist
    private List<Aluno> dadosAluno = new ArrayList<Aluno>();//nessa linha criamos um arraylist de Alunos
    private int posiçãoVetor; // aqui criamos uma variavel que vai controlar a posição do vetor
    private int maiorPosição; //essa variavel vai receber a maior posição do arraylist
    @FXML
    private TextArea exibiçãoTextArea;
    @FXML
    private Button excluirButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxCurso(); // chamamos o metodo comboBoxCurso() para assim os cursos serem adicionados no combobox

    }

    public void comboBoxCurso() { // esse metodo vai adicionar os cursos ao combobox

        String cienciasEconomicas = new String("Ciências Econômicas");
        String engComputação = new String("Engenharia da Computação");
        String engEletrica = new String("Engenharia Elétrica");
        String finanças = new String("Finanças");
        String medicina = new String("Medicina");
        String musica = new String("Música");
        String odontologia = new String("Odontologia");
        String psicologia = new String("Psicologia");

        //adicionando objetos ao ArrayList
        listaDeCursos.add(cienciasEconomicas);
        listaDeCursos.add(engComputação);
        listaDeCursos.add(engEletrica);
        listaDeCursos.add(finanças);
        listaDeCursos.add(medicina);
        listaDeCursos.add(musica);
        listaDeCursos.add(odontologia);
        listaDeCursos.add(psicologia);

        observableListCursos = FXCollections.observableArrayList(listaDeCursos);

        cursoComboBox.setItems(observableListCursos);

    }

    @FXML
    public void cadastarAluno() { //esse metodo vai ser chamado pelo Button "cadastrar" e vai inserir os dados dos alunos no arraylist
       
        try { // utilizamos o controlador de exceções para caso der algum erro, ou algum usuario inserir algum dado invalido
            int pos = dadosAluno.size();
            String nome = nomeTextField.getText();
            String sobrenome = sobrenomeTextField.getText();
            String email = emailTextField.getText();
            String dia = diaTextField.getText();
            String mes = mesTextField.getText();
            String ano = anoTextField.getText();
            int matricula = Integer.parseInt(matriculaTextField.getText());
            float nota1 = Float.parseFloat(nota1TextField.getText());
            float nota2 = Float.parseFloat(nota2TextField.getText());
            float nota3 = Float.parseFloat(nota3TextField.getText());
            String curso = cursoComboBox.getSelectionModel().getSelectedItem();

            //fizemos um objeto do tipo Aluno e estamos enviando para ele os parametros
            PosiçãoArrayList posição = new PosiçãoArrayList(pos);
            Aluno aluno = new Aluno(curso, matricula, nota1, nota2, nota3, nome, sobrenome, email, dia, mes, ano);

            dadosAluno.add(aluno);//agora estamos adicionando os dados de aluno no arraylist

            posiçãoVetor = Integer.parseInt(posição.toString());
            exibiçãoTextArea.setText("pos: " + (posiçãoVetor + 1) + "\n" + dadosAluno.get(posiçãoVetor).toString());
            maiorPosição = dadosAluno.size() - 1;

            nomeTextField.setText(null);
            sobrenomeTextField.setText(null);
            emailTextField.setText(null);
            diaTextField.setText(null);
            mesTextField.setText(null);
            anoTextField.setText(null);
            matriculaTextField.setText(null);
            nota1TextField.setText(null);
            nota2TextField.setText(null);
            nota3TextField.setText(null);
            
        } catch (Exception erro) { //caso algum usuario insira dados invalidos ele irá chamar o metodo dadosErrados
            dadosErrados();
        }
    }

    @FXML
    public void excluirbutton() { //esse metodo vai controlar o button "excluir"
        try {
            dadosAluno.remove(posiçãoVetor);
            if (posiçãoVetor > 0) {
                posiçãoVetor--;
                exibiçãoTextArea.setText("pos: " + (posiçãoVetor + 1) + "\n" + dadosAluno.get(posiçãoVetor).toString());
            } else {
                if (posiçãoVetor == 0) {
                    try {
                        posiçãoVetor = maiorPosição;
                        exibiçãoTextArea.setText("pos: " + (posiçãoVetor + 1) + "\n" + dadosAluno.get(posiçãoVetor).toString());
                    } catch (Exception erro) {
                        exibiçãoTextArea.setText(null);
                    }
                }
            }
        } catch (Exception erro) {
            listaVazia();
        }
    }

    public void proximoButton() { // esse metodo vai controlar o button "proximo"
        try {
            maiorPosição = dadosAluno.size() - 1;
            if (posiçãoVetor < maiorPosição) {
                posiçãoVetor++;
                exibiçãoTextArea.setText("pos: " + (posiçãoVetor + 1) + "\n" + dadosAluno.get(posiçãoVetor).toString());
            } else {
                posiçãoVetor = 0;
                exibiçãoTextArea.setText("pos: " + (posiçãoVetor + 1) + "\n" + dadosAluno.get(posiçãoVetor).toString());
            }
        } catch (Exception erro) {

        }
    }

    public void anteriorButtor() { //esse metodo vai controlar o button "anterior"
        try {
            maiorPosição = dadosAluno.size() - 1;
            if (posiçãoVetor > 0) {
                posiçãoVetor--;
                exibiçãoTextArea.setText("pos: " + (posiçãoVetor + 1) + "\n" + dadosAluno.get(posiçãoVetor).toString());
            } else {
                posiçãoVetor = maiorPosição;
                exibiçãoTextArea.setText("pos: " + (posiçãoVetor + 1) + "\n" + dadosAluno.get(posiçãoVetor).toString());
            }

        } catch (Exception erro) {

        }
    }
    public void listaVazia() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Lista vazia");
        alert.showAndWait();
    }
    public void dadosErrados() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Dado(s) inválidos. Confira os dados fornecidos.");
        alert.showAndWait();
    }
}
