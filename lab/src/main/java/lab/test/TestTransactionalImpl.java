//package lab.test;
//
//import cn.hutool.core.date.DateUtil;
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//import com.souche.voipasr.dao.impl.AuthDaoImpl;
//import com.souche.voipasr.entity.AuthDO;
//import com.souche.voipasr.service.TestTransactional;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author jasonsong
// * 2020/7/16
// */
//
//@Slf4j
//@Component
//public class TestTransactionalImpl implements TestTransactional {
//    @Autowired
//    private AuthDaoImpl authDao;
//    @Autowired
//    private InvokeClass invokeClass;
//
//
//    private ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("TestTransactional-%d").build();
//    private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
//            0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), threadFactory);
//
//    //    @Transactional(rollbackFor = Exception.class)
//    public void test(String name) {
//        name = name + "-" + DateUtil.now();
//        //通过代理类解决自调用失效问题
////            MyThread myThread = (MyThread) AopContext.currentProxy();
////            myThread.method(name);
////        myThread.setName(name);
//        executor.submit(new MyThread(name));
//
////        method(name);
//    }
//
//
//    //    @Transactional(rollbackFor = Exception.class)
//    public void method(String name) {
//        AuthDO authDO = AuthDO.builder()
//                .accessKey(name + "-1")
//                .serviceId(1)
//                .privateKeyBase64(name)
//                .publicKeyBase64("1")
//                .build();
//        try {
//            authDao.insert(authDO);
//        } catch (Exception e) {
//            log.error("insert error", e);
//        }
//        if (name.length() <= 24) {
//            throw new RuntimeException("TestTransactional");
//        }
//        AuthDO authDO1 = AuthDO.builder()
//                .accessKey(name + "-2")
//                .serviceId(1)
//                .privateKeyBase64(name)
//                .publicKeyBase64("2")
//                .build();
//        authDao.insert(authDO1);
//
//    }
//
//
//    public class MyThread implements Runnable {
//        String name;
//
//        public MyThread(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public void run() {
//            invokeClass.method(name);
//
//        }
////
////        //    @Transactional(rollbackFor = Exception.class)
////        public void method(String name) {
////            AuthDO authDO = AuthDO.builder()
////                    .accessKey(name + "-1")
////                    .serviceId(1)
////                    .privateKeyBase64(name)
////                    .publicKeyBase64("1")
////                    .build();
////            try {
////                authDao.insert(authDO);
////            } catch (Exception e) {
////                log.error("insert error", e);
////            }
////            if (name.length() <= 24) {
////                throw new RuntimeException("TestTransactional");
////            }
////            AuthDO authDO1 = AuthDO.builder()
////                    .accessKey(name + "-2")
////                    .serviceId(1)
////                    .privateKeyBase64(name)
////                    .publicKeyBase64("2")
////                    .build();
////            authDao.insert(authDO1);
////
////        }
//    }
//}
