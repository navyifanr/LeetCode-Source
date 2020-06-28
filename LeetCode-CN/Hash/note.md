### 哈希表

> 哈希表(Hash table)，也叫散列表，是根据关键码值(Key value)而直接进行访问的数据结构。 它通过把关键码值映射到表中一个位置来访问记录，以加快查找的 速度。
  这个映射函数叫作散列函数(Hash Function)，存放记录的数组 叫作哈希表(或散列表)。

Map: key-value 键值对，key 不可重复，value可重复；HashMap, HashTable, ConcurrentHashMap
Set: 不重复元素；HashSet, TreeSet

HashMap 源码简析：

put 方法:

- 对 key 的 hashcode 做 hash 值；
- 哈希表为空时，创建新的；找到要插入的下标，如果对应值为空，则直接插入；
- 如果发生哈希碰撞：
    - 如果节点的 key 和插入的一致，替换原来值
    - 如果节点结构是树结构，则以红黑树插入
    - 如果是链表结构，找到对应要插入的节点，如果链表过长，则转为红黑树，否则节点不存在，插到队尾，存在则替换；
```$java
    public V put(K key, V value) {
        //对 key 的 hashcode 做 hash 
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //哈希表为空时，创建新的
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //通过hash找到下标，如果下标对应的节点值为空，则将数据存储进去
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else { //通过hash找到的下标，有数据，发生碰撞
            Node<K,V> e; K k;
            //找到的下标的 key 和要插入的一致，将 e 赋值为 p
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //找到的下标的 key 和要插入的不一致，桶中数据是树结构，通过红黑树插入
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            //桶中数据是链表结构
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        //链表中不存在要插入的节点，则放在链表队尾
                        p.next = newNode(hash, key, value, null);
                        //链表过长，超过阈值，则转为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    //链表中存在要插入的节点，替换调原来的，跳出循环
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //更新发生冲突的键值对
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //hashmap size 大于阈值，则扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

```

get 方法:

- 直接根据 hash 值找对应节点数据；
- 如果节点的 key 一致，则直接返回；不一致，则判断节点是树结构还是链表结构，查询返回

```$java
    public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            //根据hash值，找到节点，key一致，则直接返回对应的节点
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                //节点为红黑树，则通过树结构查找
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    //节点为链表，遍历查询
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```
