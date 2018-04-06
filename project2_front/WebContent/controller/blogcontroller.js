


scotchApp.controller("blogcontroller",function($scope,$http,$location,$rootScope){
	
	$scope.blog={"blogName":'',"blogContent":'',"createdDate":'',"username":'',"status":'',"likes":0};
	console.log("blogcontroller Js invoked!!!");
	$scope.blogdata;
	$scope.delData;

	$scope.insertBlog=function()
	{
		console.log("insertBlog invoked!!!!");
		$http.post('http://localhost:8080/project2_mid/addBlog',$scope.blog).then(function(response) {
			console.log('status :',response.statusText);
			console.log("now blog invokde!!!");
			$location.path("/blog");
		});
		
	};
	
	listBlog();
	function listBlog()
	{
		console.log("Listing!!!");
		$http.get('http://localhost:8080/project2_mid/listBlog').then(function(response){
			$scope.blogdata=response.data;
		});
	}
	
	$scope.deleteBlog=function(id){
		console.log("Deleting!!!!");
		$http.post('http://localhost:8080/project2_mid/delBlog/'+id).then(function(response){
			$scope.delData=response.data;
			$location.path("/blog");
		
		});
	};
	
	$scope.editBlog=function(id)
	{
		console.log("Editing!!!!");
		$http.get('http://localhost:8080/project2_mid/getBlog/'+id)
		.then(function(response){
			console.log("invoked!!");
			$scope.blog=response.data;
			
			$rootScope.blog1=response.data;
			console.log("........"+$rootScope.blog1);
			$location.path("/updateBlog");
		});
	};
	
	$scope.updateBlog=function(id)
	{
		console.log("Update!!!"+$rootScope.blog1+"--------------");
		
		$http.post('http://localhost:8080/project2_mid/updateBlog/'+id,$rootScope.blog1)
		.then(function(response) {
			$location.path("/blog");
		});
	};
	
	
	$scope.incrblog=function(blogId)
	{
		console.log('into increment blog');
		$http.put('http://localhost:8080/project2_mid/incrblog/'+blogId)
		.then(function(response)
		{
			console.log(response.data);
			 $scope.blog=response.data;
			console.log('Status Text:'+response.statusText);
			$location.path("/blog");
		});
	};
});