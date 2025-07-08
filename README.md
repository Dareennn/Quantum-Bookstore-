# Quantum-Bookstore-
The book store may have an inventory of many books of 
these types: 
○ Paper book which have stock and may be shipped 
○ EBook which have a filetype and may be sent via email 
○ Showcase/Demo book which is not for sale 
All print statements should be prefixed with Quantum book store 
● you should be able to do the following: 
○ Add a book to the inventory with some details like 
ISBN(just any string identifier), title, year when the 
book is published, price 
○ Remove and return outdated books that passed 
specific number of years 
○ Buy a single book providing its ISBN, quantity, email, 
address 
■ Reduces the quantity of the book from the 
inventory, throw error if not available 
■ Return the paid amount. 
■ Send Paper book to the ShippingService with the 
address provided (no implementation required) 
■ Send EBook to MailService with the email 
provided (no implementation required) 
add field author name to the book 
● Provide a class to test adding, removing, buying books 
This class should be named QuantumBookstoreFullTest 
● Design the system to be easily extensible,  so that we don’t 
need to modify it if we’ve added a new type of products
