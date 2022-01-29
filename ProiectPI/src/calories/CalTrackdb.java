package calories; /**
 * The calories.CalTrackdb class is used to record food records and read food records from
 * the MySQL database 
 *
 */
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;


public class CalTrackdb {
	

	public static void printTable(String[][] args) {
		String[][] data = args;
		String leftAlignFormat = "| %-32s | %-10s | %-10s |%n";

		System.out.format("+----------------------------------+------------+------------+%n");
		System.out.format("| Mancare                           | Calorii   |  Data      |%n");
		System.out.format("+----------------------------------+------------+------------+%n");

		for (int i = 0; i < data.length; i++) {
			System.out.format(leftAlignFormat, data[i][0], data[i][1], data[i][2]);
		}
		System.out.format("+----------------------------------+------------+------------+%n");
	}
	

    protected static void setFood(Food food) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/caltracker",
                "root", "parola123")) {
            try (Statement stmt = conn.createStatement()) {

                // insert data
                stmt.executeUpdate(String.format("INSERT INTO food (foodName, calories, date_created)" +
                        " VALUES ('%s', %d, '%s')", food.getFoodName(), food.calIn, food.getDate()));

                conn.close();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    protected static void getAllFood() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/caltracker",
                "root", "parola123")) {
            try (Statement stmt = conn.createStatement()) {

                // Get data
				ArrayList<String> list= new ArrayList<String>();
				ArrayList<String> list2= new ArrayList<String>();
				ArrayList<String> list3= new ArrayList<String>();
				ArrayList<String> list4= new ArrayList<String>();
				
                ResultSet rset = stmt.executeQuery("SELECT * FROM food ORDER BY date_created DESC");
				


				System.out.format("+------------------------------------------------------------+%n");
                System.out.format("|                       TOATE MANCARURILE INREGISTRATE                   |%n");
				System.out.format("+------------------------------------------------------------+%n");
                int rowCount = 0;
                while (rset.next()) {
                    list.add(rset.getString("foodName"));   
					
					list2.add(String.valueOf((rset.getInt("calories"))));
					
					
					int food_id = rset.getInt("food_id");
                    String foodName = rset.getString("foodName");
                    int calories = rset.getInt("calories");
                    Date date_created = rset.getDate("date_created");
					String date_created2 = new SimpleDateFormat("dd-MM-yyyy").format(date_created);
					list3.add(date_created2);
					
                   // System.out.println(date_created + ", " + foodName + ", " + calories);
                    ++rowCount;
                }
				
				
				
				
				ArrayList<ArrayList<String>> rearrangedList = new ArrayList<ArrayList<String>>();
		
				for (int i = 0; i < list.size(); i++) {
					
					rearrangedList.add(new ArrayList<String>());

					rearrangedList.get(i).add(0,list.get(i)); 
					rearrangedList.get(i).add(1,list2.get(i)); 
					rearrangedList.get(i).add(2,list3.get(i)); 
				}
				
				//System.out.println(rearrangedList);
				
				
				String[] columnNames = {"Food",
                        "Calories",
                        "Date"
						};
				
				String[][] array = new String[rearrangedList.size()][];
				for (int i = 0; i < rearrangedList.size(); i++) {
					ArrayList<String> row = rearrangedList.get(i);
					array[i] = row.toArray(new String[row.size()]);
				}
				
				printTable(array);
				
				ResultSet cset = stmt.executeQuery("SHOW COLUMNS FROM food");
				while (cset.next()) {
					list4.add(cset.getString("Field"));
				}
                System.out.println("Numar total inregistrari = " + rowCount);

				
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    protected static void getFoodByDate(String date) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/caltracker",
                "root", "parola123")) {
            try (Statement stmt = conn.createStatement()) {
				
				
				ArrayList<String> rlist= new ArrayList<String>();
				ArrayList<String> rlist2= new ArrayList<String>();
				ArrayList<String> rlist3= new ArrayList<String>();

                // Get data
                ResultSet rset = stmt.executeQuery(String.format("SELECT * FROM food " +
                                "WHERE date_created = '%s'", date));


                /* Process ResultSet by moving the cursor forward via next().
                 *  For each row, get contents with getXxx(columnName).
                 */
				System.out.format("+------------------------------------------------------------+%n");
                System.out.format("|                 INREGISTRARI MANCARE PT " + date + "                 |%n");
				System.out.format("+------------------------------------------------------------+%n");
                int rowCount = 0;
                int totalCalories = 0;
                while (rset.next()) {   // Move cursor to next row, return false if no more row
                    
					rlist.add(rset.getString("foodName"));
					
					rlist2.add(String.valueOf((rset.getInt("calories"))));

					int food_id = rset.getInt("food_id");
                    String foodName = rset.getString("foodName");
                    int calories = rset.getInt("calories");
                    totalCalories += calories;
                    Date date_created = rset.getDate("date_created");
					
					String date_created2 = new SimpleDateFormat("dd-MM-yyyy").format(date_created);
					rlist3.add(date_created2);
                    //System.out.println(date_created + ", " + foodName + ", " + calories);
                    ++rowCount;
                }
				
				ArrayList<ArrayList<String>> recordsList = new ArrayList<ArrayList<String>>();
		
				for (int i = 0; i < rlist.size(); i++) {
					
					recordsList.add(new ArrayList<String>());

					recordsList.get(i).add(0,rlist.get(i)); 
					recordsList.get(i).add(1,rlist2.get(i)); 
					recordsList.get(i).add(2,rlist3.get(i)); 
				}
				
				String[][] array = new String[recordsList.size()][];
				for (int i = 0; i < recordsList.size(); i++) {
					ArrayList<String> row = recordsList.get(i);
					array[i] = row.toArray(new String[row.size()]);
				}
				
				printTable(array);

				
				
                System.out.printf("\nCaloriile totale pt data %s sunt: %d%n", date, totalCalories);
                System.out.println("Numar total mancaruri = " + rowCount);

                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    protected static void deleteFoodByDate(Food food){

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/caltracker",
                "root", "parola123")) {
            try (Statement stmt = conn.createStatement()) {

                // erase data
                stmt.executeUpdate(String.format("DELETE FROM food " +
                                "WHERE date_created = '%s' AND foodName = '%s' LIMIT 1",
                                food.getDate(), food.getFoodName()));

                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected static void modifyFoodCal(Food food){
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/caltracker",
                "root", "parola123")) {
            try (Statement stmt = conn.createStatement()) {

                // change date
                stmt.executeUpdate(String.format("UPDATE food SET calories = %d" +
                                "  WHERE date_created = '%s' AND foodName = '%s'",
                                food.getCalIn(), food.getDate(), food.getFoodName()));

                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
