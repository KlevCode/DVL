package implementierung;

import schnittstellen.*;


public class Queue implements IQueue
{
    // Objektattribut
    private static final int MAX_SIZE = 7;

    private IList list;

    // Standard-Konstruktor
    public Queue()
    {
        list = new List();
    }

    // Methode returniert die als DVL implementierte Datenstruktur
    public IList getDVL()
    {
        return list;
    }

    // Check, ob Schlange leer ist
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    // Returniert, ob Schlange voll ist
    public boolean isFull()
    {
        return getSize() == MAX_SIZE;
    }

    // Returniert die Anzahl der Elemente in der Schlange
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

    // Gibt erstes Element zurück, wenn die Schlange nicht leer ist
    public int front()
    {
        return isEmpty() ? -1 : list.getElementAt(1).getValue();
    }

    // Ein Element an den letzten Platz der Schlange setzen
    public void enqueue(int value)
    {
        if (!isFull() && value >= 0)
        {
            list.insertAtTheEnd(new ValueElement("Element" + value, value));
        }
    }

    // Entnahme und Löschung des ersten Elements der Schlange
    public int dequeue()
    {
        if (isEmpty())
        {
            return -1;
        }
        int res = list.getElementAt(1).getValue();
        list.deleteFirstOf(list.getElementAt(1));
        return res;
    }
}