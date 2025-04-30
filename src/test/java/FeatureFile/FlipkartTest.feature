 Feature: Testing cart section of flipkart website

   Scenario: Testing the cart quantity after deletion and re-adding same quantity products
     Given User launch chromebrowser
     When User opens URL of flipkart website
     And User go to particular product section
     And User add products to cart
     Then Verify the qunatity of products in cart
     When User delete the products
     And User add the products to the cart
     Then verify the current products quantity with original product quantity before deleting
     And User quit the browser

   @High
   Scenario: Testing the cart quantity after deletion and re-adding same quantity products using common xpath
     Given User launch chromebrowser
     When User opens URL of flipkart website
     And User go to particular product section
     And User add products to cart using common xpath of products
     Then Verify the qunatity of products in cart
     When User delete the products
     And User add products as per count considering the previous added cart quantity
     Then verify the current products quantity with original product quantity before deleting
     And User quit the browser