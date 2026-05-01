## **Q-3 a**





## PaymentProcessor.java



public interface PaymentProcessor {

&#x20;   void process(double amount);

}







## CreditCardProcessor.java





@Component("cardProcessor")

class CreditCardProcessor implements PaymentProcessor {

&#x20;   @Override

&#x20;   public void process(double amount) {

&#x20;       System.out.println("Processing payment via Credit Card");

&#x20;   }

}





## UPIProcessor.java



@Component("upiProcessor")

class UPIProcessor implements PaymentProcessor {

&#x20;   @Override

&#x20;   public void process(double amount) {

&#x20;       System.out.println("Processing payment via UPI");

&#x20;   }

}







## PaymentService.java





@Service

public class PaymentService {

&#x20;   private final PaymentProcessor cardProcessor;

&#x20;   private final PaymentProcessor upiProcessor;



&#x20;   // Constructor-based dependency injection using @Qualifier to resolve ambiguity

&#x20;   public PaymentService(

&#x20;           @Qualifier("cardProcessor") PaymentProcessor cardProcessor, 

&#x20;           @Qualifier("upiProcessor") PaymentProcessor upiProcessor) {

&#x20;       this.cardProcessor = cardProcessor;

&#x20;       this.upiProcessor = upiProcessor;

&#x20;   }



&#x20;   public void makePayment(double amount, String type) {

&#x20;       if ("CARD".equals(type)) {

&#x20;           cardProcessor.process(amount);

&#x20;       } else if ("UPI".equals(type)) {

&#x20;           upiProcessor.process(amount);

&#x20;       } else {

&#x20;           System.out.println("Invalid payment type");

&#x20;       }

&#x20;   }

}

