package eecs2030.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. 
 * A piggy bank owns a collection (or possibly collections) of coins,
 * but does not own the coins themselves. In other words,
 * the piggy bank and its collection of coins form a composition.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins
 * from the piggy bank. The piggy bank does own its owner.
 * In other words, the piggy bank and its owner form an
 * aggregation.
 */
public class OwnedPiggyBank {
	/*
	 * YOU NEED A FIELD HERE TO HOLD THE COINS OF THIS PIGGY BANK
	 */
	private List<Coin> coins;
	/**
	 * The owner of this pigyg bank.
	 */
	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner
	 * and its collection of coins is empty.
	 * 
	 * @param owner
	 *            the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.owner = owner;
		this.coins = new ArrayList<>();
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy
	 * bank will have the same owner and the same number and type of coins as
	 * the other piggy bank.
	 * 
	 * @param other
	 *            the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.coins = other.deepCopy();
		this.owner = other.getOwner();

	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * <p>
	 * This method is present only for testing purposes. Returning
	 * the owner of this piggy bank allows any user to remove coins
	 * from the piggy bank (because any user can get the owner
	 * of this piggy bank)!
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.owner;
	}

	/**
	 * Allows the current owner of this piggy bank to give this
	 * piggy bank to a new owner.
	 * 
	 * @param currentOwner the current owner of this piggy bank
	 * @param newOwner the new owner of this piggy bank
	 * @throws IllegalArgumentException if currentOwner is not the
	 * current owner of this piggy bank
	 */
	public void changeOwner(Owner currentOwner, Owner newOwner) {
		if (!(this.owner.equals(currentOwner))) {
			IllegalArgumentException ex = new IllegalArgumentException("Current Owner is not owner of piggybank");
			throw ex;
		}
		this.owner = newOwner;
	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins
	 *            a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		this.coins.addAll(coins);

	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin
	 *            a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		if (this.coins.contains(coin))
			return true;

		return false;
	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value
	 * of the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank,
	 * then the coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user
	 *            the person trying to remove the coin
	 * @param coin
	 *            a coin
	 * @return a coin equal to the value of the specified coin from this piggy
	 *         bank, or null if user is not the owner of this piggy bank
	 * @pre. the piggy bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		if (!this.getOwner().equals(user)) {
			return null;
		}
		if (this.coins.contains(coin)) {
			coins.remove(coin);
		}
		return coin;
	}

	/**
	 * Allows the owner of this piggy bank to remove
	 * the smallest number of coins whose total value in cents is equal
	 * to the specified value in cents from this piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to
	 * the owner of this piggy bank.
	 * 
	 * @param user
	 *            the person trying to remove coins from this piggy bank
	 * @param value
	 *            a value in cents
	 * @return the smallest number of coins whose total value in cents is equal
	 *         to the specified value in cents from this piggy bank 
	 * @pre. the piggy bank contains a group of coins whose total value is equal
	 *         to specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		List<Coin> list = new ArrayList<Coin>();

		if (this.owner.equals(user)) {
			while (value > 0) {

				if (value >= 200 && coins.contains(Coin.TOONIE)) {
					int n = value / 200;

					for (int i = 0; i < n; i++) {
						if (coins.contains(Coin.TOONIE)) {
							list.add(Coin.TOONIE);
							value -= 200;
							coins.remove(Coin.TOONIE);
						} else
							break;
					}
				}

				else if (value >= 100 && coins.contains(Coin.LOONIE)) {
					int n = value / 100;
					for (int i = 0; i < n; i++) {
						if (coins.contains(Coin.LOONIE)) {
							list.add(Coin.LOONIE);
							value -= 100;
							coins.remove(Coin.LOONIE);
						} else
							break;
					}
				} else if (value >= 25 && coins.contains(Coin.QUARTER)) {
					int n = value / 25;
					for (int i = 0; i < n; i++) {
						if (coins.contains(Coin.QUARTER)) {
							list.add(Coin.QUARTER);
							value -= 25;
							coins.remove(Coin.QUARTER);
						} else
							break;
					}
				} else if (value >= 10 && coins.contains(Coin.DIME)) {
					int n = value / 10;
					for (int i = 0; i < n; i++) {
						if (coins.contains(Coin.DIME)) {
							list.add(Coin.DIME);
							value -= 10;
							coins.remove(Coin.DIME);
						} else
							break;

					}
				} else if (value >= 5 && coins.contains(Coin.NICKEL)) {
					int n = value / 5;
					for (int i = 0; i < n; i++) {
						if (coins.contains(Coin.NICKEL)) {
							list.add(Coin.NICKEL);
							value -= 5;
							coins.remove(Coin.NICKEL);
						} else
							break;

					}
				} else if (value >= 1 && coins.contains(Coin.PENNY)) {
					int n = value / 1;
					for (int i = 0; i < n; i++) {
						if (coins.contains(Coin.PENNY)) {
							list.add(Coin.PENNY);
							value -= 1;
							coins.remove(Coin.PENNY);
						} else
							break;
					}
				}
			} // end while
			return list;
		} // end owner check
		else
			return list;
	}

	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list
	 * has its coins in sorted order (from smallest value to largest value;
	 * i.e., pennies first, followed by nickels, dimes, quarters, loonies, and
	 * toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		List<Coin> ret = new ArrayList<Coin>();
		for (Coin c : this.coins) {
			ret.add(new Coin(c));
		}
		Collections.sort(ret);

		return ret;

	}
}// end class
