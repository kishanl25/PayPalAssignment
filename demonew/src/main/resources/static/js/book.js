var app = angular.module('BookManagement', []);
app.controller('BookController', function($scope, $http, $location) {
  $scope.addBook= function(){
    var url = $location.absUrl() + "library" + "/addBook";
    
    var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
    var data = {
    		bookName: $scope.bookName,
    		bookIsbn: $scope.bookIsbn,
    		bookPrice: $scope.bookPrice,
    		bookAuthor: $scope.bookAuthor
        };
    
    $http.post(url, data, config).then(function (response) {
      $scope.postResultMessage = response.data;
    }, function error(response) {
      $scope.postResultMessage = "Error with status: " +  response.statusText;
    });
    
    $scope.bookName = "";
    $scope.bookISBN = "";
    $scope.bookPrice = "";
    $scope.bookAuthor = "";
  }
});