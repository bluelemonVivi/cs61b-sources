public interface theList<Item> {
    public void addFirst(Item);
    public void addLast(Item);
    public Item getFirst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public void insert(Item x, int position);
    public int size();
}
