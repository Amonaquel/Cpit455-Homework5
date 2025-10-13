public class Main {
    public static void main(String[] args) {
        DataCenter dc1 = new DataCenter("DC1");
        DataCenter dc2 = new DataCenter("DC2");
        DataCenter dc3 = new DataCenter("DC3 (Backup)");

        String[] transactions = {"Tx1", "Tx2", "Tx3", "Tx4"};

        System.out.println("Starting SADAD simulation...\n");

        for (String tx : transactions) {
            boolean success = dc1.process(tx);

            if (!success) success = dc2.process(tx);
            if (!success) success = dc3.process(tx);

            if (!success) System.out.println("All DCs failed for " + tx);
        }

        // Simulate failure and recovery
        dc1.fail();
        dc2.fail();

        System.out.println("\n-- After failure --");
        for (String tx : transactions) {
            if (!dc1.process(tx) && !dc2.process(tx))
                dc3.process(tx);
        }

        dc1.recover();
        dc2.recover();

        System.out.println("\nSystem fully recovered!");
    }
}
