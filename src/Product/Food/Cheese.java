package Product.Food;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Product.Consumable;
import Product.Nutritions;
import java.util.*;
import java.util.stream.Collectors;

public class Cheese implements Nutritions, Consumable {
    private String name;
    public int calories;

    public Cheese(){
        name = "Cheese";
        calories = 152;
    }

    public String getName() {
        return name;
    }

    public int getCalories(){
        return calories;
    }

    @Override
    public int calculateCalories() {
        return calories;
    }
    @Override
    public void consume(){
        System.out.println("Cheese is eaten");
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true; // Если ссылки на один объект, они равны
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false; // Если объект null или классы не совпадают, они не равны
        }
        Cheese cheese = (Cheese) obj; // Приведение объекта к типу
        // Сравниваем значения полей
        return name.equals(cheese.name);
    }
}
