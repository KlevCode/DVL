package schnittstellen;

public interface IListElement 
{
    public IValueElement getValueElement();
    public void setValueElement(IValueElement value);
    public IListElement getPredecessor();
    public void setPredecessor(IListElement predecessor);
    public IListElement getSuccessor();
    public void setSuccessor(IListElement successor);
}
