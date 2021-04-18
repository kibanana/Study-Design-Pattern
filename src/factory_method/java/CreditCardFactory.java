package factory_method.java;

import java.util.ArrayList;
import java.util.List;

public class CreditCardFactory extends Factory {
    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new CreditCard(owner);
    }

    @Override
    protected void registerProduct(Product p) {
        owners.add(((CreditCard) p).getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }
}
