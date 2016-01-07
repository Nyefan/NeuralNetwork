import com.sun.org.apache.xpath.internal.operations.Bool;

public class Main {

    public static void main(String[] args) {
        Neuron xor = new Neuron(0.5f);
        Neuron left = new Neuron(1.5f);
        Neuron right = new Neuron(0.5f);
        left.setWeight(-1.0f);
        right.setWeight(1.0f);
        xor.connect(left, right);

        for (String val : args) {
            Neuron op = new Neuron(0.0f);
            op.setWeight(Boolean.parseBoolean(val));
            left.connect(op);
            right.connect(op);
        }

        xor.fire();

        System.out.println("Result: " + xor.isFired());
    }
}
