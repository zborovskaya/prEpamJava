package by.zborovskaya.task08.view;

import by.zborovskaya.task08.entity.*;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewCandy {
    private final List<String> columnCaramel = List.of("Name", "Energy", "Production", "Marking", "Proteins",
            "Fats", "Carbohydrates", "Date Production", "Water", "Sugar", "Fructose", "Vanillin");
    private final List<String> columnChocolate = List.of("Name", "Energy", "Production", "Marking", "Filling", "Proteins",
            "Fats", "Carbohydrates", "Date Production", "Water", "Sugar", "Fructose", "Vanillin", "Chocolate Type");
    private final PrintWriter out;
    private final Set<Candy> candySet;

    public ViewCandy(PrintWriter out, Set<Candy> candySet) {
        this.out = out;
        this.candySet = candySet;
    }

    public void htmlShowResult() {
        Set<CaramelCandy> candyCaramelSet = new HashSet<CaramelCandy>();
        Set<ChocolateCandy> candyChocolateSet = new HashSet<ChocolateCandy>();
        for (Candy candy : candySet) {
            if (candy instanceof CaramelCandy) {
                candyCaramelSet.add((CaramelCandy) candy);
            }
            if (candy instanceof ChocolateCandy) {
                candyChocolateSet.add((ChocolateCandy) candy);
            }
        }

        createCaramelTable(candyCaramelSet);
        createChocolateTable(candyChocolateSet);
    }

    private void createCaramelTable(Set<CaramelCandy> candyCaramelSet) {
        out.println("<table class=\"table\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th scope=\"col\">#</th>");
        for (String column : columnCaramel)
            out.println("<th scope=\"col\">" + column + "</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        int itr = 1;
        for (CaramelCandy candy : candyCaramelSet) {
            out.println("<tbody>");
            out.println("<th scope=\"row\">" + itr + "</th>");
            out.println("<td>" + candy.getName() + "</td>");
            out.println("<td>" + candy.getEnergy() + "</td>");
            out.println("<td>" + candy.getProduction() + "</td>");
            out.println("<td>" + candy.getMarking() + "</td>");
            out.println("<td>" + candy.getProductValue().getProteins() + "</td>");
            out.println("<td>" + candy.getProductValue().getFats() + "</td>");
            out.println("<td>" + candy.getProductValue().getCarbohydrates() + "</td>");
            out.println("<td>" + candy.getDateProduction() + "</td>");
            out.println("<td>" + candy.getIngredients().getWater() + "</td>");
            out.println("<td>" + candy.getIngredients().getSugar() + "</td>");
            out.println("<td>" + candy.getIngredients().getFructose() + "</td>");
            out.println("<td>" + candy.getIngredients().getVanillin() + "</td>");
            out.println("</tbody>");
            itr++;
        }
        out.println("</table>");
    }
    private void createChocolateTable(Set< ChocolateCandy> candyChocolateSet){
        out.println("<table class=\"table\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th scope=\"col\">#</th>");
        for (String column : columnChocolate)
            out.println("<th scope=\"col\">" + column + "</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        int itr = 1;
        for (ChocolateCandy candy : candyChocolateSet) {
            Ingredients ingredients= candy.getIngredients();
            IngredientsChocolate ingredientsChocolate=(IngredientsChocolate) ingredients;
            out.println("<tbody>");
            out.println("<th scope=\"row\">" + itr + "</th>");
            out.println("<td>" + candy.getName() + "</td>");
            out.println("<td>" + candy.getEnergy() + "</td>");
            out.println("<td>" + candy.getProduction() + "</td>");
            out.println("<td>" + candy.getMarking() + "</td>");
            out.println("<td>" + candy.getFilling() + "</td>");
            out.println("<td>" + candy.getProductValue().getProteins() + "</td>");
            out.println("<td>" + candy.getProductValue().getFats() + "</td>");
            out.println("<td>" + candy.getProductValue().getCarbohydrates() + "</td>");
            out.println("<td>" + candy.getDateProduction() + "</td>");
            out.println("<td>" + ingredientsChocolate.getWater() + "</td>");
            out.println("<td>" + ingredientsChocolate.getSugar() + "</td>");
            out.println("<td>" + ingredientsChocolate.getFructose() + "</td>");
            out.println("<td>" +ingredientsChocolate.getVanillin() + "</td>");
            out.println("<td>" + ingredientsChocolate.getChocolateType()+ "</td>");
            out.println("</tbody>");
            itr++;
        }
        out.println("</table>");
    }
}
