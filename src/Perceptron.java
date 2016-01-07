import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nyefan on 12/31/15.
 */
public class Perceptron {
    private float threshhold;
    private float learningRate;
    private ArrayList<Neuron> neurons;
    private ArrayList<Neuron> inputs;
    private HashMap<ArrayList<Float>, Boolean> trainingSet;
    private Neuron output;

    public Perceptron() {
        this(1);
    }

    public Perceptron(int n) {
        this(n, 1.0f, 0.1f);
    }

    public Perceptron(int n, float t, float l) {
        threshhold = t;
        learningRate = l;
        neurons = new ArrayList<Neuron>(n);
//        TODO: Change this to a stream; low priority
        for(int i = 0; i < n; i++) {
            neurons.add(n, new Neuron(threshhold));
            neurons.get(n).setWeight(0.0f);
        }
        output = new Neuron(threshhold);
        output.connect(neurons.toArray(new Neuron[neurons.size()]));
        trainingSet = new HashMap<ArrayList<Float>, Boolean>();
    }

//    Put training sets into the appropriate container
    public void addTrainingKey(ArrayList<Float> inputs, Boolean expectedOutput) {
        trainingSet.put(inputs, expectedOutput);
    }

    public void train(int maxIterations) {
        int errorCount;
        int iteration = 0;
        do {
            errorCount = 0;
//            TODO: Change this to a stream; medium priority (inner loops only?)
//            for each set of inputs in the training set
//            for each input in the set
//            spoof the input of the actual neural net by creating neurons to hold the inputs
//            then connect the inputs to the neural net
            for(Map.Entry<ArrayList<Float>, Boolean> input : trainingSet.entrySet()) {
                for(Float entry : input.getKey()) {
                    Neuron tempNeuron = new Neuron(0.0f);
                    tempNeuron.setWeight(entry);
                    inputs.add(tempNeuron);
                }

                for (Neuron n : neurons) {
                    n.connect(inputs.toArray(new Neuron[inputs.size()]));
                }

//                At this point, the general structure is complete
//                Now we need to do the actual training

            }
            iteration++;
        } while ((errorCount > 0) && (iteration < maxIterations));
    }

    public ArrayList<Neuron> getNeuralNetwork() {
        return new ArrayList<Neuron>(neurons); // java learn to const
    }
}
