package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> registrationModels(){
        List<Object[]> list = new ArrayList<>();
        int z = (int) (System.currentTimeMillis() / 1000 % 3600);

        list.add(new Object[]{new User().setFirstName("Norman" + z).setLastName("Fisher").setEmail("norman" + z + "@gmail.com").setPassword("East1234$")});
        list.add(new Object[]{new User().setFirstName("Jane" + z).setLastName("Fisher").setEmail("jane" + z + "@gmail.com").setPassword("East9234$")});
        list.add(new Object[]{new User().setFirstName("Sam" + z).setLastName("Fisher").setEmail("sam" + z + "@gmail.com").setPassword("East3234$")});
        list.add(new Object[]{new User().setFirstName("Jill" + z).setLastName("Fisher").setEmail("jill" + z + "@gmail.com").setPassword("East3234$")});
        list.add(new Object[]{new User().setFirstName("Norma" + z).setLastName("Fisher").setEmail("norma" + z + "@gmail.com").setPassword("East3234$")});
        list.add(new Object[]{new User().setFirstName("Kate" + z).setLastName("Fisher").setEmail("kate" + z + "@gmail.com").setPassword("East3234$")});
        list.add(new Object[]{new User().setFirstName("Peter" + z).setLastName("Fisher").setEmail("peter" + z + "@gmail.com").setPassword("East3234$")});

        return list.iterator();
    }

}
