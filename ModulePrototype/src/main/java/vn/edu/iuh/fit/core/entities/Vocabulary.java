package vn.edu.iuh.fit.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Vocabulary {
    private String source;
    private List<Type> destination;
    private String phoneticTranscription;

    public Vocabulary() {

    }

    public Vocabulary(String source, List<Type> destination, String phoneticTranscription) {
        this.source = source;
        this.destination = destination;
        this.phoneticTranscription = phoneticTranscription;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Type> getDestination() {
        if (destination == null)
            destination = new ArrayList<>();
        return destination;
    }
    public void addDestination(Type type) {
        if (destination == null)
            destination = new ArrayList<>();
        this.destination.add(type);
    }
    public void setDestination(List<Type> destination) {
        this.destination = destination;
    }

    public String getPhoneticTranscription() {
        return phoneticTranscription;
    }

    public void setPhoneticTranscription(String phoneticTranscription) {
        this.phoneticTranscription = phoneticTranscription;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "source='" + source + '\'' +
                ", destination=" + destination +
                ", phoneticTranscription='" + phoneticTranscription + '\'' +
                '}';
    }
}
