package lab.test.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author jasonsong
 * 2020/8/21
 */

@SPI
public interface Robot {
    void sayHello();
}
