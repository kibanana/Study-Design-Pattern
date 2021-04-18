package factory_method.java;

import java.util.ArrayList;
import java.util.List;

public class PointCardFactory extends Factory {
    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new PointCard(owner);
    }

    @Override
    protected void registerProduct(Product p) {
        owners.add(((PointCard) p).getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }
}
