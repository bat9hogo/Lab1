package Product.Cocktail;

import java.util.Comparator;

public class CocktailCaloriesCompare implements Comparator<Cocktail> {
 @Override
    public int compare(Cocktail cocktail1, Cocktail cocktail2) {
     //return -1*(cocktail1.calculateCalories() - cocktail2.calculateCalories());
     return Integer.compare(cocktail2.calculateCalories(), cocktail1.calculateCalories());
 }
}
