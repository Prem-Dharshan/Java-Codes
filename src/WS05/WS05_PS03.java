// 3. Create a class named Player with the following private attributes.
// String name, int age, String country
// - Include appropriate getters and setters.
// - Include a default constructor.
// - Include a 3-argument constructor. The order in which the parameters are passed is the name,
// age, and country. Override the toString method to display the player details.

package WS05;

class WS05_PS03 {
    public static void main(String[] args) {

        System.out.println(new Player());

        Player player = new Player("DPD", 20, "Costa Rica");
        System.out.println(player);

        return;
    }
}

class Player {

    private String name;
    private int age;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "Name";
        this.age = 0;
        this.country = "India";
    }

    public Player(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Player: {" +
                " name = " + this.name +
                ", age = " + this.age +
                ", country = " + this.country +
                " }";
    }
}
