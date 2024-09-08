package org.example;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Student implements Comparable<Student> {
    private Integer id;
    private String name;
    private String department;

    public Student(Integer id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public int compareTo(Student o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", department='" + department + '\'' + '}';
    }
}

class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.compareTo(o2);
    }

}

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        waitNotify();
    }

    // region comparable
    public static void comparable() {
        var student2 = new Student(2, "Name2", "Department2");
        var student1 = new Student(1, "Name1", "Department1");
        var student4 = new Student(4, "Name4", "Department4");
        var student3 = new Student(3, "Name3", "Department3");

        var students = new ArrayList<>(List.of(student1, student2, student3, student4));

        Collections.sort(students);

        System.out.println(students);
    }
    // endregion comparable

    // region comparator
    public static void comparator() {
        var student2 = new Student(2, "Name2", "Department2");
        var student1 = new Student(1, "Name1", "Department1");
        var student4 = new Student(4, "Name4", "Department4");
        var student3 = new Student(3, "Name3", "Department3");

        var students = new ArrayList<>(List.of(student1, student2, student3, student4));

        students.sort(new StudentNameComparator());

        System.out.println(students);
    }
    // endregion comparator

    // region Parameterized class
    public static void parameterizedClass() {

        class Animal<T> {
            T values;
        }

    }
    // endregion Parameterized class

    // region Parameterized method
    public static void parameterizedMethod() {

        class Animal<T> {
            T values;

            public <G> G test() {
                return null;
            }
        }

    }
    // endregion Parameterized method

    // region subtyping
    public static void subtyping() {

        class Animal<T extends Number> {
            T values;
        }

//        new Animal<String>()
        var integerAnimal = new Animal<Integer>();


    }
    // endregion subtyping

    // region superTyping
    public static void superTyping() {

    }
    // endregion superTyping

    // region Iterator
    public static void iterator() {
        var range = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        var iterator = range.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    // endregion Iterator

    // region listIterator
    public static void listIterator() {
        var range = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        var integerListIterator = range.listIterator();

        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }

        while (integerListIterator.hasPrevious()) {
            System.out.println(integerListIterator.previous());
        }

    }
    // endregion listIterator

    // region arrayList
    public static void arrayList() {
        var integers = new ArrayList<Integer>();

        integers.add(10);
        integers.add(2);
        integers.add(3);
        integers.add(6);
        integers.add(9);
        integers.add(6);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
    // endregion arrayList

    // region vector
    public static void vector() {
        var integers = new Vector<Integer>();

        integers.add(10);
        integers.add(2);
        integers.add(3);
        integers.add(6);
        integers.add(9);
        integers.add(6);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
    // endregion vector

    // region stack
    public static void stack() {
        var integers = new Stack<Integer>();

        integers.add(10);
        integers.add(2);
        integers.add(3);
        integers.add(6);
        integers.add(9);
        integers.add(6);

        System.out.println(integers.pop());
    }
    // endregion stack

    // region linkedList
    public static void linkedList() {
        var integers = new LinkedList<Integer>();

        integers.add(10);
        integers.add(2);
        integers.add(3);
        integers.add(6);
        integers.add(9);
        integers.add(6);

        System.out.println(integers.peek());
        System.out.println(integers.peekFirst());
        System.out.println(integers.peekLast());
    }
    // endregion linkedList

    // region priorityQueue
    public static void priorityQueue() {
        var integers = new PriorityQueue<Integer>();

        integers.add(10);
        integers.add(2);
        integers.add(3);
        integers.add(6);
        integers.add(9);
        integers.add(6);

        System.out.println(integers.poll());
        System.out.println(integers);

    }
    // endregion priorityQueue

    // region arrayDeque
    public static void arrayDeque() {
        var integers = new ArrayDeque<Integer>();

        integers.add(10);
        integers.add(2);
        integers.add(3);
        integers.add(6);
        integers.addFirst(9);
        integers.add(6);

        System.out.println(integers.poll());
        System.out.println(integers.getFirst());
    }
    // endregion arrayDeque

    // region hashtable
    public static void hashtable() {
        var integers = new Hashtable<Integer, Integer>();

        integers.put(1, 1);
        integers.put(2, 2);
        integers.put(3, 3);
        integers.put(4, 4);

        for (Map.Entry<Integer, Integer> integer : integers.entrySet()) {
            System.out.println("key: " + integer.getKey() + ", value: " + integer.getValue());
        }
    }
    // endregion hashtable

    // region hashMap
    public static void hashMap() {
        var integers = new HashMap<Integer, Integer>();

        integers.put(1, 1);
        integers.put(3, 3);
        integers.put(4, 4);
        integers.put(2, 2);

        for (Map.Entry<Integer, Integer> integer : integers.entrySet()) {
            System.out.println("key: " + integer.getKey() + ", value: " + integer.getValue());
        }
    }
    // endregion hashMap

    // region linkedHashMap
    public static void linkedHashMap() {
        var integers = new LinkedHashMap<Integer, Integer>();

        integers.put(1, 1);
        integers.put(3, 3);
        integers.put(4, 4);
        integers.put(2, 2);

        for (Map.Entry<Integer, Integer> integer : integers.entrySet()) {
            System.out.println("key: " + integer.getKey() + ", value: " + integer.getValue());
        }
    }
    // endregion linkedHashMap

    // region treeMap
    public static void treeMap() {
        var integers = new TreeMap<Integer, Integer>();

        integers.put(2, 2);
        integers.put(3, 3);
        integers.put(1, 1);
        integers.put(4, 4);

        for (Map.Entry<Integer, Integer> integer : integers.entrySet()) {
            System.out.println("key: " + integer.getKey() + ", value: " + integer.getValue());
        }
    }
    // endregion treeMap

    // region hashSet
    public static void hashSet() {
        var integers = new HashSet<Integer>();

        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println(integers);
    }
    // endregion hashSet

    // region treeSet
    public static void treeSet() {
        var integers = new TreeSet<Integer>();

        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(5);

        System.out.println(integers);
    }
    // endregion treeSet

    // region createThread
    public static void createThread() {
        var thread = new Thread();
        var runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        var callable = new Callable<>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
        // new Future<Integer>() {}
    }
    // endregion createThread

    // region threadNameAndThreadPriority
    public static void threadNameAndThreadPriority() {
        var thread1 = new Thread(() -> System.out.println("CbZRk8xS"), "threadName");
        thread1.setPriority(Thread.MIN_PRIORITY);

        var thread2 = new Thread(() -> System.out.println("CbZRk8xS"));
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setName("ThreadName");

        System.out.println(thread1);

    }
    // endregion threadNameAndThreadPriority

    // region sleepJoin
    public static void sleepJoin() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Поток начался");
                Thread.sleep(5000);
                System.out.println("Поток продолжился");
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван");
            }
        });
        thread.start();

        System.out.println("before join");
        thread.join();
        System.out.println("after join");
    }
    // endregion sleepJoin

    static volatile boolean volatileTest = true;

    // region volatile
    public static void volatileTest() {
        var thread1 = new Thread(() -> {
            volatileTest = false;
        });
        var thread2 = new Thread(() -> {
            volatileTest = true;
        });

        thread1.start();
        thread2.start();
    }
    // endregion volatile

    // region daemonThread
    public static void daemonThread() throws InterruptedException {

        var thread = new Thread(() -> {
            var i = 0;
            while (i < 10) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("i: " + i);
                i++;
            }
        });

        thread.setDaemon(true);

        thread.start();
    }
    // endregion daemonThread


    // region monitor
    public static void monitor() {
        var test = new Test();

        new Thread(test::test1).start();
        new Thread(test::test2).start();
        new Thread(() -> {
            Test.test3();
        }).start();
    }
    // endregion monitor

    // region waitNotify
    public static void waitNotify() {
        var lock = new Object();
        var thread = new Thread(() -> {
            System.out.println("start thread");
            synchronized (lock) {
                System.out.println("in synchronized");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("in synchronized end");
            }
            System.out.println("end thread");
        });

        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (lock) {
            System.out.println("in lock");
            lock.notify();
        }

        System.out.println("end");
    }
    // endregion waitNotify

    // region lock
    public static void lock() {
        var lock = new ReentrantLock();
        var thread = new Thread(() -> {
            System.out.println("start thread");
            if (lock.tryLock()) {
                System.out.println("in lock");
                lock.unlock();
            }
            System.out.println("end thread");
        });
    }
    // endregion lock

    // region syncCollection
    public static void syncCollection() {
        var list = List.of();
        var synchronizedList = Collections.synchronizedList(list);
    }
    // endregion syncCollection

    // region test
    public static void test() {
    }
    // endregion test

}

class Test {
    public synchronized void test1() {
        System.out.println("test1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test1 -> end");
    }

    public synchronized void test2() {
        System.out.println("test2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test2 -> end");
    }

    public synchronized static void test3() {
        System.out.println("test3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test3 -> end");
    }
}