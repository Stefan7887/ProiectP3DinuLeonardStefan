package calories;


class Food {

    String foodName;
    int calIn = 0;
    String date;


    public Food() {
        this.calIn = 0;
        this.foodName = "null";
        this.date = "null";
    }


    public Food(String date, String foodName, int calIn) {
        this.foodName = foodName;
        this.calIn = calIn;
        this.date = date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getDate() {
        return this.date;
    }


    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return this.foodName;
    }


    public void setCalIn(int calIn) {
        this.calIn = calIn;
    }


    public int getCalIn() {
        return this.calIn;
    }


    public String toString() {
        return ("calories.Food: " + this.foodName + "\nCalories: " + this.calIn);
    }
}