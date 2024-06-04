public class StringManipulation {
    public static void main(String[] args){
        System.out.println("StringManipulation");

        String string1 = "Vivek";
        String string2 = "Vivek";
        String string3 = new String("Vivek");

        // Comparing Objects References

        // Due to Java String Intern Pool, string1 and string2 will point to the same object in the pool
        System.out.println(string1 == string2);
        // string3 is a new object created in the heap
        System.out.println(string1 == string3);


    }
}
