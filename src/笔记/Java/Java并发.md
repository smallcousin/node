## JMM详解
Java内存模型描述了Java程序中各种共享变量（线程间共享）的访问规则，以及在并发环境下，如何处
理各种复杂的情况。Java内存模型的主要目标是定义程序中的各种变量的访问方式，以及在单处理器或多处
理器环境中处理并发正常或非正常访问等问题。
线程占有各自的本地内存，共享主内存

## 死锁产生的条件
1. 互斥条件（Mutual Exclusion）：至少有一个资源必须处于非 共享模式，即一次只有一个进程可以使用。
如果其他进程请求该资源，那么请求进程必须等到占有资源的进程释放资源。
2. 占有并等待（Hold and Wait）：一个进程必须持有至少一个资源并等待获取其他进程已经占有的资源。
3. 不可抢占（No Preemption）：资源不能被强行从占有它的进程中抢占，只有当进程完成任务后才能释放资源。
4. 循环等待（Circular Wait）：存在一组等待进程，其中每个进程都在等待下一个进程所占有的资源，这形成了一个循环。

（1） 互斥条件：一个资源每次只能被一个进程使用。

（2） 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。

（3） 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。

（4） 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系

## 死锁产生的原因
（1） 因为系统资源不足。
（2） 进程运行推进的顺序不合适。
（3） 资源分配不当等。

资源竞争：当多个进程同时请求同一资源时，如果资源的分配策略不当，就可能会导致死锁。
例如，两个进程各自占有一部分资源，但同时需要对方占有的资源才能继续执行。

非预防性资源调度：在某些情况下，操作系统并未预先制定有效的资源调度策略，这可能导致资源的分配顺序导致死锁。
例如，系统允许进程在持有其他资源的同时请求新资源，这可能导致循环等待条件，从而产生死锁。

多个进程间的通信不当：如果进程间的通信没有得到良好的同步，也可能会产生死锁。
例如，两个进程互相发送请求，等待对方的响应，而又没有设置超时机制，就可能会导致死锁。

嵌套锁：在并发编程中，如果一个线程在持有一个锁的情况下试图获取另一个锁，而这个锁正被另一个线程持有，这可能导致死锁。
这种情况常发生在嵌套锁或复杂的锁定策略中。


## 同步和异步的区别
同步（Synchronous）和异步（Asynchronous）是指在执行操作或调用函数时，是否需要等待操作或函数完成后才继续执行后续任务的方式。

同步是按顺序依次执行任务，一个任务执行完后才能执行另一个；异步可以其他线程进行任务的执行，主线程可以同时做其他事情货返回

同步：在同步操作或调用函数时，后续任务会等待当前操作或函数执行完毕后才会继续执行。同步操作具有顺序性，因此易于理解和实现。
但是，同步操作可能导致整个流程阻塞，特别是在执行耗时任务时，会影响程序的性能和响应速度。

例如，当你在浏览器中访问一个网页时，浏览器需要依次下载所有的资源（如HTML、CSS、JavaScript等），这个过程是同步的，
因为浏览器需要等待一个资源下载完成后才能继续下载下一个资源。

异步：异步操作或调用函数时，不会阻塞后续任务的执行。异步操作在启动后，会立即返回（通常返回一个标识，如Promise、Callback等），
让程序继续执行后续任务。当异步操作完成时，会通过一定的机制（如回调函数、事件等）通知程序。异步操作可以提高程序的性能和响应速度，
特别是在执行耗时任务时。但是，由于异步操作具有非顺序性，因此可能会增加代码的复杂性。

例如，当你在浏览器中访问一个网页时，如果浏览器使用异步操作加载资源，那么它不需要等待一个资源下载完成后才能继续下载下一个资源，
而是可以同时下载多个资源，从而提高页面加载速度。同时，当某个资源下载完成时，浏览器可以立即开始处理该资源，
而不需要等待其他资源全部加载完毕。

## 如何预防死锁
从四个必要条件入手

## ReentrantLock的特点
可重入  公平锁  响应中断  限时等待
公平锁和限时等待不太理解  公平锁指得是会根据等待时间的长短来提供锁，等待时间长的先获得锁
问ReentrantLock是什么的时候  回答的步骤
1.表面上，即直观上是什么  2.实质上是什么  3.有什么性质  4.如何使用 5.横向对比
可重入的独占式锁

## ReadWriteLock 的简单使用
简单来讲，就是该接口允许一次读取多个线程，但一次只能写入一个线程

## 原子性  可见性
原子性：同时成功或同时失败  可见性：一个线程修改某个值，其他线程能马上看到

## 说一下CAS算法
CAS是一种无锁的并发控制算法，它包含三个参数CAS(V, A, B)。V代表要更新的变量，A代表预期值，B代表新值。
当且仅当V的值等于A时，CAS通过原子方式用新值B来更新V的值，否则不会执行任何操作。一般情况下，“更新的值”是通过某种算法计算得到的，
而不是固定的。如果用单线程执行CAS操作，那就不存在什么问题，但实际情况常常是在并发情况下使用CAS，此时可能会出现一个线程获取了变
的旧值，然后通过算法得到新值，而这个过程中，其他线程已经修改了这个变量，那么当前线程再用CAS进行更新时就会失败。

## CAS自旋？？？

##  synchronized关键字与wait()和notify()/notifyAll()方法相结合可以实现等待/通知机制
```java
public class WaitNotifyExample {
  private Object lock = new Object();

  public void producer() {
    synchronized (lock) {
      System.out.println("Producer thread started");
      try {
        lock.wait();  // 让生产者线程等待
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Producer thread resumed");
    }
  }

  public void consumer() {
    synchronized (lock) {
      System.out.println("Consumer thread started");
      lock.notify();  // 唤醒在此对象监视器上等待的单个线程
      System.out.println("Consumer thread finished");
    }
  }
}
```
ReentrantLock实现选择性通知
```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionExample {
  private ReentrantLock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void waitCondition() {
    lock.lock();
    try {
      System.out.println("开始等待...");
      condition.await();  // 让当前线程在condition上等待
      System.out.println("等待结束，继续执行...");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void signalCondition() {
    lock.lock();
    try {
      System.out.println("发送通知...");
      condition.signal();  // 唤醒在condition上等待的一个线程
    } finally {
      lock.unlock();
    }
  }
}
```

## Semaphore
Semaphore 是一个计数信号量，用来控制同时访问特定资源的线程数量。它的内部维护了一个 "许可" 集合，
线程可以通过 acquire() 方法获取许可，如果当前许可已经被其他线程全部获取，那么线程会等待直到有线程释放许可为止。
线程使用完许可后，需要调用 release() 方法来释放许可

## 对象头
在Java中，对象头是分配给每个对象的一部分内存，其中包含该对象的元数据。对象头通常包含以下信息：
对象标识信息：这部分信息用于标识对象的类、哈希码和GC状态等。
类型指针：指向表示对象类的元数据的指针。
锁信息：与对象关联的锁信息，用于同步和并发控制。
GC信息：用于垃圾回收的相关信息。

## 为什么不用Finalize方法
Java中的finalize()方法是Object类的一个方法，它会在垃圾收集器将对象从内存中清除出去之前被调用。
这个方法主要用于确保对象在被销毁前完成特殊的清理工作，比如释放非Java资源（如数据库连接，网络连接，文件句柄等）。

finalize()方法在Java 9中被标记为已弃用，因为它有很多潜在的问题：

执行时间不确定：finalize()方法是由垃圾收集器调用的，而垃圾收集器的执行时间是不可预测的，因此，
你不能确定何时finalize()会被执行。

可能导致性能下降：如果在finalize()方法中执行耗时的操作，如关闭数据库连接或清理大量的资源，可能会导致垃圾收集的效率降低。

可能导致资源不被正确释放：如果在finalize()方法中出现异常，垃圾收集器不会报告这个异常，因此可能导致资源没有正确地被清理。

因此，现在更推荐使用try-with-resources语句或显式的清理方法来管理资源，而不是依赖于finalize()方法。

1.finalize方法的优先级比较低
2.finalize只能执行一次
finalize可以用来拯救对象，但是有上面两个问题

## 怎么判断对象存活
1. 引用计数法
2. 可达性分析算法 

在Java中，垃圾收集器负责自动管理内存，它会释放那些不再被任何部分的程序代码所引用的对象的内存。
判断一个对象是否“存活”（即是否仍然可访问），通常涉及到几种不同的概念和机制。

引用计数法（不是Java使用的方法）: 每个对象有一个引用计数器，每当有一个新的引用指向该对象时，计数器值就加一；
当引用被置为null或改变引用对象时，计数器值就减一。当计数器的值为零时，对象就认为是不可达的。然而，Java没有采用这种方式
，因为它无法解决对象之间相互引用的情况。

可达性分析法: Java使用这种方式。从垃圾收集根节点开始，遍历所有的引用路径。程序中可以访问的对象被认为是可达的，
也就是“存活”的。不可达的对象认为是“死亡”的，适合进行垃圾回收。根节点集包括局部变量、活动线程、静态字段等
GCroots 有：静态变量、线程变量、常量池、JNI指针


## CMS垃圾回收器，以及问题
Concurrent Mark Sweep
CMS（Concurrent Mark Sweep）垃圾收集器是Java虚拟机中的一种垃圾收集器，主要用于收集堆内存中的老年代对象。
CMS垃圾收集器以获取最短回收停顿时间为目标，适用于响应时间有严格要求的应用。

CMS垃圾收集器的工作过程可以分为以下阶段：
初始标记（Initial Mark）：此阶段需要STW（Stop-The-World），标记GC Roots能直接关联的对象。
并发标记（Concurrent Mark）：与应用线程并发执行，对堆中的对象进行深度优先的遍历标记。
再次标记（Remark）：由于并发标记阶段用户线程依然在运行，因此需要STW，修正并发标记期间由于用户程序继续运行而导致的标记变化。
并发清除（Concurrent Sweep）：与应用线程并发执行，清除未被标记的对象。
CMS垃圾收集器存在的问题：
1. 内存碎片问题：由于CMS使用标记-清除算法，可能会产生大量不连续的内存碎片。这会导致在为大对象分配内存时发生问题，
可能触发Full GC来整理内存。
2. 停顿时间虽短但仍存在：尽管CMS减少了停顿时间，但在初始标记和再次标记阶段还是需要STW。这对于非常延迟敏感的应用仍然可能是个问题。
增加的CPU开销：为了减少停顿时间，CMS会使用更多的CPU资源来并发执行垃圾回收，这可能会影响应用的总体吞吐量。
3. 并发阶段可能导致失败：CMS在并发清理阶段若预测错误，老年代空间不足，会导致一个Full GC，这样的GC会比CMS的整
个收集周期停顿时间更长。
4. 浮动垃圾问题：在CMS工作期间，应用线程仍在运行并产生新的垃圾，这部分垃圾只能等到下一次GC时才能被清除，称之为浮动垃圾。

1.CPU敏感
2.浮动垃圾
3.内存碎片

## 用户线程和守护线程的区别
用户线程（User Thread）：用户线程通常是程序的主要执行线程，如 main() 方法的执行线程。只要有一个用户线程仍然在运行
，JVM就会继续运行。即使主线程（通常是启动程序的线程）结束，只要还有用户线程在运行，程序就不会停止。

守护线程（Daemon Thread）：守护线程主要用于后台处理服务或者进行垃圾回收、清理等操作，如 JVM的垃圾收集线程。
守护线程的生命周期依赖于用户线程，即当所有的用户线程都结束时，JVM会正常退出，而不管守护线程是否执行完毕。

## Executor和Executors的区别
Executor是一个接口  Executors是线程池的一个工具类
常用线程池有
1. FixedThreadPool：固定大小的线程池。每当提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
线程池的大小一旦达到最大值就会保持不变，如果某个线程因执行异常而结束，线程池会补充一个新线程。
2. CachedThreadPool：缓存型线程池。这种类型的线程池大小非常灵活，可以根据需求自动的更改池的大小。
3. SingleThreadExecutor：单线程的Executor，创建单个工作线程来执行任务，如果这个线程异常结束，会创建一个新的来替代
4. ScheduledThreadPoolExecutor：可调度的线程池，可以设置线程的定时或周期性执行任务。

## volatile 关键字的作用
1. 确保多线程的可见性
2. 禁止指令重排序

## 怎么去唤醒一个线程
1. wait和notify  配合synoriarine使用
2. park和unpark

## java实现多线程间的通讯和协作
1. synchronized和wait+notify
2. Lock + Condition

## 对象的创建过程
1. 类加载
2. 检查加载
3. 分配内存
4. 内存初始化
5. 设置  信息放在对象头
6. 对象初始化

## Minor GC 和 Full GC 分别发送在什么时候
Minor GC（小型垃圾收集）： Minor GC通常发生在新生代（Young Generation）的Eden区满时。新生代是堆内存的一部分，
新创建的对象通常首先在新生代中分配。当Eden区域变满，就会触发Minor GC。在Minor GC期间，活动的对象会被移动到Survivor区域，
然后，清理Eden区和其中一个Survivor区的所有对象。Minor GC要清理的内存相对较小，且新生代中的对象通常具有"朝生暮死"的特性，所
以Minor GC通常比较快，且会频繁发生。

Full GC（完全垃圾收集）： Full GC会清理整个Java堆，包括新生代和老年代（Old Generation）。通常在以下情况下触发Full GC：
老年代空间不足：在Minor GC过程中，生存周期长的对象会被移动到老年代，当老年代的空间不足以容纳新的对象时，就会触发Full GC。
显式系统调用：当系统调用了System.gc()时，也会触发Full GC。
Metaspace或PermGen空间不足：用于存储类的元信息的空间（在Java8之前是PermGen，Java8之后是Metaspace）如果不足，也
会触发Full GC。

简单来讲， Minor GC在年轻代满了的时候发生， Full GC 在老年代或方法区满的时候发生

## 类加载器，类加载器有哪些
类加载的生命周期
加载 验证 准备 解析 卸载 使用 初始化
    ————————————
        连接

类加载器
Boostrap ClassLoader
Extention ClassLoader
Application ClassLoader
Custom ClassLoader

## G1垃圾回收器
1. 并发与并行
2. 分代收集
3. 空间整合
4. 可以建立可预测的停顿模型
5. 将整个java堆内存模型分为多个大小相等的Region，使得年轻代和老年代不在物理上隔离开来

