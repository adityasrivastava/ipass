var app = angular.module("passbookApp", []);

app.controller("passbookCtrl",function($scope, $http, $location,  $interval){

	$scope.update = "";

	$scope.user = {
		id: 0,
		name: "",
		age: "",
		gender: ""
	};

	$scope.genders = [
		{
			id: 0,
		 	value: "Male"
		},
		{
			id: 1,
			value: "Female"
		}
	];

	$scope.updatePassbook =function(){

			$scope.update = "";

		var pushUrl="/pushNotifications";

		$http.get(pushUrl).then(function(response){
				$scope.update = "Pust Notification Successful";
		});

	}

	$scope.clearPassbook = function(){
		$scope.user.name = "";
		$scope.user.age = "";
		$scope.user.gender = ""; 
	}

	if($location.absUrl().indexOf("update") === -1)
		$interval(checkPassbookStatus, 1000);

	

	function checkPassbookStatus(){
			$http.get("/passbookStatus").success(function(response){
				 console.log(response);

				if(Boolean(response === 'true')){
					window.location.href="/update";
				}
			});
	}
	$scope.createPassbook = function(){

		if($scope.user.name === "" || $scope.user.age === "" || $scope.user.gender === "" ){
			$scope.error= "Please fill all the fields.";
			return;
		}

		$scope.urlPath ="/downloadPass?name="+$scope.user.name+"&age="+$scope.user.age+"&gender="+$scope.user.gender;

		return $scope.urlPath;


		// $http.get(urlPath, {responseType: 'blob'})
		// .success(function(response){
			  
		// 	// download_file("file.pkpass", response, 'application/vnd.apple.pkpass');
		// 	 var windowUrl = window.URL || window.webkitURL;
		// 	     var file = new Blob([response], {type: 'application/vnd.apple.pkpass'});

  //      var fileURL = windowUrl.createObjectURL(file);

		// var link = document.createElement("a");
		// link.id = "passbookDownload";
		// document.body.appendChild(link);
		// window.URL = window.URL || window.webkitURL;
		// var filename = 'file.pkpass';
		// $("#passbookDownload").attr({'download': filename, 'href': fileURL});
		// $('#passbookDownload')[0].click();
		// document.body.removeChild(link);

		// })


	}
});
