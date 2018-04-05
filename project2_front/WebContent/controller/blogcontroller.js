


scotchApp.controller("blogcontroller",function($scope,$http,$location){
	
	$scope.blog={"blogName":'',"blogContent":'',"createdDate":'',"username":'',"status":''};
	console.log("blogcontroller Js invoked!!!");
	$scope.blogdata;
	$scope.delData;
	$scope.insertBlog=function()
	{
		console.log("insertBlog invoked!!!!");
		$http.post('http://localhost:8080/project2_mid/addBlog',$scope.blog).then(function(response) {
			console.log('status :',response.statusText);
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
			$location.path("/blog")
		});
	};
	
	
	
});