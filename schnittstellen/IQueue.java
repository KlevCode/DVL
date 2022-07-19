package schnittstellen;

public interface IQueue 
{
    public IList getDVL();
    public int getSize();
    public boolean isEmpty();
    public boolean isFull();
    public int dequeue();
    public void enqueue(int value);
    public int front();
}
