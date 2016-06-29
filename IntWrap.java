/**
 * Created by bhavinchauhan on 1/14/16.
 */
public class IntWrap {
    public int a;

    public IntWrap(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "IntWrap{" +
                "a=" + a +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
