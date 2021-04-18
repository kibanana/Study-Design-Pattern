package factory_method.java;

abstract public class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner); // 템플릿 메소드 호출
        registerProduct(p);
        return p;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product p);
}
