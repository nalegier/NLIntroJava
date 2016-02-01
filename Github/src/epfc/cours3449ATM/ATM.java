/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epfc.cours3449ATM;

public class ATM {
    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;
    
    private Customer currentCustomer;
     private int customerNumber;
     private BankAccount currentAccount;
     private Bank theBank;
     private int state;
     
     private static final int START = 1;
     private static final int PIN = 2;
     private static final int ACCOUNT = 3;
     private static final int TRANSACT = 4;
     
    public ATM(Bank aBank){
        this.theBank = aBank; 
        this.customerNumber = -1;
        this.currentCustomer = null;
        this.state = START;
    }
    
     public void setCustomer(int customerId){
        this.customerNumber = customerId;
        this.state = PIN;
         
     }
  // Finds customer in bank.    If found, sets state to ACCOUNT, else to START.

    public void selectCustomer(int pin){
        currentCustomer = theBank.findCustomer(customerNumber, pin);
        if (currentCustomer == null)
            state = START;
        else
            state = ACCOUNT;
     }
    
// Sets current account to checking or savings. Sets state to TRANSACT.
    public void selectAccount(int account){
        currentAccount = currentCustomer.getCheckingAccount();
        state = TRANSACT;
    }
    
// Withdraws amount from current account.
    public void withdraw(double value){
        currentAccount.withdraw(value);
    }

    //Deposits amount to current account.
    public void deposit(double value){
        currentAccount.deposit(value);
    }    
     
   //get balance
    public double getBalance(){
        return currentAccount.getBalance();
    }
    
    //getstate
    public int getState(){
        return state;
    }
}
