// 9. Create an abstract class named Element that holds properties of elements, including their
//        symbol, atomic number, and atomic weight. Include a constructor that requires values for all
// three properties and a get method for each value. (For example, the symbol for carbon is C, its
// atomic number is 6, and its atomic weight is 12.01. You can find these values by reading a
// periodic table in a chemistry reference or by searching the Internet.) Also include an abstract
// method named describeElement( ). Create two extended classes named MetalElement and
// NonMetalElement. Each contains a describeElement( ) method that displays the details of the
// element and a brief explanation of the properties of the element type. For example, metals are
// good conductors of electricity, while nonmetals are poor conductors. Write an application
// named ElementArray that creates and displays an array that holds at least two elements of each
// type.

package WS05;

class WS05_PS09 {
    public static void main(String[] args) {
        Element[] elements = new Element[4];

        elements[0] = new MetalElement("Fe", 26, 55.845);
        elements[1] = new MetalElement("Au", 79, 196.967);
        elements[2] = new NonMetalElement("C", 6, 12.01);
        elements[3] = new NonMetalElement("O", 8, 15.999);

        for (Element element : elements) {
            element.describeElement();
        }
    }
}

abstract class Element {
    private final String symbol;
    private final int atomicNumber;
    private final double atomicWeight;

    public Element(String symbol, int atomicNumber, double atomicWeight) {
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public abstract void describeElement();
}

class MetalElement extends Element {

    public MetalElement(String symbol, int atomicNumber, double atomicWeight) {
        super(symbol, atomicNumber, atomicWeight);
    }

    @Override
    public void describeElement() {
        System.out.println("Metal Element: " + getSymbol());
        System.out.println("Atomic Number: " + getAtomicNumber());
        System.out.println("Atomic Weight: " + getAtomicWeight());
        System.out.println("Metals are good conductors of electricity.");
    }
}

class NonMetalElement extends Element {

    public NonMetalElement(String symbol, int atomicNumber, double atomicWeight) {
        super(symbol, atomicNumber, atomicWeight);
    }

    @Override
    public void describeElement() {
        System.out.println("Non-Metal Element: " + getSymbol());
        System.out.println("Atomic Number: " + getAtomicNumber());
        System.out.println("Atomic Weight: " + getAtomicWeight());
        System.out.println("Non-metals are poor conductors of electricity.");
    }
}

