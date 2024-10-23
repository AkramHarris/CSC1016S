import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeMaker extends JFrame {
    private JComboBox<String> shapeSelector;
    private JTextField inputField1;
    private JTextField inputField2;
    private JTextField inputField3;
    private JTextField inputField4;
    private JComboBox<String> colorSelector;
    private JButton submitButton;
    private JButton drawButton;
    private JCheckBox checkBox;
    private JPanel canvas;

    // Shape properties
    private String selectedShape;
    private double radius;
    private double width;
    private double height;
    private double sideA, sideB, sideC;  // For triangle sides
    private Color selectedColor;  // Store color object 

    // Labels for displaying area and perimeter
    private JLabel areaLabel;
    private JLabel perimeterLabel;

    public ShapeMaker() {
        setTitle("ShapeMaker"); // Title of program
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));  

        selectedColor = Color.BLACK;  // Default color

        
        JPanel topPanel = new JPanel(new GridLayout(7, 2, 5, 5)); // Using a GridLayout
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  

        shapeSelector = new JComboBox<>(new String[]{"Circle", "Rectangle", "Triangle"}); // The dropdown box for the shapes
        inputField1 = new JTextField(); // Inputfields for various inputs
        inputField2 = new JTextField();
        inputField3 = new JTextField();
        inputField4 = new JTextField();
        inputField2.setVisible(false); 
        inputField3.setVisible(false);
        colorSelector = new JComboBox<>(new String[]{"Black", "Red", "Blue", "Green"}); // Colour Selector box
        submitButton = new JButton("Submit");
        drawButton = new JButton("Draw");
        checkBox = new JCheckBox("Fill Shape");
        drawButton.setEnabled(false); 

        
        areaLabel = new JLabel("Area: N/A");
        perimeterLabel = new JLabel("Perimeter: N/A");

        // Tooltips for better UI experience
        shapeSelector.setToolTipText("Select the shape to draw");
        colorSelector.setToolTipText("Select the color for the shape");
        inputField1.setToolTipText("Enter radius/width/side A depending on the shape");
        inputField2.setToolTipText("Enter height/side B");
        inputField3.setToolTipText("Enter side C for triangle");

        topPanel.add(new JLabel("Shape:"));
        topPanel.add(shapeSelector);
        topPanel.add(new JLabel("Color:"));
        topPanel.add(colorSelector);

        topPanel.add(new JLabel("Radius/Width/Side A:")); // Different side inputs description
        topPanel.add(inputField1);
        topPanel.add(new JLabel("Height/Side B:"));
        topPanel.add(inputField2);
        topPanel.add(new JLabel("Side C:"));
        topPanel.add(inputField3);
        topPanel.add(new JLabel(""));
        topPanel.add(checkBox);
        

        
        topPanel.add(areaLabel);
        topPanel.add(perimeterLabel);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Panel for buttons
        buttonPanel.add(submitButton); // Submit button to check if the fields are entered are valid and to work out area and perimeter
        buttonPanel.add(drawButton);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        
                 // Inside the canvas panel's paintComponent method
         canvas = new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
         
                 g.setColor(selectedColor); // Set the colour of draw
         
                 int canvasWidth = getWidth();
                 int canvasHeight = getHeight();

                    if ("Circle".equals(selectedShape)) {
                        int diameter = (int) (radius * 2);
                        int centerX = (canvasWidth - diameter) / 2; // This is to centre the shape on the canvas
                        int centerY = (canvasHeight - diameter) / 2;
                        if (checkBox.isSelected()) {
                            g.fillOval(centerX, centerY, diameter, diameter); // Fill the circle
                        } else {
                            g.drawOval(centerX, centerY, diameter, diameter); // Just draw the circle
                        }
                    } else if ("Rectangle".equals(selectedShape)) {
                        int centerX = (canvasWidth - (int) width) / 2;
                        int centerY = (canvasHeight - (int) height) / 2;
                        if (checkBox.isSelected()) {
                            g.fillRect(centerX, centerY, (int) width, (int) height); // Fill the rectangle
                        } else {
                            g.drawRect(centerX, centerY, (int) width, (int) height); // Just draw the rectangle
                        }
                    } else if ("Triangle".equals(selectedShape)) {
                        if (sideA > 0 && sideB > 0 && sideC > 0) {
                              int baseX = (canvasWidth - (int) sideA) / 2;
                              int baseY = (canvasHeight - (int) sideB) / 2;
                              int x1 = baseX;
                              int y1 = baseY;
                              int x2 = baseX + (int) sideA; 
                              int y2 = baseY;
                  
                              double cosTheta = (Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2)) / (2 * sideA * sideB); // Use the cos rule to get the angle
                              double theta = Math.acos(cosTheta);
                  
                              int x3 = (int) (x1 + sideB * Math.cos(theta)); // Use this to get the revelant sides
                              int y3 = (int) (y1 - sideB * Math.sin(theta));
                  
                              int[] xPoints = {x1, x2, x3}; // convert these points to int arrays to draw the triangle
                              int[] yPoints = {y1, y2, y3};
                  
                              if (checkBox.isSelected()) {
                                  g.fillPolygon(xPoints, yPoints, 3); // Fill the triangle
                              } else {
                                  g.drawPolygon(xPoints, yPoints, 3); // Just draw the triangle
                              }
                          }
                      }
                  }
            };



        canvas.setPreferredSize(new Dimension(800, 400)); // Preffered size of canvas  
        canvas.setBorder(BorderFactory.createLineBorder(Color.GRAY)); 
        add(canvas, BorderLayout.CENTER);

       
        shapeSelector.addActionListener(new ShapeSelectionListener()); // Add the action listeners
        submitButton.addActionListener(new SubmitActionListener());
        drawButton.addActionListener(new DrawShapeAction());

        
         addComponentListener(new java.awt.event.ComponentAdapter() { // Add component listener for when stuff is resized
            public void componentResized(java.awt.event.ComponentEvent evt) {
                canvas.repaint();  
            }
        });

        setVisible(true);
    }

    
    private class ShapeSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedShape = (String) shapeSelector.getSelectedItem();
            if ("Circle".equals(selectedShape)) { // Make the input fields visible depending on the Shape
                inputField1.setVisible(true);  
                inputField2.setVisible(false);  
                inputField3.setVisible(false);
            } else if ("Rectangle".equals(selectedShape)) {
                inputField1.setVisible(true);  
                inputField2.setVisible(true);  
                inputField3.setVisible(false);
            } else if ("Triangle".equals(selectedShape)) {
                inputField1.setVisible(true);  
                inputField2.setVisible(true);
                inputField3.setVisible(true);
                sideA =0;
                sideB =0;
                sideC =0;
            }
            canvas.repaint();  
        }
    }

    
    private class SubmitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedShape = (String) shapeSelector.getSelectedItem();
            try {
                if ("Circle".equals(selectedShape)) { // Works out the area and perimeter using the properties of the shapes
                    radius = Double.parseDouble(inputField1.getText());
                    Circle circle = new Circle(radius);
                    selectedColor = getColorFromString((String) colorSelector.getSelectedItem());
                    areaLabel.setText("Area: " + String.format("%.2f", circle.getArea())); // Rounds it off
                    perimeterLabel.setText("Perimeter: " + String.format("%.2f", circle.getPerimeter()));
                    drawButton.setEnabled(true);  
                } else if ("Rectangle".equals(selectedShape)) {
                    width = Double.parseDouble(inputField1.getText());
                    height = Double.parseDouble(inputField2.getText());
                    Rectangle rectangle = new Rectangle(width, height);
                    selectedColor = getColorFromString((String) colorSelector.getSelectedItem());
                    areaLabel.setText("Area: " + String.format("%.2f", rectangle.getArea()));
                    perimeterLabel.setText("Perimeter: " + String.format("%.2f", rectangle.getPerimeter()));
                    drawButton.setEnabled(true);  
                } else if ("Triangle".equals(selectedShape)) {
                    sideA = Double.parseDouble(inputField1.getText());
                    sideB = Double.parseDouble(inputField2.getText());
                    sideC = Double.parseDouble(inputField3.getText());
                    if (isValidTriangle(sideA, sideB, sideC)){ // Checks if the triangle is valid
                     
                    Triangle triangle = new Triangle(sideA, sideB, sideC);
                    selectedColor = getColorFromString((String) colorSelector.getSelectedItem());
                    areaLabel.setText("Area: " + String.format("%.2f", triangle.getArea()));
                    perimeterLabel.setText("Perimeter: " + String.format("%.2f", triangle.getPerimeter()));
                    drawButton.setEnabled(true);
                    }
                    else JOptionPane.showMessageDialog(null, "Please enter valid dimensions.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid dimensions.");
                drawButton.setEnabled(false);  
            }
        }
    }

    
    private class DrawShapeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.repaint();  
        }
    }

    
    private Color getColorFromString(String color) { // Gets the colour of shape depending on the input
        if (color == null) return Color.BLACK;  
        switch (color.toLowerCase()) {
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            default:
                return Color.BLACK;
        }
    }

    
    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        new ShapeMaker();
    }
}
