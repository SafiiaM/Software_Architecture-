// 8. Для того чтобы следовать принципу ISP (Принцип разделения интерфейсов), нужно разделить функциональность
// интерфейсов на более специфические интерфейсы.

package HomeWork_3.SOLID;

public interface iCleaning {
    void cleanWindshield();
    void cleanHeadlights();
    void cleanMirrors();
}
