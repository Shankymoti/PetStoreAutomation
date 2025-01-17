package api.endpoints;



/*
  Swagger URL : https://petstore.swagger.io
  
  Create user (POST) : https://petstore.swagger.io/v2/user
  Get user (GET) :  https://petstore.swagger.io/v2/user/{username}
  Update User (PUT) : https://petstore.swagger.io/v2/user/{username}
  Delete User (DELETE) :  https://petstore.swagger.io/v2/user/{username}
  
  
  base url :  https://petstore.swagger.io/v2
  endpoint :  /user , user/{username}
 */

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	//Store module
	
	//here we will create store module urls
	
	//pet modules
	
	//here we will create pet module urls
	

}
