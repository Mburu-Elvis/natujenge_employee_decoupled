app.controller('AdminController', ['$scope', '$http', function($scope, $http) {
    $http({
        method: 'GET',
         mode: "cors",
        url: 'http://127.0.0.1:8080/api/v1/employees',
    }).then(function(response) {
        // Success callback
        console.log(response.data);
        $scope.employees = response.data; // Assuming you want to assign the data to $scope.employees
        console.log('Employees:', $scope.employees);
    }, function(error) {
        // Error callback
        console.error('Error fetching employees:', error);
    });
}]);