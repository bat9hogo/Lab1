package Product.Food;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Product.Consumable;
import Product.Nutritions;
import java.util.*;
import java.util.stream.Collectors;

public class Apple implements Nutritions, Consumable {
    private String name;
    private String size;
    private int calories;

    public  Apple(){
        System.out.println("Choose a size: " + "1.Small 2.Large");
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        if(n > 2){
            while(n>2)
                n = in.nextInt();
        }
        switch (n){
            case 1:
                size = "small";
                calories = 15;
                break;
            case 2:
                size = "large";
                calories = 25;
                break;
            default:
                size = "unknown";
                break;
        }
        name = "Apple " + size;
    }

    public Apple(String size) {
        this.size = size;
        this.name = "Apple " + size;
    }

    public String getSize() {
        return size;
    }
    public String getName() {
        return name;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public int getCalories(){
        return calories;
    }
    @Override
    public int calculateCalories() {
        return calories;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public void consume(){
        System.out.println(size + " apple is eaten");
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true; // Если ссылки на один объект, они равны
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false; // Если объект null или классы не совпадают, они не равны
        }
        Apple apple = (Apple) obj; // Приведение объекта к типу Apple
        // Сравниваем значения полей
        return name.equals(apple.name) && size.equals(apple.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    public static Map<String, Long> searchDuplicate(List<Object> arr) {
        return arr.stream()
                .map(obj -> (Apple) obj) // Приведение объектов к Apple
                .collect(Collectors.groupingBy(Apple::getName, Collectors.counting()));
    }

}
