package Components;

public class Component {
    private String name;
    private Integer calories;
    public Component(String name,Integer calories) {
        this.name = name;
        this.calories = calories;
    }
    public int getCalories(){
        return calories;
    }
    public String getName()
    {
        return name;
    }
}
