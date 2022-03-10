public class Test {
    public static void main(String[] args) {

        System.out.println("\n---- TESTING ----");
        Encryptor encryptorTest1 = new Encryptor(3, 4);
        String actualEncrypted1 = encryptorTest1.encryptMessage("What are you doing next weekend?");
        String expectedEncrypted1 = "W  hayaroteu nedgxo tin weAenAedAk?A";
        if (actualEncrypted1.equals(expectedEncrypted1))
        {
            System.out.println("\nTest 1 PASSED!");
        }
        else
        {
            System.out.println("\n*** Test 1 FAILED! ***");
            System.out.println("EXPECTED: " + expectedEncrypted1);
            System.out.println("  ACTUAL: " + actualEncrypted1);
        }
        Encryptor encryptorTest2 = new Encryptor(6, 5);
        String actualEncrypted2 = encryptorTest2.encryptMessage("This one time I was trying to do a handstand and fell backwards and landed on my shoe. It hurt! I won't try that again.");
        String expectedEncrypted2 = "Toi tghnmwr ieeayts  sio tI n dhtaeaoaanlc nndlkadd  w s fbarnno .dddns s e hI ldmotaa ye h nraauI'ytir t  ntw ta.!othgA";
        if (actualEncrypted2.equals(expectedEncrypted2))
        {
            System.out.println("\nTest 1 PASSED!");
        }
        else
        {
            System.out.println("\n*** Test 1 FAILED! ***");
            System.out.println("EXPECTED: " + expectedEncrypted2);
            System.out.println("  ACTUAL: " + actualEncrypted2);
        }
    }
}
