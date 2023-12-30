package solid;


// Superclass
class Shape {
    int area() {
        return 0;
    }
}

// Subclass
class MyRectangle extends Shape {
    int width;
    int height;

    @Override
    int area() {
        return width * height;
    }
}

// Another Subclass
class MySquare extends Shape {
    int side;

    @Override
    int area() {
        return side * side;
    }
}


public class LiskovCorrect {

    static void printArea(Shape shape) {
        System.out.println("Area: " + shape.area());
    }

    public static void main(String[] args) {
        Shape rectangle = new MyRectangle();
        ((MyRectangle) rectangle).width = 5;
        ((MyRectangle) rectangle).height = 10;

        Shape square = new MySquare();
        ((MySquare) square).side = 5;

        printArea(rectangle); // Output: Area: 50
        printArea(square);    // Output: Area: 25

        //NOTE : No special behaviours amongst these classes.
    }
}
