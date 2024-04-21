package vn.edu.iuh.fit.core.entities;


import java.util.ArrayList;
import java.util.List;

public class Type {
    private String typeName;
    private List<String> meanings;
    private List<String> example;

    public Type() {
    }

    public Type(String typeName, List<String> meanings, List<String> example) {
        this.typeName = typeName;
        this.meanings = meanings;
        this.example = example;
    }

    public String getTypeName() {

        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getMeanings() {
        if (meanings == null)
            meanings = new ArrayList<>();
        return meanings;
    }

    public void setMeanings(List<String> meanings) {
        this.meanings = meanings;
    }

    public List<String> getExample() {
        if (example == null)
            example = new ArrayList<>();
        return example;
    }

    public void setExample(List<String> example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeName='" + typeName + '\'' +
                ", meanings=" + meanings +
                ", example=" + example +
                '}';
    }
}

