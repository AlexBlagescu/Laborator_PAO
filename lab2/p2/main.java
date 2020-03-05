package domain;

public class p2 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("John");
        p1.setSurname("Doe");
        p1.setAge(24);
        p1.setIdNo("1123444");
        p1.setType("student");

        Person p2 = new Person();
        p2.setName("Jane");
        p2.setSurname("Roe");
        p2.setAge(56);
        p2.setIdNo("22333444");
        p2.setType("teacher");

        System.out.println(p1.getName() + " " + p1.getSurname() + " " + p1.getAge() + " " + p1.getIdNo() + " " + p1.getType());
        System.out.println(p2.getName() + " " + p2.getSurname() + " " + p2.getAge() + " " + p2.getIdNo() + " " + p2.getType());
    }
}
