1.Customer class – will hold basic customer information such as the first name and last name.
2. Account class – will hold information such as the account number, account balance and will
extend the customer class to allow customer details to be used within the constructor. This
class will also hold functions such as deposit and withdraw.
3. Transaction class – will hold a method called transfer to allow accounts to transfer money
between them.
4. Main – where you will create accounts and test your functions from the account and transfer
class.

The addition of file input. Rather than creating the accounts in the
main method manually, you will read from a csv file provided on Canvas. This file has simply 4 rows,
each containing a first name, last name, account number and balance. This will involve an additional
class:
5. ReadAccounts class – will read the data and contain 4 functions to return a list of first
names, last names, bank accounts and balances

Account class (extends Customer class)
The next class you should create is the account class. This should inherit the variables and functions from the customer class. Once you have extended this
class to use the customer class, you should create 2 new variables; balance and accountNumber. Both should be an integer. You then need to create the
following methods:
- Account – this is a constructor which will be called when an object has been created using this class. When an object of this type has been created
in the main method or elsewhere, it will require 4 parameters. The first two are linked to the customer class. You should take the FName and
LName and use the set methods from the customer class which can be used within the account class without an object to be created to set
firstName and lastName. The other 2 parameters should be used to set the global variables balance and accountNumber. You don’t need a function
to do this, simply set them equal to whatever is passed into the parameters.
- getBalance – this should return the global variable balance
- getAccountNum – this should return the global variable accountNumber
- deposit – this function has a parameter called “amount”. Whatever is passed into this “amount” variable should add onto the previous balance. For
example, if the balance is set to 1000 when an account has been created, and the function deposit(100) is called, this should add 100 to 1000.
- withdraw – this function has a parameter called “amount”. Whatever is passed into this “amount” variable should subtract from the previous
balance. For example, if the previous balance is 1000 and the function withdraw(55) is called, 55 should be subtracted from the 1000.
Transaction class
The third class you need create is the transaction class. In this class, you only need to create one function called transfer. Transfer takes in 3 parameters, the
first two are accounts and the last is the amount you wish to transfer. The first parameter is the source account, and the second parameter is the
destination account. Money from one account will transfer to the other and the amount is specified by the third parameter. As the first 2 parameters are
objects, you will need to create 2 accounts initially (this will be done in the main) and you should pass those into the first and second parameter. The
transfer method should grab the current balance of the first account and minus the amount, the next part is to grab the balance of the second account and
add the amount and this will complete the transfer.
Main class
The main class is where you will do all your testing to see whether your methods have been implemented correctly. Complete the following steps to make
sure your banking system is working correctly:
1. Create an object from Account called account1. When you create this object, it should force you to add 4 values in the parameters as you create the
object. You can set the values to whatever you want but make sure you use the correct variable types. It should throw an error in eclipse if you are
using the wrong types. For account 1, use “Jeffrey” as the first name, “Ting” as the last name, 1 as the account number and 2000 as the balance.
2. Create an object from Account called account2. Use “Hiran” as the first name, “Patel” as the last name, 2 as the account number and 1000 as the
balance.
(NOTE – in this module, you are learning the concepts of OOP and using a banking system as an application. In a traditional banking system, an account
number cannot be duplicated but with our current system, you can set the same account number. For testing purposes, DO NOT set the account number
for two accounts the same as this will cause confusion for those who want to complete part 2 and 3).
3. Print out the balance of account1
4. Print out the balance of account2
5. Call the deposit function on the account1 object and deposit 250
6. Print out the balance of account1 – does it print out 2250?
7. Call the withdraw function on the account2 object and withdraw 500
8. Print out the balance of account2 – does it print out 500?
(The balance for account1 now should be 2250 and the balance for account2 should be 500)
9. Create an object called “t” from the Transaction class. This only has a default constructor which contains no parameters.
10. Called the transfer method using “t” and add account1 as parameter 1, account2 as parameter 2 and for the amount, set it to 250. This should now
transfer 250 from account1 and add it to account2.
11. Print out balance of account1
12. Print out balance of account2
The final balance of account1 should be 2000
The final balance of account2 should be 750

