package implementierung;

import schnittstellen.IValueElement;

// Objekte vom Typ IValueElement haben Namen- und Zahlenwertattribute (String name und int value)

public class ValueElement implements IValueElement
{
    // Die Objektattribute
    private String name;
    private int value;

    
    // Konstruktor
    public ValueElement(String name, int value)
    {
        this.setName(name);
        this.setValue(value);
    }

    // Standardkonstruktor
    public ValueElement()
    {
        this("head", 0);
    }
    

    // Returniert den Elementnamen
    public String getName()
    {
        return this.name;
    }

    // Setzt einen neuen Namen
    public void setName(String name) // Variable name definiert den neuen Namen
    {
        this.name = name == null ? "unknown" : name;
    }

    // Returniert den Wert des Elements
    public int getValue()
    {
        return value;
    }

    // Setzt einen neuen Wert
    public void setValue(int value) // Variable value definiert den neuen Wert
    {
        this.value = value;
    }
 
    public String toString()
    {
        return "Name:" + name + " Wert:" + value;
    }
}