package controllerview;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.ColorCode;
import model.Model;
import model.ModularCounter;

public class Controller {

    private Model model;

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
    model.changeColorViaRelativeValue(ColorCode.RED, 10);
    txt_red.setText(Integer.toString(model.getRed()));
    hex();
    }

    @FXML
    public void minusRED(){
        model.changeColorViaRelativeValue(ColorCode.RED,-10);
        txt_blue.setText(Integer.toString(model.getRed()));
        hex();
    }
    @FXML
    public void plusGREEN(){
        model.changeColorViaRelativeValue(ColorCode.GREEN, 10);
        txt_red.setText(Integer.toString(model.getGreen()));
        hex();
    }
    @FXML
    public void minusGREEN(){
        model.changeColorViaRelativeValue(ColorCode.GREEN,-10);
        txt_blue.setText(Integer.toString(model.getGreen()));
        hex();
    }
    @FXML
    public void plusBLUE(){
        model.changeColorViaRelativeValue(ColorCode.BLUE, 10);
        txt_red.setText(Integer.toString(model.getBlue()));
        hex();
    }
    @FXML
    public void minusBLUE(){
        model.changeColorViaRelativeValue(ColorCode.BLUE,-10);
        txt_blue.setText(Integer.toString(model.getBlue()));
        hex();
    }

    private void hex(){
        txt_hex.setText(model.getHex());
        colorview.setStyle("-fx-background-color:"+model.getHex()+";");
    }
}
