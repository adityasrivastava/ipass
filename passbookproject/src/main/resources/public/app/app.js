var app = angular.module("passbookApp", []);

app.controller("passbookCtrl",function($scope, $http, $location, $document, $window,  $interval){

	$scope.update = "";

	$scope.user = {
		id: 0,
		name: "",
		age: "",
		gender: "",
		golf_course: "",
		hole_type: "",
		tee_type: "",
		handicap: "",
		par: "",
		score: ""
	};

	$scope.data_properties = {
		genders : [
			{
				id: 0,
			 	value: "Male"
			},
			{
				id: 1,
				value: "Female"
			}
		],
		golf_course_list: [
			{
				id: 0,
				value: "Golf Course 1"
			},
			{
				id: 1,
				value: "Golf Course 2"
			},
			{
				id: 3,
				value: "Golf Course 3"
			}
		],
		hole_type_list: [
			{
				id: 0,
				value: "Hole 9"
			},
			{
				id: 1,
				value: "Hole 18"
			}
		],
		tee_type_list: [
			{
				id: 0,
				value: "Red"
			},
			{
				id: 1,
				value: "Green"
			},
			{
				id: 2,
				value: "Blue"
			},
			{
				id: 3,
				value: "White"
			}
		],

		hole_list : function(){
			var returnValue = new Array();
			var count = 0;
			while(count < 18){
				returnValue[count] = count++;
			}

			return returnValue;
		}
	}


	function init(){
		// $http.get("/changeStatus").then(function(response){
		// 	console.log("Change status reset");
		// })
		$http.get("/golfDetails").then(function(response){
			$scope.data_properties = response.data;
			console.log(response.data);
		});
	}

	$scope.updatePassbook =function(){

			$scope.update = "";

		var pushUrl="/pushNotifications?hole="+$scope.user.hole+"&score="+$scope.user.score;

		$http.get(pushUrl).then(function(response){
				$scope.update = "Pust Notification Successful";
		});

	}

	$scope.clearPassbook = function(){
		$scope.user.name = "";
		$scope.user.age = "";
		$scope.user.gender = ""; 
	}

	// if($location.absUrl().indexOf("update") === -1)
	// 	$interval(checkPassbookStatus, 1000);

	

	// function checkPassbookStatus(){
	// 		$http.get("/passbookStatus").success(function(response){

	// 			if(Boolean(response === 'true')){
			
	// 				// window.location.href="/update";
	// 			}
	// 		});
	// }

	$scope.createPassbook = function(){

		if($scope.user.name === "" || $scope.user.age === "" || $scope.user.gender === "" ){
			$scope.error= "Please fill all the fields.";
			return;
		}

		$scope.urlPath ="/createPassbook?name="+$scope.user.name
							+"&age="+$scope.user.age
							+"&gender="+$scope.user.gender
							+"&golf_course="+$scope.user.golf_course
							+"&hole_type="+$scope.user.hole_type
							+"&tee_type="+$scope.user.tee_type
							+"&handicap="+$scope.user.handicap;

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

	init();
});
