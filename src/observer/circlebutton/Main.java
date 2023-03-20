package observer.circlebutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

class CircleButton {
    interface OnClickListener {
        void onClick();
    }

    OnClickListener onClickListener;

    void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    int x, y, radius;
    Color color;

    public CircleButton(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    Shape getShape() {
        return new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2);
    }

    double distanceTo(int x, int y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));  // hipotenusa
    }
}

class Window extends JFrame {
    List<CircleButton> circleButtonList = new ArrayList<>();

    void add(CircleButton circleButton) {
        circleButtonList.add(circleButton);
    }

    void open() {
        setSize(400, 400);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                for (CircleButton circleButton : circleButtonList) {
                    if (circleButton.distanceTo(mouseEvent.getX(), mouseEvent.getY()) < circleButton.radius) {
                        // button clicked. Notify observers!!!
                        circleButton.onClickListener.onClick();
                    }
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        circleButtonList.forEach(circleButton -> {
            g.setColor(circleButton.color);
            ((Graphics2D) g).fill(circleButton.getShape());
        });
    }
}


public class Main extends Frame {
    public static void main(String[] args) {
        Window window = new Window();

        CircleButton blueCircleButton = new CircleButton(240, 120, 60, Color.BLUE);
        CircleButton redCircleButton = new CircleButton(140, 300, 40, Color.RED);
        CircleButton greenCircleButton = new CircleButton(40, 150, 20, Color.GREEN);

        blueCircleButton.setOnClickListener(() -> System.out.println("Blue CLICKED"));
        redCircleButton.setOnClickListener(() -> System.out.println("Red CLICKED"));
        greenCircleButton.setOnClickListener(() -> System.out.println("Green CLICKED"));

        window.add(blueCircleButton);
        window.add(redCircleButton);
        window.add(greenCircleButton);

        window.open();
    }
}