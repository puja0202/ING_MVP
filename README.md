# ING_MVP

Test Steps:

Create customer using the below URL and sample request structure:

http://localhost:8080/customer

{
	"userId":"1001",
	"userName":"jo",
	"emailId":"alex@gmail.com",
	"address":"delhi",
	"contact":"9088006655"
	
}

{
	"userId":"1002",
	"userName":"john",
	"emailId":"john@gmail.com",
	"address":"delhi",
	"contact":"9086506655"
	
}


Create account using below:

http://localhost:8080/account

{
	"userid":1001,
	"balance":"5000",
	"accountid":"101"
	
}

{
	"userid":1001,
	"balance":"5000",
	"accountid":"102"
	
}

{
	"userid":1002,
	"balance":"9000",
	"accountid":"103"
	
}

{
	"userid":1002,
	"balance":"1000",
	"accountid":"104"
	
}

{
	"userid":1002,
	"balance":"7000",
	"accountid":"105"
	
}



To fetch all Customers:

URL: http://localhost:8080/customers

To fetch accounts of a customer:

URL: http://localhost:8080/1002/accounts


User story:1

Deposit amount:

URL: http://localhost:8080/transaction

Sample request:

{
"userId":"1001",
"accountId":"101",
"transactionType":"deposit",
"amount":"6000"
}


User story:2

Withdraw amount:

URL: http://localhost:8080/transaction

Sample request:

{
"userId":"1001",
"accountId":"101",
"transactionType":"withdraw",
"amount":"1000"
}


User story: 3

Display account balance:

URL: http://localhost:8080/{userId}/{accountId}/balance

test url: http://localhost:8080/1001/101/balance

Sample Response Structure:

{
    "accountid": "101",
    "balance": "5000.0",
    "userid": "1001"
}


User story 4:

Display account transaction history:

URL: http://localhost:8080/{userId}/{accountId}/transactions

test url: http://localhost:8080/1001/101/transactions

Sample Response Structure:

[
    {
        "txnId": "1",
        "userId": "1001",
        "accountId": "101",
        "transactionType": "deposit",
        "amount": "6000"
    },
    {
        "txnId": "2",
        "userId": "1001",
        "accountId": "101",
        "transactionType": "withdraw",
        "amount": "1000"
    }
]