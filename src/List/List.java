package List;

public class List<T> {
    private int size;
    private Node<T> head;
    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Конструктор создает новый узел с заданными данными.
         *
         * @param data данные элемента.
         */
        Node(T data) { this.data = data; this.next = null; }
    }

    /**
     * Создает пустой список.
     */
    public List() { head = null; size = 0; }


    /**
     * Метод для получения размера списка
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Метод проверки, пуст ли список
     *
     * @return  значение true, если список пуст, иначе false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Метод очистки списка
     */
    public void clear() { head = null; size = 0; }

    /**
     * Метод добавления элемента в конец списка.
     *
     * @param data данные добавляемого элемента.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null)
            head = newNode;
        else
        {
            Node<T> current = head;

            while (current.next != null)
                current = current.next;

            current.next = newNode;
        }
        size++;
    }

    /**
     * Метод получения элемента с указанным индексом
     *
     * @param index индекс извлекаемого элемента.
     * @return элемент в списке, соответствующий указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Ошибка! Индекс находится за пределами допустимого");

        Node<T> current = head;

        for (int i = 0; i < index; i++)
            current = current.next;

        return current.data;
    }

    /**
     * Метод удаления элемента с указанным индексом.
     *
     * @param index индекс эл-та, котрый удаляем
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Ошибка! Индекс находится за пределами допустимого");
        if (index == 0)
            head = head.next;
        else
        {
            Node<T> current = head;

            for (int i = 0; i < index - 1; i++)
                current = current.next;

            current.next = current.next.next;
        }
        size--;
    }
}