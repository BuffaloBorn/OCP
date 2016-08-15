package enums;

/**
 * Created by vitaly on 07.09.15.
 */
public class EnumTest {
    private final PrinterType printerType;
    private static enum T{A,B,C,}

    public EnumTest(PrinterType printerType) {
        this.printerType = printerType;
    }

    public void feature() {
        // switch based on the printer type passed in the constructor
        switch (printerType) {
            case DOTMATRIX:
                System.out.println("Dot-matrix printers are economical and almost obsolete");
                break;
            case INKJET:
                System.out.println("Inkjet printers provide decent quality prints");
                break;
            case LASER:
                System.out.println("Laser printers provide best quality prints");
                break;
        }
    }

    public static void main(String[] args) {
        EnumTest test1 = new EnumTest(PrinterType.INKJET);
        EnumTest test2 = new EnumTest(PrinterType.LASER);
        test1.feature();
        test2.feature();

    }
}

enum PrinterType {
    DOTMATRIX, INKJET(0), LASER(0);
    private final int pageCount;


    PrinterType() {
        this.pageCount = 0;
    }

    PrinterType(int pageCount) {
        this.pageCount = pageCount;
    }
}
