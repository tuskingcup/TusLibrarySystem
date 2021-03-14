/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public class BookLending extends ItemLending{

    @Override
    ItemLending checkoutItem(Item borrowItem, MemberAccount lendingMember) {
        if(!lendingMember.checkoutItem(this))return null;
        return super.checkoutItem(borrowItem, lendingMember); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    int returnItem(MemberAccount lendingMember) {
        lendingMember.returnItem(this,super.getFine());
        return super.returnItem(lendingMember); //To change body of generated methods, choose Tools | Templates.
    }

}
