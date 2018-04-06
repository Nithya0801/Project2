

scotchApp.controller("registercontroller",function($scope,$http,$location,$rootScope){
	
	console.log("User Controller!!!");
	$scope.udetail={"name":'',"email":'',"password":'',"address":'',"phone":''}
	
	
	$scope.registerUser=function(){
		
		console.log("Register User invoked!!!!");
		$http.post('http://localhost:8080/project2_mid/registerUser',$scope.udetail).then(function(response) {
			console.log('status :',response.statusText);
			console.log("now blog invokde!!!");
			$location.path("/register");
		});
	};
});