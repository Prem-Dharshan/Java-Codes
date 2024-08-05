// 5. Create a class named BloodData that includes fields that hold a blood type (the four blood
//        types are O, A, B, and AB) and an Rh factor (the factors are + and –). Create a default
// constructor that sets the fields to O and +, and an overloaded constructor that requires values
// for both fields. Include get and set methods for each field. Create a class named Patient that
//        includes an ID number, age, and BloodData. Provide a default constructor that sets the ID
// number to 0, the age to 0, and the BloodData values to O and +. Create an overloaded
// constructor that provides values for each field. Also provide get methods for each field. Create
// an application that demonstrates that each method works correctly and test it.

package WS05;

class WS05_PS05 {
    public static void main(String[] args) {
        // Default patient
        System.out.println("Patient 1");
        Patient patient1 = new Patient();
        System.out.println(patient1);

        // Patient with custom blood data
        System.out.println("Patient 2");
        BloodData bloodData2 = new BloodData(BloodData.RhFactor.NEGATIVE, BloodData.BloodType.A);
        Patient patient2 = new Patient(123, bloodData2, 30);
        System.out.println(patient2);
    }
}

class BloodData {

    enum BloodType {
        O,
        A,
        B,
        AB
    }

    enum RhFactor {
        POSITIVE("+"),
        NEGATIVE("-");

        final String value;

        private RhFactor(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    BloodType type;
    RhFactor rhFactor;

    public BloodData() {
        this.type = BloodType.O;
        this.rhFactor = RhFactor.POSITIVE;
    }

    public BloodData(RhFactor rhFactor, BloodType type) {
        this.rhFactor = rhFactor;
        this.type = type;
    }

    public BloodType getType() {
        return type;
    }

    public void setType(BloodType type) {
        this.type = type;
    }

    public RhFactor getRhFactor() {
        return rhFactor;
    }

    public void setRhFactor(RhFactor rhFactor) {
        this.rhFactor = rhFactor;
    }

    @Override
    public String toString() {
        return "" + type + rhFactor;
    }
}

class Patient {

    int id;
    int age;
    BloodData bloodData;

    public Patient() {
        this.id = 0;
        this.age = 0;
        this.bloodData = new BloodData();
    }

    public Patient(int id, BloodData bloodData, int age) {
        this.id = id;
        this.bloodData = bloodData;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BloodData getBloodData() {
        return bloodData;
    }

    public void setBloodData(BloodData bloodData) {
        this.bloodData = bloodData;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", age=" + age +
                ", bloodData=" + bloodData +
                '}';
    }
}