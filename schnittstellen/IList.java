package schnittstellen;

public interface IList 
{
    public IListElement getHead();
    public void insertAtTheEnd(IValueElement value);
    public void insertAtPos(int pos, IValueElement value);
    public IValueElement getElementAt(int position);
    public int getFirstPosOf(IValueElement value);
    public void deleteFirstOf(IValueElement value);
    public void deleteAllOf(IValueElement value);
    public boolean member (IValueElement value);
    public void reverse();
    public String toString();
}
