# Garanti Virtual Pos  Integration

### Gradle

```gradle
repositories {
    maven{
        url = uri("https://repo.emirman.dev/repository/maven-public/")
    }
}

dependencies {
    implementation 'dev.emirman.util:payment-garanti:1.0.15'
}
```

### Create Payment

The given code represents a function used to create a payment. Here is a step-by-step explanation of how the code works and what it does:

1. First, an instance of the `GPaymentService` class is created as the `service` object. This object represents a payment service provider used to perform the payment transaction.

2. Next, a `currency` object of type `GOrderCurrency` is created to determine the currency of the payment. In this case, it is set to USD (United States Dollar).

3. An `order` object is created using the builder method of the `GOrder` class. This object contains the necessary order details for the payment transaction, such as the order ID, installments, amount, currency, language, and type.

4. A `customer` object is created using the builder method of the `GCustomer` class. This object holds the customer's information, such as their IP address and email.

5. A `card` object is created using the builder method of the `GCard` class. This object includes the credit card information used for the payment, such as the cardholder's name, card number, CVC, expiration month, and expiration year.

6. A `payment` object is created using the builder method of the `GPayment` class. This object encapsulates the configuration settings, order, customer, and card information required for the payment transaction.

7. The `createRequest` method of the `service` object is called with the `payment` object to generate an HTML content representing the payment request.

8. The generated HTML content is encoded using Base64 and stored in the `encodedHtmlContent` variable.

9. The `mapper` object's `map` method is used to convert the `savedOrder` object to a `ReadOrderDTO` object.

10. Finally, a `ReadPaymentDTO` object is created using the `encodedHtmlContent` and `dto` objects, and it is returned.

The main purpose of this code is to gather the necessary information for a payment, create a payment request with an HTML representation, and return it as Base64 encoded content. It also utilizes data transfer objects (`ReadOrderDTO` and `ReadPaymentDTO`) to organize and return the relevant data in a structured manner.

#### Usage Example:
```java
public ReadPaymentDTO createPayment() {
        GPaymentService service = IGPaymentService();

        GOrderCurrency currency = GOrderCurrency.USD;

        GOrder order = GOrder.builder()
                .withOrderId(ORDER_ID)
                .withInstallments(INSTALLMENTS)
                .withAmount(AMOUNT) // e.g 99.9
                .withCurrency(currency)
                .withLang("LANG") // e.g tr
                .withType(SALES) // SALES
                .build();
                
        GCustomer customer = GCustomer.builder()
                 .withIpAddress(CUSTOMER_IP)
                 .withEmail(CUSTOMER_EMAIL)
                 .build()

        GCard card = GCard.builder()
                .withCardHolderName("John Doe")
                .withCardNumber("4022774022774026")
                .withCvc("000")
                .withExpireMonth("07")
                .withExpireYear("25")
                .build();
        
        GPayment payment = GPayment.builder()
                .withConfig(devConfig())
                .withOrder(gOrder)
                .withCustomer(customer)
                .withCard(card)
                .build();
                
        String htmlContent = service.pay(payment);
        String encodedHtmlContent = Base64.getEncoder().encodeToString(htmlContent.getBytes());
        ReadOrderDTO dto = mapper.map(savedOrder, ReadOrderDTO.class); // here i am using modelmapper.
        return ReadPaymentDTO.builder()
                .encodedHtmlContent(encodedHtmlContent)
                .order(dto)
                .build();
    }

private GStoreConfig devConfig() {
        return GStoreConfig.builder()
                .withMode("TEST")
                .withVersion("v0.01")
                .withSecure3DLevel("3D_FULL")
                .withProvUserId("PROVAUT")
                .withProvUserPass("123qweASD/")
                .withTerminalId("30691301")
                .withMerchantId("7000679")
                .withStoreKey("12345678")
                .withCompanyName("Company Name")
                .withSuccessUrl("https://example.com/api/v1/payment/callback")
                .withFailUrl("https://example.com/api/v1/payment/callback")
                .build();
    }
```
