package controllerview;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.ColorCode;
import model.Model;

import java.io.*;

/**
 * uebung 12 & 13
 * @author Brunmayr Sarah
 * @version 12.0.1, 28.01.2021
 */

public class Controller {

    private Model m = new Model();

    @FXML
    TextField txt_red = new TextField();
    @FXML
    TextField txt_blue = new TextField();
    @FXML
    TextField txt_green = new TextField();
    @FXML
    Text txt_hex = new Text("#000000");
    @FXML
    Button colorview = new Button();

    @FXML
    public void plusRED(){
        try{
            m.changeColorViaRelativeValue(ColorCode.RED, 10);
            txt_red.setText(Integer.toString(m.getRed()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void minusRED(){
        try{
            m.changeColorViaRelativeValue(ColorCode.RED,-10);
            txt_red.setText(Integer.toString(m.getRed()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void plusGREEN(){
        try{
            m.changeColorViaRelativeValue(ColorCode.GREEN, 10);
            txt_green.setText(Integer.toString(m.getGreen()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void minusGREEN(){
        try{
            m.changeColorViaRelativeValue(ColorCode.GREEN,-10);
            txt_green.setText(Integer.toString(m.getGreen()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void plusBLUE(){
        try{
            m.changeColorViaRelativeValue(ColorCode.BLUE, 10);
            txt_blue.setText(Integer.toString(m.getBlue()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void minusBLUE(){
        try{
            m.changeColorViaRelativeValue(ColorCode.BLUE,-10);
            txt_blue.setText(Integer.toString(m.getBlue()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Error! Try again!");
        }

    }
    @FXML
    public void absolutRED(){
        try{
            m.changeColorViaAbsoluteValue(ColorCode.RED, txt_red.getText());
            txt_red.setText(Integer.toString(m.getRed()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Es muss eine Zahl eingegeben werden!");
        }
    }
    @FXML
    public void absolutGREEN(){
        try{
            m.changeColorViaAbsoluteValue(ColorCode.GREEN, txt_green.getText());
            txt_green.setText(Integer.toString(m.getGreen()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Es muss eine Zahl eingegeben werden!");
        }

    }
    @FXML
    public void absolutBLUE(){
        try{
            m.changeColorViaAbsoluteValue(ColorCode.BLUE, txt_blue.getText());
            txt_blue.setText(Integer.toString(m.getBlue()));
            hex();
        }
        catch (Exception ex){
            System.err.println("Es muss eine Zahl eingegeben werden!");
        }
    }
    private void hex(){
        txt_hex.setText(m.getHex());
        colorview.setStyle("-fx-background-color:"+m.getHex()+";");
    }

    @FXML
    public boolean saveFromFile(){
        boolean saved = false;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("color.dat")))
        {
            bufferedWriter.write("Color File Format v.1.0");
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(m.getRed()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(m.getGreen()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(m.getBlue()));
            saved = true;
        }
        catch (IOException ex)
        {
            System.out.println("Something went wrong");
        }

        return saved;
    }

    @FXML
    public boolean loadFromFile(){
        boolean saved = false;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("color.dat")))
        {
            bufferedReader.readLine();
            m.changeColorViaAbsoluteValue(ColorCode.RED, bufferedReader.readLine());
            txt_red.setText(Integer.toString(m.getRed()));
            hex();
            m.changeColorViaAbsoluteValue(ColorCode.GREEN, bufferedReader.readLine());
            txt_green.setText(Integer.toString(m.getGreen()));
            hex();
            m.changeColorViaAbsoluteValue(ColorCode.BLUE, bufferedReader.readLine());
            txt_blue.setText(Integer.toString(m.getBlue()));
            hex();
            saved = true;

        }
        catch (IOException exception)
        {
            System.out.println("Something went wrong");
        }

        return saved;
    }
}
