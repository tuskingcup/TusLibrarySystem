
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CLinicIT
 */
public class Library implements Policy, MemberService, LibrarianService {

    private String libaryName;
    private MemberAccount members[];
    private int memberCount;
    private LibraianAccount libraian;
    private Item item[];
    private ItemLending librayLendingItems[];

    public Library(String libaryName, LibraianAccount libraian, int maxItem, int maxMember, int maxLendingItem) {
        this.libaryName = libaryName;
        this.libraian = libraian;
        item = new Item[maxItem];
        members = new MemberAccount[maxMember];
        librayLendingItems = new ItemLending[maxLendingItem];
    }

    public Iterator<Item> iterator() {
        ArrayList<Item> list = new ArrayList<>();
        return list.iterator();
    }

    @Override
    public ItemLending checkoutItem(MemberAccount member, Item borrowBook) {
        if (!isAMember(member)) {
            return null;
        }
        if (member.lendingIsFull()) {
            return null;
        }
        ItemLending itemLending = new BookLending();
        itemLending.checkoutItem(borrowBook, member);
        return itemLending;
    }

    @Override
    public int checkForFine(MemberAccount member, ItemLending borrowItem) {
        if (!isAMember(member)) {
            return -1;
        }
        if (member.lendingIsFull()) {
            return -1;
        }
        return member.checkForFine(borrowItem);
    }

    @Override
    public boolean returnItem(MemberAccount member, ItemLending returnItem) {
        if (!isAMember(member)) {
            return false;
        }
        if (member.lendingIsFull()) {
            return false;
        }
        returnItem.returnItem(member);
        return true;
    }

    @Override
    public ItemLending[] geMyLendingList(MemberAccount member) {
        if (!isAMember(member)) {
            return null;
        }
        if (member.lendingIsFull()) {
            return null;
        }
        return member.getMyLendingList();
    }

    @Override
    public boolean addItem(LibraianAccount librarian, Item item) {
        if (!this.libraian.equals(librarian)) {
            return false;
        }
        int i = 0;
        while (!(this.item[i] == null && i < this.item.length)) {
            i++;
        }
        try {
            this.item[i] = item;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addMember(LibraianAccount librarian, Account member) {
        if (!this.libraian.equals(librarian)) {
            return false;
        }
        int i = 0;
        while (!(members[i] == null && i < members.length)) {
            i++;
        }
        try {
            members[i] = (MemberAccount) member;
        } catch (ArrayIndexOutOfBoundsException e) {
            
            return false;
        }
        return true;

    }

    public boolean isAMember(MemberAccount member) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].equals(member)) {
                return true;
            }
        }
        return false;
    }

}
