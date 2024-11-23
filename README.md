

Project Name: Last Try Food App
Tagline: A Full-Stack Food  Clone for Seamless Food Delivery

Description:
Last Try is a feature-rich food delivery web application inspired by Swiggy, offering users a seamless experience for browsing restaurants, exploring menus, placing orders, and tracking their food. Built using a robust combination of HTML, CSS, JavaScript, Bootstrap, JDBC, J2EE, JSP, and MySQL, the app is designed to be highly responsive, visually appealing, and user-friendly.

Key Features:
User-Friendly Frontend:

Designed with HTML, CSS, JavaScript, and Bootstrap to create a responsive and visually engaging interface.
Pages include:
Homepage: Highlights restaurant carousels, customer reviews, and featured quotes.
Restaurant Page: Displays restaurant details in a Swiggy-like card layout with images and descriptions.
Menu Page: Features a menu categorized by items with quantity selection and add-to-cart functionality.
Cart and Order Summary: Displays items added to the cart, total cost, and payment options.
Order History Page: Keeps track of previous orders with details like restaurant, items, and date.
Backend Functionality:

Built using J2EE (Java Servlets and JSP) for dynamic content rendering.
JDBC ensures smooth communication between the application and the MySQL database for CRUD operations.
Database Integration:

MySQL Database to store and manage:
User data (registration and login details).
Restaurant information (name, address, rating, estimated delivery time).
Menu details (item names, prices, availability).
Order history.
Efficiently structured tables ensure scalability and optimized queries.
Admin Features:

Manage restaurant data, menus, and user details via backend modules.
Interactive and Responsive UI:

Integrated animations for smooth transitions between pages.
Responsive design to ensure compatibility across devices (desktop, tablet, and mobile).
Authentication System:

Secure user login and signup pages built with JSP and Java Servlets.
Includes validation checks and error messages for incorrect credentials.
Add to Cart & Payment:

Users can add items to the cart, view the total cost, and proceed to payment.
A reset button allows users to clear the cart.
Order History Tracking:

Users can view their past orders, including details of the items purchased, restaurant name, and total amount.
Tech Stack:
Frontend:
HTML, CSS, JavaScript, Bootstrap: For building an interactive and user-friendly interface.
Backend:
Java (J2EE), Servlets, JSP: For server-side logic and rendering dynamic content.
Database:
MySQL: For storing user data, restaurant details, menu information, and order history.
Integration:
JDBC: For seamless communication between the application and the database.
How It Works:
Homepage:

Showcases restaurant highlights with a carousel and user reviews.
Features links to all major pages via a responsive navbar.
Restaurant Page:

Displays restaurants in a card layout with names, ratings, estimated delivery time, and addresses.
Menu Page:

Displays menu items with prices, quantity selection, and "Add to Cart" functionality.
Cart and Payment:

Displays selected items, calculates the total price, and allows users to proceed with payment.
Order History:

A summary of all previous orders with timestamps and details.
User Authentication:

Signup and login system with validation for secure access.
Database Structure:
Users Table:

userId: Primary Key
name, username, password, email, phone, address, role, createdDate
Restaurants Table:

restaurantId: Primary Key
restaurantName, address, rating, eta, imagePath
Menu Table:

menuId: Primary Key
restaurantId: Foreign Key
itemName, price, ratings, isAvailable
Order Table:

orderId: Primary Key
userId: Foreign Key
restaurantId, totalAmount, orderDate
Installation and Setup:
Clone the repository:

bash
Copy code
git clone https://github.com/your-repo-link  
cd last-try-food-app  
Import the project into your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

Set up the database:

Import the SQL script provided in the db folder to create tables and insert sample data.
Configure the database connection in the JDBC settings of the project.

Build and run the project using a servlet container (e.g., Apache Tomcat).

GitHub Repository:
Check out the source code here: [GitHub Link]

Live Demo on YouTube:
Watch the full walkthrough of the Last Try Food App: [YouTube Link]
