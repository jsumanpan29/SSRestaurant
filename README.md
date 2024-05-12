# Restaurant POS System
Academic Project for the subject 'Programming 1' using Java Swing

Framework/s used:
- Java Swing


## Flowchart
![](/assets/Flowchart1.png?raw=true)
![](/assets/Flowchart2.png?raw=true)
## Login
We will start of in showing a login form. There are 2 user access roles these are admin/manager/owner and cashier:<br />
![](/assets/Login.png?raw=true)

## Admin Panel
For Admin Module: It will display a dialog that lets you input “1” for Managing Users and “2” for Managing Food Menu.<br />
![](/assets/Admin.png?raw=true)

## Users Panel
For Managing Users: it will display a table that has 3 columns mainly, “ID”, “Username” and “Role”. User Information is shown by each row. It also has 3 buttons mainly “Insert”, “Delete” and “Update”.<br />
![](/assets/Users.png?raw=true)

## Users Insert Panel
For Inserting data: “Insert” button is clicked and a dialog is shown which shows the following: <br />
1. Input ID field:<br />
  - In this field, it shows the next ID number to be used after the latest user information ID and this field is un-editable.<br />
2.	Input Username: <br />
  - In this field, this is where you input the user name for adding new user information.<br />
3.	Input Password:<br />
  - This is where the password is inputted for the user authorization purposes.<br />
4.	Input Role:<br />
  - This is where user role is determined, “1” for admin/manager/owner and “2” for cashier.<br />

![](/assets/UsersInsert.png?raw=true)

## Users Update Panel
For Updating Data: “Update” button is clicked, and a dialog is shown which shows the following:<br />
1.	Input ID field:<br />
 - In this field, it shows the current ID number to be reused, and it is also un-editable in order to avoid duplication of ID.<br />
2.	Input Username: <br />
 - In this field, this is where you input the new user name for adding new user information.<br />
3.	Input Password:<br />
 - This is where the new password is inputted for the user authorization purposes.<br />
4.	Input Role:<br />
 - This is where user role is changed, “1” for admin/manager/owner and “2” for cashier.<br />

![](/assets/UsersUpdate.png?raw=true)

## Users Delete Panel
For Deleting data: select the row to delete and then a confirmation to delete will be prompt before deleting the data entirely.<br />
![](/assets/UsersDelete.png?raw=true)

## Menu Panel
For Managing Food Menu: it will also display a table that has 3 columns mainly, “ID”, “Name” and “Price”. Food Information is shown by each row. It also has 3 buttons mainly “Insert”, “Delete” and “Update”.<br />
![](/assets/Menu.png?raw=true)

## Menu Insert Panel
For Inserting data: “Insert” button is clicked and a dialog is shown which shows the following:<br />
1.	Input ID field:<br />
 - In this field, it shows the next ID number to be used after the latest food information ID and this field is un-editable.<br />
2.	Input Food Name: <br />
 - In this field, this is where you input the food name for adding new food on the menu.<br />
3.	Input Price:<br />
 - This is where food price is determined.<br />

![](/assets/MenuInsert.png?raw=true)

## Menu Update Panel
For Updating Data: “Update” button is clicked, and a dialog is shown which shows the following:<br />
a.	Input ID field:<br />
 - In this field, it shows the current ID number to be reused, and it is also un-editable in order to avoid duplication of ID.<br />
b.	Input Food Name: <br />
 - In this field, this is where you input the new food name.<br />
c.	Input Price:<br />
 - This is where new food price is determined.<br />

![](/assets/MenuUpdate.png?raw=true)

## Menu Delete Panel
For Deleting data: select the row to delete and then a confirmation to delete will be prompt before deleting the data entirely.<br />
![](/assets/MenuDelete.png?raw=true)

## Cashier
For POS module of cashier: It will display the Cashiers Name, Food Menu, Order Table, “Customer Name” field, “Input Amount” field, “Total Price” field, “Remove”, and “Punch” button. <br />
![](/assets/Cashier.png?raw=true)<br />
For adding food in orders:  The items on the middle-left panel, which is the Food Menu with their respective prices, are to be ordered based on the customer’s choice. Clicking the item will display the orders on the table at the right of the Food Menu panel. <br />
![](/assets/Cashier2.png?raw=true)<br />
Repeated clicking of the item increases the quantity value of the item on the order table.<br />
![](/assets/Cashier3.png?raw=true)<br />
On the bottom panel, it is shown that there is “Customers Name” field, where its function is to add the Customers Name if deemed necessary. It also shows the “Input Amount” field where the amount of cash given by the customer is inputted. There is also “Punch” and “Remove” buttons. Punch button is used for finalizing the transaction while Remove button is used for removing selected item on the order table. Total price is also shown. If the cash is not greater than the total price, it will not proceed on the final transaction. <br />
![](/assets/Cashier4.png?raw=true)<br />

## Receipt
For finalizing the transaction: Punch button is clicked and then a dialog will be displayed showing the receipt:<br />
![](/assets/Receipt.png?raw=true)<br />
