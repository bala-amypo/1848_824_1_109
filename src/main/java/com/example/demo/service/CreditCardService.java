public interface CreditCardService {

    // used by controllers
    CreditCardRecord addCard(Long userId, CreditCardRecord card);

    // 🔥 REQUIRED by tests
    CreditCardRecord addCard(CreditCardRecord card);

    CreditCardRecord updateCard(Long id, CreditCardRecord card);
    CreditCardRecord getCardById(Long id);
    List<CreditCardRecord> getCardsByUser(Long userId);
    List<CreditCardRecord> getAllCards();
}
