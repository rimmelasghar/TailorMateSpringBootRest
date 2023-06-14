
# TailorMate

The Official Endpoints for the TailorMate Application

<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->



## Endpoints

* [ProductType](#producttype)
    1. [AddProductType](#1-addproducttype)
    1. [GetAllProductType](#2-getallproducttype)
    1. [UpdateProductType](#3-updateproducttype)
    1. [DeleteProductTypebyID](#4-deleteproducttypebyid)
    1. [GetProductTypeById](#5-getproducttypebyid)
* [Colors](#colors)
    1. [GetAllColors](#1-getallcolors)
    1. [AddColor](#2-addcolor)
    1. [UpdateColor](#3-updatecolor)
    1. [DeleteColorByid](#4-deletecolorbyid)
    1. [GetColorById](#5-getcolorbyid)
* [Sizes](#sizes)
    1. [GetAllSizes](#1-getallsizes)
    1. [AddSizes](#2-addsizes)
    1. [UpdateSizeByID](#3-updatesizebyid)
    1. [deleteSizeById](#4-deletesizebyid)
    1. [GetSizeById](#5-getsizebyid)
* [Measurements](#measurements)
    1. [getAllMeasurements](#1-getallmeasurements)
    1. [AddMeasurements](#2-addmeasurements)
    1. [UpdateMeasurmentById](#3-updatemeasurmentbyid)
    1. [DeleteMeasurmentById](#4-deletemeasurmentbyid)
    1. [GetMeasurmentById](#5-getmeasurmentbyid)
* [GarmentTypes](#garmenttypes)
    1. [GetAllGarmentTypes](#1-getallgarmenttypes)
    1. [AddGarmentType](#2-addgarmenttype)
    1. [UpdateGarmentType](#3-updategarmenttype)
    1. [getGarmentTypeById](#4-getgarmenttypebyid)
    1. [New Request](#5-new-request)
* [Tailor](#tailor)
    1. [getAllTailors](#1-getalltailors)
    1. [getTailorById](#2-gettailorbyid)
    1. [TailorLogin](#3-tailorlogin)
    1. [addTailor](#4-addtailor)
    1. [Update Tailor](#5-update-tailor)
    1. [changePassword](#6-changepassword)
    1. [forgotPassword](#7-forgotpassword)
    1. [TailorSignup](#8-tailorsignup)
* [AreaOfSpecialization](#areaofspecialization)
    1. [GetAll](#1-getall)
    1. [AddAreaOfSpecialization](#2-addareaofspecialization)
    1. [UpdateAreaOfSpecialization](#3-updateareaofspecialization)
    1. [New Request](#4-new-request)
* [Orders](#orders)
    1. [getAllorders](#1-getallorders)
    1. [getOrdersByTailorId](#2-getordersbytailorid)
    1. [GetOrderById](#3-getorderbyid)
    1. [updateOrderById](#4-updateorderbyid)
    1. [GetOrdersByCustomerId](#5-getordersbycustomerid)
    1. [Add Order](#6-add-order)
    1. [UpdateOrder](#7-updateorder)
* [Reviews](#reviews)
    1. [Get Reviews](#1-get-reviews)
    1. [Get Specific Tailor Reviews](#2-get-specific-tailor-reviews)
    1. [GetReviewsbyId](#3-getreviewsbyid)
    1. [AddReview](#4-addreview)
    1. [UpdateReviewById](#5-updatereviewbyid)
    1. [DeleteReviewByID](#6-deletereviewbyid)
* [Customer](#customer)
    1. [getAllCustomers](#1-getallcustomers)
    1. [AddCustomer](#2-addcustomer)
    1. [GetCustomerbyId](#3-getcustomerbyid)
    1. [UpdateCustomerById](#4-updatecustomerbyid)
    1. [deleteCustomerById](#5-deletecustomerbyid)
    1. [loginCustomer](#6-logincustomer)
    1. [ChangePasswordCustomer](#7-changepasswordcustomer)
    1. [ForgotPassword](#8-forgotpassword)
* [Portfolio](#portfolio)
    1. [GetAllPortfolioItems](#1-getallportfolioitems)
    1. [AddPortfolioItem](#2-addportfolioitem)
    1. [UpdatePortfolioItem](#3-updateportfolioitem)
    1. [New Request](#4-new-request-1)
    1. [GetById](#5-getbyid)
* [Order Details](#order-details)
    1. [GetAll](#1-getall-1)
    1. [AddOrderDetail](#2-addorderdetail)

--------



## ProductType



### 1. AddProductType



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/productTypes/
```



***Body:***

```js        
{
    "productTypeTitle":"Garment"
}
```



### 2. GetAllProductType



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/productTypes/
```



### 3. UpdateProductType



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/productTypes/1
```



***Body:***

```js        
{
    "productTypeId": 1,
    "productTypeTitle": "Garment"
}
```



### 4. DeleteProductTypebyID



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/productTypes/1
```



### 5. GetProductTypeById



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



## Colors



### 1. GetAllColors



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. AddColor



***Endpoint:***

```bash
Method: POST
Type: 
URL: http://localhost:8081/api/colors
```



### 3. UpdateColor



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/colors/1
```



***Body:***

```js        
{
    "colorTitle":"Red"
}
```



### 4. DeleteColorByid



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/colors/1
```



### 5. GetColorById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/colors/2
```



## Sizes



### 1. GetAllSizes



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/sizes/
```



### 2. AddSizes



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/sizes/
```



***Body:***

```js        
{
    "productType":{
    "productTypeId": 1,
    "productTypeTitle": "Garment"
        },
    "sizeTitle":"XL"
}
```



### 3. UpdateSizeByID



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/sizes/1
```



***Body:***

```js        
{
    "sizeId": 1,
    "productType": {
        "productTypeId": 2,
        "productTypeTitle": "Garment"
    },
    "sizeTitle": "XLL"
}
```



### 4. deleteSizeById



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/sizes/1
```



### 5. GetSizeById



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



## Measurements



### 1. getAllMeasurements



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/measurements/
```



### 2. AddMeasurements



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/measurements/
```



***Body:***

```js        
{
        "productType": {
            "productTypeId": 1,
            "productTypeTitle": "Garment"
        },
        "measurementTitle": "Neck"
}
```



### 3. UpdateMeasurmentById



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/measurements/1
```



***Body:***

```js        
{
        "measurementId": 1,
        "productType": {
            "productTypeId": 1,
            "productTypeTitle": "Garment"
        },
        "measurementTitle": "Waist"
    }
```



### 4. DeleteMeasurmentById



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/measurements/1
```



### 5. GetMeasurmentById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/measurements/1
```



## GarmentTypes



### 1. GetAllGarmentTypes



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/garmentTypes/
```



### 2. AddGarmentType



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/garmentTypes/
```



***Body:***

```js        
{
  "garmentTypeTitle": "Jacket"
}

```



### 3. UpdateGarmentType



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/garmentTypes/4
```



***Body:***

```js        
    {
        "garmentTypeTitle": "Long Shirt"
    }
```



### 4. getGarmentTypeById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/garmentTypes/4
```



### 5. New Request



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/garmentTypes/4
```



## Tailor



### 1. getAllTailors



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. getTailorById



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 3. TailorLogin



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/tailor/login
```



***Body:***

```js        
{
    "email":"rimmelasghar10gmail.com",
    "password":"rimmelasghar"
}
```



### 4. addTailor



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/tailor/add
```



***Body:***

```js        
{
    "emailAddress": "rimmelasghar40@gmail.com", 
    "username": "rimmel Asghar",
    "bio": "Programmer in reaction",
    "location": "remote",
    "password":"rimmelasghar",
    "avatar": "url:3040000",
    "createdAt": "19:30",
    "updatedAt": "11:50",
    "areaOfSpecialization": {
        "areaOfSpecializationId": 1,
        "areaOfSpecializationTitle": "kurta"
    },
    "experience": "8 years",
    "phoneNumber": 33225931
}
```



### 5. Update Tailor



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/tailor/6
```



***Body:***

```js        
{
        "emailAddress": "rimmelasghar40@gmail.com",
        "username": "rimmel Asghar",
        "bio": "Programmer in reaction",
        "location": "remote",
        "avatar": "url:50000",
        "createdAt": "19:30",
        "updatedAt": "11:50",
        "areaOfSpecialization": {
            "areaOfSpecializationId": 1,
            "areaOfSpecializationTitle": "kurta"
        },
        "experience": "8 years",
        "phoneNumber": 33225931
    }
```



### 6. changePassword



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/tailor/change-password
```



***Body:***

```js        
{
    "email":"youremail",
    "currentPassword":"pss",
    "newPassword":""
}
```



### 7. forgotPassword



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/tailor/forgotPassword
```



***Body:***

```js        
{
    "email":"rimmelasghar40@gmail.com",
    "password":"register"
}
```



### 8. TailorSignup



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



## AreaOfSpecialization



### 1. GetAll



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. AddAreaOfSpecialization



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/area-of-specializations/
```



***Body:***

```js        
{
  "areaOfSpecializationTitle": "Jacket"
}

```



### 3. UpdateAreaOfSpecialization



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/area-of-specializations/1
```



***Body:***

```js        
{
  "areaOfSpecializationTitle": "Kameez"
}

```



### 4. New Request



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/area-of-specializations/1
```



## Orders



### 1. getAllorders



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. getOrdersByTailorId



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8081/api/orders/tailors/2
```



### 3. GetOrderById



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 4. updateOrderById



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/orders/2
```



***Body:***

```js        
    {
        "tailor": {
            "tailorId": 2,
            "emailAddress": "rimmelasghar3@gmail.com",
            "username": "rimmel Asghar",
            "bio": "Programmer in reaction",
            "location": "remote",
            "avatar": "url:3040000",
            "createdAt": "19:30",
            "updatedAt": "11:50",
            "areaOfSpecialization": {
                "areaOfSpecializationId": 1,
                "areaOfSpecializationTitle": "kurta"
            },
            "experience": "8 years",
            "phoneNumber": 33225931
        },
        "customer": {
            "customerId": 2,
            "bio": "customer 2",
            "avatar": "url",
            "emailAddress": "rimmelasghar4@gmail.com",
            "username": null,
            "createdAt": "10:30",
            "updatedAt": "20:30",
            "phoneNumber": 22593149
        },
        "createdAt": "10:30",
        "expectedDeliveryAt": "01:05",
        "status": 1,
        "price": 300.0,
        "deliveryAddress": "block-14",
        "acceptedAt": "11:30",
        "sentForDeliveryAt": "10:30",
        "completedAt": "28:30",
        "cancelledAt": "12:30"
    }
```



### 5. GetOrdersByCustomerId



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 6. Add Order



***Endpoint:***

```bash
Method: POST
Type: 
URL: http://localhost:8081/api/orders/
```



### 7. UpdateOrder



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/orders/1
```



***Body:***

```js        
{
    "orderId": 1,
    "tailor": {
        "tailorId": 1,
        "emailAddress": "rimmelasghar40@gmail.com",
        "username": "rimmel Asghar",
        "bio": "Programmer in reaction",
        "location": "remote",
        "avatar": "https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png",
        "createdAt": "19:30 2022-01-01",
        "updatedAt": "11:50 2022-01-02",
        "areaOfSpecialization": {
            "areaOfSpecializationId": 1,
            "areaOfSpecializationTitle": "Kurta"
        },
        "experience": "8 years",
        "phoneNumber": "+923322593149"
    },
    "customer": {
        "customerId": 1,
        "bio": "A Customer that Can buy Anything that lies in Budget",
        "avatar": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzHQv_th9wq3ivQ1CVk7UZRxhbPq64oQrg5Q&usqp=CAU",
        "emailAddress": "rimmelasghar3@gmail.com",
        "username": "rimmel Asghar",
        "createdAt": "2023-06-11T12:00:00Z",
        "updatedAt": "2023-06-11T12:00:00Z",
        "phoneNumber": "3322593149"
    },
    "createdAt": "2022-01-01",
    "expectedDeliveryAt": "2022-01-05",
    "status": 1,
    "price": 100.0,
    "deliveryAddress": "123 Main St, City",
    "acceptedAt": "2022-01-02",
    "sentForDeliveryAt": "2022-01-03",
    "completedAt": "2022-01-04",
    "cancelledAt": null
}
```



## Reviews



### 1. Get Reviews



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. Get Specific Tailor Reviews



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 3. GetReviewsbyId



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 4. AddReview



***Endpoint:***

```bash
Method: POST
Type: 
URL: http://localhost:8081/api/reviews/
```



### 5. UpdateReviewById



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/reviews/1
```



***Body:***

```js        
{
    "tailor": {
        "tailorId": 1,
        "emailAddress": "rimmelasghar40@gmail.com",
        "username": "rimmel Asghar",
        "bio": "Programmer in reaction",
        "location": "remote",
        "avatar": "https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png",
        "createdAt": "19:30 2022-01-01",
        "updatedAt": "11:50 2022-01-02",
        "areaOfSpecialization": {
            "areaOfSpecializationId": 1,
            "areaOfSpecializationTitle": "Kurta"
        },
        "experience": "8 years",
        "phoneNumber": "+923322593149"
    },
    "customer": {
        "customerId": 1,
        "bio": "A Customer that Can buy Anything that lies in Budget",
        "avatar": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzHQv_th9wq3ivQ1CVk7UZRxhbPq64oQrg5Q&usqp=CAU",
        "emailAddress": "rimmelasghar3@gmail.com",
        "username": "rimmel Asghar",
        "createdAt": "2023-06-11T12:00:00Z",
        "updatedAt": "2023-06-11T12:00:00Z",
        "phoneNumber": "3322593149"
    },
    "rating": "5",
    "reviewText": "Tailor is Extremely nice and Talented",
    "createdAt": "2022-01-05"
}
```



### 6. DeleteReviewByID



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/reviews/1
```



## Customer



### 1. getAllCustomers



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. AddCustomer



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/customers/add
```



***Body:***

```js        
{
    "username":"Rimmel Asghar",
    "bio": "A Customer that Can buy Anything",
    "avatar": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzHQv_th9wq3ivQ1CVk7UZRxhbPq64oQrg5Q&usqp=CAU",
    "password":"rimmelasghar",
    "emailAddress": "rimmelasghar3@gmail.com",
    "username": "rimmel Asghar",
    "createdAt": "2023-06-11T12:00:00Z",
    "updatedAt": "2023-06-11T12:00:00Z",
    "phoneNumber": 3322593149
}

```



### 3. GetCustomerbyId



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 4. UpdateCustomerById



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/customers/1
```



***Body:***

```js        
{
    "bio": "A Customer that Can buy Anything that lies in Budget",
    "avatar": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzHQv_th9wq3ivQ1CVk7UZRxhbPq64oQrg5Q&usqp=CAU",
    "emailAddress": "rimmelasghar3@gmail.com",
    "username": "rimmel Asghar",
    "createdAt": "2023-06-11T12:00:00Z",
    "updatedAt": "2023-06-11T12:00:00Z",
    "phoneNumber": "3322593149"
}
```



### 5. deleteCustomerById



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/customers/1
```



### 6. loginCustomer



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/customers/login
```



***Body:***

```js        
{
    "email":"rimmelasghar3@gmail.com",
    "password":"rimmelasghar30"
}
```



### 7. ChangePasswordCustomer



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/customers/change-password
```



***Body:***

```js        
{
    "email":"rimmelasghar3@gmail.com",
    "currentPassword":"rimmelasghar",
    "newPassword":"rimmelasghar30"
}
```



### 8. ForgotPassword



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/customers/forgotPassword
```



***Body:***

```js        
{
    "email":"rimmelasghar3@gmail.com",
    "password":"rimmelasghar"
}
```



## Portfolio



### 1. GetAllPortfolioItems



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. AddPortfolioItem



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/portfolioItems/
```



***Body:***

```js        
{
  "portfolioItemId": 1,
  "tailor": {
    "tailorId": 1,
    "emailAddress": "rimmelasghar40@gmail.com",
    "username": "rimmel Asghar",
    "bio": "Programmer in reaction",
    "location": "remote",
    "avatar": "https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png",
    "createdAt": "19:30 2022-01-01",
    "updatedAt": "11:50 2022-01-02",
    "areaOfSpecialization": {
        "areaOfSpecializationId": 1,
        "areaOfSpecializationTitle": "kurta"
    },
    "experience": "8 years",
    "phoneNumber": "+923322593149"
},
  "titleText": "Kurta",
  "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXpUtwRulS_JReXjgaVUCrFE4_oJOOhIZm5A&usqp=CAU",
  "description": "I can designed beautiful kurta",
  "createdAt": "19:30 2022-01-03"
}

```



### 3. UpdatePortfolioItem



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8081/api/portfolioItems/1
```



***Body:***

```js        
{
        "portfolioItemId": 1,
        "tailor": {
            "tailorId": 1,
            "emailAddress": "rimmelasghar40@gmail.com",
            "username": "rimmel Asghar",
            "bio": "Programmer in reaction",
            "location": "remote",
            "avatar": "https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png",
            "createdAt": "19:30 2022-01-01",
            "updatedAt": "11:50 2022-01-02",
            "areaOfSpecialization": {
                "areaOfSpecializationId": 1,
                "areaOfSpecializationTitle": "Kurta"
            },
            "experience": "8 years",
            "phoneNumber": "+923322593149"
        },
        "titleText": "Kurta",
        "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXpUtwRulS_JReXjgaVUCrFE4_oJOOhIZm5A&usqp=CAU",
        "description": "I can designed beautiful kurta in a reasonable Price",
        "createdAt": "19:30 2022-01-03"
    }
```



### 4. New Request



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8081/api/portfolioItems/1
```



### 5. GetById



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



## Order Details



### 1. GetAll



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. AddOrderDetail



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8081/api/order-details/
```



***Body:***

```js        
{
  "orderDetailId": 1,
  "order": {
    "orderId": 1,
    "orderNumber": "ORD001",
    "customer": {
      "customerId": 1,
      "firstName": "John",
      "lastName": "Doe",
      "emailAddress": "john.doe@example.com",
      "phoneNumber": "+1234567890",
      "createdAt": "2022-01-01",
      "updatedAt": "2022-01-02"
    },
    "orderDate": "2022-01-03",
    "totalAmount": 100.0,
    "status": "PENDING",
    "createdAt": "2022-01-04",
    "updatedAt": "2022-01-05"
  },
  "productType": {
    "productTypeId": 1,
    "productTypeTitle": "Shirt"
  },
  "designDetailsText": "Sample design details",
  "sampleImg": "sample_image.jpg",
  "garmentType": {
    "garmentTypeId": 1,
    "garmentTypeTitle": "Men's Wear"
  },
  "color": {
    "colorId": 1,
    "colorName": "Blue",
    "colorCode": "#0000FF"
  },
  "size": {
    "sizeId": 1,
    "sizeTitle": "Small"
  },
  "instructionsText": "Sample instructions"
}

```



---
[Back to top](#tailormate)

Coded by Rimmel Asghar with ❤️
