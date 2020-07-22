package lab.test;

import lombok.Data;

import java.util.function.Consumer;

/**
 * @author jasonsong
 * 2020/7/22
 */

@Data
public class DemoConsumer implements Consumer {
    protected int id;

    public DemoConsumer(int id) {
        this.id = id;
    }

    @Override
    public Consumer andThen(Consumer after) {
        System.out.println("andThen");
        return after;
    }

    @Override
    public void accept(Object o) {
        System.out.println("DemoConsumer accept id:" + id);
        if (id < 10) {
            Consumer consumer = andThen(new DemoConsumer(++id));
            consumer.accept("test id "+ id);
        }
    }
}
