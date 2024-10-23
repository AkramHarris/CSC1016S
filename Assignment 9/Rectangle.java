// HRRAKR001
// Akram Harris
// 18/10/2024

class Rectangle extends VectorObject { // A Rectangle child class of vectorobject
    private int xLength, yLength;

    Rectangle(int id, int x, int y, int xLength, int yLength) { // A Rectangle constructor
        super(id, x, y);
        this.xLength = xLength; // Every Rectangle has a length and a width
        this.yLength = yLength;
    }

    @Override
    public void draw(char[][] matrix) {
        
        for (int i = y; i < y + yLength && i < matrix.length; ++i) { // Loops through the x and y co-ord and prints a star and creates a rectangle border
            for (int j = x; j < x + xLength && j < matrix[i].length; ++j) {
                matrix[i][j] = '*'; 
            }
        }
    }
}
