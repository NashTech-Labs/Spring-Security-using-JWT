**Spring Security with JWT(JSON Web Token)**

1.*genrate web token using this URL. passing the Username and password for web token*
http://localhost:8080/authenticate

{
      
     "username":"akshit",

      "password":"123456"

}

then you will get the web token in encrypted format:

eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJha3NoaXQiLCJleHAiOjE2NTA0OTIyMjksImlhdCI6MTY1MDQ1NjIyOX0.Wts-VYzi_Pu2mI5OyJlrAe8q9BRLWuyk9Ol-z2DGwRE

you have to just add this web token on the header.

2. http://localhost:8080/addUser

*using this url you can add a new user*:

{

     "username":"ABC",

     "password":"12345",

     "email":"abc@gmail.com",

     "role":"user"

}

3. http://localhost:8080/

         Welcome page