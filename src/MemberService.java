/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public interface MemberService {
    public ItemLending checkoutItem(MemberAccount member,Item borrowBook);
    public int checkForFine(MemberAccount member,ItemLending borrowItem);
    public boolean returnItem(MemberAccount member,ItemLending returnItem);
    public ItemLending[] geMyLendingList(MemberAccount member);
}
