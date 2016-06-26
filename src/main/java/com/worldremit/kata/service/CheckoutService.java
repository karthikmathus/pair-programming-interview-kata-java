package com.worldremit.kata.service;

import com.worldremit.kata.domain.DiscountRule;
import com.worldremit.kata.domain.Item;

import java.util.List;

/**
 * Created by kannanka on 26/06/2016.
 */
public interface CheckoutService {

    void addRules(List<DiscountRule> discountRules);

    void addItem(Item item);

    double total();
}
