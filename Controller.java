

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.lang.Math;

public class Controller {

    @FXML
    private TextArea TextArea;

    @FXML
    private TextField TextField;

    @FXML
    private Text historyNum;

    private String firstNum = "";

    private String currentNum = "";

    private String operator;

    @FXML
    void btn0Clicked(ActionEvent event) {
        if(!currentNum.equals("")){
            newNum("0");
        }
    }

    @FXML
    void btn1Clicked(ActionEvent event) {
        newNum("1");
    }

    @FXML
    void btn2Clicked(ActionEvent event) {
        newNum("2");
    }

    @FXML
    void btn3Clicked(ActionEvent event) {
        newNum("3");
    }

    @FXML
    void btn4Clicked(ActionEvent event) {
        newNum("4");
    }

    @FXML
    void btn5Clicked(ActionEvent event) {
        newNum("5");
    }

    @FXML
    void btn6Clicked(ActionEvent event) {
        newNum("6");
    }

    @FXML
    void btn7Clicked(ActionEvent event) {
        newNum("7");
    }

    @FXML
    void btn8Clicked(ActionEvent event) {
        newNum("8");
    }

    @FXML
    void btn9Clicked(ActionEvent event) {
        newNum("9");
    }

    @FXML
    void btnBackClicked(ActionEvent event) {
            backspaceprep(event);
    }

    @FXML
    void btnClearAllClicked(ActionEvent event) {
        currentNum = "";
        TextField.setText("");
        historyNum.setText("");
    }

    @FXML
    void btnClearClicked(ActionEvent event) {
        currentNum = "";
        TextField.setText("");
    }

    @FXML
    void btnDivideClicked(ActionEvent event) {
        calculationprep("/");

    }

    @FXML
    void btnEqualClicked(ActionEvent event) {
        try{
        int firstNumVal = Integer.parseInt(firstNum);
        int secondNumVal = Integer.parseInt(currentNum);

        switch (operator) {
            case "+" -> {
                int calculatedNum = firstNumVal + secondNumVal;
                historyNum.setText(firstNum + " + " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
            }
            case "-" -> {
                int calculatedNum = firstNumVal - secondNumVal;
                historyNum.setText(firstNum + " - " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
            }
            case "/" -> {
                double calculatedNum = firstNumVal / (double)secondNumVal;
                historyNum.setText(firstNum + " / " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
            }
            case "*" -> {
                int calculatedNum = firstNumVal * secondNumVal;
                historyNum.setText(firstNum + " * " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
            }
        }
    }
    catch(Exception e){

        double firstNumValD = Double.parseDouble(firstNum);
        double secondNumValD = Double.parseDouble(currentNum);
        switch (operator) {
            case "+" -> {
                Double calculatedNum = firstNumValD + secondNumValD;
                historyNum.setText(firstNum + " + " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
                updateTextField();
            }
            case "-" -> {
                Double calculatedNum = firstNumValD - secondNumValD;
                historyNum.setText(firstNum + " - " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
            }
            case "/" -> {
                double calculatedNum = firstNumValD / secondNumValD;
                historyNum.setText(firstNum + " / " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
            }
            case "*" -> {
                Double calculatedNum = firstNumValD * secondNumValD;
                historyNum.setText(firstNum + " * " + currentNum + " = " + calculatedNum);
                TextField.setText(String.valueOf(calculatedNum));
            }
        }

    }
    }

    @FXML
    void btnMinusClicked(ActionEvent event) {
        calculationprep("-");

    }

    @FXML
    void btnMultiplyClicked(ActionEvent event) {
        calculationprep("*");

    }

    @FXML
    void btnNegClicked(ActionEvent event) {
        minusNum("-");
    }

    @FXML
    void btnPlusClicked(ActionEvent event) {
        calculationprep("+");

    }

    @FXML
    void btndotClicked(ActionEvent event) {
        decimalNum(".");
    }

    @FXML
    void btnFractionClicked(ActionEvent event) {
        fractionprep();
    }

    @FXML
    void btnPercentageClicked(ActionEvent event) {
        percentageprep();
    }

    @FXML
    void btnPowerClicked(ActionEvent event) {
        powerprep();
    }

    @FXML
    void btnSqrtClicked(ActionEvent event) {
        sqrtprep();
    }

    @FXML
    void btnHistoryClicked(ActionEvent event){
        historypopup();
    }

    public void calculationprep(String operator){
        this.operator = operator;
        firstNum = currentNum;
        currentNum = "";
        historyNum.setText(firstNum + " " + operator);
    }

    public void updateTextField(){
        TextField.setText(currentNum);
    }

    public void newNum(String number){
        currentNum += number;
        updateTextField();
    }

    public void decimalNum(String DecNum){
        currentNum = currentNum + DecNum;
        updateTextField();
    }
    
    public void minusNum(String NegNum){
        currentNum = NegNum + currentNum;
        updateTextField();
    }

    public void backspaceprep(ActionEvent event) {
        String backspace = null;
        if(TextField.getText().length()>0) {
            StringBuilder strBuilder = new StringBuilder(TextField.getText());
            strBuilder.deleteCharAt(TextField.getText().length()-1);
            backspace = strBuilder.toString();
            TextField.setText(backspace);
        }
    }

    public void fractionprep(){
        String checktf = TextField.getText();
        int checktfint = Integer.parseInt(checktf);
        if(TextField.getText().length()>0 && checktfint != 0){
        double fractionVal = Double.parseDouble(currentNum);
        double fractionD = 1/fractionVal ;
        currentNum = Double.toString(fractionD);
        updateTextField();
        }
        else{
            TextField.setText("Error!");
        }
    }

    public void percentageprep(){
        String checktf = TextField.getText();
        int checktfint = Integer.parseInt(checktf);
        if(TextField.getText().length()>0 && checktfint != 0){
        double percentageVal1 = Double.parseDouble(currentNum);
        double percentageD = percentageVal1/100 ;
        currentNum = Double.toString(percentageD);
        updateTextField();
        }
        else{
            TextField.setText("Error!");
        }
    }

    public void powerhistory(double powerVal){
        String beforepower = "Sqr(" + powerVal + ")";
        historyNum.setText(beforepower);
    }

    public void sqrthistory(double sqrtD){
        String berforesqrt = "1(" + sqrtD + ")";
        historyNum.setText(berforesqrt);
    }

    public void powerprep(){
        String checktf = TextField.getText();
        int checktfint = Integer.parseInt(checktf);
        if(TextField.getText().length()>0 && checktfint != 0){
        double powerVal = Double.parseDouble(currentNum);
        double powerD = Math.exp(powerVal) ;
        currentNum = Double.toString(powerD);
        updateTextField();
        powerhistory(powerVal);
        }
        else{
            TextField.setText("Error!");
        }
    }

    public void sqrtprep(){
        String checktf = TextField.getText();
        int checktfint = Integer.parseInt(checktf);
        if(TextField.getText().length()>0 && checktfint != 0){
        double sqrtVal = Double.parseDouble(currentNum);
        double sqrtD = Math.sqrt(sqrtVal) ;
        currentNum = Double.toString(sqrtD);
        updateTextField();
        sqrthistory(sqrtVal);
        }
        else{
            TextField.setText("Error!");
        }
    }
    public void historypopup(){
        TextArea.setText(firstNum);
        if(!TextArea.isVisible()){
            TextArea.setVisible(true);
        }
        else{
            TextArea.setVisible(false);
        }
    }

    public void updatehistoryfield(String calculatedNum){
        TextArea.setText(firstNum + operator + currentNum  + "=" + calculatedNum);
    }
    
}
