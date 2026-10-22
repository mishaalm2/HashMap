public class Driver {
    public static void main(String[] args) {
        HashMap<String ,Integer> map= new HashMap(20);

        map.put("Mishaal", 95);
        map.put("Fahd", 90);
        map.put("Sami", 89);
        map.put("Mohammed", 75);
        map.put("Ayman", 100);
        map.print();

        System.out.println("Get the grade: " +map.get("Mishaal"));
        System.out.println("\n");

        System.out.println("is empty? "+ map.isEmpty());

        System.out.println("");

        System.out.println("Get the size: "+map.size());

        System.out.println("\n");

        map.remove("Mohammed");
        map.print();
        map.remove("Sami");
        map.print();
        map.remove("Abdulrahman");
        map.print();

    }

}

