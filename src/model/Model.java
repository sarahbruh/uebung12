package model;

import java.util.Scanner;

/**
 * uebung 12 & 13
 * @author Brunmayr Sarah
 * @version 12.0.1, 28.01.2021
 */

public class Model{

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;

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
        int intValue = Integer.parseInt(value);
        switch (cc) {
            case RED:
                red.reset();
                red.update(intValue);

            case BLUE:
                blue.reset();
                blue.update(intValue);

            case GREEN:
                green.reset();
                green.update(intValue);

        }
    }
    public void changeColorViaAbsoluteValue(ColorCode cc, int value){
        switch (cc) {
            case RED:
                red.reset();
                red.update(value);

            case BLUE:
                blue.reset();
                blue.update(value);

            case GREEN:
                green.reset();
                green.update(value);
        }
    }
    public void changeColorViaRelativeValue(ColorCode cc, String value){

        int intValue = Integer.parseInt(value);
        switch(cc){
            case RED:
                red.reset();
                red.update(intValue);

            case BLUE:
                blue.reset();
                blue.update(intValue);

            case GREEN:
                green.reset();
                green.update(intValue);
        }
    }
    public void changeColorViaRelativeValue(ColorCode cc, int value) {

        switch (cc) {
            case RED:
                red.update(value);

            case BLUE:
                blue.update(value);

            case GREEN:
                green.update(value);
        }
    }

    public String getHex(){

        String hex = "#";

        String redv = Integer.toHexString(red.getValue());
        String greenv = Integer.toHexString(green.getValue());
        String bluev = Integer.toHexString(blue.getValue());

        if (redv.length() == 1){
            redv += "0";
        }
        if (greenv.length() == 1){
            greenv += "0";
        }
        if (bluev.length() == 1){
            bluev += "0";
        }

        hex = hex + redv;
        hex = hex + greenv;
        hex = hex + bluev;

        return hex;
    }

    public static void main(String[] args) {
        Model model = new Model();
        boolean input = true;
        ColorCode colorCode = ColorCode.BLUE;

        while (input)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("1: Farbe via Absolutwert ändern\n" +
                    "2: Farbe via relativen Wert ändern\n" +
                    "3: Alles anzeigen\n" +
                    "4: Verlassen \n");
            System.out.println("Bitte wählen: ");
            String eingabe = sc.next();

            switch (eingabe) {
                case "1":
                    System.out.println("gruen, rot oder blau eingeben: ");
                    String color = sc.next();
                    input = true;
                    switch (color) {
                        case "rot":
                            colorCode = ColorCode.RED;
                        case "gruen":
                            colorCode = ColorCode.GREEN;
                        case "blau":
                            colorCode = ColorCode.BLUE;
                        default:
                            input = false;
                    }

                    if (input) {
                        System.out.println("Zahl zwischen 0-255 eingeben: ");
                        model.changeColorViaAbsoluteValue(colorCode, sc.nextInt());
                        System.out.println("Rot:" + model.red.getValue() + " Gruen:" + model.green.getValue() + " Blau:" + model.blue.getValue() + "\n");
                    }
                case "2":
                    System.out.println("gruen, rot oder blau eingeben: ");
                    String color1 = sc.next();
                    input = true;
                    switch (color1) {
                        case "rot":
                            colorCode = ColorCode.RED;
                        case "gruen":
                            colorCode = ColorCode.GREEN;
                        case "blau":
                            colorCode = ColorCode.BLUE;
                    }
                    if (input) {
                        System.out.println("Bitte Wert eingeben: ");
                        model.changeColorViaRelativeValue(colorCode, sc.nextInt());
                        System.out.println(model.toString());
                    } else {
                        System.out.println("Error! Bitte richtigen Wert eingeben: \n" +
                                "1: Farbe via Absolutwert ändern\n" +
                                "2: Farbe via relativen Wert ändern\n" +
                                "3: Alles anzeigen\n" +
                                "4: Verlassen \n");
                    }
                case "3":
                    System.out.println("\n Rot = " + model.getRed() +
                        "\n Gruen = " + model.getGreen() +
                        "\n Blau  = " + model.getBlue() +
                        "\n Hex   = " + model.getHex() + "\n");

                case "4":
                    return;
            }
        }
    }

    @Override
    public String toString() {
        return "Rot: " + red.getValue() +
                ", Grün: " + green.getValue() +
                ", Blau:" + blue.getValue();
    }
}
