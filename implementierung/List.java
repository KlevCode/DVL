package implementierung;

import schnittstellen.*;


public class List implements IList
{
    // Objektattribut des Listenkopfes
    private IListElement kopf;

    // Standardkonstruktor instantiiert ein ValueElement und ein ListElement zur Repräsentation des Kopfes
    public List()
    {
        kopf = new ListElement(new ValueElement("Kopf", 0));
    }

    // Returniert das Kopf-Listenelement
    public IListElement getHead()
    {
        return kopf;
    }

    /**
     * Anfuegen eines neuen Elementes mit uebergebenen Wert am Ende der Liste. 
     * Ist die Liste leer, wird das neue Element der Nachfolger des Listenkopfes.
     * Hat die Liste bereits Einträge, wird der Vorgaenger des neuen Elements der 
     * Vorgaenger des Kopfes.
     */
    public void insertAtTheEnd(IValueElement value)
    {
        IListElement neu = new ListElement(value);
        neu.setPredecessor(kopf.getPredecessor() == null ? kopf : kopf.getPredecessor());
        (kopf.getPredecessor() == null ? kopf : kopf.getPredecessor()).setSuccessor(neu);
        kopf.setPredecessor(neu);
    }

    /**
     * Methode zum Einfügen eines Elementes an die übergebene Position.
     * Einfügen am Listenende oder an der gewünschen Position
     */
    public void insertAtPos(int pos, IValueElement value) // pos: Position in der Liste | value: Wert des einzufügenden Elements
    {
        int i = 1;
        IListElement element = kopf;
        pos = pos < 1 ? 1 : pos;
        IListElement neu = new ListElement(value);

        while(element.getSuccessor() != null && i < pos) 
        {
            element = element.getSuccessor();
            ++i;
        }
        neu.setPredecessor(element);
        if (kopf.getPredecessor() == null || kopf.getPredecessor() == element)
        {
            kopf.setPredecessor(neu);
        }
        else
        {
            element.getSuccessor().setPredecessor(neu);
            neu.setSuccessor(element.getSuccessor());
        }
        element.setSuccessor(neu);
    }

    /**
     * Rückgabe des Elements, das sich an der übergebenen Position ("position") in der Liste befindet, oder den Wert null zurückgibt.
     * Dummy an Position 0.
     */
    public IValueElement getElementAt(int position)
    {
        if (position < 1)
        {
            return null;
        }
        int i = 1;
        for (IListElement temp = kopf.getSuccessor(); temp != null; temp = temp.getSuccessor(), i++)
        {
            if (i == position)
            {
                return temp.getValueElement();
            }
        }
        return null;
    }

    /**
     * Rückgabe der ersten Position an der sich der übergebene Wert vom Typ IValueElement befindet.
     * Rückgabe von -1, sollte dieser Wert nicht in der Liste vorkommen.
     */
    public int getFirstPosOf(IValueElement value) // value ist der zu suchende Wert
    {
        int i = 1;
        for (IListElement temp = kopf.getSuccessor(); temp != null; temp = temp.getSuccessor(), i++)
        {
            if (temp.getValueElement() == value)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Löschen des ersten Listenelements, das dem übergebenen value-Parameter entspricht
     */
    public void deleteFirstOf(IValueElement value)
    {
        for (IListElement temp = kopf.getSuccessor(); temp != null; temp = temp.getSuccessor())
        {
            if (temp.getValueElement() == value)
            {
                temp.getPredecessor().setSuccessor(temp.getSuccessor());
                if (temp.getSuccessor() == null)
                {
                    // letztes Element
                    kopf.setPredecessor(temp.getPredecessor() == kopf ? null : temp.getPredecessor());
                }
                else
                {
                    temp.getSuccessor().setPredecessor(temp.getPredecessor());
                }
                return;
            }
        }
    }

    /**
     * Löschen aller Listenelemente, die dem übergebenen value-Parameter entsprechen
     */
    public void deleteAllOf(IValueElement value)
    {
        for (IListElement temp = kopf.getSuccessor(); temp != null; temp = temp.getSuccessor())
        {
            deleteFirstOf(value);
        }
    }

    // Ausgabe, ob Element in der Liste enthalten ist. Gibt true zurück, wenn der Wert gefunden wurde
    public boolean member(IValueElement value)
    {
        return this.getFirstPosOf(value) != -1;
    }

    /**
     * Spiegeln der Liste durch Tausch der Elementvorgänger und Nachfolger.
     * Kopf-Vorgänger verweist nun auf erste Listenelement
     */
    public void reverse()
    {
        if (kopf.getSuccessor() != null)
        {
            for (IListElement current = kopf;;)
            {
                IListElement next = current.getSuccessor();
                IListElement temp = current.getPredecessor();
                current.setPredecessor(current.getSuccessor());
                current.setSuccessor(temp);
                if (next == null)
                {
                    current.setPredecessor(kopf);
                    kopf.getPredecessor().setSuccessor(null);
                    return;
                }
                current = next;
            }
        }
    }
    
    // Ausgabe der Liste als String
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (IListElement temp = kopf.getSuccessor(); temp != null; temp = temp.getSuccessor())
        {
            sb.append(temp.getValueElement());
        }
        return sb.toString();
    }
}