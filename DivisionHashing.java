public static class HashTable {
    public String key;
    public Object value;

    public Item(String key, Object value){
        this.key = key;
        this.value = value;
    }
}

public static class HashTable{

    private static int HASH_TABLE_CAPACITY = 1000;
    private Item[] data = new Item[HASH_TABLE_CAPACITY];
    private int size =  0;

    private int getHash(String key){
        int hash = 0;
        for(int i=0; i<key.length(); i++){
            char val = key.charAt(i);
            hash = (hash + val*(i+1)) % HASH_TABLE_CAPACITY;
        }
        return hash;
    }

    public Object get(String key){
        if(key != null){
            int hash = getHash(key);
            while(data[hash] != null & !data[hash].key.equals(key)){
                hash = (hash+1) % HASH_TABLE_CAPACITY;
            }
            return data[hash] != null ? data[hash].value  : null;
        }
    }

    public void put(String key, Object value){
        if(key != null){
            int hash = getHash(key);
            while(data[hash] != null && !data[hash].key.equals(key)){
                hash = (hash + 1) % HASH_TABLE_CAPACITY;
            }
            if(data[hash] == null)
                size++;
            data[hash] = new Item(key, value);
        }
    }

    public Object remove(String key){
        Object removed = null;
        if(key != null){
            int hash = getHash(key);
            while(data[hash] != null && !data[hash].key.equals(key)){
                hash = (hash + 1) % HASH_TABLE_CAPACITY;
            }
            if(data[hash] != null){
                removed = data[hash];
                data[hash] = null;
                size--;
            }
        }
        return removed;
    }

    public int size(){
        return size;
    }

}
