/**
 * 
 */
package org.vik.rest;

/**
 * @author vmodugu
 *
 */

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

   Connection conn = null;
   Statement st = null;
   public UserDao()
   {
   /*   try
      {
         Class.forName ("org.h2.Driver");
         conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
         st = conn.createStatement();
      String sql =  "CREATE TABLE  User " +
              "(id INTEGER not NULL, " +
              " name VARCHAR(255), " +
              " profession VARCHAR(255), " +
              " PRIMARY KEY ( id ))";
      st.executeUpdate(sql);      }catch(Exception ex)
   {
      ex.printStackTrace();
   }*/
   }


   public List<User> getAllUsers(){
      List<User> userList = null;

      try {
//         st.execute("")
         File file = new File("Users.dat");
         if (!file.exists()) {
            User user = new User(1, "Mahesh", "Teacher");
            userList = new ArrayList<User>();
            userList.add(user);

            User user1 = new User(2, "Pranay", "Staffing");

            userList.add(user1);
            saveUserList(userList);		
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (List<User>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }		
      return userList;
   }

   public void saveUserList(List<User> userList){
      try {
         File file = new File("Users.dat");
         FileOutputStream fos;

         fos = new FileOutputStream(file);

         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(userList);
         oos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }   
}