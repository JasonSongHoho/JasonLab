package lab.real.t2022;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * shopee test
 *
 * @author Jason/XiaoJie
 * @date 2022/5/31
 */

public class BlockQueue<T> {

    // classic producer/consumer model
    // suppose we have a shared pool contains a bunch list of strings.
    // use list for example:   List<String> Pool

    // Producer:
    //   produce a string and put into the pool (no matter head or tail, as long as not exceed 100), if exceed 100, then wait until there's available slots in the pool.


    // consumer:
    //   get and remove one string from the pool, and print it as logic , if empty, then wait until available elements in the pool


    // now we want to implement this model which has the shared pool and 2 P & 2 C.


    ReentrantLock lock;
    Condition notEmpty;
    Condition notFull;
    LinkedList<String> pool;
    int size;

    public BlockQueue(int size) {
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        pool = new LinkedList<>();
        this.size = size;
    }

    public static void main(String[] args) {
        System.out.println("start");
        BlockQueue<String> blockQueue = new BlockQueue<>(2);
        blockQueue.put("hello");
        blockQueue.put("hello2");
        System.out.println("take:" + blockQueue.take());
        System.out.println("take:" + blockQueue.take());
        System.out.println("take:" + blockQueue.take());
        blockQueue.put("hello3");
        blockQueue.put("hello4");
        System.out.println("take:" + blockQueue.take());
        System.out.println("take:" + blockQueue.take());
        System.out.println("end");
    }

    public void put(String word) {
        lock.lock();
        try {
            while (pool.size() >= size) {
                notFull.await();
                System.out.println("block while put ");

            }
            pool.push(word);
            notEmpty.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public String take() {
        String str = null;
        lock.lock();
        try {
            while (pool.size() == 0) {
                notEmpty.await();
                System.out.println("block while take ");
            }
            str = pool.removeLast();
            notFull.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return str;
    }

}
