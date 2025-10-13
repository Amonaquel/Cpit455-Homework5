class DataCenter {
    String name;
    boolean online = true;

    DataCenter(String name) {
        this.name = name;
    }

    void fail() {
        online = false;
        System.out.println(name + " failed!");
    }

    void recover() {
        online = true;
        System.out.println(name + " recovered!");
    }

    boolean process(String tx) {
        if (!online) return false;
        System.out.println(name + " processed " + tx);
        return true;
    }
}