package demo.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order orderObj;
    public OrderTest(){
        orderObj =new Order();
    }

    @Test
    void TestSetQuantity() {
        //given
        int quantity = 32;
        Order returnObject;

        //when
        returnObject = orderObj.setQuantity(quantity);

        //then
        assertEquals(returnObject, orderObj);
    }

    @Test
    void TestGetQuantity() {

        //given
        int actualQuantity = 12;

        //when
        orderObj.setQuantity(actualQuantity);
        int getQuantity = orderObj.getQuantity();

        //then
        assertEquals(getQuantity, actualQuantity);

    }

    @Test
    void TestGetItemName() {
        //given
        String actualItemName = "Smartwatch";

        //when
        orderObj.setItemName(actualItemName);
        String returnedItemName = orderObj.getItemName();
        //then
        assertEquals(returnedItemName, actualItemName);
    }

    @Test
    void TestSetItemName() {
        //given
        String itemName = "Laptop";

        //when
        Order returnedOrderObj = orderObj.setItemName(itemName);

        //then
        assertEquals(returnedOrderObj, orderObj);
    }

    @Test
    void TestGetPrice() {

        //given
        double actualPrice = 499;

        //when
        orderObj.setPrice(actualPrice);
        double returnedPrice = orderObj.getPrice();

        //then
        assertEquals(returnedPrice, actualPrice);
    }

    @Test
    void TestSetPrice() {

        //given
        double price = 999;

        //when
        Order returnedSetPriceObj = orderObj.setPrice(price);

        //then
        assertEquals(returnedSetPriceObj, orderObj);
    }

    @Test
    void TestGetPriceWithTex() {

        //given
        double actualTexPrice = 590;

        //when
        orderObj.setPriceWithTex(actualTexPrice);
        double returnedTexPrice = orderObj.getPriceWithTex();

        //then
        assertEquals(returnedTexPrice, actualTexPrice);

    }

    @Test
    void TestSetPriceWithTex() {
        //given
        double texPrice = 590;

        //when
        Order texPriceObj = orderObj.setPriceWithTex(texPrice);

        //then
        assertEquals(texPriceObj, orderObj);
    }
}