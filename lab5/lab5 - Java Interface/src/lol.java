import java.sql.*;
import java.util.*;

public class lol {

    public static void query1() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, avgKDA FROM Players WHERE avgKDA > 4");
            while (rs.next()){
                String name = rs.getString("name");
                String kda = rs.getString("avgKDA");
                System.out.println(name +"|KDA: "+ kda);
            }
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void query2() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT position, MAX(avgCSM) AS maxCSM FROM Players");
            while (rs.next()){
                String position = rs.getString("position");
                String maxCSM = rs.getString("maxCSM");
                System.out.println(position + "|Highest CSM: " + maxCSM);
            }
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query3() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(name) AS count FROM Players WHERE position = 'Jungle' AND kp > 50");
            while (rs.next()){
                String count = rs.getString("count");
                System.out.println("Junglers with kp > 50: " + count);
            }
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query4() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, MAX(pickrate) as maxPR FROM Champions");
            while (rs.next()){
                String name = rs.getString("name");
                String maxPR = rs.getString("maxPR");
                System.out.println(name +"|Highest Pick Rate: "+ maxPR);
            }
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query5() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, MAX(banrate) as maxBR FROM Champions");
            while (rs.next()){
                String name = rs.getString("name");
                String maxBR = rs.getString("maxBR");
                System.out.println(name +"|Highest Ban Rate: "+ maxBR);
            }
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query6() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, avgDPG FROM Teams WHERE avgDPG > 2");
            while (rs.next()){
                String name = rs.getString("name");
                String avgDPG = rs.getString("avgDPG");
                System.out.println(name +"|Average Dragons per Game: "+ avgDPG);
            }
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query7() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT region, MIN(avgGD) AS minGD FROM Teams");
            while (rs.next()){
                String region = rs.getString("region");
                String minGD = rs.getString("minGD");
                System.out.println(region +"|Game Length: "+ minGD);
            }
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query8() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            String sql = "UPDATE Teams SET name ='SKT T1' WHERE name='T1'";
            stmt.execute(sql);
            System.out.println("T1 has been updated to SKT T1");
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query9() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT splitname, MAX(prizepool) AS maxPP FROM Tournaments");
            while (rs.next()){
                String splitname = rs.getString("splitname");
                String maxPP = rs.getString("maxPP");
                System.out.println(splitname +"|Highest Prize Pool: $"+ maxPP + " USD");
            }

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public static void query10() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lol.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(splitname) AS KRTourneys FROM Tournaments WHERE region = 'KR'");
            while (rs.next()){
                String KRTourneys = rs.getString("KRTourneys");
                System.out.println(KRTourneys + " tournament(s) was(were) held in the KR region");
            }

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to the LoL database!");
        
        do{
            System.out.println("Please select from one of the following options,");
            System.out.println("by entering a number from 0-10 (0 to exit application): ");
            System.out.println("1. Find all players with KDAs greater than 4.");
            System.out.println("2. Find the position that has the highest CS per minute(CSM).");
            System.out.println("3. Count how many junglers have KPs over 50%.");
            System.out.println("4. Find the champion with the highest pick rate.");
            System.out.println("5. Find the champion with the highest ban rate.");
            System.out.println("6. Find all teams with over 2 average dragons per game(avgDPG).");
            System.out.println("7. Find the region with the shortest game duration.");
            System.out.println("8. Change the name of T1 to SKT T1.");
            System.out.println("9. Find the tournament with the highest prize pool.");
            System.out.println("10. Count how many tournaments were held in the KR region.");
            System.out.print("Query Number: ");
            
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Thank you for using my LoL database!");
                running = false;
            } else if (choice == 1) {
                query1();
            } else if (choice == 2) {
                query2();
            } else if (choice == 3) {
                query3();
            } else if (choice == 4) {
                query4();
            } else if (choice == 5) {
                query5();
            } else if (choice == 6) {
                query6();
            } else if (choice == 7) {
                query7();
            } else if (choice == 8) {
                query8();
            } else if (choice == 9) {
                query9();
            } else if (choice == 10) {
                query10();
            } else {
                System.out.println("That is not a valid choice!");
            }
        } while(running != false);
    }
}

