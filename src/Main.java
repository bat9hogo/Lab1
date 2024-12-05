import Product.Cocktail.Cocktail;
import Product.Cocktail.CocktailCaloriesCompare;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            InstantiationException, IllegalAccessException {
       try {
        Class cocktails = Class.forName("Product.Cocktail.Cocktail");
        List<Cocktail> cocktailsList = new ArrayList<>();

        Class apples = Class.forName("Product.Food.Apple");
        List<Object> applesList = new ArrayList<>();

        Class cheeses = Class.forName("Product.Food.Cheese");
        List<Object> cheesesList = new ArrayList<>();

        Method consumeApple = apples.getMethod("consume");
        Method consumeCheese = cheeses.getMethod("consume");
        Method consumeCoctail = cocktails.getMethod("consume");
        boolean b = true;
        int n;
        Scanner in = new Scanner(System.in);

        while(b){
            System.out.println("Choose: 1.Apple 2.Coctail 3.Cheese 4.End reception");
            n = in.nextInt();

            switch (n){
                case 1:
                    Object appleObject = apples.newInstance();
                    applesList.add(appleObject);
                    consumeApple.invoke(appleObject);
                    break;
                case 2:
                    Cocktail coctailObject = (Cocktail) cocktails.newInstance();
                    cocktailsList.add(coctailObject);
                    consumeCoctail.invoke(coctailObject);
                    break;
                case 3:
                    Object cheeseObject = cheeses.newInstance();
                    cheesesList.add(cheeseObject);
                    consumeCheese.invoke(cheeseObject);
                    break;
                default:
                    b = false;
                    break;
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.printf("Utilized food");
        System.out.println(" ");

        Method calculateCoctailCalories = cocktails.getMethod("calculateCalories");
        Method searchDuplicate = cocktails.getMethod("searchDuplicate", List.class);
        Method searchAppleDuplicate = apples.getMethod("searchDuplicate", List.class);
        Method calculateCheeseCalories = cheeses.getMethod("calculateCalories");
        Method calculateAppleCalories = apples.getMethod("calculateCalories");

        int buffCoctail = 0;
        int buffCheese = 0;
        int buffApple = 0;

        for(String i : args){
            if(i.equals("-calories")){
                for(Object object : cocktailsList) {
                    buffCoctail += (int) calculateCoctailCalories.invoke(object);
                }
                for(Object object: cheesesList){
                    buffCheese += (int) calculateCheeseCalories.invoke(object);
                }
                for(Object object: applesList){
                    buffApple += (int) calculateAppleCalories.invoke(object);
                }
            }
        }

        for(String i : args) {
            if(i.equals("-sort")) {
                Collections.sort(cocktailsList, new Comparator<Cocktail>() {
                    public int compare(Cocktail cocktail1, Cocktail cocktail2) {
                        return Integer.compare(cocktail2.calculateCalories(), cocktail1.calculateCalories());
                    }
                });
            }
        }

        if(!cocktailsList.isEmpty()) {
            System.out.println("Coctails:");
            for(Cocktail cocktail : cocktailsList) {
                System.out.println(cocktail.getName() + " calories: " + cocktail.calculateCalories());
            }
            System.out.println("Total coctail calories " + buffCoctail);
            System.out.println(" ");
        }
        if(!applesList.isEmpty()){
            System.out.println("Apples:");
            System.out.println(searchAppleDuplicate.invoke(applesList.get(0),applesList));
            System.out.println("Calories "+ buffApple);
            System.out.println(" ");
        }
        if(!cheesesList.isEmpty()){
            System.out.println("Cheses:");
            System.out.println("Count = "+ cheesesList.size());
            System.out.println("Calories "+ buffCheese);
            System.out.println(" ");
        }
        int buff = buffCoctail + buffCheese + buffApple;
        System.out.println("Total calories: " + buff);

       } catch(ClassNotFoundException e){
           System.out.println("The class doesn't exist");
           e.printStackTrace();
       } catch (NoSuchMethodException e){
           System.out.println("There is no method");
           e.printStackTrace();
       }
    }
}