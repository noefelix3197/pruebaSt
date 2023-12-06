package com.bbva.service.impl;

import com.bbva.dto.AccountDTO;
import com.bbva.dto.CardDTO;
import com.bbva.model.Account;
import com.bbva.model.Card;
import com.bbva.repository.IAccountRepository;
import com.bbva.repository.IGenericRepository;
import com.bbva.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl extends CRUDimpl<Account, Integer> implements IAccountService {
    @Autowired
    private IAccountRepository repository;

    @Override
    protected IGenericRepository<Account, Integer> getRepository() {
        return repository;
    }

    @Override
    public List<Account> getAccountByIdClient(Integer idClient) {
        return repository.getAccountByIdClient(idClient);
    }

    @Override
    public void delete(Integer id) {
        Account account = super.findById(id);
        if (account == null){
            throw new RuntimeException("No se encontró la cuenta");
        }
        if (account.getAmount() > 0){
            throw new RuntimeException("La cuenta no se puede anular porque aún tiene un monto de "+ account.getAmount());
        }
        super.delete(id);
    }

    @Override
    public Account save(Account account) {

        if (account.getAmount()<50.00){
            throw new RuntimeException("El monto mínimo para aperturar una cuenta es de 50.00 Soles");
        }
        Card card = new Card();
        card.setCardNumber("xxxx-XXXX-XXXX-XXXX");
        card.setCardType("DEBITO");
        String dueDate = LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().plusYears(5).getYear();
        card.setDueDate(dueDate);
        int ccv = (int)(Math.random()*(999)+1);
        String ccvS = ("000"+ccv);
        card.setCcv(ccvS.substring(ccvS.length()-3));
        //client.getAccounts().get(0).setClient(client);
        card.setAccount(account);
        List<Card> cards = new ArrayList<>();
        cards.add(card);
        account.setCards(cards);
        return super.save(account);
    }
}
