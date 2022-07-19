package schnittstellen;

public interface IStack 
{
    public IList getDVL();
    public int getSize();
    public boolean isEmpty();
    public boolean isFull();
    public int pop();
    public void push(int value);
    public int top();
}
