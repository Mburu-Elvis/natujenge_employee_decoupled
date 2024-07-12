app.controller('AdminController', ['$scope', '$http', function($scope, $http) {
    $scope.employeeForm={};
     $scope.openModal = function(employee) {
          $scope.selectedEmployee = angular.copy(employee); // Create a copy of the employee to edit
     };
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

    $scope.createEmployee = function() {
        $http({
            method: 'POST',
            headers: {
                'ngrok-skip-browser-warning': 'hello',
                'Content-Type': 'application/json'
            },
            data: $scope.employeeForm,
            url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees',
        }).then(function(response) {
            // Success callback
            console.log('Employees:', response);
        }, function(error) {
            // Error callback
            console.error('Error fetching employees:', error);
        });
    };

    $scope.updateEmployee = function() {
        $http({
            method: 'PUT',
            headers: {
                'ngrok-skip-browser-warning': 'hello',
                'Content-Type': 'application/json'
            },
            data: $scope.selectedEmployee,
            url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees',
        }).then(function(response) {
            // Success callback
            console.log('Employees:', response);
        }, function(error) {
            // Error callback
            console.error('Error fetching employees:', error);
        });
    };

    $scope.deleteEmployee = function(employeeId) {
        $http({
            method: 'DELETE',
            headers: {
                'ngrok-skip-browser-warning': 'hello',
                'Content-Type': 'application/json'
            },
            data: $scope.employeeForm,
            url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees/' + employeeId
        }).then(function(response) {
            // Success callback
            console.log('Employee deleted:', response);
            // Display success message to the user
            $scope.successMessage = 'Employee deleted successfully!';
            $scope.errorMessage = ''; // Clear any previous error message
        }, function(error) {
            // Error callback
            console.error('Error deleting employee:', error);
            // Display error message to the user
            $scope.errorMessage = 'Failed to delete employee. Please try again later.';
            $scope.successMessage = ''; // Clear any previous success message
        });
    };
}]);