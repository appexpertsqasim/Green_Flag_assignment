package LocalDB.RealmController;

import java.util.ArrayList;

import LocalDB.CustomerModel;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by TAE Consultant on 23/09/2017.
 */

public class RealmController {
    Realm realm;

    public RealmController(Realm realm) {
        this.realm = realm;
    }

    public void saveCustomer(final CustomerModel customer) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(customer);
            }
        });
    }
    public ArrayList<CustomerModel> getCustomerList(){
        ArrayList<CustomerModel>customerModelArraylist=new ArrayList<>();
        RealmResults<CustomerModel> realmResults=realm.where(CustomerModel.class).findAll();
        for (CustomerModel customerModel : realmResults){
            customerModelArraylist.add(customerModel);
        }
        return customerModelArraylist;
    }
}
