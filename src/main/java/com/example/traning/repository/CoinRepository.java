
package com.example.traning.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.traning.domain.Coin;
@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

public 	Coin findByCurrencyid(Long currencyid);

public Coin findByCoinName(String coinName);



}
