import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("orange");
        queue.offer("apple");
        queue.offer("pear");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
//        System.out.println(queue.remove());

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int com = o1.name.compareTo(o2.name);
                return com == 0 ? o1.age - o2.age : com;
            }
        };
        Queue<Person> queue2 = new PriorityQueue<>(comparator);
        queue2.add(new Person("Orange", 12));
        queue2.offer(new Person("Apple", 10));
        queue2.offer(new Person("Apple", 12));
        queue2.offer(new Person("Pear", 9));
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
        System.out.println(queue2.poll());
    }
}

class Person {
    public int age;
    public String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}