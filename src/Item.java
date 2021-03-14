
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CLinicIT
 */
public abstract class Item {

    private String barcode;
    private String title;
    private ItemStatus ItemStatus;

    public Item(String barcode, String title) {
        this.barcode = barcode;
        this.title = title;
    }
    
    public Item(Item i) {
        this(i.barcode, i.title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.barcode, other.barcode)) {
            return false;
        }
        return true;
    }

    public void setItemStatus(ItemStatus ItemStatus) {
        this.ItemStatus = ItemStatus;
    }
    
    
}
