// HRRAKR001
// Akram Harris
// 18/10/2024

class HLine extends VectorObject { // A child class of vectorobject
    private int length;

    HLine(int id, int x, int y, int length) { // HLine constructor
        super(id, x, y); 
        this.length = length; // Adds length component
    }

    @Override
    public void draw(char[][] matrix) {
        
        for (int j = x; j < x + length && j < matrix[y].length; j++) {
            matrix[y][j] = '*'; // Uses the x co-ord as reference and draws a Horizontal line
        }
    }
}
