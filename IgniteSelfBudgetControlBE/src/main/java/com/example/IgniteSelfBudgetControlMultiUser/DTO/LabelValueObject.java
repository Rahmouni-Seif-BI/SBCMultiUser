package com.example.IgniteSelfBudgetControlMultiUser.DTO;

public class LabelValueObject {

    public String label;
    public Float value;


    public LabelValueObject(String label, Float value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
