package implementierung;

import schnittstellen.*;


public class Stack implements IStack
{
    // Objektattribut
    private final static int MAX_SIZE = 7;

    private IList list;

    // Standard-Konstruktor
    public Stack()
    {
        list = new List();
    }

    // Methode returniert die als DVL implementierte Datenstruktur
    public IList getDVL()
    {
        return list;
    }

    // Check, ob Stapel leer ist
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    // Returniert, ob Stapel voll ist
    public boolean isFull()
    {
        return getSize() == MAX_SIZE;
    }

    // Returniert die Anzahl der Elemente auf dem Stack
    public int getSize()
    {
        int size = 0;
        IListElement current = list.getHead().getSuccessor();
        while (current != null)
        {
            ++size;
            current = current.getSuccessor();
        }
        return size;
    }

    // Ausgabe und Löschen des zuletzt hinzugefügten Elements auf dem Stack
    public int pop()
    {
        if (isEmpty())
        {
            return -1;
        }
        int res = list.getElementAt(1).getValue();
        list.deleteFirstOf(list.getElementAt(1));
       
        return res;
    }

    // Wenn Platz ist, Element auf den Stapel legen
    public void push(int value)
    {
        if (!isFull() && value >= 0)
        {
            list.insertAtPos(1, new ValueElement("Element" + getSize(), value));
        }
    }

    // Returniert das oberste auf dem Stack abgelegte Element, falls dieser nicht leer ist
    public int top()
    {
        return isEmpty() ? -1 : list.getElementAt(1).getValue();
    }
}