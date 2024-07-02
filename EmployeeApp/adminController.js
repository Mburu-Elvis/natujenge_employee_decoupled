app.controller('AdminController', ['$scope', '$http', function($scope, $http) {
    $http({
        method: 'GET',
        headers: {
                    'ngrok-skip-browser-warning': 'hello'
                },
        url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees',
    }).then(function(response) {
        // Success callback
        // console.log(response.data);
        $scope.employees = response.data; // Assuming you want to assign the data to $scope.employees
        console.log('Employees:', $scope.employees);
    }, function(error) {
        // Error callback
        console.error('Error fetching employees:', error);
    });
}]);
