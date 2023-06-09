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
                
        String htmlContent = service.createRequest(payment);
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
