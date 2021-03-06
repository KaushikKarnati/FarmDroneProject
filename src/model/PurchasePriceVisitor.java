package model;
import java.util.Iterator;

public class PurchasePriceVisitor implements Visitor{

    private int totalPrice;
    public PurchasePriceVisitor(){
        totalPrice = 0;
    }
    @Override
    public int visit(ItemContainer itemContainer){
        totalPrice = itemContainer.getPrice();
        Iterator<Component> iterator = itemContainer.getItemComponents().iterator();
        while(iterator.hasNext()){
            Component currentComponent = iterator.next();
            totalPrice += currentComponent.accept(new PurchasePriceVisitor());
        }
        return totalPrice;
    }
    @Override
    public int visit(Item item){
        totalPrice = item.getPrice();
        return totalPrice;
    }





}

