public class polynomial {
    public static void main(String[] args) {
        student std = new student();
        person per = new person();

        std.speak();

        per.introduce();
    }
}

class student {
    protected void speak() {
        System.out.println("Hello' i'm a student");
    }
}

class person extends student {
    public void introduce() {
        speak();
        System.out.println("yes i'm person");
    }
}