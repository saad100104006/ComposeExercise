
## A compose app with 2 screen in MVVM, Kotlin, Stateflow, Couroutines.
Endpoint for 1st screen – https://dummyjson.com/products
Endpoint for 2nd screen – https://dummyjson.com/products/  {selected index from first screen}
https://dummyjson.com/products/1

First screen will show a list of the photo info with “thumbnail”, “title”, “brand” and “price “ from the endpoint.
 
Sample: a compose card with product image + basic info : title, brand and price.
 
Second screen is when you click on the list item it will open the details view for that photo which will show the “title” and “description” again and load the photo from images [0] on the screen.
 

<img width="280" alt="Screenshot 2024-10-31 at 10 43 02 PM" src="https://github.com/user-attachments/assets/541429e4-93fb-476c-a878-b650b31b33bb">
<img width="275" alt="Screenshot 2024-10-31 at 10 43 10 PM" src="https://github.com/user-attachments/assets/35fc3f24-4396-494c-8623-9fb0f11c76de">

Android Studio Version used
Android Studio Koala Feature Drop | 2024.1.2 Patch 1


