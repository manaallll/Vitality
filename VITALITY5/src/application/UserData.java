package application;


public class UserData {
    private double age;
    private static UserData instance;
    private String sex;
    private double weight;
    private double height;
    

    public UserData() {
    }

    public UserData(int age, String sex, double weight, double height) {
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public double getAge() {
        return  age;
    }

    public void setAge(double age) {
        this.age =  age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


   

    



    
}
