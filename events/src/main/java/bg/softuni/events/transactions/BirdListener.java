package bg.softuni.events.transactions;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class BirdListener {

  @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
  public void beforeCommit(BirdEvent event) {
    System.out.println("beforeCommit " + event.getBreed());
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  public void afterCommit(BirdEvent event) {
    System.out.println("afterCommit " + event.getBreed());
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
  public void afterCompletion(BirdEvent event) {
    System.out.println("afterCompletion " + event.getBreed());
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
  public void afterRollback(BirdEvent event) {
    System.out.println("afterRollback " + event.getBreed());
  }
}

