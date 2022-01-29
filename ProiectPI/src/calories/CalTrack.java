package calories;


import java.util.*;



public class CalTrack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int repeat;

        do {

            System.out.println("Introduceti data pe care vreti sa o adaugati, vedeti sau editati (ex: 2000-02-25)");
            String date = input.nextLine();
            input.reset();


            System.out.println("\n Doriti sa creati, editati sau vedeti un fisier? \n" +
                    "(1 - nou, 2 - editare , 3 - vizualizare ): ");
            switch (input.nextInt()) {


                case 1:
                    do {
                        input.nextLine();

                        Food newFood = new Food();
                        newFood.setDate(date);

                        System.out.println("Introduceti numele mancarii: ");
                        newFood.setFoodName(input.nextLine());

                        System.out.println("Introduceti caloriile");
                        newFood.setCalIn(input.nextInt());

                        CalTrackdb.setFood(newFood);

                        System.out.println("Continuati? (1- Da, 2- Nu)");
                        repeat = input.nextInt();

                    } while (repeat == 1);

                    CalTrackdb.getFoodByDate(date);
                    break;


                case 2:
                    CalTrackdb.getFoodByDate(date);
                    int delete;

                    do {
                        input.nextLine();
                        Food newFood = new Food();
                        newFood.setDate(date);

                        System.out.println("\n\nIntroduceti numele mancarii pe care vreti sa o editati: ");
                        newFood.setFoodName(input.nextLine());

                        System.out.println("Doriti sa stergeti sau editati valoarea calorica? (1- Stergere, 2 - Editare): ");
                        delete = input.nextInt();
                        if (delete == 1) {
                            CalTrackdb.deleteFoodByDate(newFood);
                            CalTrackdb.getFoodByDate(date);
                        }
                        else if (delete == 2) {
                            System.out.println("Introduceti noua valoarea calorica pentru " + newFood.getFoodName() + ": ");
                            newFood.setCalIn(input.nextInt());
                            CalTrackdb.modifyFoodCal(newFood);
                            CalTrackdb.getFoodByDate(date);
                        }
                        System.out.println("\nContinuati? (1- Da, 2- Nu)");
                        repeat = input.nextInt();
                        input.reset();

                    } while (repeat == 1);
                    break;


                case 3:
                    CalTrackdb.getFoodByDate(date);
                    break;
                default: {
                    System.out.print("\n------------------\n Input gresit \n------------------\n");
                }
            }
            System.out.println("\nContinuati? (1 - Da, 2 - Nu): ");
            repeat = input.nextInt();
            System.out.println();
            input.nextLine();

        } while (repeat == 1);
    }
}
