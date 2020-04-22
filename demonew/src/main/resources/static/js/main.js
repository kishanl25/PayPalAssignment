var app = angular.module('LibraryManagement', []);
app.controller('LibraryController', function($scope, $http, $location) {
  $scope.submitForm= function(){
    var url = $location.absUrl() + "library" + "/addLibrary";
    
    var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
    var data = {
    		libraryName: $scope.libraryName
        };
    
    $http.post(url, data, config).then(function (response) {
      $scope.postResultMessage = response.data;
    }, function error(response) {
      $scope.postResultMessage = "Error with status: " +  response.statusText;
    });
    
    $scope.libraryName = "";
  }
});

app.controller('getcontroller', function($scope, $http, $location) {
		console.log("location:::"+$location);
	  $scope.getfunction = function(){		  
	    var url = $location.absUrl() + "library" + "/libraries";
	    console.log("URL:::"+$location.absUrl());
	    $http.get(url).then(function (response) {
	      $scope.response = response.data
	      console.log("Response:::"+$scope.response);
	    }, function error(response) {
	      $scope.postResultMessage = "Error with status: " +  response.statusText;
	    });
	  }
	});

app.controller('populateLibrary', function($scope, $http, $location) {
	
	$scope.getLibraryDataFromServer = function() {

		var url = $location.absUrl() + "library" + "/libraries";
	    console.log("URL:::"+$location.absUrl());
	    $http.get(url).then(function (response) {
	      $scope.libraryNameList = response.data
	      console.log("Response:::"+$scope.response);
	    }, function error(response) {
	      $scope.postResultMessage = "Error with status: " +  response.statusText;
	    });	    
	    };
	    
	   
	    
  });

//app.controller('populateLibrary', function($scope, $http, $location) {
//	
//	$scope.getBooksByLibrary() = function() {
//
//		var url = $location.absUrl() + "library" + "/getBooksByLibrary";
//	    
//	    var config = {
//	                headers : {
//	                    'Accept': 'text/plain'
//	                }
//	        }
//	    var data = {
//	    		libraryName: $scope.libraryselected
//	        };
//	    
//	    $http.post(url, data, config).then(function (response) {
//	      $scope.postResultMessage = response.data;
//	    }, function error(response) {
//	      $scope.postResultMessage = "Error with status: " +  response.statusText;
//	    });
//	    
//	    $scope.libraryName = "";    
//	    };
//	    
//  });


