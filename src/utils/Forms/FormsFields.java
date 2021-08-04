package utils.Forms;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public abstract class FormsFields implements Initializable {

    protected List<TextField> letterFieldsList;
    protected List<TextField> numbersFieldsList;
    protected List<TextField> floatsFieldsList;

    protected Alert alert;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Un error ha ocurrido");

        letterFieldsList = new LinkedList<>();
        numbersFieldsList = new LinkedList<>();
        floatsFieldsList = new LinkedList<>();
    }

    protected boolean isEmpty(TextField textField) {
        boolean valor = textField.getText().isBlank();
        if (valor)
            textField.setStyle(" -fx-background-color: red;");
        else
            textField.setStyle(" -fx-background-color: white;");
        return valor;
    }

    protected boolean verifyLetters(TextField textField) {
        String txt = textField.getText();
        boolean valor = txt.matches("[a-zA-Z\s]*$");
        if (!valor && !txt.equals("")) {
            textField.setStyle(" -fx-background-color: red;");
            valor = false;
        } else {
            textField.setStyle(" -fx-background-color: white;");
            valor = true;
        }
        return valor;
    }

    protected boolean verifyNumbers(TextField textField) {
        boolean valor = textField.getText().matches("[0-9]*$");
        if (!valor)
            textField.setStyle(" -fx-background-color: red;");
        else
            textField.setStyle(" -fx-background-color: white;");
        return valor;
    }

    protected boolean verifyFloats(TextField textField) {
        boolean valor = textField.getText().matches("^\\d*\\.\\d+|\\d+\\.\\d*$");
        if (!valor)
            textField.setStyle(" -fx-background-color: red;");
        else
            textField.setStyle(" -fx-background-color: white;");
        return valor;
    }

    protected boolean areEmpty() {
        boolean isCorrect = false;
        if (numbersFieldsList != null)
            for (TextField tField : numbersFieldsList) {
                isCorrect = isCorrect | isEmpty(tField);
            }

        if (letterFieldsList != null)
            for (TextField tField : letterFieldsList) {
                isCorrect = isCorrect | isEmpty(tField);
            }

        return isCorrect;
    }

    protected boolean verifyAllNumbers() {
        boolean isCorrect = true;
        if (numbersFieldsList != null)
            for (TextField tField : numbersFieldsList) {
                isCorrect = isCorrect & verifyNumbers(tField);
            }

        return isCorrect;
    }

    protected boolean verifyAllFloats() {
        boolean isCorrect = true;
        if (numbersFieldsList != null)
            for (TextField tField : numbersFieldsList) {
                isCorrect = isCorrect & verifyFloats(tField);
            }

        return isCorrect;
    }

    protected boolean verifyAllLetters() {
        boolean isCorrect = true;
        if (letterFieldsList != null)
            for (TextField tField : letterFieldsList) {
                isCorrect = isCorrect & verifyLetters(tField);
            }
        return isCorrect;
    }

}
