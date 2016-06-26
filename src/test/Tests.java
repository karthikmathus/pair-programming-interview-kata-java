import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


import com.worldremit.kata.domain.DiscountRule;
import com.worldremit.kata.domain.Item;
import com.worldremit.kata.service.CheckoutService;
import com.worldremit.kata.service.CheckoutServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tests {

    private Item A = new Item("A",50);
    private Item B = new Item("B",30);
    private Item C = new Item("C",20);
    private Item D = new Item("D",15);
    private Item K = new Item("K",0);

    private CheckoutService c = new CheckoutServiceImpl();


    private List<DiscountRule> getDiscountRules(){
        List<DiscountRule> discountrules = Arrays.asList(
                new DiscountRule(A.getName(),130,3),
                new DiscountRule(B.getName(),45,2));
        return discountrules;

    }


    /**
     * Given: Single A is priced 50
     *         and Three A is priced 130
     * When: customer buy three quantity of A commodity
     * Then: Total should be 130
     */
    @Test
    public  void verifyTotalCostWithExactDiscount(){
        c.addRules(getDiscountRules());
        c.addItem(A);c.addItem(A);
        c.addItem(A);
        assertTrue("verifyTotalCostWithExactDiscount test failed ",c.total()== 130);
    }


    /**
     * Given: Single A is priced 50
     *         and three A is priced 130
     * When: customer buy six of the A commodity
     * Then: Total should be 260
     */
    @Test
    public  void verifyTotalCostWithDoubleTheDiscount(){
        c.addRules(getDiscountRules());
        c.addItem(A);c.addItem(A);
        c.addItem(A);c.addItem(A);
        c.addItem(A);c.addItem(A);
        assertTrue("verifyTotalCostWithDoubleTheDiscount test failed",c.total() == 260);
    }

    /**
     * Given: Single A is priced 50
     *         and three A is priced 130
     * When: customer buy four of the A commodity
     * Then: Total should be 180
     */
    @Test
    public  void verifyTotalCostWithDoubleDiscountAndSingleItem(){
        c.addRules(getDiscountRules());
        c.addItem(A);
        c.addItem(A);
        c.addItem(A);
        c.addItem(A);
        assertTrue("verifyTotalCostWithDoubleDiscountAndSingleItem test failed",c.total()==180);
    }

    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     * When: customer buy four of the A commodity and two of B
     * Then: Total should be 225
     */
    @Test
    public  void verifyTotalCostWithTwoItemsHaveDiscountRule(){
        c.addRules(getDiscountRules());
        c.addItem(A);c.addItem(A);
        c.addItem(A);c.addItem(A);
        c.addItem(B);
        c.addItem(B);
        assertTrue("verifyTotalCostWithTwoItemsHaveDiscountRule test failed",c.total() == 225);
    }


    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     *         and single C is priced 20
     * When: customer buy one of the A commodity and one of B and two of C
     * Then: Total should be 120
     */
    @Test
    public  void verifyTotalWhenDiscountRuleIsNotApplicable(){
        c.addRules(getDiscountRules());
        c.addItem(A);
        c.addItem(B);
        c.addItem(C);
        c.addItem(C);
        assertTrue("verifyTotalWhenDiscountRuleIsNotApplicable test failed",c.total() == 120);
    }
    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     *         and single C is priced 20
     * When: customer buy one C
     * Then: Total should be 20
     */
    @Test
    public  void verifyTotalWhenSingleItemWithNoDiscount(){
        c.addRules(getDiscountRules());
        c.addItem(C);
        assertTrue("verifyTotalWhenSingleItemWithNoDiscount test failed",c.total()==20);
    }

    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     *         and single C is priced 20
     * When: customer buy ten B
     * Then: Total should be 225
     */
    @Test
    public  void verifyTotalWhenDiscountIsAppliedMultipleTimes(){
        c.addRules(getDiscountRules());
        c.addItem(B);c.addItem(B);
        c.addItem(B);c.addItem(B);
        c.addItem(B);c.addItem(B);
        c.addItem(B);c.addItem(B);
        c.addItem(B);c.addItem(B);
        assertTrue("verifyTotalWhenDiscountIsAppliedMultipleTimes test failed",c.total()== 225);
    }

    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     *         and single C is priced 20
     * When: customer buy 9 B
     * Then: Total should be 210
     */
    @Test
    public  void verifyTotalWhenDiscountMultipleAndASingleItem(){
        c.addRules(getDiscountRules());
        c.addItem(B);c.addItem(B);
        c.addItem(B);c.addItem(B);
        c.addItem(B);c.addItem(B);
        c.addItem(B);c.addItem(B);
        c.addItem(B);
        assertTrue("verifyTotalWhenDiscountMultipleAndASingleItem test failed",c.total()== 210);
    }

    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     *         and single C is priced 20
     * When: customer buy a product that is not priced K
     * Then: the item should not be added. Total should be 0
     */
    @Test
    public  void verifyTotalWhenUnvaluedItemAdded(){
        c.addRules(getDiscountRules());
        c.addItem(K);
        assertTrue("verifyTotalWhenUnvaluedItemAdded test failed",c.total()==0);
    }

    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     *         and single C is priced 20
     * When: customer buy items in following order A B C C A A B
     * Then: Total should be 215
     */
    @Test
    public  void verifyTotalWhenDiscountedItemsAreBoughtInRandomOrder(){
        c.addRules(getDiscountRules());
        c.addItem(A);c.addItem(B);
        c.addItem(C);c.addItem(C);
        c.addItem(A);c.addItem(A);
        c.addItem(B);
        assertTrue("verifyTotalWhenDiscountedItemsAreBoughtInRandomOrder test failed",c.total()==215);
    }

    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and three A is priced 130
     *         and Two B is priced 45
     *         and single C is priced 20
     * When: customer Doesnt buy anything
     * Then: Total should be 0 and service should not fail
     */
    @Test
    public  void verifyTotalWhenCustomerDontBuyAnyItem(){
        c.addRules(getDiscountRules());
        assertTrue("verifyTotalWhenCustomerDontBuyAnyItem test failed",c.total()==0);
    }

    /**
     * Given: Single B is priced 30
     *         and single A is priced 50
     *         and single C is priced 20
     * When: customer buy A B C in any order
     * Then: Total should be appropriate and service should not fail
     */
    @Test
    public  void verifyTotalWhenNoDiscountRule(){
        c.addItem(B);
        c.addItem(C);
        c.addItem(A);
        assertTrue("verifyTotalWhenNoDiscountRule test failed",c.total()==100);
    }



}

