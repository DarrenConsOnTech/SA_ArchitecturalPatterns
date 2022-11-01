# Desgin Drivers
This section identifies a list of design drivers extracted from requirements of a Cash Register System.
<br>
<br>

***
## Use Cases

| ID   | Use Case                     | Description                                                                                                                                                                                                                                                                      | Req. ID          |
|------|------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------|
| UC-1 | Adding and Deleting Products | User is able to scan barcodes and retrieve information regarding the specific product using the<br>information stored on the local database. Users can also cancel any product that has initially<br>been scanned. If an unknown product is scanned then a message is displayed. | R-03, R-04, R-07 |
| UC-2 | Display                      | The information gathered from the local database about a specific product is displayed on a monitor<br>for the cashier and customer to view.                                                                                                                                     | R-03             |
| UC-3 | Generate Total               | Once the payment has been processed, a receipt of all items and their specifications are printed.                                                                                                                                                                                | R-06             |
| UC-4 | Payment                      | Once payment is required, the system should be able to take multiple forms of payment such as cash,<br>debit, or credit card where 3rd party payment systems may be used to complete the transactions.                                                                           | R-05             |
| UC-5 | Manage Sessions              | User should be able to create and end sessions through different parts of the checkout process.                                                                                                                                                                                  | R-01, R-02, R-06 |
| UC-6 | Maintenance                  | The system is able to change hardware platforms promoting portability along with its local<br>database of products.                                                                                                                                                              | R-08, R-09       |


<br>
<br>

***

## Quality Scenarios

| ID   | Quality Attribute | Scenario                                                                                                                                                         | Req. ID      |
|------|-------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|
| QA-1 | Modifiability     | The system is able to run on new and upgraded systems as hardware gets updated. The system<br>should also be able to run whenever the local database is updated. | R-08, R-09   |
| QA-2 | Reliability       | Since this system is going to be essential for everyday usage, the system should not be<br>prone to having constant failures/crashes.                            | All          |
| QA-3 | Usability         | Cashier should be able to easily navigate through system to complete transactions as<br>smoothly as possible.                                                    | R-01 to R-07 |


<br>
<br>

***
## Constraints

| ID    | Constraint                                                                                                                                   | Req. ID |
|-------|----------------------------------------------------------------------------------------------------------------------------------------------|---------|
| CON-1 | Authentication is required by any individual that wishes to use the system and <br>authorization is given according to worker/company title. | R-01    |
| CON-2 | System has to be adaptable to new changes in the future.                                                                                     | R-08    |
| CON-3 | All information about products should be within the local database.                                                                          | R-09    |