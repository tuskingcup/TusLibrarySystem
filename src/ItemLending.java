
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Objects;

public abstract class ItemLending {

    private LocalDate borrowDate;
    private LocalDate durDate;
    private LocalDate returnDate;
    private Item lendingItem;
    private Account lendingMember;
    private int fine;

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
        final ItemLending other = (ItemLending) obj;
        if (!Objects.equals(this.lendingItem, other.lendingItem)) {
            return false;
        }
        return true;
    }

    int getFine() {
        if(LocalDate.now().isAfter(durDate))
        return (int)(ChronoUnit.DAYS.between(LocalDate.now(), durDate)*50);
        return 0;
    }

    ItemLending checkoutItem(Item borrowItem, MemberAccount lendingMember) {
        borrowDate = LocalDate.now();
        durDate = borrowDate.plusDays(10);
        this.lendingItem = borrowItem;
        this.lendingMember = lendingMember;
        borrowItem.setItemStatus(ItemStatus.BORROWED);
        return this;
    }
    
    int returnItem(MemberAccount lendingMember){
        returnDate = LocalDate.now();
        fine = getFine();
        lendingItem.setItemStatus(ItemStatus.AVAILABLE);
        return fine;
    }

}
