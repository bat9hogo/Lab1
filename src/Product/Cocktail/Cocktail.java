package Product.Cocktail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Components.Component;
import Components.Drink.*;
import Product.Consumable;
import Product.Nutritions;

public class Cocktail implements Nutritions, Consumable {

    private Component drink;
    private Component fruit;
    private String name;

    public Cocktail()
    {
        System.out.println("Choose a drink: " + "1.Cola 2.Fanta 3.Shveps");
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        if(n > 3){
            while(n>3)
                n = in.nextInt();
        }
        switch (n)
        {
            case (1):
                drink = new Cola();
                break;
            case(2):
                drink = new Fanta();
                break;
            case(3):
                drink = new Shveps();
                break;
            default:
                System.out.println("There's no such drink");
                break;
        }
        System.out.println("Pick a fruit: " + "1.Peach 2.Pineapple 3.Mango");
        n = in.nextInt();
        if(n > 3){
            while(n>3)
                n = in.nextInt();
        }
        switch (n)
        {
            case (1):
                fruit = new Peach();
                break;
            case(2):
                fruit = new Pineapple();
                break;
            case(3):
                fruit = new Mango();
                break;
            default:
                System.out.println("There's no such fruit");
                break;
        }
        name = "Coctail"+" "+drink.getName()+"/"+fruit.getName();
    }

    public void setCocktail()
    {
        System.out.println("Choose a drink: " + "1.Cola 2.Fanta 3.Shveps");
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        switch (n)
        {
            case (1):
                drink = new Cola();
                break;
            case(2):
                drink = new Fanta();
                break;
            case(3):
                drink = new Shveps();
                break;
            default:
                System.out.println("There's no such drink");
                break;
        }
        System.out.println("Pick a fruit: " + "1.Peach 2.Pineapple 3.Mango");
        n = in.nextInt();
        switch (n)
        {
            case (1):
                fruit = new Peach();
                break;
            case(2):
                fruit = new Pineapple();
                break;
            case(3):
                fruit = new Mango();
                break;
            default:
                System.out.println("There's no such fruit");
                break;
        }
        name = "Coctail"+" "+drink.getName()+"/"+fruit.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public int calculateCalories() {
         return drink.getCalories() + fruit.getCalories();
    }
    @Override
    public void consume(){
        System.out.println("coctail" + " " + drink.getName() + "/" + fruit.getName() + " is drinked");
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Cocktail cocktail = (Cocktail) obj;
        return drink.equals(cocktail.drink) && fruit.equals(cocktail.fruit);
    }

    public Map<String,Long> searchDuplicate(List<Object> arr)
    {
        Map<String, Long> resultMap = new HashMap<>();
        for (Object element : arr) {
            Cocktail buff = (Cocktail) element;
            if (resultMap.containsKey(buff.getName()))
                resultMap.put(buff.getName(), resultMap.get(buff.getName()) + 1L);
            else
                resultMap.put(buff.getName(), 1L);
        }
        return resultMap;
    }
}
