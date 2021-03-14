/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public class MemberAccount extends Account{
    private ItemLending[] myLendingItem;
    private int totalItemsCheckedout;
    private int overdueCount;

    public MemberAccount(String id, String password, Person person) {
        super(id, password, person);
    }

    boolean checkoutItem(ItemLending borrowItem){
        if(totalItemsCheckedout>=Policy.MAX_LENDING_BOOKS)return false;
        myLendingItem[totalItemsCheckedout]=borrowItem;
    return true;
    
    }
    ItemLending[] getMyLendingList(){
        return myLendingItem;
    }
    
    void returnItem(ItemLending lendingItem,int fine){
        for(int i = 0;i<totalItemsCheckedout;i++){
        if(lendingItem.equals(myLendingItem[i]))
            if(fine>0){
                overdueCount++;
                System.out.println(fine);
            }
            myLendingItem[i]=myLendingItem[myLendingItem.length];
            totalItemsCheckedout--;
            break;
        }
    }
    
    int checkForFine(ItemLending borrowItem){
    return borrowItem.getFine();
    }

    boolean lendingIsFull() {
        if(totalItemsCheckedout>=myLendingItem.length)return false;
        return true;
    }
}
