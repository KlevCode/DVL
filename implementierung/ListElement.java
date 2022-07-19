package implementierung;

import schnittstellen.IListElement;
import schnittstellen.IValueElement;

//Objekte vom Typ IListElement haben ein Wertattribut, ein Objekt vom Typ IValueElement und einen Verweis auf den Vorgänger und den Nachfolger

public class ListElement implements IListElement
{
    // Die Objektattribute
    private IValueElement valueElement;
    private IListElement predecessor;
    private IListElement successor;

    // Konstruktor 
    public ListElement(IValueElement value) // value = der Initialwert
    {
        setValueElement(value);
    }

    // Returniert das Werteobjekt des Listenobjekts
    public IValueElement getValueElement()
    {
        return valueElement;
    }

    // Setzt einen neuen Wert für das Wertelement
    public void setValueElement(IValueElement value) // Value: der neue Wert
    {
        valueElement = value == null ? new ValueElement() : value;
    }

    // Returniert den Vorgänger des Listenelements
    public IListElement getPredecessor()
    {
        return predecessor;
    }

    // Setzt einen neuen Vorgänger
    public void setPredecessor(IListElement predecessor)
    {
        this.predecessor = predecessor;
    }

    // Returniert den Nachfolger des Listenelements
    public IListElement getSuccessor()
    {
        return successor;
    }

    // Setzt einen neuen Nachfolger
    public void setSuccessor(IListElement successor)
    {
        this.successor = successor;
    }
}