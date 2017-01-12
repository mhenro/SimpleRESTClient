package ru.mhenro.restclient;

/**
 * Created by mhenr on 24.10.2016.
 */
public class JsonOb {
    private String text;
    private int value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{'text': '" + text + "', 'value': '" + value + "'}";
    }
}
