import java.util.ArrayList;

public class HashMap<K, V> implements Map<K, V> {
    int size = 0;
    MapItem<K, V>[] MapItems;

    public HashMap(int maxSize) {
        if(maxSize<=0) {
            throw new IllegalArgumentException("Hash table size should be a +ve number");
        }
        MapItems = new MapItem[maxSize];

    }

    private class MapItem<K, V> implements Entry {
        K key;
        V value;

        public MapItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {

            return this.key ;
        }

        @Override
        public V getValue() {

            return this.value;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        int h = Math.abs(key.hashCode());
        int index = h % MapItems.length;
        return MapItems[index].getValue();
    }

    @Override
    public V put(K key, V value) {
        int h = Math.abs(key.hashCode());
        int index = h % MapItems.length;
        MapItems[index] = new MapItem(key, value);
        size++;
        return value;
    }

    @Override
    public V remove(K key) {
        int h = Math.abs(key.hashCode());
        int index = h % MapItems.length;
        if(MapItems[index]==null) {
            throw new IllegalArgumentException("Key not found ");
        }
        V value = MapItems[index].getValue();
        MapItems[index] = null;
        size--;
        return value;
    }

    @Override
    public Iterable<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < MapItems.length; i++) {
            if (MapItems[i] != null) {
                keys.add(MapItems[i].getKey());
            }
        }
        return keys;
    }

    @Override
    public Iterable<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (int i = 0; i < MapItems.length; i++) {
            if (MapItems[i] != null) {
                values.add(MapItems[i].getValue());
            }
        }
        return values;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> list = new ArrayList<>();
        for (int i = 0; i < MapItems.length; i++) {
            if (MapItems[i] != null) {
                list.add(MapItems[i]);
            }
        }
        return list;
    }

    public void print() {
        for(int i = 0; i< MapItems.length; i++)
        {
            if(MapItems[i]!=null)
                System.out.print("("+ MapItems[i].getKey()+" - "+ MapItems[i].getValue()+") ");

        }
        System.out.println("\n");

    }
}




