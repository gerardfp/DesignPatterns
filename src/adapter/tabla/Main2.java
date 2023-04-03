package adapter.tabla;



import java.util.concurrent.ThreadLocalRandom;

class Tabla2 {

    String[][] datos;

    void setDatos(String[][] datos){
        this.datos = datos;
    }

    void show(){
        int numRows = datos.length;
        int numCols = datos.length > 0 ? datos[0].length : 0;

        int maxCellLenght = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                maxCellLenght = Math.max(maxCellLenght, datos[i][j].length());
            }
        }

        System.out.println("-".repeat(maxCellLenght*numCols+numCols*3+1));
        for (int i = 0; i < numRows; i++) {
            System.out.print("|");
            for (int j = 0; j < numCols; j++) {
                System.out.print(" " + " ".repeat(maxCellLenght-datos[i][j].length()) + datos[i][j] + " |");
            }
            System.out.println("\n" + "-".repeat(maxCellLenght*numCols+numCols*3+1));
        }
    }
}

public class Main2 {

    public static void main(String[] args) {
        Tabla2 tabla2 = new Tabla2();

        String[][] datos = new String[5][4];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                datos[i][j] = "" + ThreadLocalRandom.current().nextInt(1000);
            }
        }

        tabla2.setDatos(datos);
        tabla2.show();
    }
}

