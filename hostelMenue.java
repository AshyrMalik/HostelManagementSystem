public class hostelMenue {
    private String[] days = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };;
    private String[][] menu;

    public hostelMenue() {
         
        menu = new String[][] {
            { "Breakfast: Eggs and paratha ", "Lunch: Daal", "Dinner: Biryani" },
            { "Breakfast: Cereal", "Lunch: Chicken ", "Dinner: Nihari" },
            { "Breakfast: Pancakes", "Lunch: Sandwich", "Dinner: Haleem" },
            { "Breakfast: Lassi and paratha", "Lunch: Beef ", "Dinner: Rice" },
            { "Breakfast: Yogurt", "Lunch: Vegetable ", "Dinner: Karahi" },
            { "Breakfast: French Toast", "Lunch: Samosa", "Dinner: Pasta" },
            { "Breakfast: Aalu bhujiya", "Lunch: Salad", "Dinner: Rice" }
        };
    }

    public void displayMenu() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + " Menu:");
            for (int j = 0; j < menu[i].length; j++) {
                System.out.println("- " + menu[i][j]);
            }
            System.out.println();
        }
    }
   

   

    public void setMenu(String[][] menu) {
        this.menu = menu;
    }
}

