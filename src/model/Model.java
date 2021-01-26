package model;

import java.util.Scanner;

public class Model{

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;
    private String hex;

    public Model() {
        red = new ModularCounter(256);
        green = new ModularCounter(256);
        blue = new ModularCounter(256);
    }

    public int getRed() {
        return red.getValue();
    }

    public int getGreen() {
        return green.getValue();
    }

    public int getBlue() {
        return blue.getValue();
    }

    public void changeColorViaAbsoluteValue(ColorCode cc, String value){


    }
    public void changeColorViaAbsoluteValue(ColorCode cc, int value){

    }
    public void changeColorViaRelativeValue(ColorCode cc, String value){

    }
    public void changeColorViaRelativeValue(ColorCode cc, int value){

    }

    public String getHex(){
        String hex = "#";

        String value_r=Integer.toHexString(red.getValue());
        String value_g=Integer.toHexString(green.getValue());
        String value_b=Integer.toHexString(blue.getValue());

        if (value_r.length()==1){
            value_r="0"+value_r;
        }
        if (value_g.length()==1){
            value_g="0"+value_g;
        }
        if (value_b.length()==1){
            value_b="0"+value_b;
        }

        hex = hex + value_r;
        hex = hex + value_g;
        hex = hex + value_b;

        return hex;
    }

    public String intervalChange(String op, String id){

        if (op.contains("-")){
            if (id.contains("red"))
                red.dec(10);
            else if (id.contains("green"))
                green.dec(10);
            else
                blue.dec(10);
        }else{
            if (id.contains("red"))
                red.inc(10);
            else if (id.contains("green"))
                green.inc(10);
            else
                blue.inc(10);
        }

        return getHex();
    }

    public static void main(String[] args) {
        Model model = new Model();
        ColorCode colorCode;
        String eingabe;
        boolean input;
        colorCode = ColorCode.BLUE;

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("1: Farbe via Absolutwert ändern\n" +
                    "2: Farbe via relativen Wert ändern\n" +
                    "3: Alles anzeigen\n" +
                    "4: Verlassen \n");
            System.out.println("Bitte wählen: ");
            eingabe = sc.next();

            switch (eingabe) {
                case "1" -> {
                    System.out.println("gruen, rot oder blau eingeben: ");
                    String color = sc.next();
                    input = true;
                    switch (color) {
                        case "rot" -> colorCode = ColorCode.RED;
                        case "gruen" -> colorCode = ColorCode.GREEN;
                        case "blau" -> colorCode = ColorCode.BLUE;
                        default -> input = false;
                    }

                    if (input) {
                        System.out.println("Zahl zwischen 0-255 eingeben: ");
                        model.changeColorViaAbsoluteValue(colorCode, sc.nextInt());
                        System.out.println(" \n Rot:" + model.red + " Gruen:" + model.green.getValue() + " Blau:" + model.blue.getValue() + "\n");
                    } else {
                        System.out.println("\n Please enter a valid color (red, green or blue) \n");
                    }
                }
                case "2" -> {
                    System.out.println("gruen, rot oder blau eingeben: ");
                    String color1 = sc.next();
                    input = true;
                    switch (color1) {
                        case "rot" -> colorCode = ColorCode.RED;
                        case "gruen" -> colorCode = ColorCode.GREEN;
                        case "blau" -> colorCode = ColorCode.BLUE;
                        default -> input = false;
                    }
                    if (input) {
                        System.out.println("Enter value:");
                        model.changeColorViaRelativeValue(colorCode, sc.nextInt());
                        //System.out.println("Red:" + model_color.red + " Green:" + model_color.green.getValue() + " Blue:" + model_color.blue.getValue());
                        System.out.println(model.toString());
                    } else {
                        System.out.println("Wrong input. Please enter a valid input: \n" +
                                "1: Farbe via Absolutwert ändern\n" +
                                "2: Farbe via relativen Wert ändern\n" +
                                "3: Alles anzeigen\n" +
                                "4: Verlassen \n");
                    }
                }
                case "3" -> System.out.println("\n Rot   = " + model.getRed() +
                        "\n Gruen = " + model.getGreen() +
                        "\n Blau  = " + model.getBlue() +
                        "\n Hex   = " + model.getHex() + "\n");

                case "4" -> {
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Model{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
