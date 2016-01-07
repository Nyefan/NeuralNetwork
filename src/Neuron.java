import java.util.ArrayList;

/**
 * Created by nyefan on 12/31/15.
 */
public class Neuron {
    private ArrayList<Neuron> inputs;
    private float weight;
    private float threshhold;
    private boolean fired;

    public Neuron(float t) {
        threshhold = t;
        fired = false;
        inputs = new ArrayList<Neuron>();
    }

    public void connect(Neuron ... ns) {
        for(Neuron n : ns) inputs.add(n);
    }

    public void remove(Neuron ... ns) {
        for(Neuron n : ns) inputs.remove(n);
    }

    public void removeAll() {
        inputs = new ArrayList<Neuron>();
    }

    public void modThreshhold(float diff) {
        threshhold += diff;
        threshhold = threshhold > 1.0f ? 1.0f : threshhold;
        threshhold = threshhold < 0.0f ? 0.0f : threshhold;
    }

    public void setWeight(float w) {
        weight = w;
    }

    public void setWeight(boolean w) {
        weight = w ? 1.0f : 0.0f;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isFired() {
        return fired;
    }

    public float fire() {
        if(inputs.size() > 0) {
            float totalWeight = 0.0f;
            for(Neuron n : inputs) {
                n.fire();
                totalWeight += n.isFired() ? n.getWeight() : 0.0f;
            }
            fired = totalWeight > threshhold;
            return totalWeight;
        } else if(weight != 0.0f) {
            fired = weight > threshhold;
            return weight;
        } else {
            return 0.0f;
        }
    }
}
