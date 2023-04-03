package adapter.tabla;

import java.util.concurrent.ThreadLocalRandom;

class Tabla {
    private TablaAdapter adapter;

    interface TablaAdapter {
        String getCell(int row, int col);
        int numRows();
        int numCols();
    }

    void setAdapter(TablaAdapter adapter){
        this.adapter = adapter;
    }

    void show(){
        int numRows = adapter.numRows();
        int numCols = adapter.numCols();
        String[][] datos = new String[numRows][numCols];

        int maxCellLenght = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                datos[i][j] = adapter.getCell(i,j);
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

public class Main {

    public static void main(String[] args) {
        Tabla tabla = new Tabla();

        tabla.setAdapter(new Tabla.TablaAdapter() {
            @Override
            public String getCell(int row, int col) {
                return "" + ThreadLocalRandom.current().nextInt(1000);
            }

            @Override
            public int numRows() {
                return 30;
            }

            @Override
            public int numCols() {
                return 10;
            }
        });

        tabla.show();
    }
}
