public class Student {

    // private String fname;
    private String[] lname;
    private int max;

    public Student(int size) {
        lname = new String[size];
        max = -1;
    }

    public void get_fname() {
        for (String n : lname) {
            System.out.println("name: " + n);
        }
    }

    // public int get_Age() {
    // return Age;
    // }

    public boolean set_Name(String name) {
        if (max == 10) {
            return false;
        }
        max++;
        lname[max] = name;
        return true;
    }

    // public void set_Age(int age) {
    // Age = age;
    // }

    // public String toStrings() {
    // return "Studen name: " + fname + "," + "Age: " + Age;
    // }
}
