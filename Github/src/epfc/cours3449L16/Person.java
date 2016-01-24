package epfc.cours3449L16;

/**
 *
 * @author 0101nalegier
 */
public class Person {
    private int age;

    public void setAge(int age) {
        if (age <0) {
            throw new IllegalArgumentException("Age trop petit");
        }
        if (age > 100){
           throw new IllegalArgumentException("Trop agé");
           }
        else this.age = age;
    }

    public int getAge() {
        return age;
    }
    
    
}
