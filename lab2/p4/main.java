package domain;

public class p4 {
    public static void main(String[] args) {
        Room r1 = new Room("12C", "normal", 1);
        Room r2 = new Room("12D", "luxury", 1);

        Person p1 = new Person();
        p1.setName("David");
        p1.setSurname("Beckham");
        p1.setAge(44);
        p1.setIdNo("11233444");
        p1.setType("teacher");

        Person p2 = new Person();
        p2.setName("Lionel");
        p2.setSurname("Messi");
        p2.setAge(33);
        p2.setIdNo("10101010");
        p2.setType("teacher");

        Subject ob1 = new Subject(r1, p1, 30);
        Subject ob2 = new Subject(r2, p2 ,33);

        System.out.println("The first subject: " + ob1.getTeacher().getName() + " " + ob1.getTeacher().getSurname() + " "
                   + ob1.getTeacher().getAge() + " " + ob1.getTeacher().getIdNo() + " " + ob1.getTeacher().getType() + " "
                   + ob1.getRoom().getNumber() + " " + ob1.getRoom().getType() + " " + ob1.getRoom().getFloor() + " "
                   + ob1.getNoOfStudents());
        System.out.println("The second subject: " + ob2.getTeacher().getName() + " " + ob2.getTeacher().getSurname() + " "
                + ob2.getTeacher().getAge() + " " + ob2.getTeacher().getIdNo() + " " + ob2.getTeacher().getType() + " "
                + ob2.getRoom().getNumber() + " " + ob2.getRoom().getType() + " " + ob2.getRoom().getFloor() + " "
                + ob2.getNoOfStudents());
    }
}
