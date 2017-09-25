package LocalDB;

import io.realm.RealmObject;

/**
 * Created by TAE Consultant on 23/09/2017.
 */

public class CustomerModel extends RealmObject {
    public CustomerModel(String name, String age) {

        this.name = name;
        this.age =age;
    }

    public CustomerModel() {
    }


    String name;
    String age;
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){

        this.age=age;
    }
    public void setName(String name){
        this.name=name;

    }
}
