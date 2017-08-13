# ReadWriteLock
### 概述
场景：对共享资源读写操作时，写操作没有读操作那么频繁。在没有写操作的时候，多个线程同时读一个资源没有任何问题，所以应该允许多个
线程读取共享资源，但是如果一个线程想去写这些共享资源，就不应该允许其他线程对该资源进行读和写操作。

Java并发包提供了读写锁：ReentrantReadWriteLock，表示两个锁：一个读操作相关，为共享锁，一个写相关，为排他锁。
```java
public class ReentrantReadWriteLock implements ReadWriteLock, java.io.Serializable
```
实现的是ReentrantLock接口，而非Lock接口
```java
public static class ReadLock implements Lock, java.io.Serializable
public static class WriteLock implements Lock, java.io.Serializable
```
另外读写锁也设计成模板方法模式，通过继承队列同步器，提供了公平与非公平锁的特性：
```java
static abstract class Sync extends AbstractQueuedSynchronizer
final static class NonfairSync extends Sync
final static class FairSync extends Sync
```