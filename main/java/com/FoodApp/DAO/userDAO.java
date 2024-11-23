import java.util.List;

import com.FoodApp.Model.user;

public interface userDAO {
    int insertUser(user user);
    List<user> getAllUsers();
    user getUserById(int id);
    int deleteUserById(int id);
    int updateUserById(int id, String address);
    user getUserByEmail(String email); // This method is already included
}
